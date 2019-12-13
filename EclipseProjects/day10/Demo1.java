//强制类型转换
//需求：定义一个函数可以接受任意类型的动物对象，在函数内调用动物特有的函数
/*
abstract:
1.如果一个方法没有方法体，那么要用abstract修饰，作为抽象方法
2.如果一个类出现了一个抽象函数，那么该类也要用abstract修饰
3.一个非抽象类继承了抽象类，必须要把抽象类的所有抽象方法都要实现
4.抽象类可以有非抽象方法，也可以没有抽象方法
5.抽象类不可以创建对象（无法实例化）（抽象类对象调用抽象方法没有意义），但存在构造方法，提供给子类进行初始化父类的属性：
6.


*/
abstract class Animal{
String name;
String color;
public Animal(String name, String coloor){
this.name = name;
this.color = color;
}
//抽象类可以有非抽象方法
public void eat(){
System.out.println(name+"吃东西！！");
}
//没有函数体，抽象方法
public abstract void run();
}

class Dog extends Animal{
public Dog(String name ,String color){
super(name,color);
}
public void run(){
System.out.println(name+"四条腿跑的快！！");
}
public void sound(){
System.out.println(name+"汪汪汪打叫！！");
}


}


class Fish extends Animal{
public Fish(String name ,String color){
super(name,color);
}
public void run(){
System.out.println(name+"要摇尾巴游动起来！！");
}
public void bubble(){
System.out.println(name+"吹泡泡！！");
}

}

class Demo1{
public static void main(String[] args){
Dog d = new Dog("牧羊犬","棕色");
Fish f = new Fish("锦鲤","金色");
print(f);
print(d);
}
public static void print(Animal a){ // (a instanceof b)————>instanceof判断a是b的对象吗是返回TRUE，反之返回FALSE
if(a instanceof Dog){

Dog d = (Dog)a;
d.sound();
}
else if(a instanceof Fish){
Fish f = (Fish)a;
f.bubble();

}
}
}

