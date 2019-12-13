package ml.yike.stringbuffer;

/**
 * @author wangmeng 字符串是常量，创建后不能修改 注意字符串不适合频繁修改，字符串内容一旦发变化，就会马上创建另一个新的对象
 *         如果需要频繁修改字符串，建议使用StringBuffer（字符缓冲类）--存储字符的容器。
 *         初始化占用16个字符，增加字符变为两倍加2，16*2+2；依赖于一个方法内的字符数组 
 *         StringBuilder与StringBuffer的方法一样，功能一样，  
 *         相同点：
 *         1.两个类都是字符串缓冲类
 *         2.两个类方法一致
 *
 *         不同点：
 *         1.StringBuffer是线程安全的；而StringBuilder是线程不安全的。
 *         2.StringBuilder效率比StringBuffer高，
 *         3.StringBuffer是JDK1.0出现的，而StringBuilder是jDK1.5出现的,推荐使用StringBuilder，现实生活中，基本不会出现使用多线程操作字符串。
 *         容器具备的属性： 
 *         增加：
 *         append();可以添加任意类型的数据 
 *         StringBuffer insert​(int offset, booleanb)可以插入任意类型的数据
 *
 *         删除 
 *         StringBuffer delete​(int start, int end) 
 *         StringBuffer
 *         deleteCharAt​(int index)
 *
 *         查看 
 *         char charAt​(int index) 
 *         int capacity() 
 *         int indexOf​(String str)
 *         int lastIndexOf​(String str, int fromIndex)
 *         
 *
 *         修改 
 *         void ensureCapacity​(int minimumCapacity) 
 *         StringBuffer replace​(int start, int end, String str) 
 *         String substring​(int start)
 *         StringBuffer reverse() 
 *         void setCharAt​(int index, char ch)
 *
 *
 */
public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer sBuffer = new StringBuffer();
		// 添加
		sBuffer.append("java");// 在序列后面添加字符串。
		sBuffer.append("1234");
		sBuffer.append("JAVA");
		sBuffer.append("TRUE");
		sBuffer.append(true);
		sBuffer.append("?");
		System.out.println(sBuffer);
		// 插入
		sBuffer.insert(4, "yike");// 在索引值4后面插入亦可
		System.out.println(sBuffer);
		// 删除
		sBuffer.delete(8, 12);// 删除1234 左闭右开区间[)
		sBuffer.deleteCharAt(4);// 删除索引值为4的内容。
		System.out.println(sBuffer);
		//  修改
		sBuffer.replace(4, 7, "亦可");//把指定索引值开始与结束的字符替换为指定的内容
		System.out.println(sBuffer);
		sBuffer.reverse();//反转字符串的内容
		System.out.println(sBuffer);
		sBuffer.setCharAt(0, '!');//把指定的索引值字符替换为指定字符
		System.out.println(sBuffer);
		String s=sBuffer.substring(5);//根据指定的索引值截取子串
		System.out.println(s);
		String s1=s.substring(8, 10);
		System.out.println(s1);
		sBuffer.ensureCapacity(20);//指定容器的容量，可以使用带参数的构造方法初始化容量StringBuffer(20);
       //   查看
		char s2=sBuffer.charAt(0); //查看指定索引值的字符
		System.out.println(s2);
		int a=sBuffer.indexOf("可亦",3);//查看字符在数组中第一次出现的索引值
		sBuffer.append("可亦");
		System.out.println(a);
		 int c=sBuffer.lastIndexOf("可亦", 3);
		 System.out.println(c);
		int b=sBuffer.capacity(); //查看当前字符数组的长度
		System.out.println(b);
		System.out.println(sBuffer.length());//查看当前字符数组的个数
		String content=sBuffer.toString();//把字符容器里的字符组合成字符串返回，String可以作为参数类型传递，而StringBuffer不可以。
		System.out.println(content); 
	}

}
