package offer15;

public class NumberOf_1_InBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		NumberOf_1_InBinary demo = new NumberOf_1_InBinary();
        demo.test1();
        demo.test2();
        demo.test3();
        demo.test4();
        demo.test5();
        demo.test6();
	}

	public int NumberOf_1_Solution1(int n) {
		int count = 0;
		int flag = 1;
		//循环的次数等于整数二进制的位数
		//32位的整数需要循环32位
		while (flag != 0) {
			if ((flag & n) != 0) {
				count++;
			}
			flag = flag << 1;
		}
		return count;
	}
	
	//如果题目输入的数字n是可以看做无符号数
	//则可以使用无符号右移来减少循环次数
	public int NumberOf_1_Solution1_1(int n) {
		int count = 0;
		while (n != 0) {
			count += n & 1;
			/**
			 * 负数右移还是负数！
			 * 即如果对n=0x8000 0000右移，最高位的1是不会变的。
			 * 如果这道题目通过令n=n>>1来计算n中1的个数，该数最终会变成0xFFFF FFFF而陷入死循环！
			 * 所以采用无符号移位运算
			 */
			//n = n >> 1;
			n >>>= 1;
		}
		return count;
	}
	
	public int NumberOf_1_Solution2(int n) {
		int count = 0;
		while(n != 0) {
			count++;
			n = (n - 1) & n;
		}
		return count;
	}
	
	//另一种巧妙地思路
	public int NUmberOf_1_Solution3(int n) {
		int count = 0;
		while(n != 0) {
			int rightOne = n & ((~n) + 1);
			count++;
			n ^= rightOne;
			//n -= rightOne 这里n是负数就行不通了!!!
		}
		return count;
	}
	
    void test(String testName, int n, int expected) {
        if (testName != null)
            System.out.println(testName + ":");
        if (NumberOf_1_Solution1(n) == expected) {
            System.out.print("    expected:" + expected);
            System.out.print("    结果:" + NumberOf_1_Solution1(n) );
            System.out.println("    soluton1:" + "passed  ");
        } else {
            System.out.print("    expected:" + expected);
            System.out.print("    结果:" + NumberOf_1_Solution1(n) );
            System.out.println("    solution1:" + "failed  ");
        }
 
        if (NumberOf_1_Solution2(n) == expected) {
            System.out.print("    expected:" + expected);
            System.out.print("    结果:" + NumberOf_1_Solution2(n));
            System.out.println("    soluton2:" + "passed  ");
        } else {
            System.out.print("    expected:" + expected);
            System.out.print("    结果:" + NumberOf_1_Solution2(n));
            System.out.println("    solution2:" + "failed  ");
        }
        if (NumberOf_1_Solution1_1(n) == expected) {
            System.out.print("    expected:" + expected);
            System.out.print("    结果:" + NumberOf_1_Solution1_1(n));
            System.out.println("    soluton1_1:" + "passed  ");
        } else {
            System.out.print("    expected:" + expected);
            System.out.print("    结果:" + NumberOf_1_Solution1_1(n));
            System.out.println("    solution1_1:" + "failed  ");
        }
    }
    void test1() {
        test("Test for 0", 0, 0);
    }
     
    void test2() {
        test("Test for 1", 1, 1);
    }
     
    void test3() {
        test("Test for 10", 10, 2);
    }
     
    void test4() {
        test("Test for 0x7FFFFFFF", 0x7FFFFFFF, 31);
    }
     
    void test5() {
        test("Test for 0xFFFFFFFF", 0xFFFFFFFF, 32);
    }
     
    void test6() {
        test("Test for 0x80000000", 0x80000000, 1);
    }
}
