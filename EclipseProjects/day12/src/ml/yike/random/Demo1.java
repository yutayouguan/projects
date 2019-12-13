package ml.yike.random;

import java.util.Random;

/**
 * @author wangmeng
 *随机数类Random：
 *要求编写一个随机产生的四五数验证码
 *
 */
public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
//		int randomnum = random.nextInt(10); //产生一个1到11的随机数
		
        char[] arr = {'亦','可','的','博','客','y','i','k','e','m','l'};
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
			int index = random.nextInt(arr.length);
			stringBuilder.append(arr[index]);
		}
        
        System.out.println("验证码："+stringBuilder.toString());
        
	}

}
