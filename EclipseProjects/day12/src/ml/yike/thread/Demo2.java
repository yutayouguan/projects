package ml.yike.thread;

class VideoThread extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("现在开始视频！！");

		}

	}

}

class TalkThread extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("现在开始聊天！！");

		}
	}
}

public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VideoThread videoThread = new VideoThread();
		videoThread.start();
		TalkThread talkThread = new TalkThread();
		talkThread.start();
	}

}
