package PQ;

import java.util.Comparator;
import java.util.PriorityQueue;

/*Implement Stack using Priority Queues
* or Implement Stack using Heaps
*/
class StackElement{
	private Integer key;
	private Integer value;
	
	public StackElement(int k, int v) {
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
public class StackUsingHeaps {
	
	PriorityQueue<StackElement> mypq = new PriorityQueue<StackElement>(10, new Comparator<StackElement>() {

		@Override
		public int compare(StackElement o1, StackElement o2) {
			Integer o2Key = o2.getKey();
			Integer o1key  = o1.getKey();
			return o2Key.compareTo(o1key);
		}
	});
	
	int order = 1;
	
	public void push(int val){
		StackElement element = new StackElement(order++,val);
	    mypq.add(element);
	}
	
	public Integer pop() {
		if(!mypq.isEmpty()) {
			return mypq.poll().getValue();
		}
		return null;
	}
	
	public static void main(String args[]) {
		StackUsingHeaps q = new StackUsingHeaps();
		q.push(2);
		q.push(1);
		q.push(3);
		q.push(0);
		q.push(5);
		
		Integer ans = q.pop();
		System.out.println(ans);
	}
	
	

}
