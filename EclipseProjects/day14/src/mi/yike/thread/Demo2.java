package mi.yike.thread;
/*
 线程通讯： 一个线程完成了自己的任务时，要通知另外一个线程去完成另外一个任务.
 
生产者与消费者


wait():  等待   如果线程执行了wait方法，那么该线程会进入等待的状态，等待状态下的线程必须要被其他线程调用notify方法才能唤醒。
notify()： 唤醒    唤醒线程池等待线程其中的一个。
notifyAll() : 唤醒线程池所有等待 线程。


wait与notify方法要注意的事项：
	1. wait方法与notify方法是属于Object对象 的。
	2. wait方法与notify方法必须要在同步代码块或者是同步函数中才能 使用。
	3. wait方法与notify方法必需要由锁对象调用。
	
问题一：出现了线程安全问题。 价格错乱了...
 
 */

/**
 * @author wangmeng 生产者消费者问题：线程之间的通讯
 * 
 *
 */
//产品类
class Product {
	String name; // 产品名
	double price; // 价格
	boolean flag = false; // 产品是否生成完成的标志，默认为FALSE，没有生成

}

//生产者类
class Producer extends Thread {
	Product product; // 产品

	public Producer(String name, Product product) {
		super(name);
		this.product = product;
	}

	@Override
	public void run() {
		int i = 0;
		while (true) {
			synchronized (product) {
				if (!product.flag) {
					if (i % 2 == 0) {
						product.name = "🍎";
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {

							e.printStackTrace();
						}
						product.price = 5.6;
					} else {
						product.name = "🍓";
						product.price = 10.0;
					}

					i++;
					System.out.println(this.getName() + "生产了" + product.name + "价钱为" + product.price);
					product.flag = true;
					product.notifyAll();//唤醒消费者消费
				}

				else {//已经生产 完毕，等待消费者先去消费
					try {
						product.wait(); //等待消费
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}

		}
	}
}

//消费者类
class Consumer extends Thread {
	Product product; // 产品

	public Consumer(String name, Product product) {
		// TODO Auto-generated constructor stub
		super(name);
		this.product = product;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (product) {
			if (product.flag) {
				
					System.out
							.println(Thread.currentThread().getName() + "消费了" + product.name + "价钱为：" + product.price);
					product.flag = false;
					product.notifyAll(); //唤醒生产者去生产
			
				
			} else {//产品还没有生产,应该 等待生产者先生产。
				try {
					product.wait(); //等待生产
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}}
	}
}

public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product product = new Product();// 产品对象
		Producer producer = new Producer("生产者", product); // 生产者对象
		Consumer consumer = new Consumer("消费者", product);// 消费者对象 
		producer.start(); // 开启线程
		consumer.start();

	}

}