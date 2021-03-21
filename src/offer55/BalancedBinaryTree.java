package offer55;


/**
* @author 作者:guan
* @createDate 创建时间：Feb 11, 2021 3:13:42 PM
*/
public class BalancedBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public class TreeNode{
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	//通过判断调用树的高度的函数返回确定是否是平衡二叉树
	public boolean IsBalanced_Solution(TreeNode root) {
		return getDepth(root) != -1;
	}

	public int getDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int left = getDepth(root.left);
		if(left == -1) {
			return -1;
		}
		int right = getDepth(root.right);
		if(right == -1) {
			return -1;
		}
		//当节点root 左 / 右子树的深度差  ≤1 ：则返回当前子树的深度
		//即节点 root 的左 / 右子树的深度最大值 +1 ( max(left, right) + 1 )
		//当节点root 左 / 右子树的深度差 > 2>2 ：则返回 -1−1 ，代表 此子树不是平衡树 
		//二叉树做后序遍历，从底至顶返回子树深度，若判定某子树不是平衡树则 “剪枝” ，直接向上返回。
		return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
	}
	//一般首先会想到的方法，但是一定要把树给遍历完才行，上面的方法实现了剪枝
	boolean isBalanced = true;
	public boolean IsBalanced_Solution_1(TreeNode root) {
		TreeDepth(root);
		return isBalanced;
	}
	public int TreeDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int left = TreeDepth(root.left);
		int right = TreeDepth(root.right);
		if(left - right > 1 || right - left > 1) {
			isBalanced = false;
		}
		return Math.max(left + 1, right + 1);
	}
}
