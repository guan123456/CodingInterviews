package offer05;

public class replaceSpaceOfString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		replaceSpaceOfString test01 = new replaceSpaceOfString();
		System.out.println("方法的输入是非可变长的String：");
		String str = new String("I love you.");
		System.out.println(test01.replaceSpace02(str));
	}

	//最简单
/*	public String replaceSpace02(String s) {	
		return s.replace(" ", "%20");
	}
	*/
	
	public String replaceSpace02(String s) {
		//字符串不合法则返回null
		if(s == null) {
			System.out.print("输入错误！");
			return null;
		}
		//先计算替换后的字符串总长度
		int length = s.length();
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == ' ') {
				length += 2;
			}
		}
		//用char数组存储替换后的字符串
		char[] array = new char[length];
		int size = 0;
		for(int i = 0; i < length; i++) {
			char c = s.charAt(i);
			if(c == ' ') {
				array[size++] = '%';
				array[size++] = '0';
				array[size++] = '2';
			}
			else {
				array[size++] = c;
			}
		}
		//调用该方法将char数组转化为string字符串
		String  newStr  = new String(array,0,size);
		return newStr;
	}
}
