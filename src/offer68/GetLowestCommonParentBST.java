package offer68;

import offer35.CopyComplexList.Node;

/**
* @author 作者:guan
* @createDate 创建时间：Feb 16, 2021 9:04:47 PM
*/


public class GetLowestCommonParentBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class TreeNode{
		int value;
		TreeNode right;
		TreeNode left;
		public TreeNode(int val) {
			this.value = val;
		}
		
	}
	
	//二叉搜索树
	//利用大小关系即可
	public TreeNode getLowestCommonParentBST_1(TreeNode root, TreeNode node1, TreeNode node2) {
		while(true) {
			if(root == null) {
				return root;
			}
			if(root.value < node1.value && root.value < node2.value) {
				root = root.right;
			}
			else if(root.value > node1.value && root.value > node2.value) {
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
        if( root.value== o1 || root.value == o2){
            return root.value;
        }
        int left = lowestCommonAncestor(root.left,o1,o2);
        int right = lowestCommonAncestor(root.right,o1,o2);
        return left == -1 ? right : right == -1 ? left : root.value; 
    }
    
    public static class Info{
    	public TreeNode ans;
    	public boolean findO1;
    	public boolean findO2;
    	public Info(TreeNode a, boolean f1, boolean f2) {
    		ans = a;
    		findO1 = f1;
    		findO2 = f2;
    	}
    }
    
    public static Info process(TreeNode X, TreeNode o1, TreeNode o2) {
    	if(X == null) {
    		return new Info(null, false, false);
    	}
    	Info leftInfo = process(X.left, o1, o2);
    	Info rightInfo = process(X.right, o1, o2);
    	
    	boolean findO1 = X == o1 || leftInfo.findO1 || rightInfo.findO1;
    	boolean findO2 = X == o2 || leftInfo.findO2 || rightInfo.findO2;
    	
    	// O1和O2最初的交汇点在哪
    	// 1) 在左树上已经提前交汇了
    	// 2) 在右树上已经提前交汇了
    	// 3) 没有在左树或者右树上提前交汇，O1 O2 全了
    	// 4) 没有交汇，保持ans 为null
    	TreeNode ans = null;
    	if(leftInfo.ans != null) {
    		ans = leftInfo.ans;
    	}
    	if(rightInfo.ans != null) {
    		ans = rightInfo.ans;
    	}
    	if(ans == null) {
    		if(findO1 && findO2) {
    			ans = X;
    		}
    	}
    	return new Info(ans, findO1, findO2);
    }
}
