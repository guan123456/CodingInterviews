package offer05;

public class replaceSpaceOfStringBuffer {

	public static void main(String[] args) {

		System.out.println("方法的输入是可变长的StringBuffer：");
		replaceSpaceOfStringBuffer test1 = new replaceSpaceOfStringBuffer();
		StringBuffer sBuffer = new StringBuffer("We are happy.");
		System.out.println(test1.replaceSpace(sBuffer));

	}
	
	public String replaceSpace(StringBuffer s) {
		//字符串不合法则返回null
		if(s == null) {
			System.out.print("输入错误！");
			return null;
		}
		//先计算出替换后的字符串的总长度
		int length = s.length();
		int indexOfOriginal = length - 1;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == ' ') {
				length += 2;
			}
		}
		
		//StringBuffer是可修改的字符串序列
		//该类的对象实体内存空间可以自动改变大小，便于存放一个可变的字符序列。
		//直接调用StringBuilder的setLength()方法直接一开始给定长度
		//可避免StringBuilder后续进行频繁扩容
		s.setLength(length);
		//从后往前往新s中添加元素
		int indexOfNew = length - 1;
		while(indexOfNew > indexOfOriginal) {
			if(s.charAt(indexOfOriginal) != ' ') {
				s.setCharAt(indexOfNew--,s.charAt(indexOfOriginal));
			}
			else {
				s.setCharAt(indexOfNew--, '0');
				s.setCharAt(indexOfNew--, '2');
				s.setCharAt(indexOfNew--, '%');
			}
			//fuck，这里看走眼了，写成了indexOfNew--;
			//这是遍历原string，然后从后往前加到扩展后的string
			indexOfOriginal--;
		}
		//返回s转string字符串即可
		return s.toString();
	}

}
