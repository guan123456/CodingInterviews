package offer14;

import offer03.nonchangeArray;
import offer05.replaceSpaceOfString;

public class CuttingRope01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        CuttingRope01 demo = new CuttingRope01();
        demo.test1();
        demo.test2();
        demo.test3();
        demo.test4();
        demo.test5();
        demo.test6();
        demo.test7();
  
	}

	//动态规划
	public int maxProductAfterCutting_solution1(int length) {
		if(length <= 1) {
			return 0;
		}
		if(length == 2) {
			return 1;
		}
		if(length == 3) {
			return 2;
		}
		
		int[] product = new int[length + 1];
		product[0] = 0;
		product[1] = 1;
		product[2] = 2;
		product[3] = 3;
		
		for(int i = 4; i <= length; i++) {
			int max = 0;
			for(int j = 1; j <= i / 2; j++) {
				if (max < product[j] * product[i - j]) {
					max = product[j] * product[i - j];
				}
			}
			product[i] = max;
		}
		return product[length];
	}
	//添加大数求余的动态规划算法
	public int maxProductAfterCutting_solution1_mod(int length) {
        int p=(int)1e9+7;
		if(length <= 1) {
			return 0;
		}
		if(length == 2) {
			return 1;
		}
		if(length == 3) {
			return 2;
		}
		
		int[] product = new int[length + 1];
		product[0] = 0;
		product[1] = 1;
		product[2] = 2;
		product[3] = 3;
		
		for(int i = 4; i <= length; i++) {
			int max = 0;
			for(int j = 1; j <= i / 2; j++) {
				if (max < product[j] * product[i - j]) {
					max = product[j] * product[i - j] % p;
				}
			}
			product[i] = max;
		}
		return product[length];
	}
	
	//贪婪算法
	public int maxProductAfterCutting_solution2(int length) {
		if(length <= 1) {
			return 0;
		}
		if(length == 2) {
			return 1;
		}
		if(length == 3) {
			return 2;
		}
		
		int timesOf3 = length / 3;
		if(length / 3 == 0) {
			return (int)Math.pow(3, timesOf3);
		}
		if(length % 3 == 1) {
			return (int) Math.pow(3, timesOf3 - 1) * 4;
		}
		return (int)Math.pow(3, timesOf3) * 2;
	}
	
	//添加大数求余的贪婪算法
	public int maxProductAfterCutting_solution2_mod(int length) {
        int p=(int)1e9+7;
		if(length <= 1) {
			return 0;
		}
		if(length == 2) {
			return 1;
		}
		if(length == 3) {
			return 2;
		}
		
		int timesOf3 = length / 3;
		if(length % 3 == 0) {
			return (int)Math.pow(3, timesOf3) % p;
		}
		if(length % 3 == 1) {
			return (int) Math.pow(3, timesOf3 - 1) * 4 % p;
		}
		return (int)Math.pow(3, timesOf3) * 2 % p;
	}
	
	
	void test(String testName, int length, int expected) {
		if(testName != null) {
			System.out.println(testName + ":");
		}
        if (maxProductAfterCutting_solution1(length) == expected) {
            System.out.print("    expected:" + expected);
            System.out.print("    结果:" + maxProductAfterCutting_solution1(length));
            System.out.println("    动态规划:" + "passed  ");
        } else {
            System.out.print("    expected:" + expected);
            System.out.print("    结果:" + maxProductAfterCutting_solution1(length));
            System.out.println("    动态规划:" + "failed  ");
        }
 
        if (maxProductAfterCutting_solution2(length) == expected) {
            System.out.print("    expected:" + expected);
            System.out.print("    结果:" + maxProductAfterCutting_solution2(length));
            System.out.println("    贪婪算法:" + "passed  ");
        } else {
            System.out.print("    expected:" + expected);
            System.out.print("    结果:" + maxProductAfterCutting_solution2(length));
            System.out.println("    贪婪算法:" + "failed  ");
        }
			
	}
    void test1() {
        test("test1", 1, 0);
    }
 
    void test2() {
        test("test2", 2, 1);
    }
 
    void test3() {
        test("test3", 3, 2);
    }
 
    void test4() {
        test("test4", 4, 4);
    }
 
    void test5() {
        test("test5", 5, 6);
    }
 
    void test6() {
        test("test6", 10, 36);
    }
 
    void test7() {
        test("test7", 50, 86093442);
    }
}
