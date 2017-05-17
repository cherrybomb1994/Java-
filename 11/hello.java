package hello;

import java.io.*;
import java.net.*;

public class hello{

	public static void main(String[] args){
	 try{
	
		InetAddress ip = InetAddress.getByName(null);
		Socket client = new Socket(ip,8888);
		//最基本的InputStream和OutputStream是字符型的，要转换一下
		InputStream inputtemp = client.getInputStream();
		OutputStream outputtemp = client.getOutputStream();
		
		//通过inputstreamreader进行字符到字节的转换，再用bufferreader转成更方便使用的
		//至于为什么输出要用PrintWriter，见博客，注意printwriter构造后面要有一个参数true，不能少
		BufferedReader input = new BufferedReader(new InputStreamReader(inputtemp));
		PrintWriter output = new PrintWriter(new OutputStreamWriter(outputtemp),true);
		
		output.println("hello! 我是客户");
		System.out.println(input.readLine());
		client.close();
	
	}
	catch(Exception e){
		System.out.println(e);
	} 
	}
}
