package com.yuchen.service;

/***
 * 自定义ApplicationContextService接口，定义getBean方法，通过id返回bean
 */
public interface ApplicationContext {
    public Object getBean(String id);
}
