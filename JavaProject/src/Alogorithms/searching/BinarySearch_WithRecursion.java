package Alogorithms.searching;

import java.util.concurrent.atomic.AtomicInteger;

public class BinarySearch_WithRecursion {

	/*
	 * Assumption is the inputArray is already sorted
	 */
	public int search(int[] inputArray, int searchVal, int start_index, int end_index) 
	{
		int resultIndex = -1;
		if(start_index > end_index)
			return resultIndex;
		
		//Divide the array in to 2 and start the search either left or right of middle
		int middle_index = start_index+(end_index-start_index)/2; //instead of (a+b)/2. To avoid limit of integer max of 2^32-1
		
			
		if(inputArray[middle_index] == searchVal) {
			resultIndex = middle_index; 
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
		
		
		return resultIndex;
	}
	
	/*
	 * First Occurrence of an element
	 */
	public int firstOccurrence(int[] inputArray, int searchVal, int start_index, int end_index,AtomicInteger firstOccurrence)
	{
		if(start_index > end_index)
			return firstOccurrence.get();
		
		//Divide the array in to 2 and start the search either left or right of middle
		int middle_index = start_index+(end_index-start_index)/2; //instead of (a+b)/2. To avoid limit of integer max of 2^32-1
		
			
		if(inputArray[middle_index] == searchVal) {
			 
			firstOccurrence.set(middle_index);
			
			//Search to the left side of the middle index
			int new_end_index = middle_index-1;
			firstOccurrence(inputArray,searchVal,start_index,new_end_index,firstOccurrence);//Recursion
		}
		else if(inputArray[middle_index] < searchVal) {//search right of middle index
			/*
			 * Ignore the left side of the middle index(all lower values)
			 * start searching only right side of the middle index
			 */
				start_index = middle_index+1;
				firstOccurrence(inputArray,searchVal,start_index,end_index,firstOccurrence); //Recursion
		}
		else { //Search left side of middle index
			end_index = middle_index-1;
			firstOccurrence(inputArray,searchVal,start_index,end_index,firstOccurrence);//Recursion
		}
		
		
		return firstOccurrence.get();
	}
	
	/*
	 * Last Occurrence of an element
	 */
	public int lastOccurrence(int[] inputArray, int searchVal, int start_index, int end_index,AtomicInteger lastOccurrence)
	{
		if(start_index > end_index)
			return lastOccurrence.get();
		
		//Divide the array in to 2 and start the search either left or right of middle
		int middle_index = start_index+(end_index-start_index)/2; //instead of (a+b)/2. To avoid limit of integer max of 2^32-1
		
			
		if(inputArray[middle_index] == searchVal) {
			 
			lastOccurrence.set(middle_index);
			
			//Count to the right side of the middle index
			int new_start_index = middle_index+1;
			lastOccurrence(inputArray,searchVal,new_start_index,end_index,lastOccurrence);//Recursion
		}
		else if(inputArray[middle_index] < searchVal) { //search right of middle index
			/*
			 * Ignore the left side of the middle index(all lower values)
			 * start searching only right side of the middle index
			 */
				start_index = middle_index+1;
				lastOccurrence(inputArray,searchVal,start_index,end_index,lastOccurrence); //Recursion
		}
		else { //search left of middle index
			end_index = middle_index-1;
			lastOccurrence(inputArray,searchVal,start_index,end_index,lastOccurrence);//Recursion
		}
		
		
		return lastOccurrence.get();
	}
	
	/*
	 * Number of times an element is present
	 */
	public int countOfOccurrences(int[] inputArray, int searchVal, int start_index, int end_index,AtomicInteger countOfOccurrences)
	{
		if(start_index > end_index)
			return countOfOccurrences.get();
		
		//Divide the array in to 2 and start the search either left or right of middle
		int middle_index = start_index+(end_index-start_index)/2; //instead of (a+b)/2. To avoid limit of integer max of 2^32-1
		
			
		if(inputArray[middle_index] == searchVal) {
			countOfOccurrences.incrementAndGet(); 
			
			//Count to the right side of the middle index
			int new_start_index = middle_index+1;
			countOfOccurrences(inputArray,searchVal,new_start_index,end_index,countOfOccurrences); //Recursion
			
			//Count to the left side of the middle index
			int new_end_index = middle_index-1;
			countOfOccurrences(inputArray,searchVal,start_index,new_end_index,countOfOccurrences);//Recursion
		}
		else if(inputArray[middle_index] < searchVal) {
			/*
			 * Ignore the left side of the middle index(all lower values)
			 * start searching only right side of the middle index
			 */
				start_index = middle_index+1;
				countOfOccurrences(inputArray,searchVal,start_index,end_index,countOfOccurrences); //Recursion
		}
		else {
			end_index = middle_index-1;
			countOfOccurrences(inputArray,searchVal,start_index,end_index,countOfOccurrences);//Recursion
		}
		
		
		return countOfOccurrences.get();
	}
	
	/*
	 * divide and conquer ( n,n/2,n/4,n/8 iterations)
	 * Time complexity is O(logN)
	 */
	public static void main(String[] args) {
		BinarySearch_WithRecursion search = new BinarySearch_WithRecursion();
		int[] inputArray = new int[]{11,23,23,23,23,23,25,39,52,71,87,94,99};
//		int[] inputArray = new int[]{11,23,25,39};
		int searchVal = 10;
		
		
		int index = search.search(inputArray, searchVal,0,inputArray.length-1);
		System.out.println("Value is at :"+index);
		
		//Find the first occurrence of a value
		AtomicInteger firstOccurence = new AtomicInteger();
		int first = search.firstOccurrence(inputArray, searchVal,0,inputArray.length-1,firstOccurence);
		System.out.println("First Occurrence is at :"+first+":"+firstOccurence.get());
		
		//Find the last occurrence of a value
		AtomicInteger lastOccurence = new AtomicInteger();
		int last = search.lastOccurrence(inputArray, searchVal,0,inputArray.length-1,lastOccurence);
		System.out.println("Last Occurrence is at :"+last+":"+lastOccurence.get());
		
		//Find out how many times a particular element present in the array
		AtomicInteger countOfOccurrences = new AtomicInteger();
		int count = search.countOfOccurrences(inputArray, searchVal,0,inputArray.length-1,countOfOccurrences);
		System.out.println("Count Value is :"+count+":"+countOfOccurrences);
		
	}
}
