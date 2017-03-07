package makerectangles;
public class Rectangle extends Shape{
        private Line w;
        private Line h;
        private double perimeter;
    public Rectangle(String id,Line w,Line h){
        super(id);
        this.w=w;
        this.h=h;
        this.perimeter=setPerimeter();  
        
    }
    public void setW(Line w){
        this.w=w;
    }
    public void setH(Line h){
        this.h=h;
    }

    @Override
    public double setPerimeter(){
        perimeter=2*(this.w.getLength()+this.h.getLength());
        return perimeter;
    }
    public Line getW(){
        return w;
    }
    public Line getH(){
        return h;   
    }
    public double getPerimeter(){
        return perimeter;
    }
}
