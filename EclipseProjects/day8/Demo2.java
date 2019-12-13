/*单例设计模式：保证类在内存中只有一个对象
 1.饿汉2.懒汉（推荐使用恶汉设计模式（虽然可能浪费内存资源），懒汉设计模式存在线程安全问题，不能保证类内只有一个对象）
步骤(饿汉)：
1.私有化构造函数
2.申明本类的引用类型变量，并指向本类实例化的对象
3.提供一个调用访问类的对象的公共的静态方法*/
class Single1{
private static Single1 s = new Single1();
private Single1(){}

public static Single1 getInstance(){
return s;

}

}
/*
步骤（懒汉）：
1.私有化构造函数
2.申明本类的引用类型变量，但不指向本类实例化的对象
3.提供一个调用访问类的对象的公共的静态方法（先判断是否创建了对象，没有则创建，有则返回对象给调用者）
*/
class Single2{
private static Single2 s;
private Single2(){}

public static Single2 getInstance(){
if(s==null){
s = new Single2();
}

return s;

}
}

class Demo2{
public static void main(String[] args){
Single1 s1 = Single1.getInstance();
Single1 s2 = Single1.getInstance();
System.out.println("是同一个对象吗？"+( s1==s2));

}
}
