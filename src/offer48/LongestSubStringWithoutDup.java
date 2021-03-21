package offer48;
/**
* @author 作者:guan
* @createDate 创建时间：Feb 7, 2021 2:29:14 PM
*/
public class LongestSubStringWithoutDup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println(maxLength("arabcacfr")==4);
        System.out.println(maxLength("a")==1);
        System.out.println(maxLength("aaa")==1);
        System.out.println(maxLength("abcdef")==6);
        System.out.println(maxLength("")==0);
        System.out.println(maxLength(null)==0);
	}

	public static int maxLength(String str) {
		if(str == null || str.length() <= 0) {
			return 0;
		}
		int preLength = 0;
		int curLength = 0;
		int maxLength = 0;
		int[] pos = new int[26];
		for (int i = 0; i < pos.length; i++) {
			pos[i] = -1;
		}
		for(int i = 0; i < str.length(); i++) {
			int letterNumber = str.charAt(i) - 'a';
			if(pos[letterNumber] < 0 || i - pos[letterNumber] > preLength) {
				curLength = preLength + 1;
			}
			else {
				curLength = i - pos[letterNumber];
			}
			pos[letterNumber] = i;
			if(curLength > maxLength) {
				maxLength = curLength;
			}
			preLength = curLength;
		}
		return maxLength;
	}
}
