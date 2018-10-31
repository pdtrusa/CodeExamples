package Alogorithms.sorting;

public class BubbleSort {
	
	public void sort(int[] inputArray) {
		int size=inputArray.length;
		
		for(int j=size; j>1; j--) {
			for(int i=0; i<=j-2; i++) {
			
				if(inputArray[i+1] < inputArray[i]) {
					//Swap the elements
					int temp_val = inputArray[i];
					inputArray[i] = inputArray[i+1];
					inputArray[i+1] = temp_val;
				}
			}
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
	
	/* Output after each iteration
	 *  6,2,7,1,10
		2,6,1,7,10
		2,1,6,7,10
		1,2,6,7,10
	 */
	public static void main(String[] args) {
		BubbleSort sort = new BubbleSort();
		int[] inputArray = new int[]{10,6,8,7,1};
		sort.sort(inputArray);
	}
}
