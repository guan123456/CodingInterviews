package offer13;

public class RobotMove {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RobotMove demo = new RobotMove();
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

	public int movingCount(int threshold, int rows, int cols) {
		//如果矩阵非法或者目标值非法
		if(rows <= 0 || cols <= 0 || threshold < 0) {
			return -1;
		}
		
		boolean[] isVisited = new boolean[rows * cols];
		//传入的参数有目标值，矩阵行数，矩阵列数，访问起点行下标，访问起点列下标，访问状态
		int count = movingCountCore(threshold, rows, cols, 0, 0, isVisited);
 		return count;
	}
	
	//计算当前元素各数字之和
	private int cal(int num) {
		int sum = 0;
		while (num > 0) {
			sum += num % 10;
			num /= 10;
		}
		return sum;
	}
	
	private int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] isVisited) {
		if(row < 0 || col < 0 || row >= rows || col >= cols || isVisited[row * cols + col] || cal(row) + cal(col) > threshold) {
			return 0;
		}
		isVisited[row * cols + col] = true;
		//只需要向下或者向右搜索就行，不需要回退
		return 1 //+ movingCountCore(threshold, rows, cols, row - 1, col, isVisited)
		         + movingCountCore(threshold, rows, cols, row + 1, col, isVisited)
		         //+ movingCountCore(threshold, rows, cols, row, col - 1, isVisited)
		         + movingCountCore(threshold, rows, cols, row, col + 1, isVisited);
		//这之后不用像前一道题一样将状态回退，只要访问了就标记为true，避免重复操作
	}
	
	void test(String testName, int threshold, int rows, int cols, int expected) {
		if(testName != null) {
			System.out.print(testName + ":");
		}
		if(movingCount(threshold, rows, cols) == expected) {
            System.out.print("    expected:" + expected);
            System.out.print("    结果:" + movingCount(threshold, rows, cols) +"    ");
			System.out.println("Passed.");
		}
		else {
            System.out.print("    expected:" + expected);
            System.out.print("    结果:" + movingCount(threshold, rows, cols) +"    ");
			System.out.println("Failed.");
		}
	}
    // 方格多行多列
    void test1() {
        test("Test1", 5, 10, 10, 21);
    }
 
    // 方格多行多列
    void test2() {
        test("Test2", 15, 20, 20, 359);
    }
 
    // 方格只有一行，机器人只能到达部分方格
    void test3() {
        test("Test3", 10, 1, 100, 29);
    }
 
    // 方格只有一行，机器人能到达所有方格
    void test4() {
        test("Test4", 10, 1, 10, 10);
    }
 
    // 方格只有一列，机器人只能到达部分方格
    void test5() {
        test("Test5", 15, 100, 1, 79);
    }
 
    // 方格只有一列，机器人能到达所有方格
    void test6() {
        test("Test6", 15, 10, 1, 10);
    }
 
    // 方格只有一行一列
    void test7() {
        test("Test7", 15, 1, 1, 1);
    }
 
    // 方格只有一行一列
    void test8() {
        test("Test8", 0, 1, 1, 1);
    }
 
    // 机器人不能进入任意一个方格
    void test9() {
        test("Test9", -10, 10, 10, 0);
    }
}
