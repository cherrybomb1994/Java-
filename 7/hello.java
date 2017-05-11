package hello;


import java.util.*;
public class hello {    
	
	public static void main(String[] args)
	{        
	ArrayList list = new ArrayList();
	boolean flag = true;
	System.out.println("请按照  in:command 格式进行输入");
	System.out.println("请按照  out 格式查看内容列表");
	System.out.println("请按照  quit 格式推出");
	
	while(flag){
	
		//此处更新为用scanner类进行接收键盘输入
		Scanner scn  = new Scanner(System.in);
		String temp = scn.nextLine();
		
		String cmd = "";
		String context = "";
		
		//切割输入的字符串，提取命令与内容
		int point = temp.indexOf(":");
		//如果没有冒号，那么说明为quit或者out，trim方法返回原字符串去掉首尾的空白格
		if(point==-1){
			cmd = temp.trim();
		}
		else{
			cmd = temp.substring(0, point).trim();
			context = temp.substring(point+1).trim();
		}
		
		//分析命令，equalsIgnoreCase为忽略大小写相等，equal为严格字符串相等
		if(cmd.equals("in")){
			if(context.equals("")){
				System.out.println("输入内容不能为空");
			}
			else{
				list.add(context);
			}
		}
		else if(cmd.equals("out")){
			for(int i=1;i<list.size()+1;i++){
			System.out.println(i+": "+list.get(i-1));
			}
		}
		else if(cmd.equals("quit")){
			//像nextline 方法要不就规定输入的行数，写循环，要不就自己加入停止的标识符
			flag = false;
		}
		else{
			System.out.println("输入命令错误");
		}
		
	}
	}

}
