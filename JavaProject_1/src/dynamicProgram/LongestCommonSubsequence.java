package dynamicProgram;

public class LongestCommonSubsequence {

	/*
	 * Top Down approach
	 * Recursive + Memoized approach
	 * 
	 * Time Complexity O(Str1 Length X Str2 length)
	 */
	public int lcs(char[] str1, char[] str2, int index_1, int index_2, int[][] resultMatrix, Integer result)
	{
		if(index_1 == -1 || index_2 == -1) //Base case (Exit case)
			return result;
		
		if(resultMatrix[index_1][index_2] != 0) //Base case (Exit case)
			return resultMatrix[index_1][index_2];
		else if(str1[index_1] == str2[index_2]) {
			int newResult = 1 + lcs(str1,str2,index_1-1,index_2-1,resultMatrix, result);
			if(newResult > result)
				result = newResult;
		}
		else {
			int temp1 = lcs(str1,str2,index_1-1,index_2,resultMatrix,result);
			int temp2 = lcs(str1,str2,index_1,index_2-1,resultMatrix,result);
			result = Math.max(temp1, temp2);
		}
		
		resultMatrix[index_1][index_2] = result;
		return result;
	}
	
	/*
	 * Bottom Up + Memoized solution
	 * 
	 * Time Complexity O(str1 length X str2 length)
	 */
	public int lcs_bottomUp(char[] str1, char[] str2)
	{
		int str1_size = str1.length;
		int str2_size = str2.length;
		int[][] resultMatrix = new int[str1_size+1][str2_size+1];
		
		for(int i=0 ; i<=str1.length; i++) 
		{
			for(int j=0; j<=str2.length; j++) 
			{
				if(i==0 || j==0) {
					resultMatrix[i][j] = 0;
					continue;
				}
				
				if(str1[i-1] != str2[j-1]) {
					resultMatrix[i][j] = Math.max(resultMatrix[i-1][j], resultMatrix[i][j-1]);
				}
				else {
					resultMatrix[i][j] = 1 + resultMatrix[i-1][j-1];
				}
			}
		}
		
		return resultMatrix[str1_size][str2_size];
	}
	
	public static void main(String[] args)
	{
		LongestCommonSubsequence obj = new LongestCommonSubsequence();
		String str1 = "abcdaf";
		String str2 = "acbcf";
		
		int[][] resultMatrix = new int[str1.length()][str2.length()];
		Integer result = new Integer(0);
		int res = obj.lcs(str1.toCharArray(), str2.toCharArray(), str1.length()-1, str2.length()-1, resultMatrix,result);
		System.out.println("Result :"+res);
		
		//Bottom up approach
		int res1 = obj.lcs_bottomUp(str1.toCharArray(), str2.toCharArray());
		System.out.println("Result :"+res1);
	}
}
