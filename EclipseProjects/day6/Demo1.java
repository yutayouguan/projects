//需求:使用JAVA面熟一个汽车类，汽车有轮子，名字，颜色三号属性；还具备跑的功能
/*
自定义类的三步骤：
1、自定义类
class 类名{
事物的公共属性使用成员变量描述；
事物的公共行为使用函数描述；


}
2、通过类创建对象
格式：
类名 变量 = new 类名();


3、访问(设置)对象的属性或者调用对象的功能
访问对象的属性格式：
对象.属性     /        对象.属性 = 值;
访问对象的方法格式：
对象.方法名();
*/

class Car{
String name;
String color;
int wheel;//车轮



public void run(){
if(wheel>=4){
System.out.println(name +"飞快的跑起来了");
}
else
{
System.out.println(name+"车子轮子不足四个了，赶快去修理厂修理！");
}
}


}


class CarFactory{
String name;
String address;
String tel;
//公共行为：修车
public Car repair(Car c){
if(c.wheel>=4){
System.out.println("废了好大力气，修好了，给钱！");

}
else 
{
c.wheel = 4;
System.out.println("修好了，给钱！");
}

return c;
}

}


public class Demo1{
public static void main(String[] args){
//使用Car类申明一个c变量，指向一个车对象
Car c =  new Car();//通过车类创建一个车对象,对象一但创建，对象的成员变量会分配默认值，int 0   float 0.0f  double 0.0 char  ''  String  null   应用数据类型  null
c.name = "宝马";
c.color = "白色";
c.wheel = 4;
System.out.println("名字："+c.name+"颜色："+c.color+"车轮数："+c.wheel);
c.run();

Car c1 = new Car();
c1.name = "奔驰";
c1.color = "红色";
c1.wheel = 4;
System.out.println("名字："+c1.name+" 颜色："+c1.color+"车轮数："+c1.wheel);
for(int i = 0; i<100;i++){
c1.run();
}
c1.wheel =3;
c1.run();
CarFactory cf = new CarFactory();
cf.name = "亦可精修";
cf.address = "昆明理工大学";
cf.tel = "021-1234567";
cf.repair(c1);
c1.run();

}




}
