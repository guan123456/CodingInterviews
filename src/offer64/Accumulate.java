package offer64;
/**
* @author 作者:guan
* @createDate 创建时间：Feb 15, 2021 12:37:47 PM
*/
public class Accumulate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int getSum(int n) {
		int sum = n;
		boolean flag = (n > 1) && ((sum += getSum(n-1)) > 0);
		return sum;
	}
}
