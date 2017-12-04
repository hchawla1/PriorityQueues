package PQ;

import java.util.Iterator;
import java.util.PriorityQueue;

public class PQInBuildClass {

	public static void main(String args[]) {
		PriorityQueue<String> mypq = new PriorityQueue<String>();

		mypq.add("C++");
		mypq.add("C");
		mypq.add("Java");
		mypq.add("Python");

		System.out.println("Head value using peek function:" + mypq.peek());

		System.out.println("The queue elements are ");

		Iterator<String> itr = mypq.iterator();

		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		// Removing Java
		mypq.remove("Java");
		
		System.out.println("after removing Java with" + " remove function:");
		Iterator<String> itr1 = mypq.iterator();
		while (itr1.hasNext())
			System.out.println(itr1.next());
		
		boolean b = mypq.contains("C");
        System.out.println ( "Priority queue contains C" +
                             "ot not?: " + b);
        
        Object[] arr = mypq.toArray();
        System.out.println ( "Value in array: ");
        for (int i = 0; i<arr.length; i++)
          System.out.println ( "Value: " + arr[i].toString()) ;
	}

}
