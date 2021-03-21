package offer03;

//不一定能够找到所有的重复元素
//在一个长度为n+1的数组里的所有数字都在1到n的范围内，所以数组中至少有一个数字是重复的。
public class nonchangeArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int FindRepeatNumbers04(int[] nums) {
		//判断数组是否有效，无效则返回-1
		if(nums == null || nums.length <= 0) {
			System.out.println("数组输入无效！");
			return -1;
		}
		//判断数组中存储的数字是否都合法，只要有不合法则返回-1
		for(int a:nums) {
			if(a < 0 || a > nums.length -1) {
				System.out.println("数字大小超出范围");
				return -1;
			}
		}
		//所有数字的范围都在1~n，所以low从1开始
		//数字总数为n+1，所以high从nums.length-1开始
		//二分计算查找
		int low = 1;
		int high = nums.length - 1;
		int mid, count;
		while(low <= high) {
			mid = ((high - low) >> 1) + low;//分两半
			count = countRange(nums,low,mid);//先看看前半部分是否含有重复的
			if(low == high) {//到最后最小下标与最大下标指向同一个位置，则表示检查完成
//					if(count > 1) {
//						return low;
//					}
//					else {
//						break;
//					}
					//因为一定存在，其实以上可修改为以下
				return low;
			}
			//如值范围在1~mid的个数count大于mid-low+1
			//说明在前面部分重复，则在前面部分找
			if(count > mid - low + 1) {
				high = mid;
			}
			else {
				low = mid + 1;//否则在后面部分查找
			}

		}
		//进行到这一步说明没有重复元素，其实题目意思根本可能到这一步
		return -1;

	}
	public int countRange(int[]nums,int low,int high) {
		//如果数组不合法，则直接返回0，一般不存在这种情况
		if(nums == null) {
			return 0;
		}
		
		int count = 0;
		//遍历的是整个数组
		//计算数组中元素值在low~high的个数
		for(int a: nums) {
			if(a >= low && a <=high) {
				count++;
			}
		}
		return count;
	}
}
