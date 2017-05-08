package hello;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class hello {
	
	//更新使用hashMap,附带注意在这里用private定义了一个静态变量，可以自动保存更改的结果，
	//后续的方法就不用每个都return了，对比任务2。
	private static HashMap<String,String> hashmap = new HashMap<String,String>();
	
	//创建map内容，注意是键值对，一组key+value
	public void build(){
		String[] accRoleList = {"admin","satrap","manager","user","guest"};
	    String[] rightCodeList = {"10001","10011","10021","20011","24011"};
	    for(int i=0; i<accRoleList.length; i++){
	    	hashmap.put(accRoleList[i], rightCodeList[i]);
	    }
	}
	
	//获得权限代码
	public void getcode(String role){
		String code = hashmap.get(role);
		if(code==null){
			System.out.println("没有这个用户");
		}
		else{
			System.out.println(code);
		}
	}
	
	//添加一组键值对
	public void add(String role,String code){
		hashmap.put(role, code);
	}
	
	//删除一组键值对
	public void dele(String role){
		if(hashmap.get(role)!=null){
			hashmap.remove(role);
		}
		else{
			System.out.println("没有这个用户");
		}
	}
	
	//修改一个value
	public void change(String role,String value){
		if(hashmap.get(role)!=null){
			hashmap.remove(role);
			hashmap.put(role, value);
		}
		else{
			System.out.println("没有这个用户");
		}
	}
	
	//打印内容，此处更新为用迭代器Iterator，而不用枚举Enumeration
	//二者功能基本一样，没啥区别，都是配合集合之类的容器进行遍历，迭代器更常见
	//方法keyset，将所有键值返回一个set集合
	public void print(){
		Set<String> a =hashmap.keySet();
		Iterator<String> i = a.iterator();
		while(i.hasNext()){
			String contains = i.next();
			System.out.println(contains+": "+hashmap.get(contains));
		}
	}
	
	//重载函数print，当调用的时候自动适配参数格式，符合上一个print函数参数格式的用上一个，符合这个的参数格式自动调这个
	public void print(Object obj){
		System.out.println(obj);
	}
	
	public static void main(String[] args) {
		hello RR = new hello();
	 	RR.build();
	 	RR.print();
	 	RR.print("___________________________");
	 	RR.add("presider","10110");
	 	RR.print();
	 	RR.print("___________________________");
	 	RR.change("presider","10100");
	 	RR.print();
	 	RR.print("___________________________");
	 	RR.dele("presider");
	 	RR.print();
	}

}
