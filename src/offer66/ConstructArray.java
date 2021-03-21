package offer66;
/**
* @author 作者:guan
* @createDate 创建时间：Feb 15, 2021 12:50:41 PM
*/
public class ConstructArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] multiply(int[] A) {
		if(A == null || A.length < 2) {
			return null;
		}
		int[] B = new int[A.length];
		B[0] = 1;
		//先计算并保存左半部分为B[i]
		for(int i = 1; i < A.length; i++) {
			B[i] = B[i - 1] * A[i - 1];
		}
		int temp = 1;
		//然后计算后半部分顺便把与之前保存的B[i]相乘可得到最终的B[i]
		for(int i = A.length - 2 ; i >=0; i--) {
			temp *= A[i + 1];
			B[i] *= temp;
		}
		return B;
	}

}
