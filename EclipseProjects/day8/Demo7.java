/*//instanceof 关键字
使用格式：
对象 instanceof 类别
必须是继承或者实现关系
*/
class Animal{
String name;
String color;
public Animal(String name,String color){
this.name =name;
this.color = color;
}
}

class Dog extends Animal{
public Dog(String name,String color){
super(name,color);
}
public void bite(){
System.out.println(name+"汪汪叫！咬人！！");
}
}
class Mouse extends Animal{
public Mouse(String name,String color){
super(name,color);
}
public void bite(){
System.out.println(name+"打洞！偷吃玉米！！");
}
}
class Demo7{
public static void main(String[] args){
Dog d = new Dog("泰迪","棕色");
Mouse m = new Mouse("塔克","白色");
System.out.println("狗是动物吗："+(d instanceof Animal));
System.out.println("狗是属于狗类吗："+(d instanceof Dog));
Animal animal = new Animal("yike","黄色");
System.out.println("动物是狗吗:"+(animal instanceof Dog));
//System.out.println("狗是老鼠类吗："+(d instanceof Mouse)); //报错，没有继承或者实现关系
}

}
