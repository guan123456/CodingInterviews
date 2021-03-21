package offer11;

public class MinNumberInRotateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinNumberInRotateArray demo = new MinNumberInRotateArray();
		demo.test1();
        demo.test2();
        demo.test3();
        demo.test4();
        demo.test5();
        demo.test6();
        demo.test7();

	}

	//可使用二分法进行查找
	//查找旋转数组的最小值
	public int minArray(int[] array) {
		//如果数组不合法，直接返回-1
		if (array == null || array.length <= 0) {
			return -1;
		}
		int low = 0;
		int high = array.length - 1;
		int mid = low + ((high-low)>>1);
		//升序数组,直接返回第一个元素即可
		if(array[low] < array[high]) {
			return array[low];
		}
		//中间数字与首尾相等，需要顺序遍历
		//这种情况数组的值只有两种情况，所以只要找到有更小的值，返回即可
		if(array[mid] == array[high] && array[mid] == array[low]) {
			for(int i = 1; i <= high; i++) {
				if(array[i] < array[i - 1]) {
					return array[i];
				}
			}
			return array[low];
		}
		//其他情况，也就是普遍情况
		while(low < high) {
			//如果到了high是后部分排序数组的第一个元素的下标
			//则直接break，跳出while循环，后返回即可
			if(high - low == 1) {
				break;
			}
			//
			mid = low + ((high-low)>>1);
			//这里是二分查找的一点改进，保留mid元素查询
			if(array[mid] <= array[high]) {
				high = mid;
			}else {
				low = mid;
			}
		}
		return array[high];
	}
	
	//给定值，查找旋转数组中是否存在该值
	public int search (int[] A, int target) {
        if(A==null) return -1;
        int left = 0;
        int right = A.length-1;
        //不存在重复
        while (left<=right){
            int mid = (right-left)/2+left;
            if (A[mid]==target) return mid;
            else if(A[mid]<A[right]){
                if (target>A[mid] && target<=A[right]){
                    left = mid+1;
                }else {
                    right= mid-1;
                }
            }else {
                if(target>=A[left] && target<A[mid]){
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            }
        }
        return -1;
    }
    // =======测试代码======
    public void test1() {
        int[] array = null;
        System.out.println("test1:" + minArray01(array));
    }
 
    public void test2() {
        int[] array = {};
        System.out.println("test2:" + minArray01(array));
    }
 
    public void test3() {
        int[] array = { 1 };
        System.out.println("test3:" + minArray01(array));
    }
 
    public void test4() {
        int[] array = { 1, 2, 3, 4, 5, 6 };
        System.out.println("test4:" + minArray01(array));
    }
 
    public void test5() {
        int[] array = { 2, 2, 2, 2, 1, 2 };
        System.out.println("test5:" + minArray01(array));
    }
 
    public void test6() {
        int[] array = { 2, 1, 2, 2, 2, 2 };
        System.out.println("test6:" + minArray01(array));
    }
 
    public void test7() {
        int[] array = { 6, 6, 8, 9, 10, 1, 2, 2, 3, 3, 4, 5, 6 };
        System.out.println("test7:" + minArray01(array));
    }
	
    /**
     * 大佬代码加个人改进
     * 注意
     * 1.使用low = mid + 1，而不是 low = mid，最终会使得low = high(即最小值位置)，而跳出循环
     * 2.使用high = mid，而不是high = mid - 1，因为有可能mid就是最小值点，不能减1
     * 3.升序数组的情况可以直接在循环中一起搞定，不用单独列出来判断
     * 增加点
     * 1.增加了null的判断
     * 2.程序只有在array[low] == array[mid] && array[high] == array[high]时顺序查找，其余情况都可二分法
     * @param array
     * @return
     */
    public int minArray01(int[] array) {
    	if(array == null || array.length <= 0) {
    		return 0;
    	}
    	int low = 0;
    	int high = array.length - 1;
    	int mid = low + (high - low) / 2;
    	//中位数与首位相等
    	if(array[low] == array[mid] && array[high] == array[high]) {
    		for(int i = 1; i <= high; i++) {
    			if(array[i] < array[i - 1]) {
    				return array[i];
    			}
    		}
    		return array[low];
    	}
    	
    	while(low < high) {
    		int mid1 = low + (high - low) / 2;
    		if(array[mid1] > array[high]) {
    			low = mid1 + 1;
    		}
    		else {
    			high = mid1;
    		}
    	}
    	
    	return array[low];
    }
    
}
