package codingTest.programmers.sw;

import java.util.ArrayList;
import java.util.List;

public class Result {

    /*
     * Complete the 'balancedSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int balancedSum(List<Integer> arr) {
    // Write your code here
        int result=0;
        for(int i = 0; i < arr.size() ; i++){
            int leftSum=0;
            int rightSum=0;
            
            for(int j=0; j<i; j++){
                leftSum += arr.get(j);
            }
             for(int j=arr.size()-1; j>i; j--){
                rightSum += arr.get(j);
            }
            
            if(leftSum==rightSum){
                result = i;
            }
            
        }
        return result;
    }
    
    public static String lastLetters(String word) {
        // Write your code here
            int lastIndex = word.length();
            String result = "" +word.charAt(lastIndex-1)+word.charAt(lastIndex-2);
            return result;

        }
    
    public static int isPrime(long n) {
    	
    	for(int i=2; i<=Math.sqrt(n); i++) {
    		if(n%i==0) {
    			return i;
    		}
    	}
    	return 1;
    }
    
    public static int minX(List<Integer> arr) {
        
    	int minSum = arr.get(0);
    	int Sum = arr.get(0);
    
    	for(int i=1; i< arr.size(); i++) {
    		System.out.println("sum : "+ Sum);
    		Sum += arr.get(i); 
    		
    		if(Sum < minSum) {
    			minSum = Sum;
    		}
    	}
    	System.out.println(minSum);
    	return minSum*(-1)+1;
    }
    
    public static int countPerms(int n) {
        // Write your code here
    		List<String> list = new ArrayList<String>();
    		list.add("a");
    		list.add("e");
    		list.add("o");
    		list.add("u");
    		list.add("i");
    		
    		
    		for(int i=2; i<=n; i++) {
    			for(int j=list.size()-1; j>=0; j--) {
    				if(list.get(j).charAt(list.get(j).length()-1)=='a') {
    					
    					list.add(list.get(j)+"e");
    					list.remove(j);
    				}
    				
    				if(list.get(j).charAt(list.get(j).length()-1)=='e') {
    					list.add(list.get(j)+"a");
    					list.add(list.get(j)+"i");
    					list.remove(j);
    				}
    				
					if(list.get(j).charAt(list.get(j).length()-1)=='o') {
						list.add(list.get(j)+"i");		
						list.add(list.get(j)+"u");	
						list.remove(j);
					}
					
					if(list.get(j).charAt(list.get(j).length()-1)=='u') {
						list.add(list.get(j)+"a");
						list.remove(j);
					}
					
					if(list.get(j).charAt(list.get(j).length()-1)=='i') {
						list.add(list.get(j)+"a");
						list.add(list.get(j)+"e");
						list.add(list.get(j)+"u");
						list.add(list.get(j)+"o");
						list.remove(j);
					}
    			}
    		}
    		return list.size();
        }
    
    
    public static void main(String[] args) {
		List<Integer> arr = new ArrayList<Integer>();
		arr.add(-5);
		arr.add(4);
		arr.add(-2);
		arr.add(3);
		arr.add(1);
		
		
		String word = "apple";
		System.out.println(lastLetters(word));
		
		long n = 21;
		System.out.println(isPrime(n));
		
		System.out.println(minX(arr));
		
		
	}

}