package makerectangles;
public class Point {
    private double x;
    private double y;
    public Point(){
    
    }
    public Point(double x,double y) throws Exception { 
        if(x<0 || y<0){
            throw new IllegalArgumentException("x or y cannot be negative");
        }
        this.x=x;
        this.y=y;
    }
    
    public void setX(double x){
        this.x=x;
    }
    public void setY(double y){
        this.y=y;
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;   
    }
}
