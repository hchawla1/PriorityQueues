package PQ;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class MinHeapNode {
	Integer data;
	Integer arrayindex;
	Integer nextElementIndex;

	MinHeapNode(int val, int x, int y) {
		data = val;
		arrayindex = x;
		nextElementIndex = y;
	}
}

public class MergeKSortedArrays {
	public static void main(String args[]) {

		int arr[][] = { { 2, 6, 12, 34 }, { 1, 9, 20, 1000 }, { 23, 34, 90, 2000 } };
		List<Integer> head = mergeKSortedArrays(arr);
		System.out.println(head);
	}

	public static List<Integer> mergeKSortedArrays(int arr[][]) {
		int k = arr.length;
		List<Integer> rst = new ArrayList<Integer>();
		if (arr == null || arr.length == 0) {
			return rst;
		}

		PriorityQueue<MinHeapNode> mypq = new PriorityQueue<MinHeapNode>(k, new Comparator<MinHeapNode>() {
			@Override
			public int compare(MinHeapNode o1, MinHeapNode o2) {
				Integer o1data = o1.data;
				Integer o2data = o2.data;
				return -1 * (o2data.compareTo(o1data));
			}
		});

		for(int i=0; i<k; i++) {
			if(arr[i].length != 0) {
				mypq.add(new MinHeapNode(arr[i][0], i, 0));
			}
		}
		
		MinHeapNode node;
		
		while(!mypq.isEmpty()) {
			node = mypq.poll();
			rst.add(node.data);
			
			if(node.nextElementIndex < arr[node.arrayindex].length - 1) {
				mypq.offer(new MinHeapNode(arr[node.arrayindex][node.nextElementIndex + 1], node.arrayindex, node.nextElementIndex + 1));
			}
		}
		
		return rst;
	}

}
