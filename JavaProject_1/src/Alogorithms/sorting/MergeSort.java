package Alogorithms.sorting;

public class MergeSort {
	
	public void merge(int[] leftArray, int[] rightArray, int[] resultArray) 
	{
		int leftSize = leftArray.length;
		int rightSize = rightArray.length;
		
		int leftIndex = 0;
		int rightIndex = 0;
		int resultIndex = 0;
		
		while((leftIndex <= leftSize-1) && (rightIndex <= rightSize-1)) {
			if(leftArray[leftIndex] <= rightArray[rightIndex]) {
				resultArray[resultIndex] = leftArray[leftIndex];
				leftIndex++;
			}
			else {
				resultArray[resultIndex] = rightArray[rightIndex];
				rightIndex++;
			}
			
			resultIndex++;
		}
		
		while(leftIndex <= leftSize-1) {
			resultArray[resultIndex] = leftArray[leftIndex];
			resultIndex++;
			leftIndex++;
		}
		
		while(rightIndex <= rightSize-1) {
			resultArray[resultIndex] = rightArray[rightIndex];
			resultIndex++;
			rightIndex++;
		}
		
		System.out.println("$$$$ Merged  Array $$$");
		printArray(resultArray);
	}
	
	public void mergeSort(int[] inputArray) 
	{
		System.out.println("## Input Array##");
		printArray(inputArray);
				
		int size = inputArray.length;
		int leftSize = size/2;
		int rightSize = size-leftSize;
		
		int[] leftArray = new int[leftSize];
		int[] rightArray = new int[rightSize];
		
		if(size < 2) //Split the array until it reaches to size 1
			return;
		
		for(int i=0; i <= leftSize-1; i++) //Fill the Left Array
			leftArray[i] = inputArray[i];
		
		for(int i=0; i <= rightSize-1; i++) //Fill the Right Array
			rightArray[i] = inputArray[leftSize+i];
		
		System.out.println("-- Left  Array--");
		printArray(leftArray);
		
		System.out.println("-- Right  Array--");
		printArray(rightArray);
		
		mergeSort(leftArray);
		mergeSort(rightArray);
		merge(leftArray,rightArray,inputArray);
	}
	
	private void printArray(int[] inputArray) {
		StringBuffer buff = new StringBuffer();
		for(int i=0; i<=(inputArray.length)-1; i++) {
			buff.append(inputArray[i]);
			if(i != inputArray.length-1)
				buff.append(",");
		}
		
		System.out.println(buff.toString());
	}

	public static void main(String[] args) {
		MergeSort sort = new MergeSort();
		int[] inputArray = new int[]{10,6,9,5,3,8,2,7,4,1};
		sort.mergeSort(inputArray);		

	}

}
