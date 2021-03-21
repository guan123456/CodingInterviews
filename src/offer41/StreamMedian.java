package offer41;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
* @author 作者:guan
* @createDate 创建时间：Feb 5, 2021 12:34:03 PM
*/
public class StreamMedian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//最大最小堆可以用PriorityQueue实现
	//PriorityQueue默认是一个小顶堆
	//通过传入自定义的Comparator函数可以实现大顶堆
	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
		public int compare(Integer i1,Integer i2) {
			return i2 - i1;
		}
	});
	
	//小顶堆中的元素都比大顶堆中的元素大
	//大顶堆中的元素都比小顶堆中的元素小
	public void Insert(Integer num) {
		//或者minHeap.size() == maxHeap.size()
		if(((minHeap.size() + maxHeap.size()) & 1) == 0) {//偶数时，下个数字加入小顶堆
			if(!maxHeap.isEmpty() && maxHeap.peek() > num) {
				maxHeap.offer(num);
				num = maxHeap.poll();
			}
			minHeap.offer(num);
		}
		else {
			if(!minHeap.isEmpty() && minHeap.peek() < num) {
				minHeap.offer(num);
				num = minHeap.poll();
			}
			maxHeap.offer(num);
		}
	}
	
	public Double GetMedian() {
		if((minHeap.size() + maxHeap.size()) == 0) {
			throw new RuntimeException("No numbers are available!");
		}
		double median;
		if((minHeap.size() + maxHeap.size() & 1) == 0) {
			median = (maxHeap.peek() + minHeap.peek()) / 2.0;
		}
		else {
			median = minHeap.peek();
		}
		return median;
	}
	
}
