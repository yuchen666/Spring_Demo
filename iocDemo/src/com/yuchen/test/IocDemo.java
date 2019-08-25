package com.yuchen.test;

import com.yuchen.entity.Classes;
import com.yuchen.entity.Student;
import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/***
 * IOC方法创建实例
 */
public class IocDemo {
    public static void main(String[] args) {
        /***
         * 指定spring.xml配置文件，生产ApplicationContext对象
         */
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        /***
         * 调用Application的getBean方法，通过指定beanId获取对象，由于获取的是Object对象所以要进行强转
         */
        //Student student = (Student) applicationContext.getBean(Student.class);
        Classes classes = (Classes)applicationContext.getBean(Classes.class);
        /***
         * 通过set方法进行赋值
         */
        /*student.setId(1);
        student.setName("于晨");
        student.setAge(22);*/

        /***
         * 也可以通过<property></property>标签进行赋值，赋值时，若中文名字含有特殊符号，可以使用\]]>进行性赋值
         *  <property name="name">
         *     <value><![CDATA[&张三&]]></value>
         *  </property>
         *  使用此方法时，实体类中必须写set方法，因为Spring是通过setter方法进行赋值的，否则加载的时候会报错
         *  当spring.xml中有两个bean同时指向一个实体类时，会抛出异常，因为两个bean都是由Student类生成的，IOC无法将两个bean都返回，必须指定唯一一个bean
         * */
        //System.out.println("student = " + student);
        System.out.println("classes = " + classes);
    }
}
