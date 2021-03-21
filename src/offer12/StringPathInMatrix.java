package offer12;

public class StringPathInMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StringPathInMatrix demo = new StringPathInMatrix();
        demo.test1();
        demo.test2();
        demo.test3();
        demo.test4();
        demo.test5();
        demo.test6();
        demo.test7();
	}

	//如果题目给的是public boolean hasPath(char[][] matrix, String word){}
	//则可以rows = matrix.length;cols = matrix[0].length 求得矩阵的行数列数
	//字符串转化成字符串数组，char[] str = word.toCharArray();然后继续代码即可
	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		//如果矩阵或者字符串无效则直接返回false
		if(matrix == null || rows < 1 || cols < 1 || str == null) {
			return false;
		}
		boolean[] isVisited = new boolean[rows * cols];
		int pathLength = 0;
		for(int row = 0; row < rows; row++) {
			for(int col =0; col <cols; col++) {
				//传入参数有原矩阵，原矩阵行数，原矩阵列数，矩阵当前元素的行下标，矩阵当前元素的列下标
				//从矩阵当前元素出发的路径长度，矩阵当前元素的访问状态
				//该函数是递归调用，返回值是boolean类型，所以用另外函数来操作
				if(hasPathCore(matrix, rows, cols, row, col, str, pathLength, isVisited)) {
					return true;
				}
			}
		}
		//执行到这一步，说明矩阵中不存在路径匹配目标字符串，返回false即可
		return false;
	}
	
	private boolean hasPathCore(char[] matrix,int rows,int cols, int row, int col,
			char[] str,int pathLength, boolean[] isVisited ) {
		//判断矩阵当前元素状态，如果不满足目标状态则返回false
		if(row < 0 || col < 0|| row >= rows || col >= cols || isVisited[row * cols + col] == true
				|| str[pathLength] != matrix[row * cols + col]) {
			return false;
		}
		//当str[pathLength] = matrix[row * cols + col]时继续往下走
		//只有一种情况return true
		if(pathLength == str.length - 1) {
			return true;
		}
		//默认无路径
		boolean hasPath = false;
		//将当前元素访问状态置为true
		isVisited[row * cols + col] = true;
		hasPath =  hasPathCore(matrix, rows, cols, row - 1, col, str, pathLength + 1, isVisited)
				|| hasPathCore(matrix, rows, cols, row + 1, col, str, pathLength + 1, isVisited)
				|| hasPathCore(matrix, rows, cols, row, col - 1, str, pathLength + 1, isVisited)
				|| hasPathCore(matrix, rows, cols, row, col + 1, str, pathLength + 1, isVisited);
		
		/**
		 * 回溯的过程
		 * 如果hasPath == false
		 * 也就是当前路径字符中下标为pathLength的字符在矩阵中的定位不正确
		 * 我们需要回到前一个字符(pathLength - 1)，然后重新定位
		 * 这时需要将矩阵中当前访问字符设置为未访问，isVisited[row * cols + col] = false
		 * 因为已经没把它加入路径中，回溯上一个字符，在不同方向开始访问有可能再次访问到它
		 * 也就是复原
		 */
		
		if(!hasPath) {
			isVisited[row * cols + col] = false;
		}
		return hasPath;
	}
	
	public void test1() {
		char[] matrix = "ABTGCFCSJDEH".toCharArray();
		int rows = 3;
		int cols = 4;
		char[] str = "BFCTG".toCharArray();
		if(!hasPath(matrix, rows, cols, str)) {
			System.out.println("Test1 passed.");
		}else {
			System.out.println("Test1 failed.");
		}
	}
    public void test2() {
        char[] matrix = "ABTGCFCSJDEH".toCharArray();
        int rows = 3;
        int cols = 4;
        char[] str = "BFCH".toCharArray();
        if (hasPath(matrix, rows, cols, str))
            System.out.println("Test2 passed.");
        else
            System.out.println("Test2 failed.");
    }
 
    // matrix=null
    public void test3() {
        char[] matrix = null;
        int rows = 0;
        int cols = 0;
        char[] str = "BFCE".toCharArray();
        if (!hasPath(matrix, rows, cols, str))
            System.out.println("Test3 passed.");
        else
            System.out.println("Test3 failed.");
    }
 
    // str=null
    public void test4() {
        char[] matrix = "ABTGCFCSJDEH".toCharArray();
        int rows = 3;
        int cols = 4;
        char[] str = null;
        if (!hasPath(matrix, rows, cols, str))
            System.out.println("Test4 passed.");
        else
            System.out.println("Test4 failed.");
    }
 
    // A
 
    // A
    public void test5() {
        char[] matrix = "A".toCharArray();
        int rows = 1;
        int cols = 1;
        char[] str = "A".toCharArray();
        if (hasPath(matrix, rows, cols, str))
            System.out.println("Test5 passed.");
        else
            System.out.println("Test5 failed.");
    }
 
    // A
 
    // B
    public void test6() {
        char[] matrix = "A".toCharArray();
        int rows = 1;
        int cols = 1;
        char[] str = "B".toCharArray();
        if (!hasPath(matrix, rows, cols, str))
            System.out.println("Test6 passed.");
        else
            System.out.println("Test6 failed.");
    }
 
    // AAAA
    // AAAA
    // AAAA
 
    // AAAAAAAAAAAA
    public void test7() {
        char[] matrix = "AAAAAAAAAAAA".toCharArray();
        int rows = 3;
        int cols = 4;
        char[] str = "AAAAAAAAAAAA".toCharArray();
        if (hasPath(matrix, rows, cols, str))
            System.out.println("Test7 passed.");
        else
            System.out.println("Test7 failed.");
    }
}
