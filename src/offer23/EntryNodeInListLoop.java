package offer23;

import offer22.KthNodeFromEnd.ListNode;
import offer35.CopyComplexList.Node;

public class EntryNodeInListLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class ListNode{
		int val;
		ListNode next = null;
		ListNode(int x){
			val = x;
		}
	}
	
	/**
	 * 第一种方法，双指针
	 * 1.确定有环
	 * 2.确定环中结点的数目
	 * 3.找到环的入口
	 */
	
    /*
     * 确定链表是否有环，采用快慢指针确定
     * 返回值代表快慢指针相遇时的结点，返回null代表链表无环
     */
	private ListNode meetingNode(ListNode head) {
		if(head == null) {
			return null;
		}
		ListNode pSlow = head.next;
		if(pSlow == null) {
			return null;
		}
		ListNode pFast = pSlow.next;
		while(pFast != null && pSlow != null) {
			if(pFast == pSlow) {
				return pFast;
			}
			pSlow = pSlow.next;
			pFast = pFast.next;
			
			if(pFast != null) {
				pFast = pFast.next;
			}
		}
		return null;
	}
	
    /**
     * 计算环中入口结点
     */
	
	public ListNode entryNodeOfLoop(ListNode head) {
		ListNode meetingNode = meetingNode(head);
		if(meetingNode == null) {
			return null;
		}
		
		//计算环中结点的数目
		int count = 1;
		ListNode pNode1 = meetingNode.next;
		while(pNode1 != meetingNode) {
			count++;
			pNode1 = pNode1.next;
		}
		
		//先移动pNode1，次数为count
		pNode1 = head;
		for(int i = 1; i <= count; i++) {
			pNode1 = pNode1.next;
		}
		
		ListNode pNode2 = head;
		while(pNode1 != pNode2) {
			pNode1 = pNode1.next;
			pNode2 = pNode2.next;
		}
		return pNode1;
	}
	
	/**
	 * 第二种解法，双指针
	 * 快走2步，慢走1步
	 * 第一次相遇，记下
	 * 快指针回头，快慢都走1步
	 * 第二次相遇，返回
	 */
	
	private ListNode meetingNode2(ListNode head) {
		ListNode fast =head;
		ListNode slow = head;
		//第一次相遇，结束
		while(true) {
			if(fast == null || fast.next == null) {
				return null;
			}
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow) {
				break;
			}
		}
		//快指针回头，两者继续走
		fast = head;
		while(slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return fast;
	}
	//另一种写法
	public ListNode getLoopNode(ListNode head) {
		if(head == null || head.next == null || head.next.next == null) {
			return null;
		}
		ListNode n1 = head.next;
		ListNode n2 = head.next;
		while(n1 != n2) {
			if(n2.next == null || n2.next.next == null) {
				return null;
			}
			n2 = n2.next.next;
			n1 = n1.next;
		}
		n2 = head;
		while(n1 != n2) {
			n1 = n1.next;
			n2 = n2.next;
		}
		return n1;
	}
}
