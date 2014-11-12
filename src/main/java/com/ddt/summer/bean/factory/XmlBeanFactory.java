package com.ddt.summer.bean.factory;
 
import java.util.ArrayList;
import java.util.List;
 
import com.ddt.summer.bean.entity.Bean;
 
public class XmlBeanFactory implements BeanFactory {
     
    private List<Bean> beans = new ArrayList<Bean>();
     
    private static XmlBeanFactory factory;
     
    private XmlBeanFactory(){
    }
     
    public static XmlBeanFactory getInstance(){
        if(factory==null){
            factory = new XmlBeanFactory();
        }
        return factory;
    }
     
    @Override
    public void putBean(String name, Object object){
        Bean bean = new Bean();
        bean.setId(name);
        bean.setObject(object);
        beans.add(bean);
    }
 
    @Override
    public Object getBean(String name) {
        for(Bean bean:beans){
            if(bean.getId().equals(name)){
                return bean.getObject();
            }
        }
        return null;
    }
 
    @Override
    public boolean containsBean(String name) {
        for(Bean bean:beans){
            if(bean.getId().equals(name)){
                return true;
            }
        }
        return false;
    }
}