public class Demo3
{
public static void main(String[] args){
int i = 128;
byte b =(byte) i;

System.out.println(b);//-128
//byte\short\char类型的数据在参与算数运算时首先会转换为int类型在参与运算
System.out.println('a'+1);//98
System.out.println('0'+1);//49
System.out.println('A'+1);//65
//计算机每次运算的时候只能取两个数据运算
System.out.println(1+2+3+"yike.ml"+1+2+3);//6yike.ml123
//在JAVA中做取模运算时，结果的±号取决于被除数
System.out.println(10%3)//1
System.out.println(10%-3)//1
System.out.println(-10%-3)//-1
System.out.println(-10%3)//-1

/*后自增在jvm的运行原理：
因为后自增要使用到没有+1之前的值，那么jvm会先声明一个变量用于保存没有+1之前的值。
原理：
int temp = i;//申明一个变量用于记录i没有+1之前的值。i=0
i++;//i=1
return temp;//temp作为表达式的结果 i=temp //i=0

i值发生的变化：
i = 0 ---->1----->0
*/
int i = 0;
i = i++;//后自增没有使用到+1之后的值
System.out.println("i=" + i);//0

}

/*后自减在jvm的运行原理：
因为后自减要使用到没有-1之前的值，那么jvm会先声明一个变量用于保存没有-1之前的值。
原理：
int temp = i;//申明一个变量用于记录i没有+1之前的值。i=1
i--;//i=0
return temp;//temp作为表达式的结果 i=temp //i=1

i值发生的变化：
i = 1 ---->0----->1
*/
int i = 1;
i = i--;//后自减没有使用到-1之后的值
System.out.println("i=" + i);//1
}


}
