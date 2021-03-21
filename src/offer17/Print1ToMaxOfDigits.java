package offer17;

public class Print1ToMaxOfDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        Print1ToMaxOfDigits demo = new Print1ToMaxOfDigits();
      //demo.test(-1);
      //demo.test(0);
        demo.test(3);
        demo.test(2);
	}

	public void print1ToMaxOfDigits(int n) {
		if (n <= 0) {
			return;
		}
		char[] number = new char[n];
		//foreach仅可用于遍历输出数组，但不能用于修改数组，也就是不能赋值
		
		for (int k = 0; k < number.length; k++) {
			number[k] = '0';
		}
		
		//一个一个数字打
		while (!increment(number)) {
			printCharNumber(number);
		}
	}
	
	/**
	 * 最难以理解的函数
	 * @param number
	 * @return
	 */
	//increment(char[] number)用于自增1
	//printCharNumber(char[] number)用于打印输出字符数字
	//char数组的长度为n，也就是存储n位
	private boolean increment(char[] number) {
		//nTakeOver表示进位
		int nTakeOver = 0;
		for (int i = number.length - 1; i >= 0; i--) {
			//这里已经实现了自增了，直接调用number[i]
			int nSum = (number[i] - '0') + nTakeOver;
			//先判断当前为是否是最后一位，nSum加1操作只发生在最后一位
			if(i == number.length - 1) {
				nSum++;
			}
			//如果当前位加1后(最后一位加或者进位加)仍需进位则继续进位
			//这里nSum最多是能达到10而已
			if(nSum == 10) {
				//数值超过最大值
				//这里也就是999,第i位，也就是9进位，就是4位数了，超出范围，直接返回true即可
				if(i == 0) {
					return true;
				}
				//把进位设置为1
				nTakeOver = 1;
				//这里也可以写成nSum %= 10，但没必要，因为
				//nSum -= 10;
				number[i] = '0';
			}else {
				//在不需要进位时跳出循环
				//break跳出的是for循环
				//break语句对if-else的条件语句不起作用
				//在多层循环中，一个break语句只向外跳一层
				number[i] = (char)(nSum + '0');
				break;
			}
		}
		return false;
	}
	//从左到右，利用布尔变量isBeginning0来从第一个非零字符打印
	private void printCharNumber(char[] number) {
		boolean isBeginning0 = true;
		for (int i = 0; i < number.length; i++) {
			if(isBeginning0 && (number[i] - '0') != 0) {
				isBeginning0 = false;
			}
			if(!isBeginning0) {
				System.out.print(number[i]);
			}
		}
		System.out.println();
	}
	
	//从左到右，利用for循环的break找出第一个非零字符位置，往后进行打印
	private void printCharNumber2(char[] number) {
		int beginner = number.length;
		//不写成number.length-1，以防写出0

		for (int i = 0; i<= number.length - 1; i++) {
			if((number[i] - '0') != 0) {
				beginner = i;
				break;
			}
		}
		//也就是字符数组全是0，执行完上面for循环，下面for循环还会执行一次，故而错误
		//所以把默认beginner设置为number.length
		//虽然传入的字符串数组肯定不是全0，但是这也是为了代码安全性考虑
		for (int i = beginner; i<= number.length - 1; i++) {
			System.out.print(number[i]);
		}
		if(beginner != number.length) {
			System.out.println();
		}
	}
    //=========方法二============
    /**
     * 采用递归的方法
     */
	public void print1ToMaxOfDigits2(int n) {
		if(n <= 0) {
			return;
		}
		char[] number = new char[n];
		for(int k = 0; k < number.length; k++) {
			number[k] = '0';
		}
		for(int i = 0; i <= 9; i++) {
			makeNumber(number, i, 0);
		}
	}
	
	/*
	 * 基于分治算法的思想，先固定高位，向低位递归，当个位已被固定时，添加数字的字符串。
	 * 例如当 n = 2 时（数字范围 1−99 ）
	 * 固定十位为 0 - 9 ，按顺序依次开启递归
	 * 固定个位 0 - 9 ，终止递归并添加数字字符串。
	 */
	public void makeNumber(char[] number, int nNumber, int index) {
		if(index == number.length - 1) {//终止条件，已固定完所有位
			number[index] = (char)(nNumber + '0');
			printCharNumber2(number);
			return;
			//return到140行for循环
			//然后设置新的i
			//然后继续调用makeNumber函数
			//index还是等于字符串数组的长度
		}
		else{
			//固定第index位为nNumber，也就是i
			number[index] = (char)(nNumber + '0');
			for(int i = 0; i <= 9; i++) {
				//开始固定第index+1位
				makeNumber(number, i, index + 1);
			}
		}
	}
    void test(int nDigits) {
        System.out.println("===test begin===");
       // System.out.println("method1:");
       // print1ToMaxOfDigits(nDigits);
        System.out.println("method2:");
        print1ToMaxOfDigits2(nDigits);
        System.out.println("===test over===");
    }
}
