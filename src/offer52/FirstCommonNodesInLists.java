package offer52;

import offer23.EntryNodeInListLoop.ListNode;

/**
* @author 作者:guan
* @createDate 创建时间：Feb 9, 2021 1:09:42 PM
*/
public class FirstCommonNodesInLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class ListNode{
		int val;
		ListNode next = null;
		ListNode(int val){
			this.val = val;
		}
	}
	
	//方法1:利用长度关系
	public ListNode findFirstCommonNode1(ListNode pHead1,ListNode pHead2) {
		if(pHead1 == null || pHead2 == null) {
			return null;
		}
		int length1 = getLength(pHead1);
		int length2 = getLength(pHead2);
		int lengthDif = length1 - length2;
		ListNode longList = pHead1;
		ListNode shortList = pHead2;
		if(lengthDif < 0) {
			longList = pHead2;
			shortList = pHead1;
			lengthDif = -lengthDif;
		}
		for(int i = 0; i < lengthDif; i++) {
			longList = longList.next;
		}
		while(longList != null && longList != shortList) {
			longList = longList.next;
			shortList = shortList.next;
		}
		return longList;
		
	}
	
	private int getLength(ListNode head) {
		int len = 0;
		while(head != null) {
			len++;
			head = head.next;
		}
		return len;
	}
	
	//方法2:两个指针，p1顺序遍历list1和list2;
	//p2顺序遍历list2和list1
	//最终一定会浪漫地相遇
	public ListNode findFirstCommonNode2(ListNode pHead1,ListNode pHead2) {
		ListNode p1 = pHead1;
		ListNode p2 = pHead2;
		while(p1 != p2) {
			p1 = p1==null ? pHead2 : p1.next;
			p2 = p2==null ? pHead1 : p2.next;
		}
		return p1;
	}
	//如果两个如环结点相交，那么他们的环公用，但是有可能如环一个或者两个结点
	
	public ListNode getIntersectNode(ListNode head1, ListNode head2) {
		if(head1 == null || head2 == null) {
			return null;
		}
		ListNode loop1 = getLoopNode(head1);
		ListNode loop2 = getLoopNode(head2);
		if(loop1 == null && loop2 == null) {
			return noLoop(head1, head2);
		}
		if(loop1 != null && loop2 != null) {
			return bothLoop(head1, loop1, head2, loop2);
		}
		return null;
	}
	
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
	
	
	public ListNode noLoop(ListNode head1, ListNode head2) {
		if(head1 == null || head2 == null) {
			return null;
		}
		ListNode cur1 = head1;
		ListNode cur2 = head2;
		int n = 0;
		while(cur1.next != null) {
			n++;
			cur1 = cur1.next;
		}
		while(cur2.next != null) {
			n--;
			cur2 = cur2.next;
		}
		if(cur1 != cur2) {
			return null;
		}
		// n : 链表1长度减去链表2长度的值
		cur1 = n > 0 ? head1 : head2; // 谁长，谁的头变成cur1
		cur2 = cur1 == head1 ? head2 : head1; // 谁短，谁的头变成cur2
		n = Math.abs(n);
		while(n != 0) {
			n--;
			cur1 = cur1.next;
		}
		while(cur1 != cur2) {
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return cur1;
	}
	
	public ListNode bothLoop(ListNode head1, ListNode loop1, ListNode head2, ListNode loop2) {
		ListNode cur1 = null;
		ListNode cur2 = null;
		//如果只有一个如环结点
		if(loop1 == loop2) {
			cur1 = head1;
			cur2 = head2;
			int n = 0;
			while(cur1 != loop1) {
				n++;
				cur1 = cur1.next;
			}
			while(cur2 != loop2) {
				n--;
				cur2 = cur2.next;
			}
			cur1 = n > 0 ? head1 : head2;
			cur2 = cur1 == head1 ? head2 : head1;
			n = Math.abs(n);
			while(n != 0) {
				n--;
				cur1 = cur1.next;
			}
			while(cur1 != cur2) {
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
			return cur1;
		}else {
			cur1 = loop1.next;
			while(cur1 != loop1) {
				if(cur1 == loop2) {
					return loop1;
				}
				cur1 = cur1.next;
			}
			return null;
		}
	}
}
