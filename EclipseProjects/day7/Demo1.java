class Person{
int id;
String name;
int age;

public Person(int id,String name,int age){
this.id = id;
this.name = name;
this.age = age;
}
public void compareAge(Person p2){
if(this.age>p2.age)
{
System.out.println(this.name+"年龄大！");

}
else if(this.age<p2.age){
System.out.println(p2.age+"年龄大");
}
else {
System.out.println("年龄相等！");
}
}

}
class Demo1{
public static void main(String[] args){
Person p1 = new Person(1,"亦可",19);
Person p2 = new Person(2,"小姐姐",22);
p1.compareAge(p2);
}
}
