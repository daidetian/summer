package test;
 
public class Mouse implements Animal{
     
    private String name;
     
    public void setName(String name){
        this.name=name;
    }
     
    public String getName(){
        return this.name;
    }
    @Override
    public void say(){
        System.out.println("mouse is "+name);
    }
 
}