package offer53;
/**
* @author 作者:guan
* @createDate 创建时间：Feb 10, 2021 5:01:07 PM
*/
public class MissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int getMissingNumber(int[] arr) {
		if(arr == null || arr.length <= 0) {
			return -1;
		}
		int low = 0;
		int high = arr.length - 1;
		while(low <= high) {
			int mid = low+((high-low)>>1);
		    //当中间数字不等于其下标时
			if(arr[mid] != mid) {
				//如果中间数字的前一个数字等于其下标，则说明中间数字的下标即为我们所要找的数字
				if(mid == 0 || arr[mid - 1] == mid - 1) {
					return mid;
				}
				//如果中间数字的前一个数字也不等于其下标，则在前半部分查找
				else {
					high = mid - 1;
				}
			}
			//当中间数字等于其下标时，我们在后半部分查找；
			else {
				low = mid + 1;
			}
		}
		if(low == arr.length) {
			return low;
		}
		return -1;
	}
	//另外一种很巧妙的解法，这种在没排序好的数组效果很明显!!!
    public int solve (int[] a) {
        // write code here
        int length = a.length;
        int total = (length*(length+1))/2;
        int sum = 0;
        for(int i = 0; i < length; i++){
            sum += a[i];
        }
        return total-sum;
    }
}
