package offer61;

import java.util.Arrays;

/**
* @author 作者:guan
* @createDate 创建时间：Feb 15, 2021 11:08:04 AM
*/
public class ContinousCards {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isContinous(int[] numbers) {
		if(numbers == null || numbers.length <= 0) {
			return false;
		}
		Arrays.sort(numbers);
		int numberOf0 = 0;
		int numberOfGap = 0;
		//统计数组中0的个数
		for(int i = 0; i < numbers.length; i++) {
			if(numbers[i] == 0) {
				numberOf0++;
			}
		}
		//计算数组中的间隔个数
		int small = numberOf0;
		int big =  numberOf0+1;
		while(big < numbers.length) {
			//两个数想得，有对子，不可能是顺子
			if(numbers[small] == numbers[big]) {
				return false;
			}
			//下面语句相当于
			//numberOfGap += numbers[big] - numbers[small] - 1
			//small = big; 也就是++small
			//++big
			numberOfGap += numbers[big++] - numbers[small++] - 1;
		}
		if(numberOf0 >= numberOfGap) {
			return true;
		}
		return false;
	}
}
