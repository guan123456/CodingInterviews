package offer65;
/**
* @author 作者:guan
* @createDate 创建时间：Feb 15, 2021 12:43:15 PM
*/
public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int add(int num1, int num2) {
		while(num2 != 0) {
			int sum = num1 ^ num2;
			int carry = (num1 & num2) << 1;
			num1 = sum;
			num2 = carry;
		}
		return num1;
	}

}
