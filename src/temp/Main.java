package temp;
/**
* @author 作者:guan
* @createDate 创建时间：Feb 24, 2021 4:27:38 PM
*/

import java.util.*;

//高矮高矮高，最小移动次数
public class Main{
	//2021/3/3 13:35
	//我的这种想法肯定有问题，md，这道题困了我那么久，还是没做出来！！！
	//整个人心情都不好了！！！
	//2021/3/3 13:50 终于做出来了,果然再坚持一下就行了
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            String string = scan.nextLine();
            String[] strArray = string.split(" ");
            int length = strArray.length;
            int[] array = new int[length];
            for(int i = 0; i < length; i++) {
            	array[i] = Integer.parseInt(strArray[i]);
            }
            int total = Method(array);
            System.out.println(total);
            if(array.length > 0) {
            	for(int i = 0; i < array.length ;i++) {
            		System.out.print(array[i] + " ");
            	}
            }else {
            	int[] a = new int[0];
            	System.out.print(a[0]);
            }
            System.out.println();
        }

    }
    public static int Method(int[] array) {
    	int count = 0;
    	int length = array.length;
    	if(length < 2) {
    		return 0;
    	}
    	if(array[0] < array[1]) {
    		//这里是移动，而不是交换,虽然看上去是一样，只是后面不移动而已
    		int temp = 0;
    		temp = array[0];
    		array[0] = array[1];
    		array[1] = temp;
/*    		//本题保持原序的话不应该交换，移动即可
    		int temp = 0;
    		temp = array[0];
    		array[0] = array[1];
    		array[1] = temp;*/
    		count++;
    	}
    	if(length >= 3) {
        	for(int i = 1; i  < length; i++) {
        		for(int j = i + 1; j < length; j++) {
        			if((i&1) == 0) {//偶数的话，大于等于两头，默认前面已满足，也就是当前i大于等于i-1
        				if(array[j] <= array[i] && j - i == 1) {
        					break;
        				}else if(array[j] > array[i]){
        					int temp = array[i];
        					int k = j + 1;
        					while(k < length && array[k] < array[i]) {
        						k++;
        					}
        					if(k > j + 1) {
         						count += (k - i);
            				    while(i < k-1) {
            				    	array[i] = array[i + 1];
            				    	i++;
            				    }
            				    array[k - 1] = temp;
        					}else {
        						count += (j - i + 1);
        						while(i < j) {
        							array[i] = array[i + 1];
        							i++;
        						}
        						array[k - 1] = temp;
        					}
/*        					//本题保持原序的话不应该交换，移动即可
    						int temp = 0;
    						temp = array[i];
    						array[i] = array[j];
    						array[j] = temp;*/
        				}
        			}else {//奇数的话，小于等于两头，默认前面已满足，也就是当前i小于等于i-1
        				if(array[j] >= array[i] && j - i == 1) {
        					break;
        				}else if(array[j] < array[i]){
        					int temp = array[i];
        					int k = j + 1;
        					while(k < length && array[k] > array[i]) {
        						k++;
        					}
        					if(k > j + 1) {
         						count += (k - i);
            				    while(i < k-1) {
            				    	array[i] = array[i + 1];
            				    	i++;
            				    }
            				    array[k - 1] = temp;
        					}else {
        						count += (j - i + 1);
        						while(i < j) {
        							array[i] = array[i + 1];
        							i++;
        						}
        						array[k - 1] = temp;
        					}
/*        					//本题保持原序的话不应该交换，移动即可
    						int temp = 0;
    						temp = array[i];
    						array[i] = array[j];
    						array[j] = temp;*/
        				} 
        			}
        		}
        	}
    	}

    	return count;
    }
}