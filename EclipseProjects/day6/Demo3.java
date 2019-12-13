/*


需求：使用JAVA类描述百合网的会员
问题：性别 出问题
问题分析：由于其他人可以直接操作sex属性，对sex进行赋值
面向对象的三大特征：封装、继承、多肽

封装：
权限修饰符：控制变量可见的范围。
public ：公共的，修饰的成员变量或者方法任何人都可以访问；
private: 私有的，修饰的成员变量或者方法只能在本类中进行直接访问；

封装的步骤：
1.使用private修饰需要被封装的属性
2.提供一个公共的方法设置或者获取该私有成员属性
规范：
set属性名();
get属性名();
疑问：封装一定要用get或者set方法吗？
不一定，根据用户需求而定。
*/
class MyMember{
public String name;
private String sex;

int salary;//薪水
//提供一个设置sex的方法
public void setSex(String sex)
{
if(sex.equals("男")||sex.equals("女"))//如果比较两个字符串相等，不要用”==”号；使用String1.equals(String2);
{
this.sex = sex;
}
else{
this.sex = "男"; //默认是男
}

}
//提供一个获取sex的方法
public String getSex(){
return sex;
}
public void chat(){

System.out.println(name+"聊的很开心！");

}

}

public class Demo3{
public static void main(String[] args){
MyMember m = new MyMember();

m.name = "大漂亮";
m.setSex("人妖");
m.salary =10000;

System.out.println("姓名："+m.name+"\n性别："+m.getSex()+"\n薪水："+m.salary);

}
}
