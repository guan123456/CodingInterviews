package offer52;
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
}
