package offer51;

import java.nio.channels.NonWritableChannelException;

/**
* @author 作者:guan
* @createDate 创建时间：Feb 9, 2021 12:48:16 PM
*/
public class InversePairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//牛客网上要将count对1000000007取模才能通过
	public static int inverseParis(int[] array) {
		if(array == null || array.length <= 0) {
			return 0;
		}
		int count = getCount(array,0,array.length - 1);
		return count;
	}
	
	private static int getCount(int[] array,int start,int end) {
		if(start >= end) {
			return 0;
		}
		int mid = (end + start) >> 1;
		//递归计算左子区域的逆序对数
		int left = getCount(array, start, mid);
		//递归计算右子区域的逆序对数
		int right = getCount(array, mid + 1, end);
		
		//合并
		int count = 0;
		int i = mid;//左边区域的指针，默认指向结尾
		int j = end;//右边区域的指针，默认指向结尾
		int[] temp = new int[end - start + 1];//临时区域
		//辅助数组需要从后往前加入数据，也就是从大到小
		int k = end - start;
		while(i >= start && j >= mid + 1) {
			//情况一
			if(array[i] > array[j]) {
				count +=(j-mid);
				temp[k--] = array[i--];
			}
			//情况二
			else {
				temp[k--] = array[j--];
			}
		}
		//当左子区域元素未空，也就是右子区域元素已空
		while(i >= start) {
			temp[k--] = array[i--];
		}
		//当右子区域元素未空，也就是左子区域元素已空
		while(j >= mid + 1) {
			temp[k--] = array[j--];
		}
		//将辅助数组的值加入到原来数组，该数组已排好序
		for(k = 0; k < temp.length; k++) {
			array[k + start] = temp[k];
		}
		//输出总数
		return count+left+right;
	}
}
