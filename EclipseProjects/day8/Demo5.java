//调用父类的构造方法可以初始化从父类继承下来的成员变量

class Fu{
int x =10;
String name ;
public Fu(){
System.out.println("父类无参数的构造方法");
}
public Fu(String name){
this.name = name;
System.out.println("父类有参数的构造方法");
}
public void eat(){
System.out.println("父亲吃番薯！！");

}

}
class Zi extends Fu{
int x = 20;
public Zi(){
System.out.println("子类无参数的构造方法");
}
public Zi(String name){
super(name);//指定调用父类一个参数的构造函数
System.out.println("子类类有参数的构造方法");

}

public void eat(){
System.out.println("儿子喝汤！！");
System.out.println("儿子吃龙虾！！");
System.out.println("儿子吃甜品！！");
System.out.println("儿子和两杯！！");

}

public void print(){
System.out.println("x+"+x);
System.out.println("x="+super.x);
System.out.println("name"+name);
System.out.println("name="+super.name);
}

}
class Demo5{
public static void main(String[] args){
Zi z = new Zi("大头儿子");
z.print();
z.eat();
}

}
