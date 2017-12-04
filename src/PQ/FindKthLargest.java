package PQ;

import java.util.PriorityQueue;

import java.util.Comparator;
/*Given an array and a number k where k is smaller than size of array, 
 * we need to find the k'th largest element in the given array. 
 */

public class FindKthLargest {

	public static void main(String args[]) {
		int arr[] = {12, 11, 13, 5, 6, 7};
		int k = 4;
		int ans = findKthlargest(arr, k);
		System.out.println(ans);
	}
	
	public static int findKthlargest(int[] arr, int  k) {
		
		PriorityQueue<Integer> mypq = new PriorityQueue<Integer>(arr.length, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return -1 * o1.compareTo(o2);
			}
		});
		
		for(int i=0; i<arr.length; i++) {
			mypq.offer(arr[i]);
		}
		
		for(int i=0; i< k-1; i++) {
			mypq.poll();
		}
		 
		 return mypq.peek();

	}
}
