public class Demo7{
public static void main(String[] args){
int[] arr = {12,34,11,78,23,43,21,67,89,3,21,9};
selectSort(arr);
traversing(arr);
ascending(arr);
traversing(arr);
}
//选择排序
public static void selectSort(int[] arr){
for(int i =0; i<arr.length-1;i++){
for(int j=i+1;j<arr.length;j++){
if(arr[j]>arr[i])
{
arr[i] = arr[i]^arr[j];
arr[j] = arr[i]^arr[j];
arr[i] = arr[j]^arr[i];
}
}
}
}
//遍历数组
public static void traversing(int[] arr){
System.out.print("排序结果为：");
for(int i= 0;i<arr.length;i++)
System.out.print(arr[i]+"->");
System.out.println(" ");

}
//改为升序
public static void ascending(int[] arr){
int j = arr.length-1;
for(int i = 0;i<=(arr.length-1)/2;i++){

arr[i] = arr[i]^arr[j];
arr[j] = arr[i]^arr[j];
arr[i] = arr[i]^arr[j];
j--;


}

}



}
