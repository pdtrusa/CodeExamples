package Alogorithms.sorting;

public class SelectSort {
	
	public void sort(int[] inputArray) {
		int size=inputArray.length;
		for(int i=0; i<=size-2;i++) {
			int min_val = inputArray[i];
			int min_index=i;
			for(int j=i+1; j<= size-1; j++) {
				if(inputArray[j] < min_val) {
					min_val = inputArray[j];
					min_index=j;
				}
			}
			
			//Swap the elements
			int temp_val = inputArray[i];
			inputArray[i] = min_val;
			inputArray[min_index] = temp_val;
			
			//Print Array for each iteration
			printArray(inputArray);
		}
	}
	
	private void printArray(int[] inputArray) {
		StringBuffer buff = new StringBuffer();
		for(int i=0; i<=(inputArray.length)-1; i++) {
			buff.append(inputArray[i]).append(",");
		}
		
		System.out.println(buff.toString());
	}
	
	/* Output is this
	1,6,2,7,10,
	1,2,6,7,10,
	1,2,6,7,10,
	1,2,6,7,10,
	*/
	public static void main(String[] args) {
		SelectSort sort = new SelectSort();
		int[] inputArray = new int[]{10,6,2,7,1};
		sort.sort(inputArray);
	}

}
