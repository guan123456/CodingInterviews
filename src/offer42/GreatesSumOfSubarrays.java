package offer42;

import java.util.Scanner;

/**
* @author 作者:guan
* @createDate 创建时间：Feb 5, 2021 1:04:31 PM
*/
public class GreatesSumOfSubarrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			String string = scanner.nextLine();
			String[] strArray = string.split(", ");
			int[] array = new int[strArray.length];
			for(int i = 0; i < strArray.length; i++) {
				array[i] = Integer.parseInt(strArray[i]);
			}
			System.out.println(FindGreatesSumOfSubArray(array));
		}
	}

	static boolean InvalidInput = false;
	public static int FindGreatesSumOfSubArray(int[] array) {
		if(array == null || array.length <= 0) {
			InvalidInput = true;
			return 0;
		}
		InvalidInput = false;
		int sum = array[0];
		int maxSum = array[0];
		for (int i = 1; i < array.length; i++) {
			if(sum < 0) {
				sum = array[i];
			}else {
				sum += array[i];
			}
			if(sum > maxSum) {
				maxSum = sum;
			}
		}
		return maxSum;
	}
}
