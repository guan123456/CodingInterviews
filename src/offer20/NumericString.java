package offer20;

public class NumericString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        NumericString demo = new NumericString();
        demo.test1();
        demo.test2();
        demo.test3();
        demo.test4();
        demo.test5();
        demo.test6();
        demo.test7();
        demo.test8();
        demo.test9();
        demo.test10();
        demo.test11();
        demo.test12();
	}
    //程序验证小技巧，只要带一两个测试用例进去，自己模拟过程就可以理解了
	//如果自己模拟不了那就可以使用debug调试
	//(A.B E/e C)
	public boolean isNumeric(char[] str) {
		//如果输入的字符串不合法，直接返回false
		if(str == null || str.length == 0) {
			return false;
		}
		int[] index = new int[1];
		index[0] = 0;//用于记录当前字符串的位置
		//字符串开始有空格，可以返回true，故而将标记移动到字符串第一个字符的下标位置
		while(str[index[0]] == ' ') {
			++index[0];
		}
		//先判断A是不是合法带符号整数
		boolean isNumeric;
		isNumeric = isInteger(str,index);
		//再判断B是不是合法无符号整数，如果有当前位有小数点，则肯定有B
		if(index[0] < str.length && (str[index[0]] == '.')) {
			index[0]++;
			//这里与isNumeric是或运算
			// .B和A.和A.B形式均可以
			if(str[index[0]]== '-') {
				isNumeric = false;
			}else {
				isNumeric = isUnsignedInteger(str, index) || isNumeric;
			}
		}
		//后判断C是不是合法带符号整数
		if(index[0] < str.length && (str[index[0]] == 'e' || str[index[0]] ==  'E')) {
			index[0]++;
			isNumeric = isInteger(str, index) && isNumeric;
		}
		
/*		//字符串结尾有空格，可以返回true
		while(str[index[0]] == ' ') {
			++index[0];
		}*/

		/**
		 * 以下可以简化为
		 * return isNumeric && index[0] == str.length;
		 */
		if(isNumeric && index[0] == str.length) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	private boolean isInteger(char[] str, int[] index) {//index[0]记录了字符串的位置，也就是有效的位置
		if(index[0] < str.length && (str[index[0]] == '+' || str[index[0]] == '-')) {
			index[0]++;//位置往后移动，略过正负号，然后再对数值进行比较
		}
		//判断是否是无符号整数可以调用函数即可，提高代码重用性
		return isUnsignedInteger(str,index);
	}
	
	private boolean isUnsignedInteger(char[] str, int[] index) {
		int start = index[0];
		//判断当前在字符串中地址的值是否为数字
		while(index[0] < str.length && (str[index[0]] -'0' <= 9 && str[index[0]] - '0' >= 0)) {
			index[0]++;
		}
		//如果是数字则index[0]的值肯定有移动，说明有效
		if(index[0] > start) {
			return true;
		}
		//反之则无效
		else {
			return false;
		}
	}
	
    // =======测试代码=========
    void test(String testName, char[] str, boolean expected) {
        System.out.print(testName + "：");
        if (isNumeric(str) == expected)
            System.out.println(" passed!");
        else
            System.out.println(" failed!");
    }
    
    void test1() {
        char[] str = null;
        test("test1", str, false);
    }
    
    void test2() {
        char[] str = {};
        test("test2", str, false);
    }
    
    void test3() {
        String string ="e3";
        char[] str=string.toCharArray();
        test("test3", str, false);
    }
    
    void test4() {
        String string ="3e1.2";
        char[] str=string.toCharArray();
        test("test4", str, false);
    }
    
    void test5() {
        String string ="E3";
        char[] str=string.toCharArray();
        test("test5", str, false);
    }
    
    void test6() {
        String string ="1.2e3";
        char[] str=string.toCharArray();
        test("test6", str, true);
    }
    
    void test7() {
        String string ="-.2e3";
        char[] str=string.toCharArray();
        test("test7", str, true);
    }
     
    void test8() {
        String string ="-.2e-3";
        char[] str=string.toCharArray();
        test("test8", str, true);
    }
     
    void test9() {
        String string ="1.e-3";
        char[] str=string.toCharArray();
        test("test9", str, true);
    }
     
    void test10() {
        String string ="1.";
        char[] str=string.toCharArray();
        test("test10", str, true);
    }
     
    void test11() {
        String string =".2";
        char[] str=string.toCharArray();
        test("test11", str, true);
    }
 
    void test12() {
        String string ="12e3";
        char[] str=string.toCharArray();
        test("test12", str, true);
    }
    
}

