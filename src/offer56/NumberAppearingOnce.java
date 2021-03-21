package offer56;
/**
* @author 作者:guan
* @createDate 创建时间：Feb 11, 2021 3:54:27 PM
*/
public class NumberAppearingOnce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int findNumberAppearingOnce(int[] arr) {
		if(arr == null || arr.length <= 0) {
			throw new RuntimeException();
		}
		int[] bitSum = new int[32];
		//最大三十二位，每一位和大小默认为0
		for(int i = 0; i < 32; i++) {
			bitSum[i] = 0;
		}
		//把每个数字的每一位相加
		for(int i = 0; i < arr.length; i++) {
			int bitMask = 1;
			for(int j = 31; j >=0; j--) {
				//注意arr[i]&bitMask不一定等于1或者0，有可能等于00010000
				int bit = arr[i] & bitMask;
				if(bit != 0) {
					bitSum[j]+=1;
				}
				bitMask = bitMask << 1;
			}
		}
		//找目标数
		int result = 0;
		for(int i = 0; i < 32; i++) {
			result = result << 1;
			result += (bitSum[i] % 3);
		}
		//返回目标数
		return result;
	}

}
