package test;
 
public class Cat implements Animal {
     
    private String name;
    private Mouse mouse;
 
    @Override
    public void say() {
        System.out.println("i am "+name+" !");
        System.out.println("catched:");
            mouse.say();
    }
     
    public String getName(){
        return this.name;
    }
     
    public Mouse getMouse(){
        return mouse;
    }
     
    public void setName(String name){
        this.name = name;
    }
     
    public void setMouse(Mouse mouse){
        this.mouse = mouse;
    }
 
}