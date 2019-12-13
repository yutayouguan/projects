//清除数组中的重复元素并返回一个新数组
import java.util.Arrays;
class Demo2{
public static void main(String[] args){
int[] arr = {12,23, 45,56,12,43,65,21,23,94,65,54,12};
arr=clearRepeat(arr);
sort(arr);
System.out.println("清除重复元素后的数组为："+toString(arr));
}
//传入一个数组，并清除重复元素，并回一个新数组
public static int[] clearRepeat(int[] arr){
int count = 0;//记录重复元素的个数
//遍历旧数组找出重复元素的个数
for(int i =0;i<arr.length;i++)
{
for(int j=i+1;j<arr.length;j++){
if(arr[i]==arr[j])
{
count++;
break; //找到第一个重复元素就跳出此次循环
}
}
}
int newLength=arr.length-count; //新数组 的长度
int[] newArr = new int[newLength]; //创建一个新的数组
//遍历旧数组把不重复数据存入新数组

int index = 0; //新数组的索引值
for(int i =0;i<arr.length;i++)
{
Boolean flag = false; //默认不是重复元素
int temp = arr[i];//取出旧数组中的元素
for(int j=0;j<newArr.length;j++){
if(temp==newArr[j])
{
flag=true;
break;
}
}
if(!flag){
newArr[index++]=temp;
}

}
return newArr;

}
//重写toString方法，遍历输出一个数组
public static String toString(int[] arr){
String a=null;
for(int i =0; i<arr.length;i++){
if(i==0){
a= "["+arr[i]+",";
}
else if(i==arr.length-1){
a+=arr[i]+"]";
}
else{
a+=arr[i]+",";
}

}
return a;
}
//重写sort方法
public static void sort(int[] arr){
for(int i= 0;i<arr.length;i++){
for(int j=i+1;j<arr.length;j++){
if(arr[i]>arr[j])
{
arr[i]=arr[i]^arr[j];
arr[j]=arr[i]^arr[j];
arr[i]=arr[i]^arr[j];
}
}
}

}
}

