package test;

import simple.XmlReader;

public class Example {
	
	public static void main(String[] args){
        Animal a1 = (Animal) XmlReader.getBean("animal");
        a1.say();
    }

}
