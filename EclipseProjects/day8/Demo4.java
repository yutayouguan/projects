//人类、
/*
面相对象的三大特征：
1.封装：通过Private关键字
2.继承：通过extends关键字
3.多态：

继承格式：

class 类名1 extends 类名2{

}
*/
//人类
class Person{
String name;
private int age;
public Person(String name){
this.name = name;
}
public Person(){
System.out.println("person的构造方法被调用了！！");
}
public void eat(){
System.out.println("嘴角开始动，他在吃饭了！！");
}
}
//学生类
class Student extends Person{//Student就称作Person类的子类，Person类就称作Student的父类（超类（super）、基类（base））
int num;
public Student(){
System.out.println("Student的构造方法被调用了！！");
}
public void study(){
System.out.println(name+"good good study ,day day up!!");
}
}



class Demo4{
public static void main(String[] args){
Student s =new Student();
/*s.name = "yike";
System.out.println("名字"+s.name);
s.eat();
*/
}


}
