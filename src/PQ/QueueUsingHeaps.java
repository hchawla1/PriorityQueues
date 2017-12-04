package PQ;

import java.util.Comparator;
import java.util.PriorityQueue;

/*Implement Queue using Priority Queues
 * or Implement Queue using Heaps
 */
		
class QueueElement{
	private Integer key;
	private Integer value;
	
	public QueueElement(int k, int v) {
		key = k;
		value = v;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
}
public class QueueUsingHeaps {
	
	PriorityQueue<QueueElement> mypq = new PriorityQueue<QueueElement>(10, new Comparator<QueueElement>() {

		@Override
		public int compare(QueueElement o1, QueueElement o2) {
			Integer o1key = o1.getKey();
			Integer o2key = o2.getKey();
			return o1key.compareTo(o2key);
		}
		
	});
	
	int order = 1;
	
	public void push(int val){
		QueueElement element = new QueueElement(order++,val);
	    mypq.add(element);
	}
	
	public Integer pop() {
		if(!mypq.isEmpty()) {
			return mypq.poll().getValue();
		}
		return null;
	}
	
	public static void main(String args[]) {
		QueueUsingHeaps q = new QueueUsingHeaps();
		q.push(2);
		q.push(1);
		q.push(3);
		q.push(0);
		q.push(5);
		
		Integer ans = q.pop();
		System.out.println(ans);
	}
}
