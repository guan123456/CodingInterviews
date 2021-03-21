package offer06;

import java.util.ArrayList;
import java.util.Stack;



import javax.xml.soap.Node;

public class PrintListInReverseOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PrintListInReverseOrder stack1 = new PrintListInReverseOrder();
		stack1.test();
		
	}
	
	  class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			val = x;
		}

	}
	
	public void test() {
        ListNode ListNode1 = new ListNode(1);
        ListNode ListNode2 = new ListNode(2);
        ListNode ListNode3 = new ListNode(3);
        ListNode ListNode4 = new ListNode(4);
        ListNode ListNode5 = new ListNode(5);
        ListNode1.next=ListNode2;
        ListNode2.next=ListNode3;
        ListNode3.next=ListNode4;
        ListNode4.next=ListNode5;
		System.out.println("栈实现1：");
		int[] s = reversePrint_Stack01(ListNode1);
		for(int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}
		System.out.println("栈实现2：");
		reversePrint_Stack02(ListNode1);
		System.out.println("递归实现1：");
		reversePrint_Recursively(ListNode1);

	}
	
	//栈实现方式1,要返回一个int数组
	public int[] reversePrint_Stack01(ListNode head) {
		//创建一个链表栈的方式
		Stack<ListNode> stack = new Stack<ListNode>();
		//遍历链表加入栈中
		ListNode node = head;
		while(node != null) {
			stack.push(node);
			node = node.next;
		}
		
		//因为要返回的是一个数组，所以需要知道栈的大小
		int size = stack.size();
		int[] print = new int[size];
		for(int i = 0; i < size; i++) {
			print[i] = stack.pop().val;
		}
	return print;
	}
	
	//栈实现方式1,其实还可这样
	public int[] reversePrint_Stack01_1(ListNode head) {
		//创建一个链表栈的方式
		Stack<ListNode> stack = new Stack<ListNode>();
		//遍历链表加入栈中
		ListNode node = head;
		int size = 0;
		while(node != null) {
			stack.push(node);
			node = node.next;
			size++;
		}
		int[] print = new int[size];
		int i = 0;
		while(!stack.isEmpty()) {
			print[i++] = stack.pop().val;
		}
	return print;
	}
	//栈实现方式2,不用返回，直接输出
	public void reversePrint_Stack02(ListNode head) {
		Stack<ListNode> stack = new Stack<ListNode>();
		ListNode node = head;
		while(node != null) {
			stack.push(node);
			node = node.next;
		}
		
		while(!stack.empty()) {
			System.out.println(stack.pop().val);
		}
	}
	
	//递归实现方式1
	public void reversePrint_Recursively(ListNode head) {

		if(head != null) {
			reversePrint_Recursively(head.next);
			System.out.println(head.val);
		}else {
			return;
		}
	}
	
	//递归实现方式2
	ArrayList<Integer> array = new ArrayList<Integer>();
	public int[] reversePrint_2(ListNode head) {
		reversePrint_Recursively_1(head);
		int[] res = new int[array.size()];
		for(int i = 0; i < res.length; i++) {
			res[i] = array.get(i);
		}
		return res;
	}
	public void reversePrint_Recursively_1(ListNode head) {

		if(head != null) {
			reversePrint_Recursively_1(head.next);
			array.add(head.val);
		}else {
			return ;
		}
	}
	
}
