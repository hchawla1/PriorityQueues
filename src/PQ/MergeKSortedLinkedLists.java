package PQ;

import java.util.Comparator;
import java.util.PriorityQueue;
/* Merge k sorted lists 
 * Given k sorted linked lists, merge them and return as one sorted list.
 */
class Node {
	private Integer data;
	private Node next;

	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node(int val) {
		data = val;
		next = null;
	}

}

public class MergeKSortedLinkedLists {

	public static void main(String args[]) {
		int numberLists = 3; // Number of linked lists

		Node[] arr = new Node[numberLists];

		arr[0] = new Node(1);
		arr[0].setNext(new Node(3));
		arr[0].getNext().setNext(new Node(5));
		arr[0].getNext().getNext().setNext(new Node(7));

		arr[1] = new Node(2);
		arr[1].setNext(new Node(4));
		arr[1].getNext().setNext(new Node(6));
		arr[1].getNext().getNext().setNext(new Node(8));

		arr[2] = new Node(0);
		arr[2].setNext(new Node(9));
		arr[2].getNext().setNext(new Node(10));
		arr[2].getNext().getNext().setNext(new Node(11));

		Node head = mergeKLists(arr);
		printList(head);

		// System.out.println("Doing again with Linked List of Nodes");
		// List<Node> mylist = new LinkedList<Node>();
		//
		// Node n1 = new Node(1);
		// n1.next = new Node(3);
		// n1.next.next = new Node(5);
		// n1.next.next.next = new Node(7);
		//
		// Node n2 = new Node(2);
		// n2.next = new Node(4);
		// n2.next.next = new Node(6);
		// n2.next.next.next = new Node(8);
		//
		// Node n3 = new Node(0);
		// n3.next = new Node(9);
		// n3.next.next = new Node(10);
		// n3.next.next.next = new Node(11);
		//
		// mylist.add(n1);
		// mylist.add(n2);
		// mylist.add(n3);
		//
		// Node head2 = mergeKList(mylist);
		// printList(head2);
		//
	}

	// private static Node mergeKList(List<Node> mylist) {
	// PriorityQueue<Node> mypq = new PriorityQueue<Node>(mylist.size(), new
	// Comparator<Node>() {
	//
	// @Override
	// public int compare(Node o1, Node o2) {
	// if(o1.data < o2.data) {
	// return -1;
	// }else if(o1.data == o2.data){
	// return 0;
	// }else {
	// return 1;
	// }
	// Integer a = o1.getData();
	// Integer b = o2.getData();
	// return a.compareTo(b);
	//
	// }
	//
	// });
	//
	// for(Node node : mylist) {
	// mypq.add(node);
	// }
	//
	// Node head = new Node(-1);
	// Node curr = head;
	//
	// while(!mypq.isEmpty()) {
	// curr.setNext(mypq.poll());
	// curr = curr.getNext();
	//
	// if(curr.getNext() != null) {
	// mypq.add(curr.getNext());
	// }
	// }
	// return head.getNext();
	// }

	private static void printList(Node head1) {
		while (head1 != null) {
			System.out.print(head1.getData() + " ");
			head1 = head1.getNext();
		}
		System.out.println();
	}

	public static Node mergeKLists(Node[] lists) {

		if (lists.length == 0 || lists == null) {
			return null;
		}

		PriorityQueue<Node> mypq = new PriorityQueue<Node>(lists.length, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				Integer a = o1.getData();
				Integer b = o2.getData();
				return a.compareTo(b);
			}
		});

		Node dummy = new Node(0);
		Node curr = dummy;

		for (Node node : lists) {
			if (node != null) {
				mypq.add(node);
			}
		}

		while (!mypq.isEmpty()) {

			curr.setNext(mypq.poll());
			curr = curr.getNext();

			if (curr.getNext() != null) {
				mypq.add(curr.getNext());
			}
		}
		return dummy.getNext();
	}
}
