package offer28;


public class SymmetricalBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
			// TODO Auto-generated constructor stub
		}
	}
	
	//原代码
	
	public boolean isSymmetrical(TreeNode pRoot) {
		if(pRoot == null) {
			return true;
		}
		return isEqual(pRoot.left, pRoot.right);
	}
	
	private boolean isEqual(TreeNode pRoot1, TreeNode pRoot2) {
		if(pRoot1 == null && pRoot2 == null) {
			return true;
		}
		if(pRoot1 == null || pRoot2 == null) {
			return false;
		}
		return pRoot1.val == pRoot2.val
				&& isEqual(pRoot1.left, pRoot2.right)
				&& isEqual(pRoot1.right, pRoot2.left);
	}
	
	//缩减代码
	public boolean isSymmetric(TreeNode root) {
		return root == null ? true:recur(root.left,root.right);
	}
	
	private boolean recur(TreeNode L, TreeNode R) {
		if(L == null && R == null){
			return true;
		}
		if(L == null || R == null || L.val != R.val) {
			return false;
		}
		return recur(L.left, R.right) && recur(L.right, R.left);
	}
}
