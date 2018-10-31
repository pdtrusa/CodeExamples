package Alogorithms.sorting;

public class InsertionSort {

	public void sort(int[] inputArray) {
		int size=inputArray.length;
		
		for(int i=1; i<=size-1; i++) {
			int index = i;
			int tempVal = inputArray[index];
			while(index > 0 && (inputArray[index-1] > tempVal) ) {
				inputArray[index] = inputArray[index-1];
				index--;
			}
			inputArray[index] = tempVal;
			
			//Print Array for each iteration
			printArray(inputArray);
		}
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
		InsertionSort sort = new InsertionSort();
		int[] inputArray = new int[]{10,6,8,7,1};
		sort.sort(inputArray);		
	}

}
