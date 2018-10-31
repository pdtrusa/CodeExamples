package dynamicProgram;

public class Fibonacci {
	/*
	 * Time complexity is O(2^n)
	 */
	public long fib(int n) {
		long res = 0;
		
		if(n==1 || n==2)
			res = 1;
		else
			res = fib(n-2) + fib(n-1);
		
		return res;
	}
	
	/*
	 * Time Complexity is O(n)
	 * 
	 * Top Down Approach
	 * Fill the memorized array from Left to Right when we traverse the iteration
	 * 
	 */
	public long fib_memoized(int n, long[] memo) {
		
		if(memo[n-1] != 0L)
			return memo[n-1];
		
		long res = 0;
		if(n==1 || n==2)
			res = 1;
		else
			res = fib_memoized(n-2,memo) + fib_memoized(n-1,memo);
		
		memo[n-1] = res;
		return res;
	}
	
	/*
	 * Time Complexity O(n)
	 * 
	 * Fill the array in the sequential order until we reach Nth element
	 */
	public long fib_bottomUp(int n) {
		long[] bottomUp = new long[n];
		
		if(bottomUp[n-1] != 0)
			return bottomUp[n-1];
		
		bottomUp[0] = 1;
		bottomUp[1] = 1;
		
		for(int i=2; i<n; i++)
			bottomUp[i] = bottomUp[i-2] + bottomUp[i-1];
		
		return bottomUp[n-1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fibonacci obj = new Fibonacci();
		
		System.out.println("Recursive Method");
		long time1 = System.currentTimeMillis();
		
		//Method Execute
		long res = obj.fib(50);
		
		long time2 = System.currentTimeMillis();
		System.out.println(res+"-- Time Taken:"+(time2-time1));
		
		System.out.println("Memoized Method");
		long time3 = System.currentTimeMillis();

		//Method Execute
		res = obj.fib_memoized(1000, new long[1000]);
		
		long time4 = System.currentTimeMillis();
		System.out.println(res+"-- Time Taken(ms):"+(time4-time3));
		
		System.out.println("Bottom Up Method");
		long time5 = System.currentTimeMillis();
		
		//Method Execute
		res = obj.fib_bottomUp(10000);
		
		long time6 = System.currentTimeMillis();
		System.out.println(res+"-- Time Taken(ms):"+(time6-time5));
	}

}
