package offer57;
/**
* @author 作者:guan
* @createDate 创建时间：Feb 12, 2021 6:03:21 PM
*/

import java.util.ArrayList;

public class ContinuousSwquenceWithSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum){
        ArrayList<ArrayList<Integer> > sequenceList = new ArrayList<ArrayList<Integer> >();
        if(sum <= 0) {
        	return sequenceList;
        }
        
        int small = 1;
        int big = 2;
        int curSum = small + big;
        while(small <= sum / 2) {
        	if(curSum == sum) {
        		ArrayList<Integer> sequence = new ArrayList<>();
        		for(int i = small; i <= big; i++) {
        			sequence.add(i);
        		}
        		sequenceList.add(sequence);
        		curSum -= small;
        		small++;
        	}
        	if(curSum < sum) {
        		big++;
        		curSum += big;
        	}
        	if(curSum > sum) {
        		curSum -= small;
        		small++;
        	}
        }
        return sequenceList;
	}
}
