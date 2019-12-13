//接口实现关系下的多态
interface Dao{
public abstract void add(); //接口的方法全部是非静态的，调用子类的方法。
public  abstract void delete();
}
//接口实现类
class UserDao implements Dao{
public void add(){
System.out.println("添加成功！！");
}
public void delete(){
System.out.println("删除成功！！");
}

}
class Demo2{
public static void main(String[] args){
Dao d = new UserDao();
d.add();
d.delete();

}
}