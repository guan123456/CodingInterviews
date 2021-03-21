package offer32;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import javax.swing.RootPaneContainer;

public class PrintTreeFromTopToBottom {

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
	
	/**
	 * 不分行从上往下打印二叉树
	 * 无返回值，但是需要自己打印，故无需用数组存起来，直接打印
	 */
	public void printTree1(TreeNode root) {
		//如果树空，则直接返回即可
		if(root == null) {
			return;
		}
		//新建一个辅助队列，队列先进先出，辅助层次遍历打印
		LinkedList<TreeNode> queue = new LinkedList<>();
		//先加进根结点
		queue.offer(root);
		//建立一个辅助结点，用于存储从队列中出来的结点
		TreeNode node = null;
		//如果队列不空，则执行while循环里的语句
		//一个一个进队出队
		while(queue.size() != 0) {
			//先弹出队列元素，并保存或者输出
			node = queue.poll();
			System.out.print(node.val + " ");
			//从左到右，所以先判断当前从队列中弹出的结点是否有左右孩子
			//有左孩子则把左孩子进队
			if(node.left != null) {
				queue.offer(node.left);
			}
			//有右孩子则把右孩子进队
			if(node.right != null) {
				queue.offer(node.right);
			}
		}
		//换行输出或者返回
		System.out.println();
	}
	
	/**
	 * 返回值为数组，故而需要将结果存起来
	 * @param root
	 * @return
	 */
	//这里只是以上方式的数组实现
	//因为没法一开始就知道数组的长度，所以只能先用一个动态数组存储
	//然后新建一个数组并把动态数组的值传进去，再返回
	public int[] printTree1_1(TreeNode root) {
		if(root == null) {
			return new int[0];
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		ArrayList<Integer> ans = new ArrayList<>();
		while(!queue.isEmpty()) {
			//The method of poll is used to output the node
			//First,store the root node
			TreeNode node = queue.poll();
			ans.add(node.val);
			//Second,store the left node
			if(node.left != null) {
				queue.add(node.left);
			}
			//Third,store the right node
			if(node.right != null) {
				queue.add(node.right);
			}
		}
		//Transfer the ArrayList node into array node
		int[] res = new int[ans.size()];
		for(int i = 0; i < ans.size(); i++) {
			res[i] = ans.get(i);
		}
		return res;
	}
	
	//按层打印
	//如果是输出的话，每输出一层需要换行
	//如果是返回的话，需要用一个矩阵存储
	public void printTree2(TreeNode root) {
		//如果树空，则直接返回即可
		if(root == null) {
			return;
		}
		//这里跟前面是一样的
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		TreeNode node = null;
		//pCount表示当前层的结点数，方便输出
		int pCount = 0;
		//nextCount表示下一层的结点数，方便下一层的输出
		int nextCount = 1;
		
		while(!queue.isEmpty()) {
			//获取当前层的结点数
			pCount = nextCount;
			//把下一层结点数清零，重新计数
			nextCount = 0;
			//遍历pCount次
			for(int i = 1; i <= pCount; i++) {
				node = queue.poll();
				System.out.print(node.val + " ");
				//下面与上面不同就是多了一个计数
				if(node.left != null) {
					queue.offer(node.left);
					nextCount++;
				}
				if(node.right != null) {
					queue.offer(node.right);
					nextCount++;
				}
			}
			//每打印输出了一行，就换行
			System.out.println();
		}
	}
	//以上方法的有返回值实现
	public ArrayList<ArrayList<Integer>> printTree2_1(TreeNode root) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		//如果树空，则直接返回即可
		if(root == null) {
			return list;
		}
		//这里跟前面是一样的
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		TreeNode node = null;
		//pCount表示当前层的结点数，方便输出
		int pCount = 0;
		//nextCount表示下一层的结点数，方便下一层的输出
		int nextCount = 1;
		while(!queue.isEmpty()) {
			//获取当前层的结点数
			pCount = nextCount;
			//把下一层结点数清零，重新计数
			nextCount = 0;
			//遍历pCount次
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for(int i = 1; i <= pCount; i++) {
				node = queue.poll();
				temp.add(node.val);
				//下面与上面不同就是多了一个计数
				if(node.left != null) {
					queue.offer(node.left);
					nextCount++;
				}
				if(node.right != null) {
					queue.offer(node.right);
					nextCount++;
				}
			}
			//每打印输出了一行，就换行
			list.add(temp);
		}
		return list;
	}
	//以下这种方法较上面的优化之处是
	//不用pCount和nextCount来计算当前层与下一层的结点数
	public List<List<Integer>> printTree2_2(TreeNode root){
		//记住以后新建Queue要用到LinkedList
		//要导入java.util.Queue 和 java.util.LinkedList
		Queue<TreeNode> queue = new LinkedList<>();
		/**
		 * 就是搞成矩阵的样子
         * [[3],[9,20],[15,7]]
		 */
		//新建一个动态数据矩阵
		List<List<Integer>> res = new ArrayList<>();
	     
	     if(root != null) {
	    	 queue.add(root);
	     }
	     while(!queue.isEmpty()) {
	    	 List<Integer> temp = new ArrayList<>();
	    	 //这里的queue.size()直接就相当于pCount与nextCount这两部操作了
	    	 for(int i = queue.size(); i > 0; i--) {
	    		 TreeNode node = queue.poll();
	    		 temp.add(node.val);
	    		 if(node.left != null) {
	    			 queue.add(node.left);
	    		 }
	    		 if(node.right != null) {
	    			 queue.add(node.right);
	    		 }
	    	 }
	    	 res.add(temp);
	     }
	     return res;
	}
	/**
	 * 之字形打印二叉树
	 */
	
	public void printTree3(TreeNode root) {
		//如果树空，则直接返回即可
		if(root == null) {
			return;
		}
		//这里跟前面是一样的
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		TreeNode node = null;
		//pCount表示当前层的结点数，方便输出
		int pCount = 0;
		//nextCount表示下一层的结点数，方便下一层输出
		int nextCount = 1;
		//标记当前层数，以便输出
		int level = 1;
		//用一个数组来存储，方便输出
		//从头到尾对应从左到右，从尾到头对应从右到左
		int[] pNums = null;
		
		while(!queue.isEmpty()) {
			//获取当前层的结点数
			pCount = nextCount;
			//把下一层结点数清零，重新计数
			nextCount = 0;
			//创建一个当前层结点数的数组以存储当前层结点
			pNums = new int[pCount];
			
			for(int i = 0; i < pCount; i++) {
				
				node = queue.poll();
				//只是输出这一步转为了存储而已
				pNums[i] = node.val;
				if(node.left != null) {
					queue.offer(node.left);
					nextCount++;
				}
				if(node.right != null) {
					queue.offer(node.right);
					nextCount++;
				}
			}
			//如果当前层数奇数层，则从左到右打印
			if((level & 1) != 0) {
				for(int i = 0; i < pCount; i++) {
					System.out.print(pNums[i] + " ");
				}
			}
			//否则当前层是偶数层，则从右到左打印
			else {
				for(int i = pCount- 1; i >= 0; i--) {
					System.out.print(pNums[i] + " ");
				}
			}
			//层数+1
			level++;
			//换行输出
			System.out.println();
		}
		

	}
	
	public void printTree3_1(TreeNode root) {
		if(root == null) {
			return;
		}
		Stack<TreeNode> stack1 = new Stack<>();
		Stack<TreeNode> stack2 = new Stack<>();
		TreeNode node = null;
		stack1.push(root);
		while(!stack1.empty() || !stack2.empty()) {
			while(!stack1.empty()) {
				node = stack1.pop();
				System.out.print(node.val + " ");
				//先存左后存右
				if(node.left != null) {
					stack2.push(node.left);
				}
				if(node.right != null) {
					stack2.push(node.right);
				}
			}
			
			while(!stack2.empty()) {
				node = stack2.pop();
				System.out.print(node.val + " ");
				//先存右后存左
				if(node.right != null) {
					stack1.push(node.right);
				}
				if(node.left != null) {
					stack1.push(node.left);
				}
			}
			System.out.println();
		}
	}
	//以下方式是上面的有返回值实现
	//利用了两个栈
	//直接用queue.size()取代了pCount和nextCount
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null){
            return list;
        }
       //这句代码要放在里面，不然的话因为会因为前一行元素没删除而叠加到原有的元素中
       //从而每一次都输出整个数组的值，而不是一层一层的
        //woc，原来这里有这么多门道
        //首先是list.add(temp)这里是引用传递，所以若不新建一个temp
        //那么当temp里面的值改变的时候，原来存的temp也是会改变的
        //所以这里continue和新建的temp都是这个功能
        //如果没有continue跳回到while循环然后重新创建一个temp
        //那么temp会在接下里的if循环里发生改变，那么就不能结果就不正确了
        //后面的continue可有可无，因为它下一步就是跳到了while循环了
        
        //用两个栈取代了一个队列存储
        //stack1从右到左存储，则输出是从左到右
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        //stack2从右到左存储，则输出是从右到左
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        
        TreeNode node = null;
        stack1.add(pRoot);
        //当两个栈不全为空时，执行while循环里的语句
        while(stack1.size() > 0 || stack2.size() > 0){
        	//新建一个动态数组来存储当前层结点
            ArrayList<Integer> temp = new ArrayList<Integer>();
            //当奇数层有节点，也就是stack1不为空
            //则弹出stack1元素，并依次判断弹出元素是否有孩子结点，有则压入stack2中
            if(stack1.size() > 0){
                int size = stack1.size();
                for(int i = 0; i < size; i++){
                	//从stack1中弹出元素，加入动态数组temp，后判断
                    node = stack1.pop();
                    temp.add(node.val);
                    if(node.left != null){
                        stack2.add(node.left);
                    }
                    if(node.right != null){
                        stack2.add(node.right);
                    }
                }
                //将动态数组加入动态矩阵
                list.add(temp);
                //进行下一轮while循环
                continue;
            }    
           //当偶数层有节点，也就是stack2不为空
           //则弹出stack2元素，并依次判断弹出元素是否有孩子结点，有则压入stack1中
           if(stack2.size() > 0){
               int size = stack2.size();
               for(int i = 0; i < size; i++){
            	   //从stack2中弹出元素，加入动态数组temp，后判断
                   node = stack2.pop();
                   temp.add(node.val);
                   if(node.right != null){
                       stack1.add(node.right);
                   }
                   if(node.left != null){
                       stack1.add(node.left);
                   }
               }
               //将动态数组加入动态矩阵
               list.add(temp);
               //进行下一轮while循环
               continue;
           }
        }
        //返回动态矩阵
        return list;
    }
	
	
}
