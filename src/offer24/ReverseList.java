package offer24;

public class ReverseList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public class ListNode {
        int val;
        ListNode next=null;
        ListNode(int val){
            this.val=val;          
        }
    }
    
    /**
     * 三个指针实现
     */
    
    public ListNode reverseList(ListNode head) {
    	if(head == null) {
    		return null;
    	}
    	ListNode pNode = head;
    	ListNode preNode = null;
    	ListNode nextNode = pNode.next;
    	while(nextNode != null) {
    		pNode.next = preNode;
    		preNode = pNode;
    		pNode = nextNode;
    		nextNode = pNode.next;
    	}
    	//This is the last step
    	//Because nextNode is null,the above code block is out 
    	//But the last node is not connected.
    	pNode.next = preNode;
    	return pNode;
    }
    /**
     * 改进
     */
    
    public ListNode reverseList2(ListNode head) {
    	ListNode pre = null;
    	ListNode cur = head;
    	while(cur != null) {
    		ListNode next = cur.next;
    		cur.next = pre;
    		pre = cur;
    		cur = next;
    	}
    	return pre;
    }
    
    /**
     * 递归实现
     */
    
    public ListNode reverseListRecursive(ListNode head){
    	if(head == null || head.next == null) {
    		return null;
    	}
    	ListNode newHead = reverseListRecursive(head.next);
    	head.next.next = head;
    	head.next = null;
    	return newHead;
    }
    
}
