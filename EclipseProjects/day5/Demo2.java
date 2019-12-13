//需求：定义一个函数接受一个char类型的数组对象，然后函数中的小写字母变为大写字母

public class Demo2{
public static void main(String[] args)
{
char[] arr = {'a','b','c','d','e','d','f'};
for(char i:arr){
System.out.print(i+",");

}
System.out.println(" ");
for(int i = 0;i<arr.length;i++)
{
arr[i]-=32;
System.out.print(arr[i]+",");
}
System.out.println(" ");
}





}
