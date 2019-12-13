package ml.yike.runtime;

import java.io.IOException;

/**
 * @author wangmeng RunTime类 该类主要代表了，应用程序运行的环境 单例设计模式 没有构造方法，必须有一个静态函数来获取对象
 * 常用方法：
 * static Runtime	getRuntime() 返回与当前Java应用程序关联的运行时对象。
 * Process	exec​(String command)  在单独的过程中执行指定的字符串命令。
 * long	freeMemory() 返回Java虚拟机中的可用内存量。
 * long	maxMemory() 返回Java虚拟机将尝试使用的最大内存量。
 * long	totalMemory()  返回Java虚拟机中的内存总量。
 * abstract void	destroy() Kills the process.
 */
public class Demo1 {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		Runtime runtime = Runtime.getRuntime(); // 调用getRunTime()静态方法获取对象；
		Process process = runtime.exec("/Applications/Calculator.app/Contents/MacOS/Calculator");  //在单独的过程中执行指定的字符串命令
		Thread.sleep(10000);  //等待10秒
		process.destroy();  //中指进程
		System.out.println("java虚拟机中空闲的内存："+runtime.freeMemory());
		System.out.println("java虚拟机中试图使用的最大的内存："+runtime.maxMemory());
		System.out.println("java虚拟机中的内存总量："+runtime.totalMemory());
	}

}
