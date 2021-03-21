package offer21;

import java.util.Arrays;

public class ReorderArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ReorderArray demo = new ReorderArray();
        demo.test1();
        demo.test2();
        demo.test3();
        demo.test4();
        demo.test5();
        demo.test6();
        demo.test7();
	}
	/**
	 * 牛客网上这种方法不同，因为它不能保证原数字相对位置不变
	 * 首尾双指针
	 * @param array
	 */
	

	public void reOrderArray(int[] array) {
		if(array == null || array.length == 0) {
			return;
		}
		
		int length = array.length;
		int low = 0;
		int high = length - 1;
		int temp;
		
		while(low < high) {
			//向后移动low指针，直到它指向偶数,也就是array[high] & 1) == 0
			while(low < length && (array[low] & 1) != 0) {
				low++;
			}
			//向前移动high指针，直到它指向奇数
			while(high >= 0 && (array[high] & 1) == 0) {
				high--;
			}
			if(low < high) {
				temp = array[low];
				array[low] = array[high];
				array[high] = temp;
			}
		}
	}
	
	/**
	 * 牛客网上这种方法不同，因为它不能保证原数字相对位置不变
	 * 保证原序则不能使用交换，可以使用插入
	 * 快慢双指针
	 * @param array
	 */
	
	public void reOrderArray2(int[] array) {
		if(array == null || array.length == 0) {
			return;
		}
		
		int length = array.length;
		int low = 0;
		int fast = 0;
		int temp = 0;
		
		for(fast = 0; fast < length; fast++) {
			if((array[fast] & 1) != 0) {
				temp = array[fast];
				array[fast] = array[low];
				array[low] = temp;
				low++;
			}
		}
	}
	
	/*
	 * 附加要求：保证调整后的数组中，奇数和奇数之间，偶数和偶数之间的相对位置不变。
	 * 采用类似直接插入排序算法
	 */
	
	public void reOrderArray3(int[] array) {
		if(array == null || array.length == 0) {
			return;
		}
		int length = array.length;
		int temp;
		int j;
		for(int i = 1; i < length; i++) {
			if((array[i] & 1) != 0) {
				j = i;
				temp = array[j];
				while((j > 0) && (array[j - 1] & 1) == 0) {
					array[j] = array[j - 1];
					j--;
				}
				array[j] = temp;
			}
		}
	}
	
    //===============测试代码===================
    void test1() {
        int[] array = null;
        System.out.println("原始数组："+Arrays.toString(array));
        reOrderArray2(array);
        System.out.println("调整结果："+Arrays.toString(array));
        System.out.println();
    }
     
    void test2() {
        int[] array = {};
        System.out.println("原始数组："+Arrays.toString(array));
        reOrderArray2(array);
        System.out.println("调整结果："+Arrays.toString(array));
        System.out.println();
    }
     
    void test3() {
        int[] array = {-2,4,-6,1,-3,5};
        System.out.println("原始数组："+Arrays.toString(array));
        reOrderArray2(array);
        System.out.println("调整结果："+Arrays.toString(array));
        System.out.println();
    }
     
    void test4() {
        int[] array = {-1,3,-5,2,-4,6};
        System.out.println("原始数组："+Arrays.toString(array));
        reOrderArray2(array);
        System.out.println("调整结果："+Arrays.toString(array));
        System.out.println();
    }
     
    void test5() {
        int[] array = {-1,2,-3,4,-5,6};
        System.out.println("原始数组："+Arrays.toString(array));
        reOrderArray2(array);
        System.out.println("调整结果："+Arrays.toString(array));
        System.out.println();
    }
     
    void test6() {
        int[] array = {2,2,1,3,4,1};
        System.out.println("原始数组："+Arrays.toString(array));
        reOrderArray2(array);
        System.out.println("调整结果："+Arrays.toString(array));
        System.out.println();
    }
     
    void test7() {
        int[] array = {1};
        System.out.println("原始数组："+Arrays.toString(array));
        reOrderArray2(array);
        System.out.println("调整结果："+Arrays.toString(array));
        System.out.println();
    }
    
}
