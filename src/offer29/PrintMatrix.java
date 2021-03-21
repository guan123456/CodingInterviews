package offer29;


public class PrintMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    PrintMatrix demo = new PrintMatrix();
        int[][] a1= {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
	    int[][] a2= {};
	    int[][] a3= {{}};
	    int[][] a4= {{1}};
	    int[][] a5= {{1,2,3,4}};
	    int[][] a6= {{1},{2},{3},{4}};
	    int[][] a7= {{1,2,3},{4,5,6}};
	    int[][] a8=null;
        demo.printMatrix(a1);
		System.out.println();
        demo.printMatrix(a2);
		System.out.println();
        demo.printMatrix(a3);
		System.out.println();
        demo.printMatrix(a4);
		System.out.println();
        demo.printMatrix(a5);
		System.out.println();
        demo.printMatrix(a6);
		System.out.println();
        demo.printMatrix(a7);
		System.out.println();
        demo.printMatrix(a8);
	}

	public void printMatrix(int[][] matrix) {
		if(matrix == null || matrix.length <= 0) {
			return;
		}
		printMatrixInCircle(matrix,0);
	}
	
	private void printMatrixInCircle(int[][] matrix, int start) {
		int row = matrix.length;
		int col = matrix[0].length;
		int endX = col - 1 - start; //the amount of cols
		int endY = row - 1 - start; //the amount of rows
		if(endX < start || endY < start) {
			return;
		}
		//only one row
		if(endY == start) {
			for(int i = start; i <= endX; i++) {
				System.out.print(matrix[start][i] + " ");
			}
			return; //remember to return
		}
		//only one col
		if(endX == start) {
			for(int i = start; i <= endY; i++) {
				System.out.print(matrix[i][start] + " ");
			}
			return; // remember to return
		}
		//print the border
		for(int i = start; i <= endX; i++) {
			System.out.print(matrix[start][i] + " ");
		}
		for(int i = start+1; i <= endY; i++) {
			System.out.print(matrix[i][endX] + " ");
		}
		for(int i = endX - 1; i >= start; i--) {
			System.out.print(matrix[endY][i] + " ");
		}
		for(int i = endY - 1; i >= start + 1; i--) {
			System.out.print(matrix[i][start] + " ");
		}
		
		printMatrixInCircle(matrix, start + 1);
	}
	
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0) 
        	return new int[0];
        int l = 0;//左边界
        int r = matrix[0].length - 1; //右边界
        int t = 0;//上边界
        int b = matrix.length - 1; //下边界
        int x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while(true) {
            for(int i = l; i <= r; i++) 
            	res[x++] = matrix[t][i]; // left to right.
            if(++t > b) break;//can't go down 
            for(int i = t; i <= b; i++)
            	res[x++] = matrix[i][r]; // top to bottom.
            if(l > --r) break;//can't go left
            for(int i = r; i >= l; i--)
            	res[x++] = matrix[b][i]; // right to left.
            if(t > --b) break;//can't go up
            for(int i = b; i >= t; i--) 
            	res[x++] = matrix[i][l]; // bottom to top.
            if(++l > r) break; //can't go right
        }
        return res;
    }

}
