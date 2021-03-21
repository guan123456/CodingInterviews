package offer29;

import java.time.format.TextStyle;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		test demo = new test();
        int[][] a1= {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[] b1= demo.spiralOrder(a1);
        for(int i = 0; i < b1.length; i++) {
        	System.out.print(b1[i] + " ");
        }
		
	}
	   public int[] spiralOrder(int[][] matrix) {
			if(matrix.length == 0) {
				return new int[0];
			}
	        int row = matrix.length;
			int col = matrix[0].length;
	        int[] array = new int[(row) * (col)];
	        int a = 0;
	        return printMatrixInCircle(matrix,0,array,a);
	    }
	    private int[] printMatrixInCircle(int[][] matrix, int start,int[] res,int x) {
			int row = matrix.length;
			int col = matrix[0].length;
			int endX = col - 1 - start; //the amount of cols
			int endY = row - 1 - start; //the amount of rows
			if(endX < start || endY < start) {
				return res;
			}
			//only one row
			if(endY == start) {
				for(int i = start; i <= endX; i++) {
	                res[x++] = matrix[start][i];
				}
				return res; //remember to return
			}
			//only one col
			if(endX == start) {
				for(int i = start; i <= endY; i++) {
	                 res[x++] = matrix[i][start];
				}
				return res; // remember to return
			}
			//print the border
			for(int i = start; i <= endX; i++) {
	            res[x++] = matrix[start][i];
			}
			for(int i = start+1; i <= endY; i++) {
	            res[x++] = matrix[i][endX];
			}
			for(int i = endX - 1; i >= start; i--) {
	            res[x++] = matrix[endY][i]; 
			}
			for(int i = endY - 1; i >= start + 1; i--) {
	            res[x++] = matrix[i][start];
			}
		     
	        return printMatrixInCircle(matrix, start + 1,res,x);
		}
}
