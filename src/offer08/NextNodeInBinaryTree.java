package offer08;


public class NextNodeInBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NextNodeInBinaryTree test = new NextNodeInBinaryTree();
		System.out.println("Test:");
		test.test();

	}

	 class TreeNode{
		String val;
		TreeNode left;
		TreeNode right;
		TreeNode parent;
		TreeNode(String x){
			val = x;
		}
	}
	
	public TreeNode GetNext(TreeNode pNode) {
		//当树不合法时，返回null
		if(pNode == null) {
			System.out.print("结点为null!");
			return null;
		}
		//若当前结点有右子树时，其下一个结点为右子树中最左子结点
		if(pNode.right != null) {
			//先到当前结点右子树
			pNode = pNode.right;
			//然后到当前结点右子树的最左结点
			while(pNode.left != null) {
				pNode= pNode.left;
			}
			//返回目标结点
			return pNode;
		}
		//若当前结点没有右子树时
		//这里是while循环不是if循环
		while(pNode.parent != null) {
			//若当前结点为其父结点的左子结点时，其下一个结点为其父结点
			if(pNode == pNode.parent.left) {
				return pNode.parent;
			}
			//若当前结点为其父结点的右子结点时，继续向上遍历父结点的父结点
			//直到找到一个结点是其父结点的左子结点,该结点的父结点即为下一结点
			pNode = pNode.parent;
		}
		//若最后没找到则返回null
		return null;
	}
	
	public void test() {
		TreeNode node1 = new TreeNode("a");
		TreeNode node2 = new TreeNode("b");
		TreeNode node3 = new TreeNode("c");
		TreeNode node4 = new TreeNode("d");
		TreeNode node5 = new TreeNode("e");
		TreeNode node6 = new TreeNode("f");
		
		node1.right = node3;
		node1.left = node2;
		node2.parent = node1;
		node2.left = node4;
		node4.parent = node2;
		node3.parent = node1;
		node3.left = node5;
		node3.right = node6;
		node5.parent = node3;
		node6.parent = node3;
		
		TreeNode nextNodeOf_a = GetNext(node1);
		TreeNode nextNodeOf_b = GetNext(node2);
		TreeNode nextNodeOf_c = GetNext(node3);
		TreeNode nextNodeOf_d = GetNext(node4);
		TreeNode nextNodeOf_e = GetNext(node5);
		TreeNode nextNodeOf_f = GetNext(node6);
		
        if(nextNodeOf_a!=null)
            System.out.println("a结点的下一个结点值为："+nextNodeOf_a.val);
        else
            System.out.println("a结点无下一结点");
        if(nextNodeOf_b!=null)
            System.out.println("b结点的下一个结点值为："+nextNodeOf_b.val);
        else
            System.out.println("b结点无下一结点");
        if(nextNodeOf_c!=null)
            System.out.println("c结点的下一个结点值为："+nextNodeOf_c.val);
        else
            System.out.println("c结点无下一结点");
        if(nextNodeOf_d!=null)
            System.out.println("d结点的下一个结点值为："+nextNodeOf_d.val);
        else
            System.out.println("d结点无下一结点");
        if(nextNodeOf_e!=null)
            System.out.println("e结点的下一个结点值为："+nextNodeOf_e.val);
        else
            System.out.println("e结点无下一结点");
        if(nextNodeOf_f!=null)
            System.out.println("f结点的下一个结点值为："+nextNodeOf_f.val);
        else
            System.out.println("f结点无下一结点");
	}
}
