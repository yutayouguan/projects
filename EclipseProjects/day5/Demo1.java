/*
 * @Descripttion: 功能描述
 * @version: 1.0
 * @Author: yike
 * @Date: 2019-08-19 15:52:38
 * @LastEditors: yike
 * @LastEditTime: 2019-08-24 13:09:34
 */

//折半查找
import java.util.*;
import java.io.*;

public class Demo1 {
    public static void main(String[] args) {
        int[] arr = { 12, 14, 16, 19, 21, 25, 45, 67, 89 };
        // int index = searchEle(arr,21);
        int index = selfSearch(arr, 21);
        System.out.println("元素所在的索引值是：" + index);
    }

    /*
     * public static int searchEle(int[] arr,int target){ for(int i= 0;
     * i<arr.length;i++) { if(arr[i]==target) { return i; }
     *
     *
     * }
     *
     *
     * return -1;
     *
     * }
     */
    public static int selfSearch(int[] arr, int target) {
        int max = arr.length - 1;
        int min = 0;
        int mid = (min + max) / 2;

        while (true) {
            if (arr[mid] > target) {
                max = mid - 1;

            } else if (arr[mid] < target) {
                min = mid + 1;
            } else {
                return mid;// 找到了
            }
            // 当不存在时,不管左边还是右边找不到都会出现max<min
            if (min > max) {
                return -1;

            }
            // 从新计算中间索引值
            mid = (min + max) / 2;
        }
    }
}
