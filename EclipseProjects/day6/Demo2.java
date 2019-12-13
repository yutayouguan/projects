//匿名对象：没有引用类型变量指向的对象
//需求：使用JAVA类描述一个学生类
/*
匿名对象注意事项：
1、我们一般不给匿名对象赋予属性值，因为永远访问不到；
2、两个匿名对象不可能是同一个对象。
匿名对象的应用场景：
1.如果一个对象要调用一个方法，而调用完方法后，该对象就不在使用了。
2.可以作为一个实参调用一个函数

好处：
简化书写、尽快的释放内存（执行完后，匿名对象就变为垃圾对象，会被JVM垃圾回收内存）、
*/

class Student{
int num;
String name;
 

public void study(){
System.out.println("学习使我快乐！");


}
}

public class Demo2{
public static void main(String[] args){
/*
//创建一个学生对象
//Student s = new Student();
//new Student();//匿名对象
//new Student().name = "yike.ml";
//System.out.println(Student().name);//null
System.out.println(new Student()==new Student());//FALSE "=="用于引用类型变量时，比较的是内存地址。
需求：调用student类的的study方法
*/
new Student().study();



}




}
