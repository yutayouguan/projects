import java.util.*;
public class Demo8{
public static void main(String[] args){

int[] arr = new int[12];

Scanner input = new Scanner(System.in);
int i =0;
while(i<arr.length)
{
  arr[i] = input.nextInt();
i++;
}
bubbleSort(arr);
traversing(arr);


}
//冒泡排序
public static void bubbleSort(int[] arr){
for(int i=0;i<arr.length-1;i++){
for(int j=0;j<arr.length-1-i;j++){
if(arr[j]>arr[j+1])
{
arr[j] = arr[j]^arr[j+1];
arr[j+1] = arr[j]^arr[j+1];
arr[j] = arr[j]^arr[j+1];
}
}
}
}
//遍历数组
public static void traversing(int[] arr){
for(int i = 0;i<arr.length;i++){
System.out.print(arr[i]+"->");

}
System.out.println(" ");
}
}
