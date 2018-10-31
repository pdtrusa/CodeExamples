package dynamicProgram;

public class CatalanNumbers {

	/*
	 * Bottom Up + Memoized solution
	 */
	public int catalan(int index)
	{
		int[] catalan = new int[index+1];
		catalan[0] = 1;
		catalan[1] = 1;
		
		for(int i=2; i <= index; i++) {
			for(int j=0; j < i; j++) {
				catalan[i] += catalan[j] * catalan[i-j-1]; 
			}
		}
		
		return catalan[index];
	}
	/*
	 * Number of Binary Trees possible for a given pre-order subsequence length
	 */
	public static void main(String[] args) {
		CatalanNumbers obj = new CatalanNumbers();
		System.out.println(obj.catalan(5));

	}

}
