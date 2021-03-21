package offer58;
/**
* @author 作者:guan
* @createDate 创建时间：Feb 12, 2021 6:11:57 PM
*/
public class ReverseWordsInSentence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String ReverseSentence(char[] chars) {
		if(chars == null || chars.length <= 0) {
			return String.valueOf(chars);
		}
		reverseSb(chars,0,chars.length - 1);
		int start = 0;
		int end = 0;
		while(start < chars.length) {
			while(end < chars.length && chars[end] != ' ') {
				end++;
			}
			reverseSb(chars,start,end - 1);
			start = ++end;
		}
		return String.valueOf(chars);
	}
	
	private void reverseSb(char[] chars,int start,int end) {
		while(start <= end) {
			char temp = chars[start];
			chars[start] = chars[end];
			chars[end] = temp;
			start++;
			end--;
		}
	}
	//以下方法在华为那道题可以通过，因为测试用例没那么复杂，测试用例基本是规范的
/*	import java.util.*;
	public class Main {
	    public static void main(String[] args){
	        Scanner scan = new Scanner(System.in);
	        String str = scan.nextLine();
	        int length = str.length();
	        String[] s = str.split(" ");
	        StringBuilder sb = new StringBuilder();
	        for(int i = s.length - 1; i >= 0; i--){
	            sb.append(s[i] + " ");
	        }
	        System.out.println(sb);
	    }

	}
*/
}
