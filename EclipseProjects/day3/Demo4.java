import java.util.*;
import java.io.*;
public class Demo4{
public static void main(String[] args)
{
System.out.println("请输入需要打印的行数：");
Scanner input = new Scanner(System.in);
int num = input.nextInt();
print(num);
System.out.println("请输入分数：");
int grade = input.nextInt();
String str = reClass(grade);
System.out.println(str);
}
//打印乘法表

public static void print(int row)
{
for(int i = 1;i<=row;i++)
{
for(int j = 1;j<=i;j++)
{
System.out.print(i+"*"+j+"="+i*j+"\t");

}
System.out.println("");
}

}
//输入成绩计算等级
public static String reClass(int score){
String str = "";
if(score>=90&&score<=100)
{
str = "等级A";
}
else if(score>=80){
str = "等级B";
}
else if(score>=70){
str = "等级C";
}
else if(score>=60){
str = "等级D";
}
else 
{
str = "补考";
}
return str;
}



}
