package offer44;
/**
* @author 作者:guan
* @createDate 创建时间：Feb 6, 2021 12:29:26 PM
*/
public class DigitsInSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitsInSequence demo = new DigitsInSequence();
        System.out.println(demo.digitAtIndex(0)==0);
        System.out.println(demo.digitAtIndex(1)==1);
        System.out.println(demo.digitAtIndex(19)==4);
        System.out.println(demo.digitAtIndex(1000)==3);
        System.out.println(demo.digitAtIndex(1001)==7);
        System.out.println(demo.digitAtIndex(1002)==0);

	}

	public int digitAtIndex(int index) {
		if(index < 0) {
			return -1;
		}
		int m = 1;
		while(true) {
			int numbers = numbersOfIntegers(m);
			if(index < numbers * m) {
				return getDigit(index, m);
			}
			index -= numbers * m;
			m++;
		}
	}
	
	/**
	 * 返回m的总位数
	 * @param m
	 * @return
	 */
	private int numbersOfIntegers(int m) {
		if(m == 1) {
			return 10;
		}
		return (int)(9 * Math.pow(10, m - 1));
	}
	
	private int getDigit(int index, int m) {
		//index/m表示m位数的第几个，因为m位数每一个数字都有m位
		int number = getFirstNumber(m) + index / m;
		//m位数从右到左的第几个，比如6位数，从右到左第三位,chance,从右到左第三位就是n
		int indexFromRight = m - index % m;//从后往前剔除
		//除以10^2,得chan
		for(int i = 1; i < indexFromRight; i++) {
			number /= 10;
		}
		//最后chan对10取余就得到n
		return number % 10;
		
	}
	/**
	 * 第一个m位数
	 */
	private int getFirstNumber(int m) {
		if(m == 1) {
			return 0;
		}
		return (int) Math.pow(10, m - 1);
	}
}
