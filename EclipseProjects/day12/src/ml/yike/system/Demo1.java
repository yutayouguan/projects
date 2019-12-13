package ml.yike.system;

import java.util.Arrays;



/**
 * @author wangmeng System系统类 主要用于获取系统属性数据 
 * System常用的方法： 
 * static void  arraycopy​(Object src, int srcPos, Object dest, int destPos, int length) 
 * static long	currentTimeMillis() 返回系统时间毫秒数
 * static void	exit​(int status) 退出jvm
 * static void	gc() 建议虚拟机赶快启动垃圾回收器
 * finalize() 如果一个对象被回收时会先调用finalize()
 *static String	getenv​(String name)  根据环境变量的名字获取环境变量
 *static Properties	getProperties() 获取系统属性
 */

class Persona{

	String name;
	int age;
	Persona(String name,int age)
	{
		this.age=age;
		this.name=name;
	}

	@SuppressWarnings("deprecation")
	@Override
		protected void finalize() throws Throwable {
			// TODO Auto-generated method stub
			super.finalize();
			System.out.println(name+"被回收了！！");
		}
	public void eat() {
		System.out.println(name+age+"岁就会吃饭");
		
	}
	
}
public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 12, 23, 34, 56, 76, 54, 32, 21 };
		int[] arr1 = new int[5];
		System.arraycopy(arr, 5, arr1, 1, 3);
		System.out.println(Arrays.toString(arr1));
//		System.exit(0);//推出jvm；
	String env=	System.getenv("PATH");//获取系统环境变量
	System.out.println("环境变量为:"+env);
//	Properties properties=System.getProperties();
//	properties.list(System.out);
	String string=System.getProperty("os.name");
	String string1=System.getProperty("user.name");
	System.out.println("当前系统名称："+string);
	System.out.println("当前用户名称："+string1);
		getTime(); // 显示当前时间
	
//		for(int i=0;i<4;i++) {
//	    new Persona("亦可", i).eat();
//		System.gc(); //建议虚拟机赶快启动垃圾回收器
//	}		
	}

//获取系统当前长时间（东八区）
	public static void getTime() {
		long tolmillis = System.currentTimeMillis();
		long tolsecond = tolmillis / 1000;
		long currentmillis = tolmillis % 1000;
		long tolminute = tolsecond / 60;
		long currentsecond = tolsecond % 60;
		long tolhour = tolminute / 60;
		long currentminute = tolminute % 60;
		long currenthour = tolhour % 24 + 8;

		if (currenthour < 12) {
			System.out.println(
					"当前系统时间：" + "上午" + currenthour + ":" + currentminute + ":" + currentsecond + ":" + currentmillis);

		} else {
			currenthour -= 12;
			System.out.println(
					"当前系统时间：" + "下午 " + currenthour + ":" + currentminute + ":" + currentsecond + ":" + currentmillis);
		}
	}

}
