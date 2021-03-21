package offer35;

import java.util.HashMap;
import java.util.Map;

public class CopyComplexList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static class ComplexListNode{
		int val;
		ComplexListNode next = null;
		ComplexListNode sibling = null;
		
		ComplexListNode(int label) {
			this.val = label;
			// TODO Auto-generated constructor stub
		}
	}
	
	/**
	 * 注意：原链表是没有头指针的
	 * 主程序(三步走)
	 */
	public static ComplexListNode cloneList(ComplexListNode head) {
		cloneNodes(head);              //1.复制结点
		connectSiblingNodes(head);     //2.设置sibling
		return reconnectNodes(head);   //3.拆分长链表
	}

	/**
	 * 复制每个结点，并插入到原始结点的后面
	 */
	private static void cloneNodes(ComplexListNode head) {
		//辅助结点，初试赋头结点
		ComplexListNode pNode = head;
		while(pNode != null) {
			//原始链表:a-->b-->c-->d-->null
			//1.     pNode=a      
			//2.     cloneNode:a'
			//3.     a'-->b          ==>a'-->b-->c-->d-->null
			//4.     pNode-->a'      ==>a-->a'-->b-->c-->d-->null
			//5.     pNode=a'-->    ==>pNodex=b
			//New a node that its value is original node value
			ComplexListNode clonedNode = new ComplexListNode(pNode.val);
			//Draw a simple map that can understand it 
			clonedNode.next = pNode.next;
			pNode.next = clonedNode;
			pNode = clonedNode.next;
		}
	}
	
	
	/**
	 * 根据原始结点的sibling，设置复制结点的sibling
	 */
	private static void connectSiblingNodes(ComplexListNode head) {
		//辅助结点，初试赋头结点
		ComplexListNode pNode = head;
		while(pNode != null) {
			if(pNode.sibling != null) {//判断siblingNode == null 的情况
				//pNode.next 是A',pNode.sibling是C,pNode.sibling.next 是C'
				pNode.next.sibling =  pNode.sibling.next;
			}
			//因为是复制后的链表，所以每设置一次，往前走两个结点
			pNode = pNode.next.next;
		}
	}
	
	/**
	 * 将长链表拆分成原始链表和赋值链表（根据奇偶位置）
	 */
	//想当初想了半天都没搞懂
	//现在画个图就了解了，很直观又易于理解
	private static ComplexListNode reconnectNodes(ComplexListNode head) {
		//辅助结点，初始赋空，用于保存复制链表的头结点
		ComplexListNode clonedHead = null;
		//辅助结点，初始赋空，用于动态操作复制链表
		ComplexListNode clonedNode = null;
		//辅助结点，初始赋头结点，用于动态保存原始链表
		ComplexListNode pNode = head;
		//If loop operate only once in order to get head node 
		if(head != null) {
			//原始链表:a-->a'-->b-->b'-->c-->c'-->d-->d'-->null
			//1.     pHead=a;
			//2.     cloneHead=head-->         ==>clonedHead=a'
			//3.     clonedNode=pHead-->       ==>clonedNode=a'
			//4.     pNode-->=clonedNode-->    ==>a-->b        ==>a-->b-->b'-->c-->c'-->d-->d'-->null
			//5.     pNode=pNode-->            ==>pNode=b      
			clonedHead = head.next;
			clonedNode = pNode.next;
			
			pNode.next = clonedNode.next;
			//提前将pNode指向下一个结点，方便判断是否为null
			pNode = pNode.next;
		}
		while(pNode != null) {
			//设置新克隆链表下一个结点
			//复制链表的连接
			//6.     clonedNode-->=pNode-->    ==>a'-->b'
			//7.     clonedNode=cloneNode-->   ==>clonedNode=b'
			//8.     pNode-->=clonedNode-->    ==>b-->c        ==>a-->b-->c-->c'-->d-->d'-->null
			//9.     pNode=pNode-->            ==>pNode=c
			clonedNode.next = pNode.next;
			clonedNode = clonedNode.next;
			//原链表的连接
			pNode.next = clonedNode.next;
			pNode = pNode.next;
		}
		//最后返回复制链表的头结点即可
		return clonedHead;
		
	}
	
	//更简洁的代码
	public static ComplexListNode copyListWithRand(ComplexListNode head) {
		if(head == null) {
			return null;
		}
		ComplexListNode cur = head;
		ComplexListNode next = null;
		// copy node and link to every node
		// 1 -> 2
		// 1 -> 1' -> 2
		while(cur != null) {
			// cur 老
			// next 老的下一个
			next = cur.next;
			cur.next = new ComplexListNode(cur.val);
			cur.next.next = next;
			cur = next;
		}
		cur = head;
		ComplexListNode curCopy = null;
		// set copy node rand
		// 1 -> 1' -> 2 -> 2'
		while(cur != null) {
			// cur 老
			// cur.next 新copy
			next = cur.next.next;//save node
			curCopy = cur.next;
			curCopy.sibling = cur.sibling != null ? cur.sibling.next : null;
			cur = next;
		}
		ComplexListNode res = head.next;
		cur = head;
		// split
		while(cur != null) {
			next = cur.next.next;
			curCopy = cur.next;
			cur.next = next;
			curCopy.next = next != null ? next.next : null;
			cur = next;
		}
		return res;
	}
	/**
	 * 使用哈希辅助空间来实现
	 */
	public class Node{
		int val;
		Node next;
		Node random;
		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}
	//这里输入的[a,b],[d,f],[b,null],[f,null]
	//a的random指针指向b，d的random指针指向f
	//链表默认连接a-->d-->b-->f-->null
	public Node copyRandomList(Node head) {
		//如果链表为空，直接返回null
		if(head == null) {
			return null;
		}
		//辅助结点，用于动态复制
		Node cur = head;
		//哈希存储的是{7:7,3:3,1:1,0:0,2:2}
		//为了方便找到链表结点而已，存储的不是random
		Map<Node, Node> map = new HashMap<Node,Node>();
		//复制各结点，并建立"原结点-->新结点"的Map映射
		while(cur != null) {
			map.put(cur, new Node(cur.val));
			cur = cur.next;
		}
		//辅助结点，重新重新遍历链表
		cur = head;
		//构建新链表的next和random指向
		while(cur != null) {
			// cur 老
			// map.get(cur) 新
			//新结点next指向同旧结点的next指向
			map.get(cur).next = map.get(cur.next);
			////新结点random指向同旧结点的random指向
			map.get(cur).random = map.get(cur.random);
			cur = cur.next;
		}
		//返回新链表的头结点
		return map.get(head);
	}
}
