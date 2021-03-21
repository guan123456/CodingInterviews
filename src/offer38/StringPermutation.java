package offer38;

import java.util.ArrayList;
import java.util.Collections;

public class StringPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringPermutation demo = new StringPermutation();
		demo.test();

	}

	public ArrayList<String> Permutation(String str){
		ArrayList<String> list = new ArrayList<>();
		if(str == null || str.length() == 0) {
			return list;
		}
		permutationCore(str.toCharArray(),0,list);
		Collections.sort(list);
		
		return list;
	}
	private void permutationCore(char[] strArray, int index, ArrayList<String> list) {
		if(index == strArray.length -  1) {
			if(!list.contains(String.valueOf(strArray))) {
				list.add(String.valueOf(strArray));
			}
		}
		else {
			for(int i = index; i < strArray.length; i++) {
				
				char temp = strArray[index];
				
				strArray[index] = strArray[i];
				strArray[i] = temp;
				
				permutationCore(strArray, index + 1, list);
				
				strArray[i] = strArray[index];
				strArray[index] = temp;
			}
		}
	}
	
	public void test() {
		String str = "abc";
         ArrayList<String> list = Permutation(str);
        System.out.println("调整结果："+list);
	}
}
