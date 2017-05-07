package hello;

import java.util.ArrayList;

public class hello {
	//创建一个4×4的ArrayList
	public ArrayList<String> build(){
		ArrayList<String> a = new ArrayList<String>();
		for(int i=1; i<4; i++){
			for(int j=1; j<4; j++){
				a.add("a("+i+")("+j+")");
			}
		}
		return a;
	}
	
	//指定位置添加元素
	public ArrayList addnew(ArrayList b,int index,String news){
		if(index>b.size()){
			System.out.println("插入位置错误");
			return null;
		}
		else{
			b.add(index, news);
		    return b;
		}
		
	}
	
	//指定位置删除元素
	public ArrayList delete(ArrayList b,int index){
		if(index>b.size()){
			System.out.println("输入位置错误");
			return null;
		}
		else{
			b.remove(index);
			return b;
		}
	
	}
	
	//修改指定位置元素
	public ArrayList change(ArrayList b,int index,String news){
		if(index>b.size()){
			System.out.println("输入位置错误");
			return null;
		}
		else{
			b.set(index, news);
			return b;
		}
	}
	
	//打印内容
	public void print(ArrayList b){
		System.out.println('\n'+"该list内容为：");
		for(int i=0; i<b.size(); i++){
			System.out.print(b.get(i));
			if(i%3==2){
				System.out.print('\n');
			}
			
		}
	}

	public static void main(String[] args) {
		hello ov = new hello();
		ArrayList vTemp = ov.build();
		ov.print(vTemp);
		ArrayList vResult = ov.addnew(vTemp,2,"添加的数据");
		ov.print(vResult);
        ArrayList vResultup = ov.change(vResult,2,"修改的数据");
		ov.print(vResultup);
		ArrayList vResultnow = ov.delete(vResultup,2);
		ov.print(vResultnow);
	}

}
