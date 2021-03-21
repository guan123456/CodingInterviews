package offer68;
/**
* @author 作者:guan
* @createDate 创建时间：Feb 16, 2021 9:04:47 PM
*/


public class GetLowestCommonParentBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class TreeNode{
		int val;
		TreeNode right = null;
		TreeNode left = null;
		public TreeNode(int val) {
			this.val = val;
		}
		
	}
	
	//二叉搜索树
	//利用大小关系即可
	public TreeNode getLowestCommonParentBST_1(TreeNode root, TreeNode node1, TreeNode node2) {
		while(true) {
			if(root == null) {
				return root;
			}
			if(root.val < node1.val && root.val < node2.val) {
				root = root.right;
			}
			else if(root.val > node1.val && root.val > node2.val) {
				root = root.left;
			}else {
				return root;
			}
		}
	}
	
	//普通二叉树
	//将下面结点的信息利用递归s往上传递
	public TreeNode getLowestCommonParent_2(TreeNode root, TreeNode node1, TreeNode node2) {
		if(root == null || root == node1 || root == node2) {
			return root;
		}
		TreeNode left = getLowestCommonParent_2(root.left, node1, node2);
		TreeNode right = getLowestCommonParent_2(root.left, node1, node2);
		return left == null ? right : right == null ? left : root;
	}
	
	//普通二叉树返回值为int版
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        // write code here
        if(root==null){
            return -1;
        }
        if( root.val== o1 || root.val == o2){
            return root.val;
        }
        int left = lowestCommonAncestor(root.left,o1,o2);
        int right = lowestCommonAncestor(root.right,o1,o2);
        return left == -1 ? right : right == -1 ? left : root.val; 
    }
}
