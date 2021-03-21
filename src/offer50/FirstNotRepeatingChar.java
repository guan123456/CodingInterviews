package offer50;
/**
* @author 作者:guan
* @createDate 创建时间：Feb 8, 2021 1:26:57 PM
*/
public class FirstNotRepeatingChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        FirstNotRepeatingChar demo =new FirstNotRepeatingChar();
        System.out.println((demo.firstNotRepeatingChar("google")=='l'));
        System.out.println((demo.firstNotRepeatingChar("aabccdbd")=='\0'));
        System.out.println((demo.firstNotRepeatingChar("$abcdefg")=='$'));
        System.out.println((demo.firstNotRepeatingChar(null)=='\0'));
	}
	public  char firstNotRepeatingChar(String str) {
		if(str == null) {
			return '\0';
		}
		int[] repetitions = new int[256];
		for(int i = 0; i < str.length(); i++) {
			int loc = (int) str.charAt(i);
			repetitions[loc] += 1;
		}
		for(int i = 0; i < str.length(); i++) {
			int loc = (int) str.charAt(i);
			if(repetitions[loc] == 1) {
				return (char)loc;
			}
		}
		return '\0';
	}

}
