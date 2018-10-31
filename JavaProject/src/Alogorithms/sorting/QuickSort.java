package Alogorithms.sorting;

public class QuickSort {
	
	public void quickSort(int[] inputArray, int startIndex, int endIndex) 
	{
		if(startIndex < endIndex) {
			int partitionIndex = partitionArray(inputArray,startIndex,endIndex);
			quickSort(inputArray,startIndex,partitionIndex-1);
			quickSort(inputArray,partitionIndex+1,endIndex);
		}
	}

	public int partitionArray(int[] inputArray, int startIndex, int endIndex)
	{
		//Choose the last element as pivot and arrange the rest of the elements
		//smaller values to the left of the pivot and larger values to the right
		
		int pivotValue = inputArray[endIndex];
		int partitionIndex = startIndex;
		
		
		for(int i=startIndex; i<= endIndex; i++) {
			if(inputArray[i] <= pivotValue) {
				//swap the inputArray value with partitionIndexedValue
				//move the partition to next position
				int temp = inputArray[i];
				inputArray[i] = inputArray[partitionIndex];
				inputArray[partitionIndex] = temp;
				
				partitionIndex++;
			}
		}
		
		printArray(inputArray);
		return partitionIndex-1;
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
		QuickSort sort = new QuickSort();
		int[] inputArray = new int[]{10,6,9,5,3,8,2,4,1,7};
		sort.quickSort(inputArray,0,9);
		System.out.println("Returning---");
		return;

	}

}
