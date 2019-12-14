package ml.yike.thread;

/**
 * @author wangmeng 线程常用的方法： Thread(String name) 初始化线程的名字 getName() 返回线程的名字
 *         setName(String name) 设置线程对象名
 *          sleep() 线程睡眠指定的毫秒数。是静态方法，那个线程的代码执行了sleep 就是那个线程睡眠。
 *         getPriority(）返回当前线程对象的优先级 默认线程的优先级是5 setPriority(int newPriority)
 *         设置线程的优先级虽然设置了线程的优先级，但是具体的实现取决于底层的操作系统的实现（最大的优先级是10 ，最小的1 ， 默认是5）。
 *         currentThread() 返回CPU正在执行的线程的对象，是静态方法，那个线程的代码执行了currentThread 就是返回那个线程对象。
 *
 */
public class Demo3 extends Thread {
	public Demo3(String string) {
		// TODO Auto-generated constructor stub
		super(string);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			System.out.println("i:" + i);
			try {
				Thread.sleep(2000);  //父类run方法没有抛出异常，子类只能捕获处理
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Demo3 demo3 = new Demo3("亦可"); //创建线程
		demo3.start(); //开启线程
		String string = demo3.getName();
		System.out.println("线程的名字："+string);
		demo3.setName("王二");
		
	
//		demo3.sleep(2000);主线程在睡眠
		String string2 = demo3.getName();
		
		System.out.println("线程的名字："+string2);
		System.out.println("yike");
		int a = demo3.getPriority();
		System.out.println(a);
		demo3.setPriority(7);
		int b = demo3.getPriority();
		System.out.println("当前线程的优先级："+b);
		System.out.println("当前线程："+Demo3.currentThread());
	}

}