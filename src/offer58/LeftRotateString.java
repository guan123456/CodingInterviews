package offer58;
/**
* @author 作者:guan
* @createDate 创建时间：Feb 12, 2021 6:19:49 PM
*/
public class LeftRotateString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String leftRotateString(char[] chars,int n) {
		//judge the chars array valid or not
		if(chars == null || chars.length <= 0) {
			return String.valueOf(chars);
		}
		//judge the n valid or not
		if(n <= 0 || n > chars.length) {
			return String.copyValueOf(chars);
		}
		reverse(chars,0,n-1);
		reverse(chars, n, chars.length - 1);
		reverse(chars, 0, chars.length - 1);
		return String.valueOf(chars);

	}
	//如果输入的是String 字符串，那么可以将字符串先转化为char数组
    public String LeftRotateString_1(String str,int n) {
        if(str == null || str.length() <= 0){
            return "";
        }
        if(n <= 0 || n > str.length()){
            return str;
        }
        char[] chars = str.toCharArray();
        reverse(chars,0,n - 1);
        reverse(chars,n,chars.length - 1);
        reverse(chars,0,chars.length - 1);
        return String.valueOf(chars);
    }
	private void reverse(char[] chars, int start,int end) {
		while(start < end) {
			char temp = chars[start];
			chars[start] = chars[end];
			chars[end] = temp;
			start++;
			end--;
		}
	}
	//Another method
    public String LeftRotateString_2(String str,int n) {
        //保证旋转的位数大于字符串的长度，否则返回空字符串
        if(n>str.length())
            return "";
        //把原字符串截取成俩字符串，然后拼接
        String s1 = str.substring(0, n);
        String s2 = str.substring(n,str.length());
        return s2 + s1;
    }
}
