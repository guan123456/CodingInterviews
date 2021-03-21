package offer40;

import java.util.ArrayList;

public class KLeastNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 方法一，基于快速排序
	 * @param input
	 * @param k
	 * @return
	 */
	public ArrayList<Integer> GetLeastNumbers_Solution1(int[] input ,int k){
		ArrayList<Integer> leastNumbers = new ArrayList<>();
		while(input == null || k <= 0 || k > input.length) {
			return leastNumbers;
		}
		
		int start = 0;
		int end = input.length - 1;

		QuickSort(input,start,end);
/*		//查找到最小的第k个元素的下标
 *      //如果题目要求是按照排序输出下面这种很可能出错，因为它找到划分点就返回，前面元素可能没排序好
 * 		int index = partition(input,start,end);
		while(index != k - 1) {
			if(index < k - 1) {
				start = index + 1;
				index = partition(input, start, end);
			}
			else {
				end = index - 1;
				index = partition(input, start, end);
			}
		}*/
		for(int i = 0; i < k; i++) {
			leastNumbers.add(input[i]);
		}
		
		return leastNumbers;
	}
	
	public void QuickSort(int[] array,int start, int end) {
		if(start < end) {
			int pivotpos = partition(array, start, end);
			QuickSort(array, start, pivotpos - 1);
			QuickSort(array, pivotpos + 1, end);
		}
	}
	private int partition(int[] arr, int start, int end) {
		int pivotKey = arr[start];
		while(start < end) {
			while(start < end && arr[end] >= pivotKey) {
				end--;
			}
			swap(arr,start,end);
			while(start < end && arr[start] <= pivotKey) {
				start++;
			}
			swap(arr,start,end);
		}
		return start;
	}
	
	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	/**
	 * 方法二，基于堆排序
	 * 堆排序基本思路
	 * 1.将无需序列构建成一个堆，根据升序需求选择大顶堆
	 * 2.将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端
	 * 3.重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序
	 * @param input
	 * @param k
	 * @return
	 */
	
	public ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k){
		ArrayList<Integer> leastNumbers = new ArrayList<>();
		while(input == null || k <= 0 || k > input.length) {
			return leastNumbers;
		}
		//用于放最小的k个数
		int[] numbers = new int[k];
		//先放入前k个数
		for(int i = 0; i < k; i++) {
			numbers[i] = input[i];
		}
		//将数组构造成最大堆形式
		//循环进行了(k/2)次
		//从 k / 2 - 1开始是因为要从最后与一个非叶子节点开始
		//这样就可以确保每一个非叶子节点都比较了
		//每一次的堆调整之后，都会有一个元素到达自己的最终位置
		for(int i = k / 2 - 1;i >= 0; i--) {
			adjustHeap(numbers,i,k - 1);
		}
		
		for(int i = k; i < input.length; i++) {
			//存在更小的数字时,重新调整最大堆
			if(input[i] < numbers[0]) {
				numbers[0] = input[i];
				adjustHeap(numbers, 0, k - 1);
			}
		}
		//将numbers数组中的元素赋值给leastNumbers数组
		for(int n : numbers) {
			leastNumbers.add(n);
		}
		
		return leastNumbers;
	}
	//大顶堆：arr[i] >= arr[2i+1] && arr[i] >= arr[2i+2] 
	//调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
	private void adjustHeap(int[] arr, int start, int end) {
		//temp保存当前父节点
		int temp = arr[start];
		//先获得左孩子
		int child = start * 2 + 1;
		//如果上面传入的是k,那么这里就应该改为child < end
		while(child <= end ) {
			// 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
			//这一步选择父节点之外的最大孩子结点
			if(child + 1 < end && arr[child + 1] > arr[child]) {
				child++;
			}
			// 如果父结点的值已经大于孩子结点的值，则直接结束
			if(arr[child] < temp) {
				break;
			}
			//如果父节点的值小于最大的孩子结点的值
			//也就是新加入的元素不是最大值，故需要把父节点换下去
			//把最大孩子结点作为堆最大值，然后向下调整换下去的父节点到合适的位置
			// 把孩子结点的值赋给父结点
			arr[start] = arr[child];
			// 选取孩子结点的左孩子结点,继续向下筛选
			start = child;
			child = child * 2 + 1;
		}
		//将temp值放到最终的位置
		arr[start] = temp;

	}
}
