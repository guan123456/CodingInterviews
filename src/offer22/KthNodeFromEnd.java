package offer22;

import java.util.Stack;


public class KthNodeFromEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		KthNodeFromEnd demo = new KthNodeFromEnd();
		demo.test1();
		demo.test2();
		demo.test3();
		demo.test4();
		demo.test5();
		demo.test6();
	}
	
	public class ListNode{
		int val;
		ListNode next = null;
		ListNode(int x){
			val = x;
		}
	}

	//方法1：利用栈
	public ListNode FindKthNodeToTail(ListNode head, int k) {
		if(head == null || k <= 0) {
			return null;
		}
		
		int numOfList = 1;
		Stack<ListNode> st = new Stack<ListNode>();
		
		//这下面两句可以省略，只不过要把上面的numOfList 的值初试为0
		st.push(head);
		ListNode node = head.next;
		while(node != null) {
			numOfList++;
			st.push(node);
			node = node.next;
		}
		if(k > numOfList) {
			return null;
		}
		else {
			for(int i = 1; i <= k; i++) {
				node =st.pop();
			}
			return node;
		}
	}
	
	//方法2：利用相距为k-1的快慢双指针
	public ListNode FindKthToTail2(ListNode head, int k) {
		if(head == null || k <= 0) {
			return null;
		}
		ListNode pAhead = head;
		for(int i = 1; i < k; i++) {
			pAhead = pAhead.next;
			if(pAhead == null) {
				return null;
			}
		}
		ListNode pBehind = head;
		while(pAhead.next != null) {
			pAhead = pAhead.next;
			pBehind = pBehind.next;
		}
		return pBehind;
	}
    //=====================测试代码=======================
    
    /*
     * null
     */
	void test1() {
		ListNode head = null;
		ListNode result = FindKthToTail2(head, 1);
		if(result == null) {
			System.out.println("test1 passed.");
		}
		else {
			System.out.println("test1 failed.");
		}
	}
	
    /*
     * k超出范围
     */
    void test2() {
        ListNode head=new ListNode(2);
        ListNode result=FindKthToTail2(head, 2);
        if(result==null)
            System.out.println("test2 passed!");
        else
            System.out.println("test2 failed!");   
    }
    
    /*
     * 单个结点
     */
    void test3() {
        ListNode head=new ListNode(1);
        ListNode result=FindKthToTail2(head, 1);
        if(result.val==1)
            System.out.println("test3 passed!");
        else
            System.out.println("test3 failed!");   
    }
    
    /*
     * 尾结点
     */
    void test4() {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        ListNode result=FindKthToTail2(node1, 1);
        if(result.val==4)
            System.out.println("test4 passed!");
        else
            System.out.println("test4 failed!");   
    }
    
    /*
     * 中间结点
     */
    void test5() {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        ListNode result=FindKthToTail2(node1, 2);
        if(result.val==3)
            System.out.println("test5 passed!");
        else
            System.out.println("test5 failed!");   
    }
    /*
     * 头结点
     */
    void test6() {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        ListNode result=FindKthToTail2(node1, 4);
        if(result.val==1)
            System.out.println("test6 passed!");
        else
            System.out.println("test6 failed!");   
    }
}
