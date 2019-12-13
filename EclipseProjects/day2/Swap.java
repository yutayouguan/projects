//交换两个数的值，不出现第三方变量
import java.util.*;
import java.io.*;
public class Swap(){
public static void main(String[] args) throws Exception{

int a = 3;
int b = 5;

/*//第一种方法：引用第三方变量
int temp = a;
a = b;
b = temp;


//第二种方法：使用相加法，数据相加，可能会超出int的表示范围

a = a + b;
b = a - b;
a = a - b;
*/

//第三种方法:使用异或。缺点：逻辑不清晰
a = a^b; 
b = a^b;
a = b^a;

System.out.println("a="+a+";"+"b="+b);





}


}
