package offer45;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
* @author 作者:guan
* @createDate 创建时间：Feb 6, 2021 12:44:24 PM
*/
public class SortArrayForMinNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String PrintMinNumber(int[] numbers) {
		if(numbers == null || numbers.length <= 0) {
			return "";
		}
		ArrayList<String> list = new ArrayList<>();
		for(int number : numbers) {
			list.add(String.valueOf(number));
		}
		Collections.sort(list,  new Comparator<String>(){
			@Override
			public int compare(String s1, String s2) {
				String a = s1 + s2;
				String b = s2 + s1;
				return a.compareTo(b);
			}
		});
		StringBuilder sb = new StringBuilder();
		for(String str : list) {
			sb.append(str);
		}
		return sb.toString();
	}
	
	public static class MyComparator implements Comparator<String>{
		@Override
		public int compare(String a, String b) {
			return (a + b).compareTo(b + a);
		}
	}
	public static String lowestString(String[] strs) {
		if(strs == null || strs.length == 0) {
			return "";
		}
		Arrays.sort(strs,new MyComparator());
		String res = "";
		for(int i = 0; i < strs.length; i++) {
			res += strs[i];
		}
		return res;
	}
}
