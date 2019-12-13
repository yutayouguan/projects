package ml.yike.insertion_sort;

public class Instertion_Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 12, 23, 45, 65, 1, 2, 4, 9, 6, 8, 3, 15, 7 };
		arr = intertionSort(arr);
		System.out.println("插入排序后数组：" + toString(arr));
	}

	private static int[] intertionSort(int[] arr) {
		// TODO Auto-generated method stub
		// 默认第一个数已经排好序，
		int j = 0;
		for (int i = 1; i < arr.length; i++) // 第一个元素认为已经被排序,进行len-1次次扫描，依次向正序中插入len-1个数
		{
			int temp = arr[i];

			// //每趟要插入的a[i]先取出来。
		
			for (j = i - 1; arr[j] > arr[i] && j >= 0; j--) // 在已经是正序中从右向左扫描，找到arr[i]插入的位置
			{
				arr[j + 1] = arr[j];
				// //依次把比需要插入的arr[i]大的数向后移动
			}
			arr[j + 1] = temp;
			// //把需要插入的arr[i]插入到已经找到的位置。这里为什么是J+1？因为上面跳出循环时执行了j--
		}

		return arr;

	}

	private static String toString(int[] arr) {
		// TODO Auto-generated method stub
		String s = null;
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				s = "[" + arr[i] + ",";
			} else if (i == arr.length - 1) {

				s += arr[i] + "]";
			} else {
				s += arr[i] + ",";
			}
		}
		return s;
	}
}
