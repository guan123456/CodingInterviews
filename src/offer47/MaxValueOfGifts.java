package offer47;

import java.util.Arrays;

/**
* @author 作者:guan
* @createDate 创建时间：Feb 7, 2021 1:25:40 PM
*/
public class MaxValueOfGifts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxValueOfGifts demo = new MaxValueOfGifts();
		demo.test();

	}
	public int maxValueOfGifts(int[][] values) {
		if(values == null || values.length <= 0 || values[0].length <= 0) {
			return 0;
		}
		int rows = values.length;//行数
		int cols = values[0].length;//列数
		int[][] maxValue = new int[rows][cols];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				int left = 0;
				int up = 0;
				if(i > 0) {
					up = maxValue[i - 1][j];
				}
				if(j > 0) {
					left = maxValue[i][j - 1];
				}
				maxValue[i][j]=Math.max(up, left)+values[i][j];
			}
		}
		return maxValue[rows - 1][cols - 1];
	}
	
	public int[] maxValueOfGifts_1(int[][] values) {
		if(values == null || values.length <= 0 || values[0].length <= 0) {
			return new int[0];
		}
		//debug 一遍就懂了，就是从第一列开始从上往下，然后回头从第二列开始从上往下，直到末尾，不断更新当前最大值
		int rows = values.length;//行数
		int cols = values[0].length;//列数
		int[] maxValue = new int[cols];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				int left = 0;
				int up = 0;
				if(i > 0) {
					up = maxValue[j];
				}
				if(j > 0) {
					left = maxValue[j - 1];
				}
				maxValue[j]=Math.max(up, left)+values[i][j];
			}
		}
		return maxValue;
	}

	void test() {
		int[][] testArray ={{1,3,1},{1,5,1},{4,2,1}};
		//注意，不是以下方式创建
		/**
		 * int[][] testArray =[[1,3,1],[1,5,1],[4,2,1]];
		 */
		//输出[I@15db9742
		System.out.println(maxValueOfGifts_1(testArray));
		//输出数组
		System.out.println(Arrays.toString(maxValueOfGifts_1(testArray)));
	}
}
