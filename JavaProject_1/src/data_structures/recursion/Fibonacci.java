package data_structures.recursion;

public class Fibonacci {
	
	public long fib(long n) {
		
		long[] bottomup = new long[(int)n];
		bottomup[0] =1;
		bottomup[1] =1;
		
		for(int i=3; i<=n; i++) {
			bottomup[i-1] = bottomup[i-3]+bottomup[i-2];
		}
		return bottomup[(int)n-1];
	}

	/*
	 * 1,1,2,3,5,8,13......
	 */
	public static void main(String[] args) {
		Fibonacci fibonacci = new Fibonacci();
		System.out.println(fibonacci.fib(1000));
	}
}
