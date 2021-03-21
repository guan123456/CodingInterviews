package offer59;
/**
* @author 作者:guan
* @createDate 创建时间：Feb 13, 2021 1:11:14 PM
*/

import java.util.ArrayDeque;
import java.util.ArrayList;

public class MaxInSlidingWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public ArrayList<Integer> maxInWindows(int[] num, int size){
		ArrayList<Integer> max = new ArrayList<>();
		if(num == null || num.length <= 0 || size <= 0 || size > num.length) {
			return max;
		}
		ArrayDeque<Integer> indexDeque = new ArrayDeque<>();
		//先遍历数组中前size-1个数
		for(int i = 0; i < size - 1; i++) {
			//如果双端队列不为空，且当前数组下表i对应的值大于队列中的元素
			//则将队列中较小元素删除
			while(!indexDeque.isEmpty() && num[i] > num[indexDeque.getLast()]) {
				indexDeque.removeLast();
			}
			//然后加入新的值
			indexDeque.addLast(i);
		}
		
		//然后从size个数字开始于队列中元素进行比较
		//没进行一次到最后就会有一个max产生，滑动窗口也跟着往前一步
		for(int i = size - 1; i < num.length; i++) {
			//如果双端队列不为空，且当前数组下表i对应的值大于队列中的元素
			//则将队列中较小元素删除
			while(!indexDeque.isEmpty() && num[i] > num[indexDeque.getLast()]) {
				indexDeque.removeLast();
			}
			//如果队列中最大值的下标超过滑动窗口的距离，则将队列中最大值删除
			if(!indexDeque.isEmpty() && (i - indexDeque.getFirst()) >= size) {
				indexDeque.removeFirst();
			}
			//判断完之后添加当前元素
			indexDeque.addLast(i);
			//获取这一轮滑动窗口的最大值
			max.add(num[indexDeque.getFirst()]);
		}
		return max;
	}
	
	
}
