package offer55;
/**
* @author 作者:guan
* @createDate 创建时间：Feb 11, 2021 3:09:32 PM
*/
public class TreeDepth {

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
	
	public int TreeDepth1(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int left = TreeDepth1(root.left);
		int right = TreeDepth1(root.right);
		return Math.max(left + 1, right + 1);
	}

}
