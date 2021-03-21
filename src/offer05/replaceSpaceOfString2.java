package offer05;

public class replaceSpaceOfString2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		replaceSpaceOfString2 test01 = new replaceSpaceOfString2();
		System.out.println("方法的输入是非可变长的String：");
		String str = new String("I love you.");
		System.out.println(test01.replaceSpace02(str));
	}


	public String replaceSpace02(String s) {	
		//直接调用string中的replace()方法即可
		return s.replace(" ", "%20");
	}
	

}
