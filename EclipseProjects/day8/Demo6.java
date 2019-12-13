//学生类
class Student{
String name;
public Student(String name){
this.name = name;
}
public void study(){
System.out.println(name+"学习马克思列林主义！！");
}
}

class BaseStudent extends Student{
public BaseStudent(String name){
super(name);
}
public void study(){
System.out.println(name+"学习JAVA基础！！");
}
}
class WorkStudent extends Student{
public WorkStudent(String name){
super(name);
}
public void study(){
System.out.println(name+"学习JAVAEE + Andriod！！");
}
}
class Demo6{
public static void main(String[] args){
BaseStudent b = new BaseStudent("yike");
WorkStudent w = new WorkStudent("亦可");
b.study();
w.study();
}

}
