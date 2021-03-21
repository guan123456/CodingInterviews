package offer31;

import java.util.Stack;

public class StackPushPopOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isPopOrder(int[] pushA, int[] popA) {
		//如果输入的压入或弹出序列非法，则直接返回false即可
		if(pushA == null || popA == null) {
			return false;
		}
		//新建一个栈模拟压入弹出
		Stack<Integer> stack = new Stack<Integer>();
		//如果压入序列与弹出序列长度不等或者压入序列长度为0，则返回false
		if(popA.length != pushA.length || pushA.length == 0) {
			return false;
		}
		//记录弹出序列的下标
		int popIndex = 0;
		//遍历压入序列，模拟压入弹出，判断是否匹配弹出序列
		for(int pushIndex = 0; pushIndex < pushA.length; pushIndex++) {
			//先压入
			stack.push(pushA[pushIndex]);
			//如果栈为空，且栈顶元素与弹出序列下标元素相等，则从栈中弹出栈顶元素
			//弹出序列下标后移，比较下一个元素
			while(!stack.empty() && stack.peek() == popA[popIndex]) {
				stack.pop();
				popIndex++;
			}
		}
		//Finally,just to judge whether stack is empty or not 
		//最后，若是栈空了，说明匹配成功，否则匹配失败
		return stack.empty();
	}
}
