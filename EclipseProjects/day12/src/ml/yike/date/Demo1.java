package ml.yike.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author wangmeng Date类： 日期类：2019年09月21日 （已经过时了）被 Calendar类取代 Calendar类 常用方法：
 *         static Calendar getInstance() 使用默认时区和区域设置获取日历。 int get​(int field)
 *         返回给定日历字段的值。
 * 
 * 
 * 
 * 
 */
public class Demo1 {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
//		Date date = new Date();
//		System.out.println("当前时间："+date.getDate());//已经过时了，

		Calendar calendar = Calendar.getInstance();
		System.out.println("当前年份：" + calendar.get(Calendar.YEAR));
		System.out.println("当前月份：" + (calendar.get(Calendar.MONTH) + 1));
		System.out.println("当前号数：" + calendar.get(Calendar.DATE));
		System.out.println("当前时间：" + calendar.get(Calendar.HOUR));
		System.out.println("当前分钟：" + calendar.get(Calendar.MINUTE));
		System.out.println("当前秒数：" + calendar.get(Calendar.MINUTE));

		System.out.println("当前时间：" + calendar.get(Calendar.YEAR) + "年" + (calendar.get(Calendar.MONTH) + 1) + "月"
				+ calendar.get(Calendar.DATE) + "日" + calendar.get(Calendar.HOUR) + "时" + calendar.get(Calendar.MINUTE)
				+ "分" + calendar.get(Calendar.MINUTE) + "秒");

		/**
		 * 日期格式化类SimpleDateFormat是一个具体的类，用于以对语言环境敏感的方式来格式化和解析日期。它允许格式化（日期→文本），解析（文本→日期）和规范化。
		 * SimpleDateFormat​(String pattern)使用给定的模式和默认的FORMAT语言环境的默认日期格式符号构造一个SimpleDateFormat。
		 * Date	parse​(String text, ParsePosition pos) 解析字符串中的文本以产生日期。
		 * StringBuffer	format​(Date date, StringBuffer toAppendTo, FieldPosition pos) 将给定的Date格式化为日期/时间字符串，并将结果附加到给定的StringBuffer中。
		 */
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("Gyyyy年MM月dd日 a HH:mm:ss Z");  //字符串格式

		String timeString = simpleDateFormat.format(date);
		System.out.println("当前时间：" + timeString);

		String birthdayString = "公元1997年05月20日 下午 12:56:23 +0800"; //字符串格式必须一致，注意空格
		Date date2 = simpleDateFormat.parse(birthdayString);
		
		System.out.println("生日：" + date2);
		
	}

}
