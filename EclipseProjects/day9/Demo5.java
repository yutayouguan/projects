/*
接口：扩展程序的功能
接口定义格式：
interface 接口名{

}

注意事项：
1.接口是一个特殊的类
2.接口的成员变量默认的修饰符为：public static final，（接口中的成员变量都是常量）（public static final
这三个单词少一个jvm都会自动加上去）
3.接口中的方法默认的修饰符为：public abstract，都为抽象方法
4.接口不能创建对象（实例化）。
5.接口没有构造方法，区别于普通的抽象方法（有构造方法给子类对父类的属性进行初始化）

*/

interface A{
//成员变量
public static final int i = 10;
//成员函数
public abstract void print();
}

class Demo5 implements A{ //Demo5实现了A接口
public  static void main(String[] args){


Demo5 d =new Demo5();
d.print();
}
public void print(){
System.out.println("这是个接口中的抽象方法！！");

}


}