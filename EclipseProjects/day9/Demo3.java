/*
abstract不能和以下关键字共同修饰一个方法：
1.private
2.static
3.final
*/

abstract class MyShape{
String name;
public MyShape(String name){
this.name = name;
} 
public abstract void getArea();
public abstract void getLength();
}


class Circle extends MyShape{
double r;
public static final double PI=3.14159;
public Circle(String name,double r){
super(name);
this.r = r;
}
public void getArea(){
System.out.println(name+"的面积是："+(PI*r*r));
}
public void getLength(){
System.out.println(name+"周长是："+(2*PI*r));
}
}

class Rectangle extends MyShape{
int width;
int height;
public Rectangle(String name,int width,int height){
super(name);
this.width=width;
this.height=height;
}

public void getArea(){
System.out.println(name+"的面积是："+(width*height));
}
public void getLength(){
System.out.println(name+"周长是："+(2*(width+height)));
}
}

class Demo3{
public static void main(String[] args){
Circle c= new Circle("圆形",100);
c.getArea();
c.getLength();
Rectangle r = new Rectangle("矩形",10,10);
r.getArea();
r.getLength();
}

}
