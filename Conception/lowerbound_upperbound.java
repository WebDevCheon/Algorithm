import java.util.ArrayList;

public class lowerbound_upperbound {
	private static int binary_search(int[] arr,int start,int end,int data) {
		int mid = -1;
		while(start <= end) {
			mid = (start + end) / 2;
			if(arr[mid] < data)
				start = mid + 1;
			else if(arr[mid] > data)
				end = mid - 1;
			else
				return mid;
		}
		return -1;
	}
	
	private static int lower_bound(ArrayList<Integer> list,int start,int end,int data) {
		int mid = -1;
		while(start <= end) {
			mid = (start + end) / 2;
			if(list.get(start) < data)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return start;
	}
	
	private static int upper_bound(int[] arr,int start,int end,int data) {
		int mid = -1;
		while(start <= end) {
			mid = (start + end) / 2;
			if(arr[mid] <= data)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return start;
	}
}
