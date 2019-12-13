public class Demo9{
public static void main(String[] args){
int[] arr = {12,23,12,3,4,5,67,78,34,89,45,54,56,12};
int index = searchEle(arr,12);
System.out.println("元素的索引值为："+index);


}

public static int searchEle(int[] arr,int num)
{
for(int i= 0;i<arr.length;i++){
if(arr[i]==num)
return i;
}
return -1;
}

}
