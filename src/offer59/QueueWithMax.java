package offer59;
/**
* @author 作者:guan
* @createDate 创建时间：Feb 13, 2021 1:46:02 PM
*/

import java.util.ArrayDeque;

public class QueueWithMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        QueueWithMax testQueue = new QueueWithMax();
        // {2}
        testQueue.push_back(2);
        System.out.println(testQueue.max()==2);
        // {2, 3}
        testQueue.push_back(3);
        System.out.println(testQueue.max()==3);
        // {2, 3, 4}
        testQueue.push_back(4);
        System.out.println(testQueue.max()==4);
        // {2, 3, 4, 2}
        testQueue.push_back(2);
        System.out.println(testQueue.max()==4);
        // {3, 4, 2}
        testQueue.pop_front();
        System.out.println(testQueue.max()==4);
        // {4, 2}
        testQueue.pop_front();
        System.out.println(testQueue.max()==4);
        // {2}
        testQueue.pop_front();
        System.out.println(testQueue.max()==2);
        // {2, 6}
        testQueue.push_back(6);
        System.out.println(testQueue.max()==6);
        // {2, 6, 2}
        testQueue.push_back(2);
        System.out.println(testQueue.max()==6);
        // {2, 6, 2, 5}
        testQueue.push_back(5);
        System.out.println(testQueue.max()==6);
        // {6, 2, 5}
        testQueue.pop_front();
        System.out.println(testQueue.max()==6);
        // {2, 5}
        testQueue.pop_front();
        System.out.println(testQueue.max()==5);
        // {5}
        testQueue.pop_front();
        System.out.println(testQueue.max()==5);
        // {5, 1}
        testQueue.push_back(1);
        System.out.println(testQueue.max()==5);   
	}
	private class InternalData{
		int number;
		int index;
		public InternalData(int number,int index) {
			this.number = number;
			this.index = index;
		}
	}

	private ArrayDeque<InternalData> datas = new ArrayDeque<InternalData>();
	private ArrayDeque<InternalData> maximum = new ArrayDeque<InternalData>();
	
	private int curIndex;
	
	public void push_back(int number) {
		//首先往队列data中添加数值
		InternalData curData = new InternalData(number, curIndex);
		datas.addLast(curData);
		//maximum存储的是当前队列里的最大值以及之后可能的最大值
		//所以maximum的队首元素时最大的，maximum中元素肯定是按照递减排序
		while(!maximum.isEmpty() && maximum.getLast().number < number) {
			maximum.removeLast();
		}
		
		maximum.addLast(curData);
		curIndex++;//这一步不能忘
		
	}
	public void pop_front() {
		if(datas.isEmpty()) {
			System.out.println("队列为空，无法删除！");
			return;
		}
		
		InternalData curData = datas.removeFirst();
		
		if(curData.index == maximum.getFirst().index) {
			maximum.removeFirst();
		}
	}
	
	public int max() {
		if(maximum == null) {
			System.out.println("队列为空，无法删除！");
			return 0;
		}
		return maximum.getFirst().number;
	}
}
