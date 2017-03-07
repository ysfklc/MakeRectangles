package makerectangles;
public abstract class Shape { 
    private final String id;
    public Shape (String s){
        this.id = s; 
    }
    public abstract double setPerimeter(); 
    public String getId(){
        return id;
    }
    @Override
    public String toString(){
    return "Shape[id="+id+"]";
    }
}