package offer18;

public class DeleteNodeList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DeleteNodeList demo = new DeleteNodeList();
        demo.test1();
        demo.test2();
        demo.test3();
        demo.test4();
        demo.test5();
	}

	public class ListNode{
		int val;
		ListNode next;
		public ListNode(int value, ListNode nextNode) {
			val = value;
			next = nextNode;
		}
	}
	//如果传入的是一个待删除结点的结点指针
	//单指针
	public ListNode deleteNode(ListNode head, ListNode pToBeDeleted) {
		//如果链表为空或者待删除元素为空
		if(head == null || pToBeDeleted == null) {
			return head;
		}
		//待删除结点不是尾结点
		if(pToBeDeleted.next != null) {
			//辅助删除结点nextNode
			ListNode nextNode = pToBeDeleted.next;
			pToBeDeleted.val = nextNode.val;
			pToBeDeleted.next = nextNode.next;
			//最后将辅助结点置为null
			nextNode = null;
		}
		//只有一个结点（既是尾结点，又是头结点）
		else if(head==pToBeDeleted){
			pToBeDeleted = null;
			head = null;
		}
		//链表中有多个结点，删除尾结点
		
		else {
			//需要从头到尾遍历找到尾结点的前一个结点，然后修改它的指针指向
			ListNode preNode = head;
			while(preNode.next != pToBeDeleted && preNode != null) {
				preNode = preNode.next;
			}
			if(preNode == null) {
				System.out.println("无法找到待删除结点!");
				return head;
			}
			//将待删除结点与待删除结点的前一个结点指针指向设置为null
			preNode.next = null;
			pToBeDeleted = null;
		}
		return head;
	}
	//如果传入的是一个待删除结点的值,且该值只有一个
	//双指针
	public ListNode deleteNode2(ListNode head, int val) {
		if(head.val == val) {
			return head.next;
		}
		ListNode pre = head;
		ListNode cur = head.next;
		while(cur != null && cur.val != val) {
			pre = cur;
			cur = cur.next;
		}
		//若cur指向不为，则删除
		//即cur != null && cur.val == val
		if(cur != null) {
			pre.next = cur.next;
		}
		//若cur指向为空，则返回头结点即可
		//即cur == null && cur.val ！= val
		return head;
	}
	
	//另一种解法,左程云
	public static ListNode removeValue(ListNode head, int num) {
		while(head != null) {
			if(head.val != num) {
				break;
			}
			head = head.next;
		}
		//head 来到 第一个不需要删的位置
		ListNode pre = head;
		ListNode cur = head;
		while(cur != null) {
			if(cur.val == num) {
				pre.next = cur.next;
			}else {
				pre = cur;
			}
			cur = cur.next;
		}
		return head;
	}
	void test(ListNode head, ListNode pToBeDeleted) {
		System.out.println("===========");
		System.out.print("The original list is : ");
		ListNode curr = head;
		if(curr != null) {
			while(curr.next != null) {
				System.out.print(curr.val + ",");
				curr = curr.next;
			}
			System.out.println(curr.val);
		}else {
			System.out.println();
		}

		System.out.print("The node to be deleted is : ");
		if(pToBeDeleted != null) {
			System.out.println(pToBeDeleted.val);
		}else {
			System.out.println();
		}
		curr = deleteNode(head, pToBeDeleted);
		System.out.print("The result list is : ");
		if(curr != null) {
			while(curr.next != null) {
                System.out.print(curr.val+",");
                curr=curr.next;
			}
	            System.out.println(curr.val);
		}
		else {
            System.out.println();
        }
        System.out.println("============");
	}
	
    /**
     * 链表含多个结点，删除头结点
     */
    void test1() {
        ListNode p4=new ListNode(4, null);
        ListNode p3=new ListNode(3, p4);
        ListNode p2=new ListNode(2, p3);
        ListNode p1=new ListNode(1, p2);
        test(p1, p1);
    }
    
    /**
     * 链表含多个结点，删除中间结点
     */
    void test2() {
        ListNode p4=new ListNode(4, null);
        ListNode p3=new ListNode(3, p4);
        ListNode p2=new ListNode(2, p3);
        ListNode p1=new ListNode(1, p2);
        test(p1, p3);
    }
    
    /**
     * 链表含多个结点，删除尾结点
     */
    void test3() {
        ListNode p4=new ListNode(4, null);
        ListNode p3=new ListNode(3, p4);
        ListNode p2=new ListNode(2, p3);
        ListNode p1=new ListNode(1, p2);
        test(p1, p4);
    }
    
    /**
     * 链表含一个结点，删除结点
     */
    void test4() {
        ListNode p4=new ListNode(4, null);
        test(p4, p4);
    }
    
    /**
     * 链表为空
     */
    void test5() {
        test(null, null);
    }
}
