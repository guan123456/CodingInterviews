package offer03;

public class inSitu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//这种方法并不能够输出“第一个重复的数字”
	//因为有可能在开始交换的时候把一个还没遍历过的元素交换到了正确的位置
	//当下一次第一次遍历这个元素时发现它已经在正确的位置，故而交换，实际上它还没有被遍历过
	//故而它可能不是第一组重复的元素
	public int findRepeatNumber03(int[] nums) {
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
		//从头到尾遍历数组
		for(int i = 0; i < nums.length; ++i) {
			//运用辅助变量以方面交换
			int temp;
			//如果下标为i的元素值num[i]不等于下标i
			while(nums[i] != i) {
				//如果下标为i的元素值num[i]等于下标为num[i]所存储的元素值num[num[i]]
				//说明有重复元素，直接返回即可
				if(nums[i] == nums[nums[i]]) {
					return nums[i];
				}
				//否则进行交换
				temp = nums[i];
				nums[i] = nums[nums[i]];
				nums[nums[i]] = temp;
			}
		}
		//进行到这一步说明没有重复元素，则返回-1
		System.out.println("数组中无重复数字！");
		return -1;
	}

}
