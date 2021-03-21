package offer26;

public class SubstructureInTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x;
		}
	}
	
	public boolean hasSubtree(TreeNode root1, TreeNode root2) {
		if(root1 == null || root2 == null) {
			return false;
		}
		return doesTree1HasTree2(root1, root2) || hasSubtree(root1.left, root2) || hasSubtree(root1.right, root2);
	}
	
	 private boolean doesTree1HasTree2(TreeNode root1, TreeNode root2){
		if(root2 == null) {
			return true;
		}
		if(root1 == null) {
			return false;
		}
		return equal(root1.val, root2.val) && doesTree1HasTree2(root1.left, root2.left) && doesTree1HasTree2(root1.right, root2.right);
	}
	 
	 private boolean equal(double num1, double num2) {
		 if(num1 - num2 < 0.0000001 && num1 - num2 > -0.0000001) {
			 return true;
		 }
		 return false;
	 }
}
