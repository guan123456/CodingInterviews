package offer36;

public class ConvertBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
 
        public TreeNode(int val) {
            this.val = val;
        }
    }
    
    public TreeNode convert(TreeNode head) {
    	//如果树为空则返回null
    	if(head == null) {
    		return head;
    	}
    	
    	TreeNode lastNodeInList = null;
    	//该递归函数返回的是排序链表的最后一个结点
    	lastNodeInList = convertHelper(head,lastNodeInList);
    	//要找到二叉搜索的第一个结点输出
    	TreeNode firstNodeInList = lastNodeInList;
    	while(firstNodeInList.left != null) {
    		firstNodeInList = firstNodeInList.left;
    	}
    	
    	return firstNodeInList;
    }
    
    //将以node为根节点的树转化为排序链表，链表头部与lastNode链接，并返回最后一个结点
    private TreeNode convertHelper(TreeNode node, TreeNode lastNode) {
    	//处理左子树，获得最大结点
    	if(node.left != null) {
    		lastNode = convertHelper(node.left, lastNode);
    	}
    	//链接最大结点和根节点
    	//node.left相当于链表中的node.pre
    	node.left = lastNode;
    	//如果lastNode不为空，也就是当前结点node的左边最大值为lastNode
    	//则需要连接
    	if(lastNode != null) {
    		//lastNode.right相当于链表中node.next
    		lastNode.right = node;
    	}
    	//处理右子树
    	//更新当前最大值
    	lastNode = node;
    	//这一层递归的右子树最大值其实是上一层递归的左子树的最大值
    	if(node.right != null) {
    		//下一层递归，node变成了这一层的node.right，又保证了node是最大的
    		//只要连接node与左边最大即可
    		lastNode = convertHelper(node.right, lastNode);
    	}
    	//返回最大值，也就是尾结点
    	return lastNode;
    }

    
}
