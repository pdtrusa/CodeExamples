package Alogorithms.searching;

public class CicularlySortedArray {

	public int findMinimumValIndex(int[] inputArray, int start_index, int end_index, int searchVal)
	{
		
		int minimumValIndex = 0;
		if(start_index > end_index)
			return minimumValIndex;
		
		//Divide the array in to 2 and start the search either left or right of middle
		int middle_index = start_index+(end_index-start_index)/2; //instead of (a+b)/2. To avoid limit of integer max of 2^32-1

		if((inputArray[middle_index-1] > inputArray[middle_index]) && 
				inputArray[middle_index] < inputArray[middle_index+1])
			return middle_index;
		
		if(inputArray[middle_index-1] > inputArray[middle_index]) {
				start_index = middle_index+1;
			findMinimumValIndex(inputArray, start_index, end_index,searchVal);
		}
		else if(inputArray[middle_index] < searchVal) {
			/*
			 * Ignore the left side of the middle index(all lower values)
			 * start searching only right side of the middle index
			 */
				start_index = middle_index+1;
				resultIndex = search(inputArray,searchVal,start_index,end_index); //Recursion
		}
		else {
			end_index = middle_index-1;
			resultIndex = search(inputArray,searchVal,start_index,end_index);//Recursion
		}
		
		return minimumValIndex;
		
	}
	
	public static void main(String[] args) {


	}

}
