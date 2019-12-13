/*
二维数组：数组中的数组
一根烟    变量
一盒烟    一维数组
一条烟    二维数组

格式：数据类型[][] 变量名 = new 数据类型[长度1][长度2]
eg:  int[][] arr = new int[3][5];
*/
//需求：定义一个二维数组的偶数的总和

public class Demo4{
public static void  main(String[] args){
int[][] arr = {{12,34,56,78,9,1},{12,34,56},{354,56,343},{334,55,45,655,78},{234,45,434,545,56,34}};
int sum = 0;
System.out.println("数组长度："+arr.length);
System.out.println("偶数总和为:");
for(int i = 0;i<arr.length;i++)
{
for(int j=0;j<arr[i].length;j++){
if(arr[i][j]%2==0)
{
sum+=arr[i][j];
System.out.print(arr[i][j]+"+");
}
}
}

System.out.println("="+sum);

}



}
