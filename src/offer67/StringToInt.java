package offer67;
/**
* @author 作者:guan
* @createDate 创建时间：Feb 16, 2021 8:52:00 PM
*/
public class StringToInt {


	static boolean isValid = false;
	public static int strToInt(String str) {
		if(str == null || str.length() <= 0) {
			return 0;
		}
		//都是先将string字符串转换成char数组
		char[] chars = str.toCharArray();
		long num = 0;
		boolean minus = false;
		for(int i = 0; i < chars.length; i++) {
			if(i == 0 && chars[i] == '-') {
				minus = true;
			}else if(i == 0 && chars[i] == '+') {
				minus = false;
			}else {
				int a = (int)(chars[i] - '0');
				if(a < 0 || a > 9) {
					isValid = false;
					return 0;
				}
				//这里因为是负数，所以只能一直减才能得到最终的数字
				//因为a是正数，所以不能加
				num = (minus == false) ? num * 10 + a : num * 10 - a;
				isValid = true;
				if((!minus && num > 0x7FFFFFFF)
						||(minus && num < 0x80000000)) {
					isValid = false;
					return 0;
				}
				
			}
		}
		return (int)num;
	}
	
	   public static void main(String[] args) {
	        System.out.println(strToInt("1948243")==1948243);
	        System.out.println(isValid==true);
	        System.out.println(strToInt("+1948243")==1948243);
	        System.out.println(isValid==true);
	        System.out.println(strToInt("-1948243")==-1948243);
	        System.out.println(isValid==true);
	        System.out.println(strToInt("-0")==0);
	        System.out.println(isValid==true);
	        System.out.println(strToInt("-194+8243")==0);
	        System.out.println(isValid==false);
	        System.out.println(strToInt("")==0);
	        System.out.println(isValid==false);
	        System.out.println(strToInt(null)==0);
	        System.out.println(isValid==false);
	        System.out.println(strToInt("999999999999999")==0);
	        System.out.println(isValid==false);
	        System.out.println(strToInt("+")==0);
	        System.out.println(isValid==false);
	         
	        System.out.println(strToInt("2147483647")==2147483647); //0x7FFFFFFF
	        System.out.println(isValid==true);
	        System.out.println(strToInt("2147483648")==0);
	        System.out.println(isValid==false);
	         
	        System.out.println(strToInt("-2147483648")==-2147483648); //0x80000000
	        System.out.println(isValid==true);
	        System.out.println(strToInt("-2147483649")==0);
	        System.out.println(isValid==false);
	    }
}
