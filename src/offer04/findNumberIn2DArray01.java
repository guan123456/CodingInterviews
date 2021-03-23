package offer04;

public class findNumberIn2DArray01 {
	public static boolean Find01(int[][] matrix, int target) {
		
		//如果矩阵不合法则返回false
		if(matrix == null || matrix.length <= 0) {
			return false;
		}
		//获取矩阵右上角的行列坐标，从右上角开始比较
		int row = 0;
		int column = matrix[0].length - 1;
		//当当前元素的行列符合矩阵要求时执行while循环里的语句
		while(row <= matrix.length - 1 && column >= 0) {
			//当矩阵中当前元素等于目标元素直接返回即可
			if(target == matrix[row][column]) {
				return true;
			}
			//当矩阵中当前元素大于目标元素，当前元素应小一些
			//即往左走，行数不变，列数减1
			else if(matrix[row][column] > target) {
				column--;
			}
			//当矩阵中当前元素小于目标元素，当前元素应大一些
			//即往下走，列数不变，行数加1
			else {
				row++;
			}
		}
		//执行到这一步说明矩阵中不存在目标元素，直接返回即可
		return false;
	}

	//这是以上方法的非静态实现，去掉static即可
	public  boolean Find02(int[][] matrix, int target) {
		
		if(matrix == null || matrix.length <= 0) {
			return false;
		}
		
		int row = 0;
		int column = matrix[0].length - 1;
		while(row <= matrix.length - 1 && column >= 0) {
			if(target == matrix[row][column]) {
				return true;
			}
			else if(target < matrix[row][column]) {
				column--;
			}
			else {
				row++;
			}
		}
		
		return false;
	}
	
	//从左到右递增，下一行第一个比上一行最后一个还大!!!
	//也就是整体可以连成一个有序序列！！！ 那么可以采用二分查找！！！
	boolean find(int matrix[][], int value) { 
		 int rows = matrix.length; 
		 int cols = matrix[0].length; 
		 int start = 0; 
		 int end = rows * cols - 1; 
		 while (start <= end) { 
		 int mid = start + (end - start) / 2; 
		 int row = mid / cols; 
		 int col = mid % cols; 
		 int v = matrix[row][col]; 
		 
		 if (v == value) 
		 return true; 
		 if (v > value) 
		 end = mid - 1; 
		 else 
		 start = mid + 1; 
		 } 
		 
		 return false; 
		}
	public static void main(String[] args) {
		System.out.print("main函数调用静态方法：");
		int[][] matrix = { { 1, 2, 8 }, { 4, 3, 9, 12 }, { 4, 7, 10 }, { 6, 8, 11, 15 } };
		System.out.println(Find01(matrix,7));
		
		System.out.print("main函数调用非静态方法：");
		findNumberIn2DArray01 test = new findNumberIn2DArray01();
		System.out.println(test.Find02(matrix,14));
	}
}
