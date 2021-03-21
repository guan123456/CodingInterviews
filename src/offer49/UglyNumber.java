package offer49;
/**
* @author 作者:guan
* @createDate 创建时间：Feb 8, 2021 1:15:01 PM
*/
public class UglyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * 维持三个指针来记录当前乘以2、乘以3、乘以5的最小值，
	 * 然后当其被选为新的最小值后，要把相应的指针+1；
	 * 因为这个指针会逐渐遍历整个数组，因此最终数组中的每一个值都会被乘以2、乘以3、乘以5，
	 * 也就是实现了我们最开始的想法，只不过不是同时成乘以2、3、5，而是在需要的时候乘以2、3、5.
	 */
	public int GetUgly_Solution(int index) {
		if(index <= 0) {
			return 0;
		}
		int[] UglyNumbers = new int[index];
		UglyNumbers[0] = 1;
		int index2 = 0;
		int index3 = 0;
		int index5 = 0;
		for(int i = 1; i < index; i++) {
			UglyNumbers[i] = getMinimum(UglyNumbers[index2] * 2,UglyNumbers[index3] * 3, UglyNumbers[index5] * 5);
			while(UglyNumbers[index2] * 2 == UglyNumbers[i]) {
				index2++;//为了防止重复需要三个if都能够走到
			}
			while(UglyNumbers[index3] * 3 == UglyNumbers[i]) {
				index3++;//为了防止重复需要三个if都能够走到
			}
			while(UglyNumbers[index5] * 5 == UglyNumbers[i]) {
				index5++;//为了防止重复需要三个if都能够走到
			}
		}
		return UglyNumbers[index - 1];
	}
	
	private int getMinimum(int a, int b, int c) {
		if(a > b) {
			a = b;
		}
		if(a > c) {
			a = c;
		}
		return a;
	}
	
	//效率低的方式
	public int GetUglyNumber_Solution_1(int index) {
		if(index <= 0) {
			return 0;
		}
		int number = 1;
		int count = 0;
		while(true) {
			if(isUgly(number)) {
				count++;
			}
			if(count == index) {
				return number;
			}
			number++;
		}
	}
	
	private boolean isUgly(int number) {
		while(number % 5 == 0) {
			number /= 5;
		}
		while(number % 3 == 0) {
			number /= 3;
		}
		while(number % 2 == 0) {
			number /= 2;
		}
		return number == 1;
	}
}
