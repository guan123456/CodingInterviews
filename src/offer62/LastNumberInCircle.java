package offer62;

import java.util.LinkedList;

/**
* @author 作者:guan
* @createDate 创建时间：Feb 15, 2021 11:26:51 AM
*/
public class LastNumberInCircle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//method_1
	public int LastRemaining_Solution(int n, int m) {
		if(n < 1 || m < 1) {
			return -1;
		}
		int last = 0;
		//基于循环的实现，从n取最小值一直累次计算到n取到目标值
		for(int i = 2; i < n; i++) {
			last = (last + m) % i;
		}
		//最后返回结果
		return last;
	}
	//method_2
	public int LastRemaining_Solution2(int n, int m) {
		if(n < 1 || m < 1) {
			return -1;
		}
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i = 0; i < n; i++) {
			list.add(i);
		}
		int removeIndex = 0;
		while(list.size() > 1) {
			removeIndex = (removeIndex + m -1) % list.size();
			list.remove(removeIndex);
		}
		return list.getFirst();
	}
}
