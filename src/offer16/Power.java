package offer16;

public class Power {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Power demo = new Power();
        demo.test1();
        demo.test2();
        demo.test3();
        demo.test4();
        demo.test5();
        demo.test6();
        demo.test7();
	}

	boolean IsInvalid = false;//默认未出错，也就是出错状态为false
	public double power(double base, int exponent) {
		IsInvalid = false;//用全局变量标记是否出错
		double result;//结果为double类型
		if (exponent > 0) {
			result = powerCore(base, exponent);
		}
		else if (exponent < 0) {
			if(base == 0) {
				IsInvalid = true;//0的负数次方不存在
				return 0;
			}
			result = 1 / powerCore(base, -exponent);
		}
		else {
			return 1;
			//这里默认0的0次方输出为1,所有数0次方都为1
			//所以powerCore中没有出现exponent等于0的情况
		}
		return result;
	}
	
	private double powerCore(double base, int exponent) {
		//这里不可省，这是递归调用的重要出口
		if (exponent == 0) {
			return 1;
		}
		if (exponent == 1) {
			return base;
		}
		
		double result = powerCore(base, exponent >> 1);
		result *= result;
		/*
		 * 用右移运算符代替了除以2，用位与运算符代替了求余运算符%来判断一个数是奇偶
		 * 位运算的效率要比乘除法以及求余运算的效率要高很多
		 * 这样能把代码优化到极致
		 */
		if ((exponent & 1) == 1) {
			result *=base;
		}
		return result;
	}
	
	//非递归实现乘方
	private double powerCore2(double base, int exponent) {
		double result = 1;
		while (exponent != 0) {
			if((exponent & 0x1) == 1) {
				result *= base;
			}
			exponent >>= 1;
			base *= base;
		}
		return result;
	}
	
	void test(String testName, double base, int exponent, double expected, boolean expectedFlag) {
		if (testName != null) {
			System.out.print(testName + ":");
		}
        if (power(base, exponent) == expected && IsInvalid == expectedFlag) {
            System.out.println("passed.");
        } else {
            System.out.println("failed.");
        }
	}
	
    void test1() {
        test("test1", 0, 6, 0, false);
    }
 
    void test2() {
        test("test2", 0, -6, 0, true);
    }
 
    void test3() {
        test("test3", 0, 0, 1, false);
    }
 
    void test4() {
        test("test4", 2, 6, 64, false);
    }
 
    void test5() {
        test("test5", 2, -3, 0.125, false);
    }
 
    void test6() {
        test("test6", 5, 0, 1, false);
    }
 
    void test7() {
        test("test7", -2, 6, 64, false);
    }
}
