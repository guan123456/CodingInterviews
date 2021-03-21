package offer34;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathInTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class TreeNode{
		int val = 0;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public void findPath(TreeNode root ,int target) {
		//如果树空则返回即可
		if(root == null) {
			return;
		}
		//用list存储路径
		ArrayList<Integer> list = new ArrayList<>();
		//因为有递归，所以另起一个函数做递归函数
		//传入参数有，根节点，目标值，存储路径的list
		printPath(root,target,list);
	}
	
	private void printPath(TreeNode node, int target, ArrayList<Integer> list) {
		//如果当前结点为空，则返回即可
		if(node == null) {
			return;
		}
		//如果当前结点不为空，则将该结点值加入存储数组中
		list.add(node.val);
		//更新目标值
		target -= node.val;
		//如果目标值为零，且当前结点是叶节点，则找到了路径，直接输出存储数组即可
		if(target == 0 && node.left == null && node.right == null) {
			for(Integer integer : list) {
				System.out.print(integer + " ");
			}
			//有可能有多组，所以需要换行输出
			System.out.println();
		}
		//否则，递归遍历左子树与右子树
		else {
			printPath(node.left, target, list);
			printPath(node.right, target, list);
		}
		//最后存储数组要么输出了，要么当前结点路径不满足
		//需要删除把当前结点从存储数组中删除
		list.remove(list.size() - 1);
	}
	//leetcode
	//动态矩阵res用于存储所有满足的路径
	LinkedList<List<Integer>> res = new LinkedList<>();
	//动态链表用于存储当前路径
	LinkedList<Integer> path = new LinkedList<>();
	public List<List<Integer>> pathSum(TreeNode root , int sum){
		recur(root,sum);
		return res;
	}
	public void recur(TreeNode root, int tar) {
		//如果当前结点为空，则返回即可
		if(root == null) {
			return;
		}
		//如果当前结点不为空，则将该结点值加入存储链表中
		path.add(root.val);
		//更新目标值
		tar -= root.val;
		//如果目标值为零，且当前结点是叶节点，则找到了路径，直接把当前链表路径存入动态矩阵即可
		if(tar == 0 && root.left == null && root.right == null) {
			res.add(new LinkedList<Integer>(path));
		}
		//否则，递归遍历左子树与右子树
		recur(root.left, tar);
		recur(root.right, tar);
		//最后存储数组要么存储了，要么当前结点路径不满足
		//需要删除把当前结点从存储数组中删除，也就是最后加进去也是刚加进去的元素
		path.removeLast();
	}
	
	//nowcoder
	/**1.将nodeList和pathList定义成全局变量，避免在方法中的多次传递
	 * 2.在pathList中添加nodeList时，因为nodeList会不断变化，所以必须新建一个list存入
	 * 	  复制ArrayList的方法：newList = new ArrayList<Integer>(oldList)
	 *   (复制内容，而不是赋值地址，这与newList = oldList不同)
	 * 3.在当前结点完成左右子树的路径搜索后，记得删除nodeList中的当前结点
	 */
	
	private ArrayList<Integer> nodeList = new ArrayList<Integer>();
	private ArrayList<ArrayList<Integer>> pathList = new ArrayList<ArrayList<Integer>>();
	
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode node,int target){
		if(node == null) {
			return pathList;
		}
		nodeList.add(node.val);
		target -= node.val;
		//leaf node
		if(target == 0 && node.left == null && node.right == null) {
			//把长度大的nodeList插入到pathList的前面
			int i = 0;
			//to find the index of i that length is less than new list
			//这里与前面相比就是多了一个按照路径长度从大到小的排序
			//找到第一个路径长度小于当前路径长度的位置下标，将当前路径插入即可
			while(i < pathList.size() && nodeList.size() < pathList.get(i).size()) {
				i++;
			}
			//This method can put the node into the position of the i
			//注意这里需要new ArrayList<Integer>(nodeList);
			//不能直接加nodeList
			//nodeList会随方法变化，必须新建一个list存入pathList中！
			pathList.add(i,new ArrayList<Integer>(nodeList));
		}
		//middle node
		else {
			pathList = FindPath(node.left, target);
			pathList = FindPath(node.right, target);
		}
		nodeList.remove(nodeList.size() - 1);//记得删除当前结点
		return pathList;
	}
	
}
