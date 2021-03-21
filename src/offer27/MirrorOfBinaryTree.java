package offer27;

public class MirrorOfBinaryTree {

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
	
	//Use a temporary variable named tempNode for swapping
	//Then recursing the left node and right node of root
	public void Mirror(TreeNode root) {
		if(root == null) {
			return;
		}
		TreeNode tempNode = root.left;
		root.left = root.right;
		root.right = tempNode;
		
		Mirror(root.left);
		Mirror(root.right);
	}
	//有返回值
	public TreeNode Mirror2(TreeNode root) {
		if(root == null) {
			return null;
		}
		TreeNode tempNode = root.left;
		root.left = root.right;
		root.right = tempNode;
		
		Mirror(root.left);
		Mirror(root.right);
		return root;
	}
	
	public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftRoot = mirrorTree(root.right);
        TreeNode rightRoot = mirrorTree(root.left);
        root.left = leftRoot;
        root.right = rightRoot;
        return root;
    }
}
