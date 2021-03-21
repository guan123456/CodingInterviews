package offer19;

public class RegularExpressions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RegularExpressions demo = new RegularExpressions();
        demo.test1();
        demo.test2();
        demo.test3();
        demo.test4();
        demo.test5();
        demo.test6();
        demo.test7();
        demo.test8();
        demo.test9();
	}
	/**
	 * null如其名，什么都不是，也就没有任何属性，更不可能有.length
	 * 定义任何一个对象不使用new关键字 Object O; 
	 * O此刻就是null，只有 = new Object()之后才有意义
	 * new之前为null，此刻使用O.任何属性方法都是不可接受的，null不占用内存
	 * 而"".length = 0,""此刻是一个字符串，已经为其分配了一定的内存空间
	 */

	public boolean match(char[] str, char[] pattern) {
		//如果正则表达式
		if(str == null || pattern == null) {
			return false;
		}
		return matchCore(str, 0, pattern, 0);
	}
	
	private boolean matchCore(char[] str, int indexOfStr, char[] pattern, int indexOfPattern) {
		//字符串与模式串都移动到了最后
		if(indexOfStr == str.length && indexOfPattern == pattern.length) {
			return true;
		}
		//字符串还有剩余没比较，但是模式串已经移动到了最后
		if(indexOfStr < str.length && indexOfPattern == pattern.length) {
			return false;
		}

		//其他情况
		//1.模式串与字符串都未匹配结束
		//2.模式串还有剩余，但是字符串已经移动到了最后
		
		//当模式中第二个字符为“*”时
		if(indexOfPattern + 1 < pattern.length && pattern[indexOfPattern + 1] == '*') {
			//若当前字符相等，则有三种情况：
			if((indexOfStr < str.length && pattern[indexOfPattern] == '.')
					||(indexOfStr < str.length && pattern[indexOfPattern] == str[indexOfStr])) {
				        //1.字符串后移一个字符，模式后移两个字符，继续比较
				return     matchCore(str, indexOfStr + 1, pattern, indexOfPattern + 2)
						//2.字符串后移一个字符，模式字符位置不变，继续比较
						|| matchCore(str, indexOfStr + 1, pattern, indexOfPattern)
						//3.字符串字符位置不变，模式后移两个字符，继续比较
						|| matchCore(str, indexOfStr, pattern, indexOfPattern + 2);
			}
			else {
				//若当前字符不相等，则模式后移两个字符，继续比较
                return matchCore(str, indexOfStr, pattern, indexOfPattern + 2);
         }
		}
		/**
		 * 这一个if语句块放前面与放后面结果不同
		 * 因为前面也有一个判断
		 * if((indexOfStr < str.length && pattern[indexOfPattern] == '.')
		 * 只有当判断了第二个不是*之后才可以判断当前，而不是先判断当前然后直接执行
		 */
		//若当前字符相等，则字符串和模式都后移一个字符，继续调用函数进行比较
		if(indexOfStr < str.length && (pattern[indexOfPattern] == str[indexOfStr] || pattern[indexOfPattern] == '.')) {
			return matchCore(str, indexOfStr + 1, pattern, indexOfPattern + 1);
		}
		//进行到这一步没有返回，则返回false
		return false;
	}
	
	void test(String testName, char[] str, char[] pattern, boolean expected) {
		System.out.print(testName + ':');
		if(match(str, pattern) == expected) {
			System.out.println("passed.");
		}
		else {
			System.out.println("failed.");
		}
	}
    void test1() {
        char[] str = {};
        char[] pattern = { '.' };
        test("test1", str, pattern, false);
    }
    void test2() {
        char[] str = {};
        char[] pattern = { '.', '*' };
        test("test2", str, pattern, true);
    }
    void test3() {
        char[] str = { 'a' };
        char[] pattern = { '.', '*' };
        test("test3", str, pattern, true);
    }
    void test4() {
        char[] str = {};
        char[] pattern = {};
        test("test4", str, pattern, true);
    }
    
    void test5() {
        char[] str = null;
        char[] pattern = null;
        test("test5", str, pattern, false);
    }
    void test6() {
        char[] str = { 'a', 'b', 'b' };
        char[] pattern = { 'a', 'b', 'b', '*', 'b' };
        test("test6", str, pattern, true);
    }
 
    void test7() {
        char[] str = { 'a' };
        char[] pattern = { 'a', 'a', '*' };
        test("test7", str, pattern, true);
    }
    void test8() {
        char[] str = { 'a', 'b', 'b' };
        char[] pattern = { '.', '*' };
        test("test8", str, pattern, true);
    }
    void test9() {
        char[] str = { 'a', 'a', 'a' };
        char[] pattern = { '.', '*' };
        test("test9", str, pattern, true);
    }
}
