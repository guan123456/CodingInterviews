package offer56;
/**
* @author 作者:guan
* @createDate 创建时间：Feb 11, 2021 3:41:27 PM
*/
public class NumbersAppearOnce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
		if(array == null || array.length < 2) {
			return;
		}
		int resultExclusiveOR = 0;
		for(int i = 0; i < array.length; i++) {
			resultExclusiveOR ^= array[i];
		}
		
		int indexOf1 = 0;
		while(((resultExclusiveOR & 1) == 0) && (indexOf1 <= 4 * 8)) {
			resultExclusiveOR = resultExclusiveOR >> 1;
		    indexOf1++;
		}
		num1[0] = 0;
		num2[0] = 0;
		for(int i = 0; i < array.length; i++) {
			if(((array[i] >> indexOf1) & 1) == 1) {
				num1[0] ^= array[i];
			}
			else {
				num2[0] ^= array[i];
			}
		}
		
	}
	//这种方式好简单啊!!!
	public static void printOddTimesNum(int[] arr) {
		int eor = 0;
		for(int i = 0; i < arr.length; i++) {
			eor ^= arr[i];
		}
		int rightOne = eor & (~eor + 1);
		int onlyOne = 0;
		for(int i = 0; i < arr.length; i++) {
			if((arr[i] & rightOne) != 0) {
				onlyOne ^= arr[i];
			}
		}
		System.out.println(onlyOne + " " + (eor ^ onlyOne));
	}
}
