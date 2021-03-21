package offer53;
/**
* @author 作者:guan
* @createDate 创建时间：Feb 10, 2021 5:11:16 PM
*/
public class IntegerIdenticalToIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int getNumberSameAsIndex(int[] arr) {
		if(arr == null || arr.length <= 0) {
			return -1;
		}
		int low = 0;
		int high = arr.length - 1;
		while(low <= high) {
			int mid = (high + low)>>1;
			if(arr[mid] > mid) {
				high = mid - 1;
			}
			else if(arr[mid] < mid) {
				low = mid + 1;
			}
			else {
				return mid;
			}
		}
		return -1;
	}
}
