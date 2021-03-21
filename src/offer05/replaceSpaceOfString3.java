package offer05;

public class replaceSpaceOfString3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		replaceSpaceOfString3 test01 = new replaceSpaceOfString3();
		System.out.println("方法的输入是非可变长的String：");
		String str = new String("I love you.");
		System.out.println(test01.replaceSpace02(str));
	}


	
	public String replaceSpace02(String s) {
		//字符串不合法则返回null
		if(s == null) {
			System.out.print("输入错误！");
			return null;
		}
		//调用StringBuilder函数来动态存储字符串
		StringBuilder sbBuilder = new StringBuilder();
		//从头遍历字符串并根据情况加入sbBuilder中
		for(int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				sbBuilder.append("%20");
				
			}else {
				sbBuilder.append(s.charAt(i));
			}
		}
		//返回sbBuilder转字符串即可
		return sbBuilder.toString();

	}
}
