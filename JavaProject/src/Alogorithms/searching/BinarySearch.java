package Alogorithms.searching;



public class BinarySearch { 

	/*
	 * Assumption is the inputArray is already sorted
	 */
	
	//with Iteration search. Not the recursion
	public int search(int[] inputArray, int searchVal) 
	{
		int start_index = 0;
		int end_index = inputArray.length-1;
		
		while(start_index <= end_index) {
			//Divide the array in to 2 and start the search either left or right of middle
			int middle_index = start_index+(end_index-start_index)/2; //instead of (a+b)/2. To avoid limit of integer max of 2^32-1
			
			if(inputArray[middle_index] == searchVal) {
				return middle_index; 
			}
			else if(inputArray[middle_index] < searchVal) {
				/*
				 * Ignore the left side of the middle index(all lower values)
				 * start searching only right side of the middle index
				 */
				start_index = middle_index+1;
			}
			else {
				end_index = middle_index-1;
			}
		}
		
		return -1;
	}
	
	public int searchCount(int[] inputArray, int searchVal, int start_index, int end_index) 
	{
		int countOfOccurances = 0;
		while(start_index <= end_index) {
			//Divide the array in to 2 and start the search either left or right of middle
			int middle_index = start_index+(end_index-start_index)/2; //instead of (a+b)/2. To avoid limit of integer max of 2^32-1
			
			if(inputArray[middle_index] == searchVal) {
				countOfOccurances++;
//				start_index = middle_index+1;
			}
			else if(inputArray[middle_index] < searchVal) {
				/*
				 * Ignore the left side of the middle index(all lower values)
				 * start searching only right side of the middle index
				 */
				start_index = middle_index+1;
			}
			else {
				end_index = middle_index-1;
			}
		}
		
		return countOfOccurances;
	}
	/*
	 * divide and conquer ( n,n/2,n/4,n/8 iterations)
	 * Time complexity is O(logN)
	 */
	
	public static void main(String[] args) {
		BinarySearch search = new BinarySearch();
		int[] inputArray = new int[]{11,23,25,39,52,71,87,94,99};
		int searchVal = 97;
		int index = search.search(inputArray, searchVal);
		System.out.println("Value is at :"+index);
	}

}
