package ml.yike.object;

/*
 * java面相对象的语言，找正确的对象做正确的事
 * 1.自定义类，然后创建对象
 * 2.sun公司提供很多的类，认识这些类，创建类的对象
 * */
/*
 * 查看源代码：
 * 1、光标停在方法上点击F3
 * 2、Ctrl+点击左键
 * 3、打开申明（declaration）窗口
 * */
/*
 * Object类：所有类的终极父类，任何一个类都默认继承了object类，它所有的方法都可以使用。
 * 常用方法：
 * toString()
 * hashCode()
 * */
class Person {
	String name;
	int id;

	public Person(int id, String name) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "编号：" + this.id + " 姓名：" + this.name;
	}

}

public class Demo1 {
	public static void main(String[] args) {
		Demo1 demo1 = new Demo1();
		System.out.println("hashCode:" + demo1.hashCode());// 返回对象的内存地址
		System.out.println("toString:" + demo1.toString());
		System.out.println(demo1);// 查看函数源代码可知方法内部调用了toString()方法

		Person person = new Person(112, "亦可");
		System.out.println("Person:" + person);// 和toString()方法一样
	}
}
