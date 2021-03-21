package offer50;
/**
* @author 作者:guan
* @createDate 创建时间：Feb 8, 2021 1:39:03 PM
*/
public class FirstCharacterInStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private int index = 1;
	private int[] occurence = new int[256];

	//构造函数！！！
	//在构造函数中初始化成员变量
	
	//还可以进行改进，下面这里可以不需要，因为初始化的时候全部为0
	//同时上面的index要初试化为1
/*	public  FirstCharacterInStream() {
		index = 0;
		occurence = new int[256];
		for(int i = 0; i < 256; i++) {
			occurence[i] = -1;
		}
	}*/
	
	public void insert(char ch) {
		//这里也要做相应的改变
		//同时也不用强转为int
		//因为ch也可以对应下标
		if(occurence[ch] == 0) {
			occurence[ch] = index++;//第一次出现
		}
		else  {
			occurence[ch] = -1;
		}
	}
	
	public char getFirst() {
		int minIndex = Integer.MAX_VALUE;
		char ch = '#';
		for(int i = 0; i < occurence.length; i++) {
			//这里也需要做相应的改变
			if(occurence[i] != 0 && occurence[i] != -1 && occurence[i] < minIndex) {
				//如果存在只出现一次的字符，则将该字符赋值给ch
				ch = (char)i;
				minIndex = occurence[i];
			}
		}
		//最后欧返回ch
		return ch;
	}
}
