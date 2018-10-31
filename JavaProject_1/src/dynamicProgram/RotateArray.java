package dynamicProgram;

public class RotateArray {

	public void rotate() {
		int[][] inputArray = { {1,2,3,10},{4,5,6,11},{7,8,9,12},{13,14,15,16}};
		System.out.println("Input Array");
		
		int[][] resultArray = new int[4][4];
		
		for(int i=0; i<inputArray.length; i++) {
			int n=inputArray.length;
			for(int j=0; j<inputArray.length; j++) {
				n=n-1;
				resultArray[i][j] = inputArray[n][i];
			}
		}
		return;
	}
	
	private void printArray(int[][][] inputArray)
	{
		
	}
	public static void main(String[] args) {
		RotateArray obj = new RotateArray();
		obj.rotate();

	}

}
