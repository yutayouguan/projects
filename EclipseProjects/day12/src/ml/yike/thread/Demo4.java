package ml.yike.thread;

class TicketSale extends Thread {
	
	static int num =50;

	static Object object = new Object();  //唯一共享的状态

	public TicketSale(String nameString) {
		super(nameString);
	}

	@Override
	public void run() {

		while (true) {
			
            //synchronized (object) {  //这个锁是唯一共享的才能锁定住 可以是个字符串常量（因为在字符串常量池中只维护一份字符串）
			//同步代码块解决线程安全问题
			
			synchronized ("🔒") {
				if (num > 0) {
					System.out.println(this.getName() + "在售第" + num + "张票。");
					num--;
				} else {
					System.out.println("票售罄了！！");
					break;
				}
			}
		}
	}

}

public class Demo4 {

	public static void main(String[] args) {
		TicketSale ticketSale1 = new TicketSale("窗口1");
		TicketSale ticketSale2 = new TicketSale("窗口2");
		TicketSale ticketSale3 = new TicketSale("窗口3");
		ticketSale1.start();
		ticketSale2.start();
		ticketSale3.start();
	}

}
