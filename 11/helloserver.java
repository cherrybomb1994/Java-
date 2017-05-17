package hello;

import java.io.*;
import java.net.*;

public class helloserver {

	public static void main(String[] args) {
		try{
			//服务器端，serversocket要监听的端口号需要你自己写进去，与客户端使用的一样
			int ip = 8888;
			ServerSocket serverso = new ServerSocket(ip);
			//监听有消息了，accept就返回一个纯socket实例，就可以进行io操作了
			Socket server = serverso.accept();
			
			//io操作与客户端相同
			InputStream inputtemp = server.getInputStream();
			OutputStream outputtemp = server.getOutputStream();
			
			BufferedReader input = new BufferedReader(new InputStreamReader(inputtemp));
			PrintWriter output = new PrintWriter(new OutputStreamWriter(outputtemp),true);
			
			System.out.println(input.readLine());
			output.println("我是服务器端，我收到了");
			
			server.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

}
