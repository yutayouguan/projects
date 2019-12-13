import java.util.*;

public class Demo3{
public static void main(String[] args)
{
int[] arr = {12,23,34,56,32,43,12,32};
String nums = Arrays.toString(arr);//遍历数组
System.out.println(nums);
Arrays.sort(arr);//排序
nums = Arrays.toString(arr);
System.out.println(nums);
int index = Arrays.binarySearch(arr,33);//二分查找法，必须排好序 找不到后返回（-插入点-1）//-6
System.out.println("索引值为"+index);
}
}
