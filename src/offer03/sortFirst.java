package offer03;

import java.util.Arrays;

public class sortFirst {
	public int findRepeatNumber01(int [] nums) {
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
		//调用Arrays.sort()函数对数组进行排序
		Arrays.sort(nums);
		//遍历排序后的数组
		for(int i = 1; i < nums.length; ++i) { //execute n-1 times
			//当前元素与上一个元素相等就返回
			if(nums[i] == nums[i - 1]) {
				return nums[i];
			}
		}
		//进行到这一步说明无重复元素，直接返回-1即可
		System.out.println("数组中无重复数字！");
		return -1;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
