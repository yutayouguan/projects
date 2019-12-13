package ml.yike.bubble_sort;

/**
 * @author wangmeng
 * @version 1.0
 */
public class Bubble_Sort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 12, 23, 45, 65, 1, 2, 4, 9, 6, 8, 3, 15, 7 };
		arr = bubbleSort(arr);
		System.out.println("冒泡排序后数组：" + toString(arr));
	}

	/**
	 * @param arr
	 * @return arr
	 */
	public static int[] bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					arr[j] = arr[j] ^ arr[j + 1];
					arr[j + 1] = arr[j] ^ arr[j + 1];
					arr[j] = arr[j] ^ arr[j + 1];
				}
			}
		}
		return arr;
	}

	/**
	 * @param arr
	 * @return arr
	 */
	public static String toString(int[] arr) {
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