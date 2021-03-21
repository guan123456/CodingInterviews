package offer54;
/**
* @author 作者:guan
* @createDate 创建时间：Feb 10, 2021 5:14:00 PM
*/
public class KthNodeInBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	int index = 0;
	public class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
 
        public TreeNode(int val) {
            this.val = val;
        }
    }
	
	TreeNode KthNode(TreeNode pRoot, int k) {
		TreeNode pNode = null;
		if(pRoot == null || k <= 0) {
			return pNode;
		}
		pNode = getKthNode(pRoot, k);
		return pNode;
	}
	private TreeNode getKthNode(TreeNode pRoot, int k) {
		TreeNode kthNode = null;
		//left
		if(pRoot.left != null) {
			//递归遍历左子树
			kthNode = getKthNode(pRoot.left,k);
		}
		//root
		//如果目标元素未找到，也就是值为null，则继续执行
		if(kthNode == null) {
			index++;
			if(k == index) {
				kthNode = pRoot;
			}
		}
		//right
		if(kthNode == null && pRoot.right != null) {
			//递归遍历右子树
			kthNode = getKthNode(pRoot.right, k);
		}
		//这一趟递归中有没有找到目标元素都返回kthNode的值
		return kthNode;
	}

}
