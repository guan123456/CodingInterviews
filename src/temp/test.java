package temp;
import java.util.*;
/**
* @author 作者:guan
* @createDate 创建时间：Feb 24, 2021 4:06:32 PM
*/
public class test {
	
	//每个字符都对应一个ASCII码值，比如字符a的ASCII码值为97，那么a每出现了一次，cnt['a']++也就是cnt[97]++。
	//字符型在内存中存储是用的ASCII码值，所以字符可以直接用来索引
/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		for(int i = 0; i < string.length();i++) {
			System.out.print(string.charAt(i) + " ");
		}
		for(int i = 0; i < string.length();i++) {
			System.out.print( " ");
		}
	}
*/
    public static void main(String[] args){
/*        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int count = 0;
        int[] occurence = new int[128];
        for(int i = 0; i < str.length(); i++){
            //charAt(i) 函数 是获取字符串中i位置的字符 
            //str.charAt(i)的意思是第i个字符在字符串str中所占的位置
            //输出的是数字
            if(occurence[str.charAt(i)] == 0){
                occurence[str.charAt(i)]++;
            }
        }
        for(int i = 0; i < occurence.length; i++){
            if(occurence[i] != 0){
                count++;
            }
        }
        System.out.println(count);*/
    	String string = " ";
    	System.out.print(string.length());
    	System.out.print(string);
    	boolean[] isVisited = new boolean[8];
    	System.out.println(isVisited[1]);
    	
    	String a = "as";
    	int[] o = new int[128];
    	o[a.charAt(1)] =2;
    	System.out.print(o);

    	
    	
        
    }
}
