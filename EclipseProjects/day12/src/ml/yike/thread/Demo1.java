package ml.yike.thread;


/**
 * @author wangmeng
 *线程：
 *一个JAVA程序中至少有几个线程？
 *至少有两个，一个是主线程负责main方法代码的执行，一个是垃圾回收器线程，负责回收垃圾。
 *多线程的优点：
 *1.解决了一个进程能同时执行多个任务的问题
 *2.提高了资源的利用率
 *多线程的缺点：
 *1.增加了CPU的负担
 *2.降低了一个进程中线程的执行效率。
 *3.引发线程安全
 *4.出现了死锁现象
 *
 *
 *创建多线程：
 *
 *方式一：
 *1.自定义一个类继承thread类，
 *2.重写Thread类的run方法。
 *疑问：重写润run（）方法的目的是什么？
 *每个线程都有自己的任务代码，jvm创建的主线程的任务代码就是main方法中的所有代码，自定线程负责了run方法中的代码。
 *3.创建thread的子类对象，并调用start方法开启线程。
 *注意：一个线程一旦开启，那么线程就会执行run方法中的代码，run方法千万不能直接调用，直接调用就相当于调用了一个普通的函数而已，没有启动一个线程
 */
public class Demo1 extends Thread{
	@Override //把自定义线程中的任务代码写在run方法中。
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("自定义线程"+i);
		}
	}
	
	public static void main(String[] args) {
		Demo1 demo1 = new Demo1();
	   demo1.start();

		
		for (int i = 0; i < 5; i++) {
			System.out.println("主线程"+i);
			
		}

	}
	


}
