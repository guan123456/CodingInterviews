package offer09;

import java.util.Stack;

/**
 * public class
 * 1.如果使用了该类，则类名必须与文件名一致
 * 2.被public修饰的类可以被其他包访问，只要导包就好
 * 
 * class
 * class类可以访问public 类，但不能被其他包访问
 * @author 11976
 *
 */
public class QueueWithTwoStacks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueWithTwoStacks demo = new QueueWithTwoStacks();
		demo.test1();
		demo.test2();

	}
	
	//一个队列里面包含两个方法，所以定义为class
	//这样可通过Queue q = new Queue();
	//q.A()来调用方法
	
	class Queue{
		//创建两个栈
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		
		//进元素，直接往stack1中加入即可
		//不用管stack1中是否有元素
		public void push(int node) {
			stack1.push(node);
		}
		
		//出元素，要判断stack2中是否为空
		//空则要将stack1中元素全部进入
		//不空则可以直接出
		public int pop() {
			//stack2空的情况
			if(stack2.empty()) {
				if(stack1.empty()) {
					//throw new RuntimeException("队列为空！");
					return -1;
				}else {
					while(!stack1.empty()) {
						stack2.push(stack1.pop());
					}
				}

			}
			//stack2 不空的情况
			return stack2.pop();
		}
		
	}
	
	public void test1() {
		Queue queue = new Queue();
		queue.push(1);
		queue.push(2);
		System.out.println(queue.pop());
		queue.push(3);
		System.out.println(queue.pop());
		System.out.println(queue.pop());
	}

    public void test2() {
        Queue queue= new Queue();
        System.out.println(queue.pop());
    }
    
	/**
	 * 同一个java文件只能有一个public class
	 * (加public表示全局类，该类可以import到任何类内
	 * 不加public默认为保留类，只能被同一个包内的其他类引用)
	 * 在public class中写public class作为内部类存在也可以
	 * 也可以在外部去掉public，只写class类，并不作为全局类，只在这个包的其他类引用
	 * public class Main {
 
		    public static void main(String[] args) {
		        System.out.println("Welcome to qunqunstyle's Blog!");
		    }
		    public class QUN {}  //正确，内部类
		}
		
		//因为每个编译单元都只能有一个公共接口，用public类来表现。
		//该接口可以按照要求包含众多的支持包访问权限的类。
		//如果有一个以上的public 类，编译器就会报错。
		public class QUN1{}          //错误
		class  QUN2{}                   //正确，仅被同包的类引用
	 */
}
