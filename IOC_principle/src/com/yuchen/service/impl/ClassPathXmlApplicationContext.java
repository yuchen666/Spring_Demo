package com.yuchen.service.impl;

import com.yuchen.service.ApplicationContext;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/***
 * 实现步骤：需要引入DOM4J
 * 1. 创建装置 bean 的集合，这里使用 Map 集合，因为其 key-value 的存储结构方便存取 bean。
 * 2. 在 ClassPathXmlApplicationContext 类的构造函数中完成 IoC 的核心业务，解析 XML 配置文件，通过反射机制创建定义好的 bean，并保存在上一步创建的集合中。
 * 3. 实现抽象方法 getBean，通过 id 从集合中找到对应的 bean 进行返回。
 */
public class ClassPathXmlApplicationContext implements ApplicationContext {
    private Map<String,Object> ioc = new HashMap<String,Object>();

    public ClassPathXmlApplicationContext(String path){
        try {
            /***
             * 通过SAXReader对象读取xml文件
             */
            SAXReader reader = new SAXReader();
            /***
             * 获取document对象
             */
            Document document = reader.read("./resource/"+path);
            /***
             * 获取文档的根节点
             */
            Element root = document.getRootElement();
            /***
             * 将docement对象序列化
             */
            Iterator<Element> iterator = root.elementIterator();

            /***
             * while循环完成对bean标签的解析，首先获取bean标签的id和class值
             */
            while(iterator.hasNext()){
                Element element = iterator.next();
                String id = element.attributeValue("id");
                String className = element.attributeValue("class");
                /***
                 * 通过反射机制获取 className 对应的运行时类，进而获取无参构造函数创建 bean
                 */
                Class clazz = Class.forName(className);
                /***
                 * 获取无参构造函数，创建目标对象
                 */
                Constructor constructor = clazz.getConstructor();
                /***
                 * 创建目标对象
                 */
                Object object = constructor.newInstance();
                /***
                 * 给目标对象赋值
                 */
                Iterator<Element> beanIter = element.elementIterator();

                while (beanIter.hasNext()){
                    Element property = beanIter.next();
                    /***
                     * 获取属性
                     */
                    String name = property.attributeValue("name");
                    String valueStr = property.attributeValue("value");
                    /***
                     * 通过name属性，获取到对应的Setter方法
                     * 然后调用Setter方法并将value的作为参数传入来赋值
                     */
                    String methodName = "set"+name.substring(0,1).toUpperCase()+name.substring(1);
                    /***
                     * 获得在这个类型的声明中定义的指定名称的属性
                     */
                    Field field = clazz.getDeclaredField(name);
                    /***
                     * 通过反射机制来获取到name对应属性的setter方法
                     */
                    Method method = clazz.getDeclaredMethod(methodName,field.getType());
                    /***
                     * 根据成员变量的数据类型，将value进行转换
                     */
                    Object value = null;
                    if (field.getType().getName()=="long"){
                        value = Long.parseLong(valueStr);
                    }
                    if(field.getType().getName()=="java.lang.String"){
                        value = valueStr;
                    }if(field.getType().getName()=="int"){
                        value = Integer.parseInt(valueStr);
                    }
                    /***
                     * 通过反射机制调用动态生成的 setter 方法完成属性赋值
                     * 同时将动态创建的 bean 存入集合中，bean 标签的 id 值作为 key
                     */
                    method.invoke(object,value);
                        ioc.put(id,object);
                }
            }

        }catch (DocumentException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (NoSuchMethodException e){
            e.printStackTrace();
        }catch (InstantiationException e){
            e.printStackTrace();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }catch (InvocationTargetException e){
            e.printStackTrace();
        }catch (NoSuchFieldException e){
            e.printStackTrace();
        }
    }

    @Override
    public Object getBean(String id) {
        return ioc.get(id);
    }
}
