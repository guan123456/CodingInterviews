package offer57;
/**
* @author 作者:guan
* @createDate 创建时间：Feb 12, 2021 5:55:30 PM
*/

import java.util.ArrayList;

public class TwoNumbersWithSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//注意点，如果题目要求输出乘机最小的两个数，那么不要被误导，因为最外层乘机最小
	public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum){
		ArrayList<Integer> list = new ArrayList<>();
		if(array == null || array.length <= 0) {
			return list;
		}
		int low = 0;
		int high = array.length - 1;
		while(low < high) {
			if(array[low] + array[high] == sum) {
				list.add(array[low]);
				list.add(array[high]);
				break;
			}
			else if(array[low] + array[high] < sum) {
				low++;
			}
			else {
				high--;
			}
		}
		return list;
	}
	//如果要输出乘机最大的两个数，那么可以将上面代码进行以下修改
	public ArrayList<Integer> FindNumbersWithSum_1(int[] array, int sum){
		ArrayList<Integer> list = new ArrayList<>();
		if(array == null || array.length <= 0) {
			return list;
		}
		int low = 0;
		int high = array.length - 1;
		int multiply = 0;
		while(low < high) {
			if(array[low] + array[high] == sum) {
				if(multiply <array[low] * array[high]) {
					multiply = array[low] * array[high];
					list.clear();
					list.add(array[low]);
					list.add(array[high]);
				}
				low++;
				high--;
			}
			else if(array[low] + array[high] < sum) {
				low++;
			}
			else {
				high--;
			}
		}
		return list;
	}
}
