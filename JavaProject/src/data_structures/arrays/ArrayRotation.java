package data_structures.arrays;

public class ArrayRotation {
	public void rotate(int[][] inputArray) {
		
		int[][] resultArray = new int[4][4];
		
		for(int i=0; i<inputArray.length; i++) {
			int n=inputArray.length;
			for(int j=0; j<inputArray.length; j++) {
				n=n-1;
				resultArray[i][j] = inputArray[n][i];
			}
		}
		
		printArray(resultArray);
		return;
	}
	
	private void printArray(int[][] inputArray)
	{
		StringBuffer buff = new StringBuffer();
		for(int i=0; i< inputArray.length; i++) {
			for(int j=0; j< inputArray[i].length; j++) {
				buff.append(inputArray[i][j]+" ");
			}
			buff.append("\n");
		}
		System.out.println(buff.toString());
	}
	
	public static void main(String[] args) {
		ArrayRotation obj = new ArrayRotation();
		int[][] inputArray = { {1,2,3,10},{4,5,6,11},{7,8,9,12},{13,14,15,16}};
		obj.rotate(inputArray);

	}
}
