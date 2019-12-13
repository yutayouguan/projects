package mi.yike.thread;


/**
 * @author wangmeng
 *join 方法 :在一个线程开启另一个线程
 */

class Mom extends Thread{
public Mom(String name) {
	super(name);
	// TODO Auto-generated constructor stub
}
	@Override
		public void run() {
		System.out.println(Thread.currentThread().getName()+"注备做饭！");
		System.out.println(Thread.currentThread().getName()+"煮饭！");
		System.out.println(Thread.currentThread().getName()+"洗菜！");
		System.out.println(Thread.currentThread().getName()+"炒菜，发现酱油没有了！");//发现酱油没有了，叫儿子去买酱油
		System.out.println(Thread.currentThread().getName()+"拿钱叫儿子去打酱油");
		Son son = new Son("儿子");
		son.start();
		try {
			son.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName()+"炒好菜了！");
		System.out.println("一家人开心的在饭桌上享受晚饭！");
		}
	
}

class Son extends Thread{
	public Son(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void run() {
		System.out.println(this.getName()+"拿钱下楼！");
		System.out.println(this.getName()+"小跑着去打酱油！");
		System.out.println(this.getName()+"打到加油！");
		System.out.println(this.getName()+"飞快的把酱油带回家！");
		
	}
	
}
public class Demo4 {
public static void main(String[] args) {
	Mom mom = new Mom("妈妈");
	mom.start();
	
}
}
