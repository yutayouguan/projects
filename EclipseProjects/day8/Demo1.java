//静态方法不可以出现this,super关键字

class Student{
String name;
static String country = "中国";

public Student(String name){
this.name = name;
}
public void study(){
System.out.println(name+"开始认真学习！！");


}
//静态方法
public static void seelp(){
System.out.println("呼呼大睡！！");
}
}

class Demo1{
public static void main(String[] args){
Student s1  = new Student("亦可");
s1.study();
s1.seelp();
}
}

