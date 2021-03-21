package temp;
import java.util.*;
/**
* @author 作者:guan
* @createDate 创建时间：Feb 23, 2021 2:53:49 PM
*/
public class temp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	    
	    public int[] LRU (int[][] operators, int k) {
	        //true 表示让 linkedHashMap 按照访问顺序来进行排序，最近访问的放在尾部，最老访问的放在头部。
	        LinkedHashMap<Integer, Integer> urlMap = new LinkedHashMap<Integer, Integer>((int)Math.ceil(k/0.75)+1, 0.75f, true);
	        ArrayList<Integer> list = new ArrayList<>();
	        for(int[] op: operators){
	            if(op[0] == 1){
	                if(urlMap.size() >= k){
	                	//有一个Map对象，这时候使用keySet()方法获取所有的key值
	                	//最近访问的放在尾部，最晚访问的放在头部
	                	//remove操作移除的是头部元素，用迭代器访问是从头部第一个元素开始的
	                	//第一次调用iterator.next()方法时，它返回的是序列的第一个元素。
	                	//同样，第一次调用iterator.previous()方法时，它返回的是序列的倒数第一个元素，而不是倒数第二个元素。
	                    urlMap.remove(urlMap.keySet().iterator().next());
	                }
	                urlMap.put(op[1], op[2]);
	            }
	            else if(op[0] == 2){
	                if(urlMap.get(op[1]) == null){
	                    list.add(-1);
	                }else {
	                    list.add(urlMap.get(op[1]));
	                    //在LinkedHashMap订购模式中设置参数为true
	                    //LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>((int)Math.ceil(k/0.75)+1,0.75f,true);
	                    //后 map按照访问顺序排序，
	                    //lruMap.remove(key); lruMap.put(key,val);这两行就可以不用
	                    //rulMap.remove(op[1]);
	                    //rulMap.put(op[1],op[2]);
	                }
	            }
	        }
	        int[] res = new int[list.size()];
	        int index = 0;
	        for(int i : list){
	            res[index++] = i;
	        }
	        return res;
	    }
	
}
