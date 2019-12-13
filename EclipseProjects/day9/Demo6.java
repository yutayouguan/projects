/*
接口的作用：
1.拓展功能
2.可以定义约束规范
3.程序解耦。底耦合
*/

//橡皮擦接口
interface Eraser{
public abstract void remove();


}
//铅笔类
class Pencil{
String name;
public Pencil(String name){
this.name= name;
}
public void write(){
System.out.println(name+"刷刷的写起来！！");
}
}
//带橡皮的铅笔

class PencilWithEraser extends Pencil implements Eraser{
public PencilWithEraser(String name){
super(name);
}
public void remove(){
System.out.println(name+"把错误的东西擦除了！！");
}

}

class Demo6{
public static void main(String[] args){
PencilWithEraser pwe = new PencilWithEraser("多功能铅笔");
pwe.write();
pwe.remove();
}

}