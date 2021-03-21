package offer43;
/**
* @author 作者:guan
* @createDate 创建时间：Feb 5, 2021 1:32:22 PM
*/
public class NumberOf1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int NumberOf1Between_1_And_N_Solution(int n) {
		int count = 0;
		for(int i = 1; i <= n; i *= 10) {
			int high = n / (i * 10);
			int low = (n % i);
			int cur = (n / i) % 10;
			if(cur == 0) {
				count +=high * i;
			}
			else if(cur == 1) {
				count += high * i + (low + 1);
			}
			else {
				count += (high + 1) * i;
			}
		}
		return count;
	}
}
