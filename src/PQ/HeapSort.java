package PQ;

public class HeapSort {
	
	public static void main(String args[]) {
		int arr[] = {12, 11, 13, 5, 6, 7};
		
        HeapSort ob = new HeapSort();
        ob.sort(arr);
 
        System.out.println("Sorted array is");
        printArray(arr);
	}

	private static void printArray(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n");
	}

	private void sort(int[] arr) {
		int n = arr.length;
		
		for(int i = n / 2 - 1; i>=0; i--) {
			System.out.println("* " + i +  " " + n);
			maxHeapify(arr, n, i);
		}
		
		printArray(arr);
		for(int i = n-1; i>=0; i--) {
			System.out.println("    " + i +  " ->  " + (n-1));
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			
			maxHeapify(arr, i, 0);
		}
		
	}

	private void maxHeapify(int[] arr, int n, int i) {
		
		int largest = i;
		int l = 2*i + 1;
		int r  = 2*i + 2;
		
		System.out.println("    " + i +  " " + n + " " + l + " " + r + " " +  largest);
		if(l < n && arr[l] > arr[largest]) {
			largest = l;
		}
		
		if(r < n && arr[r] > arr[largest]) {
			largest = r;
		}
		
		if(largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;
			
			maxHeapify(arr, n, largest);
		}
		
	}
	
	

}
