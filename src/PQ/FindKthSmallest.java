package PQ;

import java.util.PriorityQueue;

/*Given an array and a number k where k is smaller than size of array, 
 * we need to find the k'th smallest element in the given array. 
 */

public class FindKthSmallest {

	public static void main(String args[]) {
		int arr[] = {12, 11, 13, 5, 6, 7};
		int k = 4;
		int ans = findKthlargest(arr, k);
		System.out.println(ans);
	}
	
	public static int findKthlargest(int[] arr, int  k) {
		PriorityQueue<Integer> mypq = new PriorityQueue<Integer>();
		
		for(int i=0; i<arr.length; i++) {
			mypq.offer(arr[i]);
		}
		
		for(int i=0; i< k-1; i++) {
			mypq.poll();
		}
		 
		 return mypq.peek();
	}
}
