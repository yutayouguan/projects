package ml.yike.selection_sort;

/**
 * @author wangmeng
 *
 */
public class Selection_Sort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 12, 23, 45, 65, 1, 2, 4, 9, 6, 8, 3, 15, 7 };
		arr = selectionSort(arr);
		System.out.println("选择排序后数组：" + toString(arr));
	}

	/**
	 * @param arr
	 * @return arr
	 */
	private static int[] selectionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int minIndex = i; // 记录最小值的索引，默认第一个为最小值
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[minIndex] > arr[j]) { // 找到最小值的索引
					minIndex = j;
				}
			}
			if (minIndex != i) {// 没有找到则不交换

				arr[i] = arr[i] ^ arr[minIndex];
				arr[minIndex] = arr[i] ^ arr[minIndex];
				arr[i] = arr[i] ^ arr[minIndex];

			}
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
