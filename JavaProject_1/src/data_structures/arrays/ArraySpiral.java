package data_structures.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class ArraySpiral {

	public ArrayList<Integer> spiralOrder(int[][] A) {
	         ArrayList<Integer> retList = new ArrayList<>();
	        if(A.length == 0)
	        	return retList;
	        int numOfRows = A.length;
	        int numOfColumns = A[0].length;
	        int numOfArrays = ((numOfRows%2) ==0) ? numOfRows/2 : ((numOfRows/2)+1);
	        int numOfArrayColumns = ((numOfColumns%2) ==0) ? numOfColumns/2 : ((numOfColumns/2)+1);
	        if(numOfRows == 1)
	        	numOfArrays = 1;
	        
	        int rowIndex = numOfRows-1;
	        int columnIndex = numOfColumns-1;
	        for(int i=0,j=0; i<numOfArrays&&j<numOfArrayColumns; i++,j++) {
	        		if(rowIndex < 0 || columnIndex < 0)
	        			break;
	               spirals(A,retList,i,rowIndex,i,columnIndex);
	               rowIndex--;
	               columnIndex--;
	        }
	         return retList;
	}
	    
	private void spirals(int[][] A, ArrayList<Integer> retList,
	                                    int startingRow, int endingRow, 
	                                    int startingColumn, int endingColumn) 
	{
	        Stack<Integer> stack = new Stack<>();
	        
	        for(int i=startingRow; i<=endingRow; i++) {
/*	            if(num_columns == 1) {
	                retList.add(A[i][0]);
	                continue;
	            }*/
	            if(i == startingRow ) {
	                for(int j=startingColumn; j<=endingColumn; j++) {
//	                    retList.add(A[i].get[j]);
	                    retList.add(A[i][j]);
	                }
	            }
	            else if(i == endingRow) {
	                for(int j=endingColumn; j >= startingColumn; j--) {
//	                    retList.add(A.get(i).get(j));
	                    retList.add(A[i][j]);
	                }
	            }
	            else {
//	                retList.add(A.get(i).get(endingColumn));
	                retList.add(A[i][endingColumn]);
	                if(endingColumn > startingColumn )
	                	stack.push(A[i][startingColumn]);
	            }
	        }
	        
	        while(!stack.isEmpty())
	        	retList.add(stack.pop());
	        
	        return;
	        
	}
	
	public static void main(String[] args) {
		ArraySpiral obj = new ArraySpiral();
//		int[][] inputArray = { {1,2,3,10},{4,5,6,11},{7,8,9,12},{13,14,15,16}};
//		int[][] inputArray = {{1},{2},{3},{10},{11},{12},{13},{14},{15},{16},{17},{18}};
//		int[][] inputArray = {{1}};
//		int[][] inputArray = {};
//		int[][] inputArray = { {1,2,3},{4,5,6},{7,8,9} };
//		int[][] inputArray = { {1,2,3},{4,5,6},{7,8,9},{10,11,12}};
//		int[][] inputArray = {{1},{2},{3}};
		/*int[][] inputArray =  { {150, 6, 240, 129, 168, 346, 218, 168, 309, 242, 26, 327},
				  {98, 275, 315, 389, 270, 2, 172, 100, 151, 41, 217, 176},
						  {267, 5, 324, 344, 134, 122, 229, 196, 225, 280, 200, 274},
						  {155, 320, 8, 215, 273, 291, 174, 165, 279, 26, 327, 214},
						  {207, 91, 121, 46, 125, 247, 303, 387, 214, 249, 97, 316}};
		*/
		int[][] inputArray = {  {252, 60, 110, 389},
								{311, 84, 264, 305},
								{203, 118, 376, 90},
								{37, 55, 223, 153},
								{234, 335, 52, 263},
								{207, 350, 272, 233},
								{140, 327, 125, 168}};
		
		List inputList = new ArrayList<>();
		for(int[] array : inputArray) {
			inputList.add(Arrays.asList(array));
		}
		/*Arrays.stream(inputArray)
                								.map(Arrays::asList)
                								.collect(Collectors.toList());*/
		ArrayList<Integer> retList = obj.spiralOrder(inputArray);
		retList.forEach(i->System.out.println(i));
		
	}

}
