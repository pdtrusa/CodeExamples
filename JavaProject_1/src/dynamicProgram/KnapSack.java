package dynamicProgram;

public class KnapSack {

	/*
	 * Top down approach ( Matrix is filled from the last box of the matrix
	 * Recursive + Memoization
	 * 
	 * Time Complexity O(n)
	 */
	public int knapSack(int index, int max_sack_capacity, int[] weights, int[] costs, int[][] resultArray)
	{
		int result = 0;
		
		if(index == 0 || max_sack_capacity == 0)
			return 0;
		if(resultArray[index-1][max_sack_capacity-1] != 0)
			return resultArray[index-1][max_sack_capacity-1];
		
		if(weights[index-1] > max_sack_capacity)
			result = knapSack(index-1, max_sack_capacity, weights, costs, resultArray);
		else {
			//If the item is not added in to the sack
			int temp1 = knapSack(index-1, max_sack_capacity, weights, costs, resultArray);
			
			//If the item is added and left of over capacity is filled with previous items
			int temp2 = costs[index-1]+knapSack(index-1, (max_sack_capacity- weights[index-1]),
								weights, costs, resultArray);
			result = Math.max(temp1, temp2);
			resultArray[index-1][max_sack_capacity-1] = result;
		}
		
		return result;
	}
	
	/*
	 * The matrix is filled from the first element
	 * Bottom Up + Memoized
	 * 
	 * Time Complexity o(n)
	 */
	public int knapSack_bottomUp(int max_sack_capacity, int[] weights, int[] costs)
	{
		int numberOfItems = weights.length;
		int[][] resultArray = new int[numberOfItems][max_sack_capacity+1];
		for(int i=0; i < numberOfItems; i++) 
		{
			for(int j=0; j<=max_sack_capacity; j++) 
			{
				int remaining_sack_capacity = j;
				if(i==0 || j==0) {
					resultArray[i][j] = 0;
				}
				else if(weights[i] > remaining_sack_capacity) {
					resultArray[i][j] = resultArray[i-1][j];
				}
				else {
					remaining_sack_capacity = j-weights[i];
					int temp1 = costs[i]+resultArray[i-1][remaining_sack_capacity];
					int temp2 = resultArray[i-1][j];
					resultArray[i][j] = Math.max(temp1, temp2);
				}
			}
		}
		return resultArray[numberOfItems-1][max_sack_capacity];
	}
	
	public static void main(String[] args) {
		int[] item_weights = {0,1,3,4,5};
		int[] item_costs = {0,1,4,5,7};
		int numOfItems = item_weights.length;
		int index = numOfItems; // Start from last element-- BottomUp
		int max_sack_capacity = 7;
		
		int[][] resultArray = new int[numOfItems][max_sack_capacity];
		
		KnapSack obj = new KnapSack();
		int maxValue = obj.knapSack(index, max_sack_capacity, item_weights, item_costs,  resultArray);
//		System.out.println("Max Value :"+resultArray[numOfItems-1][max_sack_capacity-1]);
		System.out.println("Max Value :"+maxValue);
		
		int maxVal = obj.knapSack_bottomUp(max_sack_capacity, item_weights, item_costs);
		System.out.println("Max Value :"+maxVal);
	}
}
