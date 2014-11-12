package simple;
 
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.List;
 
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
 
import com.ddt.summer.bean.factory.BeanFactory;
import com.ddt.summer.bean.factory.XmlBeanFactory;
 
public class XmlReader {
     
    public static void read(){
        URL base = ClassLoader.getSystemResource("");
        File file = new File(base.getFile(),"applicationContext.xml");
        SAXBuilder builder = new SAXBuilder();
        try {
            Document doc = builder.build(file);
            Element beans = doc.getRootElement();
            paking(beans);
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     
    private static void paking(Element beans){
        List<Element> list = beans.getChildren();
        for(Element beanEle:list){
            String id = beanEle.getAttributeValue("id");
            String className = beanEle.getAttributeValue("class");
            try {
                Class<?> clazz = Class.forName(className);
                Object obj = clazz.newInstance();
                BeanFactory factory = XmlBeanFactory.getInstance();
                factory.putBean(id, obj);
                List<Element> properties = beanEle.getChildren();
                for(Element property:properties){
                    if("property".equals(property.getName())){
                        String name = property.getAttributeValue("name");
                        String value = property.getAttributeValue("value");
                        if(value!=null){
                            Field field = clazz.getDeclaredField(name);
                            PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
                            Method setterMethod = pd.getWriteMethod();
                            setterMethod.invoke(obj,value);
                        }
                        String ref = property.getAttributeValue("ref");
                        if(ref!=null){
                        	if(XmlBeanFactory.getInstance().getBean(ref)!=null){
	                        	Field field = clazz.getDeclaredField(name);
	                            PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
	                            Method setterMethod = pd.getWriteMethod();
	                            setterMethod.invoke(obj,XmlBeanFactory.getInstance().getBean(ref));
                        	}else {
								//新建未实现
							}
                        }
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IntrospectionException e) {
                e.printStackTrace();
            }
        }
    }
     
    public static Object getBean(String id){
        read();
        BeanFactory factory = XmlBeanFactory.getInstance();
        return factory.getBean(id);
    }
 
}