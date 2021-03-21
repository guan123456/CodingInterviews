package offer18;

public class DeleteDuplicatedNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        DeleteDuplicatedNode demo= new DeleteDuplicatedNode();
        demo.test1();
        demo.test2();
        demo.test3();
        demo.test4();
        demo.test5();
        demo.test6();
        demo.test7();
        demo.test8();
	}
    class ListNode{
        int val;
         ListNode next = null;

         ListNode(int val,ListNode next) {
             this.val = val;
             this.next=next;
         }
 }
    public ListNode deleteDuplication(ListNode pHead) {
    	if(pHead == null || pHead.next == null) {
    		return pHead;
    	}
    	//First point
    	ListNode preNode = null;
    	//Second point
    	ListNode curNode = pHead;
    	
    	while(curNode != null) {
    		boolean needDelete = false;
    		if(curNode.next != null && curNode.val == curNode.next.val) {
    			needDelete = true;
    		}
    		if(!needDelete) {
    			preNode = curNode;
    			curNode = curNode.next;
    		}else {
    			int dupValue = curNode.val;
    			//Third point
    			ListNode toBeDel = curNode;
    			while(toBeDel != null && toBeDel.val == dupValue) {
    				toBeDel = toBeDel.next;
    			}
    			//When above while loop is done,toBeDel is the next single node 
    			if(preNode == null) {
    				pHead = toBeDel;
    			}
    			else {
    				preNode.next = toBeDel;
    			}
    			//继续往后删除重复元素
    			curNode = toBeDel;
    		}
    	}
    	return pHead;
    }
    
    //========测试代码======
    void test(ListNode pHead) {
        System.out.println("-----------");
        System.out.print("The original list is: ");
        ListNode curr=pHead;
        if(curr!=null) {
            while(curr.next!=null) {
                System.out.print(curr.val+",");
                curr=curr.next;
            }
            System.out.println(curr.val);
        }else {
            System.out.println();
        }
        pHead=deleteDuplication(pHead);
        System.out.print("The result list is: ");
        curr=pHead;
        if(curr!=null) {
            while(curr.next!=null) {
                System.out.print(curr.val+",");
                curr=curr.next;
            }
            System.out.println(curr.val);
        }else {
            System.out.println();
        }
        System.out.println("-----------");
    }
    
    /**
     * 重复结点位于链表头部
     */
    void test1() {
        ListNode p4=new ListNode(3, null);
        ListNode p3=new ListNode(2, p4);
        ListNode p2=new ListNode(1, p3);
        ListNode p1=new ListNode(1, p2);
        test(p1);
    }
    /**
     * 重复结点位于链表尾部
     */
    void test2() {
        ListNode p4=new ListNode(3, null);
        ListNode p3=new ListNode(3, p4);
        ListNode p2=new ListNode(2, p3);
        ListNode p1=new ListNode(1, p2);
        test(p1);
    }
    /**
     * 重复结点位于链表中部
     */
    void test3() {
        ListNode p4=new ListNode(3, null);
        ListNode p3=new ListNode(2, p4);
        ListNode p2=new ListNode(2, p3);
        ListNode p1=new ListNode(1, p2);
        test(p1);
    }
    /**
     * 连续出现重复结点
     */
    void test4() {
        ListNode p6=new ListNode(3, null);
        ListNode p5=new ListNode(3, p6);
        ListNode p4=new ListNode(2, p5);
        ListNode p3=new ListNode(2, p4);
        ListNode p2=new ListNode(1, p3);
        ListNode p1=new ListNode(1, p2);
        test(p1);
    }
    /**
     * 多个重复结点
     */
    void test5() {
        ListNode p6=new ListNode(3, null);
        ListNode p5=new ListNode(3, p6);
        ListNode p4=new ListNode(3, p5);
        ListNode p3=new ListNode(2, p4);
        ListNode p2=new ListNode(1, p3);
        ListNode p1=new ListNode(1, p2);
        test(p1);
    }
    /**
     * 无重复结点
     */
    void test6() {
        ListNode p6=new ListNode(6, null);
        ListNode p5=new ListNode(5, p6);
        ListNode p4=new ListNode(4, p5);
        ListNode p3=new ListNode(3, p4);
        ListNode p2=new ListNode(2, p3);
        ListNode p1=new ListNode(1, p2);
        test(p1);
    }
    /**
     * 单个结点
     */
    void test7() {
        ListNode p1=new ListNode(6, null);
        test(p1);
    }
     
    /**
     * null
     */
    void test8() {
        ListNode p1=null;
        test(p1);
    }
    
    
}
