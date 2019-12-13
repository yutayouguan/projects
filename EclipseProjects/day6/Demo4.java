/*
需求：
使用JAVA类描述一个计算器类，计算器具有操作数1，操作数2，操作符三个工工属性，
还具备计算的功能行为。
要求： 不能直接对操作数1，操作数2，运算符这些属性直接赋值，要封装起来（+ - * /）
根据需求提供get或者set方法

*/
public class Demo4{
public static void main(String[] args){
//创建对象
Calculator calc = new Calculator();
/*calc.setNum1();
calc.setOption();
calc.setNum2();
*/
//设置属性
calc.initCalculator(1,2,'/');
//调用计算
calc.calculate();

}
}

class Calculator{
private int num1; //操作数1
private int num2; //操作数2
private char option; //操作符
//设置公共的方法设置属性
public void initCalculator(int n1 ,int n2,char o){
num1 = n1;
num2 = n2;
if(o=='+'||o=='-'||o=='*'||o=='/')
{
option = o;
}
else{
option = '+';
}
}

public void calculate(){
int result=0;
switch(option)
{
case '+':
result = num1 + num2;
break;
case '-':
result = num1 - num2;
break;
case '*':
result = num1 * num2;
break;
case '/':
result = num1 / num2;
break;
}
System.out.println("运算结果是："+result);
}
/*
public void setNum1(int num1)
{
this.num1 =num1;
}

public void setNum2(int num2){

this.num2 = num2;
}
public void setOption(char option){
if(option=='+'||option=='-'||option=='*'||option=='/'){this.option = option;}
else{

this.option = '+';
}
}
*/

}

