import java.util.*;
//对数组的操作
//已知一个数组int[] arr = {0,1,4,0,6,0,7,8,9,0,0,4}; ,要求去掉数组内的0，返回一个无零的新数组

public class Demo5{
public static void main(String[] args){
int[] arr = {0,1,4,0,6,0,7,8,9,0,0,4};
int count=0;//统计0的个数
for(int i :arr){
if(i==0){
count++;
}
}
String a1 = Arrays.toString(arr);
System.out.println(a1);

int[] newarr = new int[arr.length-count];
int index = 0;//记录新数组的索引值
for(int i:arr){
if(i!=0){
newarr[index] = i;
index++;
}
}
String a2 = Arrays.toString(newarr);
System.out.println(a2);

}

}


