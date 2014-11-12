package com.ddt.summer.bean.factory;
 
/**
 * 
 * @author daidetian@gmail.com
 */
public interface BeanFactory {
     
    /**
     * 放入bean对象
     * @param name
     * @param object
     */
    void putBean(String name, Object object);
     
    /**
     * 根据bean名称获取bean实例
     * @param name
     * @return
     */
    Object getBean(String name);
 
    /**
     * 是否含有名称为name的bean
     * @param name
     * @return
     */
    boolean containsBean(String name);
 
}