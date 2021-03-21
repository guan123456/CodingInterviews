package offer03;

import java.util.HashSet;
import java.util.Set;

/**
 * （1）上传本地工程到Github
 *     http://www.cnblogs.com/yc-755909659/p/3753626.html。
 *（2）从Github同步工程到本地仓库
 *     http://blog.sina.com.cn/s/blog_4fb490ff010142jw.html
 * @author 11976
 *
 */

public class hashTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int findRepeatNumber02(int[] nums) {
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
		//用set来辅助判断是否有重复元素
		Set<Integer> set = new HashSet<Integer>();
		
		//从头到尾遍历数组
		for(int i = 0; i < nums.length; ++i) { //Execute n times
			//如果set中有该元素则直接返回该元素即可
			if(set.contains(nums[i])) {
				return nums[i];
			}
			//否则将该元素加入set中
			set.add(nums[i]);
		}
		//执行到这一步说明没有重复元素，直接返回-1即可
		System.out.println("数组中无重复数字！");
		return -1;
	}

}
