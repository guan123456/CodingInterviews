package offer37;

public class SerializeBinaryTrees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class TreeNode{
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	String Serialize(TreeNode node) {
		StringBuilder sb = new StringBuilder();
		//如果当前结点为空，则加入$,
		if(node == null) {
			sb.append("$,");
		}
		else {
			//根左右前序遍历
			sb.append(node.val + ",");
			sb.append(Serialize(node.left));
			sb.append(Serialize(node.right));
		}
		//返回转string字符串即可
		return sb.toString();
	}
	
	int index = 0;
	TreeNode Deserialize(String str) {
		TreeNode node = null;
		if (str == null || str.length() == 0) {
			return node;
		}
		int start = index;
		//找到分割位置 ","
		//substring(beginIndex,endIndex) 函数
		//从beginIndex开始取，到endIndex结束，从0开始数，其中不包括endIndex位置的字符
		while (str.charAt(index) != ',') {
			index++;
		}
		if (!str.substring(start, index).equals("$")) {
			node = new TreeNode(Integer.parseInt(str.substring(start,index)));
			index++;//这条语句位置别放错了
			node.left = Deserialize(str);
			node.right = Deserialize(str);
		}
		else {
			index++;
		}
		return node;
	}
	
	TreeNode Deserialize_1(String str) {
		TreeNode node = null;
		if (str == null || str.length() == 0) {
			return node;
		}
		int start = index;
		//找到分割位置 ","
		//substring(beginIndex,endIndex) 函数
		//从beginIndex开始取，到endIndex结束，从0开始数，其中不包括endIndex位置的字符
        String[] string = str.split(",");
		if (!string[index].equals("$")) {
			node = new TreeNode(Integer.parseInt(string[index]));
			index++;//这条语句位置别放错了
			node.left = Deserialize(str);
			node.right = Deserialize(str);
		}
		else {
			index++;
		}
		return node;
	}
}
