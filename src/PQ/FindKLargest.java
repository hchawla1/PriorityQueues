package PQ;

import java.util.LinkedList;

/*Given an array and a number k where k is smaller than size of array, 
 * we need to find the k largest element in the given array. 
 */
import java.util.List;
import java.util.PriorityQueue;

public class FindKLargest {
	public static void main(String args[]) {
		int arr[] = { 12, 11, 13, 5, 6, 7 };
		int k = 4;
		List<Integer> ans = findKlargest(arr, k);
		System.out.println(ans);
	}

	public static List<Integer> findKlargest(int[] arr, int k) {
		List<Integer> mylist = new LinkedList<Integer>();
		PriorityQueue<Integer> mypq = new PriorityQueue<Integer>(k);

		for (int i = 0; i < k; i++) {
			mypq.offer(arr[i]);
		}
		for (int i = k; i < arr.length; i++) {
			if (mypq.peek() < arr[i]) {
				mypq.poll();
				mypq.offer(arr[i]);
			}
		}
		while (!mypq.isEmpty()) {
			mylist.add(mypq.poll());
		}
		return mylist;
	}
}
