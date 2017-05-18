package hello;

import java.io.*;
import java.net.*;

//客户端，客户端有多个，所以不是多线程，在这里就是单纯new了5个客户端
class hellothread {
	public static int count;
	Socket client = null;
	BufferedReader input = null;
	PrintWriter output = null;
	
	//实际上就是相当于重写了客户端的构造函数，每次构造出一个新的客户端就执行发送
	public hellothread(){
		count++;
		
		try{
		InetAddress ip = InetAddress.getByName(null);
		client = new Socket(ip,8888);
		
		InputStream inputtemp = client.getInputStream();
		OutputStream outputtemp = client.getOutputStream();
		
		input = new BufferedReader(new InputStreamReader(inputtemp));
		output = new PrintWriter(new OutputStreamWriter(outputtemp),true);
		
		System.out.println("创建"+count+"号client");
		output.println("hello");
		System.out.println(input.readLine());
		output.println("bye");
		System.out.println(input.readLine());
		output.println("end");
		System.out.println(input.readLine());
		
	
	}
	catch(Exception e){
		System.out.println(e);
	} 
	 finally{
		 try{
		 client.close ();
		 input.close();
		 output.close();
		   }
		 catch(Exception e){
			 }
		 }
	 }
}
	


public class hello{
	public static void main(String[] args)throws IOException,InterruptedException{
	//主函数中创建了5个客户
		for(int i=0;i<5;i++){
	         new hellothread();
	//在这里调用了Thread.currentThread()方法，捕获当前的进程，算是封装好的thread自带的方法
	         Thread.currentThread().sleep(1000);
		}
	}
}
