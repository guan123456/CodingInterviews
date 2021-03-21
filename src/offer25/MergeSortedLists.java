package offer25;

public class MergeSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class ListNode{
		int val;
		ListNode next = null;
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	//递归实现
	//返回的头结点
	public ListNode merge(ListNode list1, ListNode list2) {
		if(list1 == null) {
			return list2;
		}
		if(list2 == null) {
			return list1;
		}
		
		if(list1.val < list2.val) {
			//The current miner node point at the next miner
			//that is from the miner node in next two nodes
			list1.next = merge(list1.next, list2);
			return list1;
		}
		else {
			list2.next = merge(list1, list2.next);
			return list2;
		}
	}
	
	//非递归实现
	public ListNode merge2(ListNode list1, ListNode list2) {
		if(list1 == null) {
			return list2;
		}
		if(list2 == null) {
			return list1;
		}
		
		//p = dummyHead means that dummyHead is referred by p
		//when p.next changes,dummyHead.next changes too.
		//But why it can't return p,this is because p changes when p = p.next
		//meanwhile dummyHead is not changed for that
		//so when returning dummyHead,it means return the first node of the list
		ListNode dummyHead = new ListNode(0);
		ListNode p = dummyHead;
		while(list1 != null && list2 != null) {
			if(list1.val < list2.val) {
				p.next = list1;
				list1 =list1.next;
			}
			else {
				p.next = list2;
				list2 = list2.next;
			}
			p = p.next;
		}
		
		if(list1 == null) {
			p.next = list2;
		}
		else {
			p.next = list1;
		}
		return dummyHead.next;
		
	}
	
}
