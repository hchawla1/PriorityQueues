package PQ;

import java.util.PriorityQueue;
/* Sort a nearly sorted (or K sorted) array
 * Given an array of n elements, where each element is at most k away from its target position, 
 * devise an algorithm that sorts in O(n log k) time. 
 */
public class SortAlmostSortedArray {
	public static void main(String args[]) {
		int[] arr = {2, 6, 3, 12, 56, 8};
		int k= 3;
		int[] ans = sort(arr, k);
		for(int i=0; i<ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
	}

	public static int[] sort(int[] arr, int k) {
		int[] ans = new int[arr.length];
		PriorityQueue<Integer> mypq = new PriorityQueue<Integer>(k+1);
		for(int i=0; i<=k; i++) {
			mypq.offer(arr[i]);
		}
		
		 for(int i = k+1, nextEle = 0; nextEle < arr.length; i++, nextEle++) {
			 if(i<arr.length) {
				 ans[nextEle] = mypq.poll();
				 mypq.offer(arr[i]);
			 }else {
				 ans[nextEle] = mypq.poll();
			 }
		 }
		return ans;
	}
}
