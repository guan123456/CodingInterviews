package offer53;
/**
* @author 作者:guan
* @createDate 创建时间：Feb 10, 2021 4:37:20 PM
*/
public class NumberOfK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int GetNumberOfK(int[] array, int k) {
		if(array == null || array.length <= 0) {
			return 0;
		}
		int firstK = getFirstK(array,0,array.length - 1,k);
		if(firstK == -1) {
			return 0;
		}
		int lastK = getLastK(array,firstK,array.length - 1,k);
		return lastK - firstK + 1;
	}
	
	private int getFirstK(int[] arr, int start, int end,int k) {
		if(start > end) {
			return -1;
		}
		int mid = (start + end )>>1;
		if(arr[mid] == k) {
			if(mid == 0 || arr[mid - 1] != k) {
				//找到了第一个等于k的元素,或到了数组最前面
				return mid;
			}
			else {
				//该元素等于k，但不是第一个
				end = mid - 1;
			}
			//第一个等于k的元素在当前元素的后面
		}else if(arr[mid] < k) {
			start = mid + 1;
		}else {
			//第一个等于k的元素在当前元素的前面
			end = mid - 1;
		}
		//递归调用
		return getFirstK(arr, start, end, k);
	}
	
	private int getLastK(int[] arr, int start, int end, int k) {
		if(start > end) {
			return -1;
		}
		int mid = (start + end) >> 1;
		if(arr[mid] == k) {
			if(mid == arr.length - 1 || arr[mid + 1] != k) {
				//找到了最后一个等于k的元素,或到了数组最后面
				return mid;
			}
			else {
				//该元素等于k，但不是最后一个
				start = mid;
			}
			//最后一个等于k的元素在当前元素的后面
		}else if(arr[mid] < k) {
			start = mid + 1;
		}
		else {
			//最后一个等于k的元素在当前元素的前面
			end = mid - 1;
		}
		//递归调用
		return getLastK(arr, start, end, k);
	}
	
	public int GetNumberOfK_1(int[] arr, int k) {
		if(arr == null || arr.length <= 0) {
			return 0;
		}
		int first = getLoc(arr, k, k - 0.5);
		int last = getLoc(arr, k, k + 0.5);
		return last - first;
	}
	
	private int getLoc(int[] arr, int k, double m) {
		int start = 0;
		int end = arr.length - 1;
		while(start <= end) {
	        int mid=(start+end)>>1;
	        if(arr[mid]>m){
	            end=mid-1;
	        }else{
	            start=mid+1;
	        }
		}
		return start;
	}
}
