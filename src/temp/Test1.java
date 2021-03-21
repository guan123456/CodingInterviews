package temp;
import java.util.*;
/**
* @author 作者:guan
* @createDate 创建时间：Feb 26, 2021 4:06:43 PM
*/
public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		String[] a = str.split(",");
		int cols = Integer.parseInt(a[0]);
		int columns = Integer.parseInt(a[1]);
		int firstcol = Integer.parseInt(a[2]);
		int firstcolumn = Integer.parseInt(a[3]);
		int secondcol = Integer.parseInt(a[4]);
		int secondcolumn = Integer.parseInt(a[5]);
        boolean[][] matrix = new boolean[cols][columns];
        for(int i = 0; i < cols; i++) {
        	for(int j = 0; j < columns; j++) {
        		matrix[i][j] = false;
        	}
        }
        //这里的输入应该检查一下
        if(firstcol > cols || secondcol > cols || firstcolumn > columns || secondcolumn > columns) {
        	System.out.print(0);
         	
        }
        matrix[firstcol][firstcolumn] = true;
        matrix[secondcol][secondcolumn] = true;
        int[][] matrix_1 = new int[cols][columns];
        for(int i = 0; i < cols; i++) {
        	for(int j = 0; j < columns; j++) {
        		matrix_1[i][j] =0;
        	}
        }
        matrix_1[firstcol][firstcolumn] = 1;
        matrix_1[secondcol][secondcolumn] = 1;
        int minsecond = 0;
        minsecond = CountSecond(matrix,minsecond,matrix_1);
        System.out.print(minsecond);
        
	}
	public static boolean JudgeFull(boolean[][] matrix) {
		int cols = matrix.length;
		int columns = matrix[0].length;
		int count = 0;
        for(int i = 0; i < cols; i++) {
        	for(int j = 0; j < columns; j++) {
        		if(matrix[i][j] == true) {
        			count++;
        		}
        	}
        }
        if(count == cols * columns) {
        	return true;
        }
        return false;
		
	}
	public static int CountSecond(boolean[][] matrix,int minsecond,int[][] matrix_1) {
		
		if(JudgeFull(matrix)) {
			return minsecond;
		}
		int flag = 0;
		int cols = matrix.length;
		int columns = matrix[0].length;
        for(int i = 0; i < cols; i++) {
        	for(int j = 0; j < columns; j++) {
        		if(matrix[i][j] == true) {
        			matrix_1[i][j] = 1;
        		}
        	}
        }
        for(int i = 0; i < cols; i++) {
        	for(int j = 0; j < columns; j++) {
        		if(matrix_1[i][j] == 1) {
        			if(i- 1 >= 0 && matrix[i - 1][j] != true) {
        				matrix[i - 1][j] = true;
        				//matrix_1[i - 1][j] = 1;
        				
        			}
        			if(j- 1 >= 0 && matrix[i][j-1] != true) {
        				matrix[i][j - 1] = true;
        				//matrix_1[i][j - 1] = 1;
        			}
        			if(i + 1 <= cols - 1 && matrix[i+1][j] != true) {
        				matrix[i+1][j] = true;
        				//matrix_1[i+1][j] = 1;
        			}
        			if(j+1 <= columns -1 && matrix[i][j + 1] != true) {
        				matrix[i][j+1] = true;
        				//matrix_1[i][j+1] = 1;
        			}
        		}
        	}
        }

        minsecond++;
        minsecond=CountSecond(matrix,minsecond,matrix_1);
		return minsecond;
	}

}
