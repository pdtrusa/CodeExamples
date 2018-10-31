package dynamicProgram;

import java.util.HashMap;

public class SetsOfNumbers 
{
	public int findSets(int[] array, int total, int index, HashMap<String,Integer> mem)
	{
		int result = 0;
		String memKey = total+":"+index;
		if(mem.get(memKey) != null)
			return mem.get(memKey);
		else if(total == 0)
			return 1;
		else if(index < 0)
			return 0;
		else if(total < array[index]) {//can not consider that element and move to previous index
			result = findSets(array,total,index-1,mem);
		}
		else {
			//Either consider that element and move to previous element by subtracting the number
			//Or do not consider and move on to previoius element with total as is..
			int remainingTotal = total-array[index];
			int res1 = findSets(array,remainingTotal,index-1,mem);
			int res2 = findSets(array,total,index-1,mem);
			result = res1+res2;
		}
		
		mem.put(memKey, result);
		return result;
	}
	
	public static void main(String[] args) {
	
		SetsOfNumbers obj = new SetsOfNumbers();
		int[] inputArray = new int[] {2,4,6,10};
		int total = 5;
		int index = inputArray.length-1;//Start from last index
		int result = obj.findSets(inputArray,total,index, new HashMap<>());
		System.out.println("Total number of sets :"+result);

	}

}
