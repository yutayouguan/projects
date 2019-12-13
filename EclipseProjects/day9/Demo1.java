
/*
final
final 修饰一个基本数据类型变量时，不能给改变量重新赋值，第一次为最终值。
final 修饰一个引用数据类型变量时，改变量不能指向新的对象；
final 修饰一个方法是时，为最终方法，不可重写
final 修饰一个类时，为最终类，不可继承。

常量的修饰符一般为：public static final 
*/
class Circle{
double r;
//private double pi = 3.14159;
public static final double pi = 3.14159;
public Circle(double r){
this.r=r;
}
public void getArea(){
System.out.println("面积为："+(r*r*pi));
}
}

class Demo1{
public static void main(String[] args){
Circle c= new Circle(10);
//final Circle c= new Circle(10);
//c.pi = 0; //设置pi为private 修饰时，不可访问，pi 在 Circle 中是 private 访问控制
//c.pi = 0; //设置pi为final修饰时， 无法为最终变量pi分配值
//c= new Circle(100);// 设置引用类型变量c为final修饰时，无法为最终变量c分配值
c.getArea();
System.out.println("");
}

}
