package offer33;


public class SquenceOfBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean verifySquenceOfBST(int[] sequence) {
		//leetcode里默认是不用检查这些边界条件的
		if(sequence == null || sequence.length <= 0) {
			return false;
		}
		//因为有递归调用，所以用另起函数做递归
		//传入参数有后续遍历数组，后续遍历数组起始元素下标，后续遍历数组结束元素下标
		return verifyCore(sequence, 0, sequence.length - 1);
		//return recur(sequence, 0 ,sequence.length - 1);
	}
	
	private boolean verifyCore(int[] sequence, int start, int end) {
		//递归结束条件
		if(start >= end) {
			return true;
		}
		//判断左子树
		//后续遍历数组最后一个元素是根节点
		//获取到右子树第一个元素下标
		int mid = start;
		while(sequence[mid] < sequence[end]) {
			mid++;
		}
		//判断右子树
		//如果左子树有元素不满足条件，也就是有元素小于根节点，就返回false
		for(int i = mid; i < end; i++) {
			if(sequence[i] < sequence[end]) {
				return false;
			}
		}
		//递归调用函数，只有左右子树都满足条件才返回true
		return verifyCore(sequence, start, mid - 1) && verifyCore(sequence, mid, end - 1);
	}
	
/*	private boolean recur(int[] sequence, int start, int end) {
		if(start >= end) {
			return true;
		}
		
		int p = start;
		while(sequence[p] < sequence[end]) {
			p++;
		}
		int m = p;
		while(sequence[p] > sequence[end]) {
			p++;
		}
		return p == end && recur(sequence, start, m - 1) && recur(sequence, m, end - 1);
	}*/

}
