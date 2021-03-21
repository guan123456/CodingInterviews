package offer39;

public class MoreThanHalfNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	boolean isInputInvalid = true;
	
	//方法一
	public int MoreThanHalfNum_Solution(int[] array) {
		if(array == null || array.length <= 0) {
			return 0;
		}
		int low = 0;
		int high = array.length - 1;
		int index = partition(array,low,high);
		//找到中位数index = n/2
		while(index != array.length >> 1) {
			if(index < array.length >> 1) {
				low = high + 1;
				index = partition(array, low, high);
			}
			else {
				high = index - 1;
				index = partition(array, low, high);
			}
		}
		//判断次数是否超过一半
		int num = array[index];
		int times = 0;{
			for(int i = 0; i < array.length; i++) {
				if(array[i] == num) {
					times++;
				}
			}
			if(times * 2 > array.length) {
				isInputInvalid = false;
				return num;
			}
		}
		return 0;
	}
	
	private int partition(int[] array, int low, int high) {
		int pivotKey = array[low];
		//(x)这种方式实现的快速排序也可以哦，演示一遍就行了
		//(x)这种改进的快速排序在最后循环退出的时候low是在n/2附近，nice!
		//(x)但是如果是正常那种大概率low不是在n/2附近
		//temp的意义何在？
		//还不如这种方式
		/**
		 * 
		 * 	while(low < high) {
			while(low < high && array[high] >= pivotKey) {
				high--;
			}
			array[low] = array[high];
			while(low < high && array[low] <= pivotKey) {
				low++;
			}
			array[high] = array[low];
		}
		//Don't forget
		array[low] = pivotKey;
		 */
		while(low < high) {
			while(low < high && array[high] >= pivotKey) {
				high--;
			}
			int temp = array[low];
			array[low] = array[high];
			array[high] = temp;
			while(low < high && array[low] <= pivotKey) {
				low++;
			}
			temp = array[low];
			array[low] = array[high];
			array[high] = temp;
		}
		
		return low;
	}
	
	//方法2
	public int MoreThanHalfNum_Solution2(int[] array) {
		if(array == null || array.length <= 0) {
			return 0;
		}
		int num = array[0];
		int count = 1;
		for(int i = 1; i < array.length; i++) {
			if(count == 0) {
				num = array[i];
				count++;
			}
			else if(array[i] == num) {
				count++;
			}
			else {
				count--;
			}
		}
		if(count > 0) {
			int times = 0;
			for(int i = 0; i < array.length; i++) {
				if(array[i] == num) {
					times++;
				}
			}
			if(times * 2 > array.length) {
				isInputInvalid =false;
				return num;
			}
		}
		return 0;
	}
}
