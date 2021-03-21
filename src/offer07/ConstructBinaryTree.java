package offer07;



public class ConstructBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConstructBinaryTree test1 = new ConstructBinaryTree();
		test1.test();

	}

	 class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x;
		}
	}
	
	public TreeNode reConstructBinary(int[] pre, int[] in) {
		//如果输入不合法则返回null
		if(pre == null || in == null || pre.length <= 0 || in.length <= 0 || pre.length != in.length) {
			//throw new RuntimeException("数组不符合规范！")
			return null;
		}
		//构造过程在另一函数里，因为这里有递归操作，所以最好另起一个函数
		//该函数传参，传入前序遍历和中序遍历的原数组，数组首位下标
		return construct(pre, in, 0, pre.length - 1, 0, in.length - 1);
	}
	
	
	/**
	 * 
	 * @param pre 最初的前序遍历数组
	 * @param in  最初的中序遍历数组
	 * @param pStart 当前树的前序数组开始位置
	 * @param pEnd   当前树的前序数组结束位置
	 * @param iStart 当前树的中序数组开始位置
	 * @param iEnd   当前树的中序数组结束位置
	 * @return
	 */
	//递归主体函数,返回值为数的根节点
	public TreeNode construct(int[] pre, int[] in, int pStart, int pEnd, int iStart, int iEnd) {
		//从前序遍历中获取根节点，也就是中序遍历数组的第一个元素
		TreeNode root = new TreeNode(pre[pStart]);
		//递归的最后一层，当前序与中序数组都只剩一个元素时
		if(pStart == pEnd && iStart == iEnd) {
			//理论这种情况的测试用例不会出现
			if(pre[pStart] != in[iStart]) {
				//throw new RuntimeException("数组不符合规范");
				return null;
			}
			return root;
		}
		//先找到中序遍历中根节点的位置，即数组下标
		int index = iStart;
		//虽然不大可能出现不存在的情况，但是还是将index<=iEnd加上去
		while(root.val != in[index] && index <=iEnd ) {
			index++;
		}
		//在中序遍历中没有前序遍历的根节点，也就是前序中序不匹配
		//这种情况应该不会出现
		if(index > iEnd) {
			//throw new RuntimeException("数组不符合规范");
			return null;
		}
		//计算左子树结点数，该减法已经除去根节点，如5-0 = 5
		int leftLength = index - iStart;
		//递归处理左子树
		if(leftLength > 0) {
			root.left = construct(pre, in, pStart + 1, pStart + leftLength, iStart, index - 1);
		}
		//递归处理右子树
		//iEnd - iStart 已经减去了根节点，剩余是左右子树结点总数和
		if(leftLength < iEnd - iStart) {
			root.right = construct(pre, in, pStart + leftLength + 1, pEnd, index + 1, iEnd);
		}
		//如果前面都没有返回，则最后返回根节点
		return root;
	}
	
	//把注释与不存在的情况去除，可得到如下代码
	//以下代码可以在leetcode上通过
	public TreeNode buildTree(int[] preorder, int[] inorder) {
    	if(preorder == null || inorder == null || preorder.length <= 0 || inorder.length <= 0 || preorder.length != inorder.length) {
		//throw new RuntimeException("数组不符合规范！")
		return null;
	}
		return construct_1(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
	}
	public TreeNode construct_1(int[] pre, int[] in, int pStart, int pEnd, int iStart, int iEnd) {
		TreeNode root = new TreeNode(pre[pStart]);
		if(pStart == pEnd && iStart == iEnd) {
			return root;
		}
		int index = iStart;
		while(root.val != in[index]) {
			index++;
		}
		int leftLength = index - iStart;
		if(leftLength > 0) {
			root.left = construct_1(pre, in, pStart + 1, pStart + leftLength, iStart, index - 1);
		}
		if(leftLength < iEnd - iStart) {
			root.right = construct_1(pre, in, pStart + leftLength + 1, pEnd, index + 1, iEnd);
		}
		return root;
	}
	
	//测试使用，树的前序遍历
	private void preOrderTraverse(TreeNode node) {
		if(node == null) {
			return;
		}
		System.out.print(node.val+" ");
		preOrderTraverse(node.left);
		preOrderTraverse(node.right);
	}
	
	//测试使用，树的中序遍历
	private void inOrderTraverse(TreeNode node) {
		if(node == null) {
			return;
		}

		inOrderTraverse(node.left);
		System.out.print(node.val + " ");
		inOrderTraverse(node.right);
	}
	
	public void test() {
		  int[] pre = { 1, 2, 4, 7, 3, 5, 6, 8 };
	      int[] in = { 4, 7, 2, 1, 5, 3, 8, 6 };
	      //新建树
	      TreeNode root = reConstructBinary(pre, in);
	      System.out.println("test:");
	      System.out.print("新建树的前序遍历:");
	      preOrderTraverse(root);
	      System.out.println();
	      System.out.print("新建树的中序遍历:");
	      inOrderTraverse(root);
	      System.out.println();
	}
}
