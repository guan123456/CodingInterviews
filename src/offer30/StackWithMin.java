package offer30;

import java.util.Stack;

public class StackWithMin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Stack<Integer> stack_data = new Stack<Integer>();
	Stack<Integer> stack_min = new Stack<Integer>();
	
	//When pushing new node,two stacks must operate together
	public void push(int node) {
		stack_data.push(node);
		if(stack_min.empty() || stack_min.peek() > node) {
			stack_min.push(node);
		}
		else {
			stack_min.push(stack_min.peek());
		}
	}
	//When popping node,two stacks must operate together
	public void pop() {
		if(!stack_data.empty()) {
			stack_data.pop();
			stack_min.pop();
		}
	}
	
	//When getting the minimum node,just to operate the stack_min 
	//The operation of peek doesn't change(delete) the top node in stack
	//it just gets the value of the top node
	public int min() {
		return stack_min.peek();
	}
	
	//When getting the top node,just to operate the stack_data
	//The operation of peek doesn't change(delete) the top node in stack
	//it just gets the value of the top node
	public int top() {
		return stack_data.peek();
	}
}
