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
public abstract void eat();
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


}


class Fish extends Animal{
public Fish(String name ,String color){
super(name,color);
}
public void run(){
System.out.println(name+"要摇尾巴游动起来！！");
}

}

class Demo2{
public static void main(String[] args){
Dog d = new Dog("牧羊犬","棕色");
d.run();
Fish f = new Fish("锦鲤","金色");
f.run();
}

}
