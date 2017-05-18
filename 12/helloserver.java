package hello;

import java.io.*;
import java.net.*;

//创建多线程俩服务多个client的请求
//服务端只有一个，所以要用多线程进行处理
class helloserverthread extends Thread{
	private Socket server;
	
	//个人理解这段相当于给多线程的构造函数串了参数，相当于告诉是谁启用了多线程
	//在这里是服务端最后由serversocket的accept监听成功后返回的socket，来启用多线程
	helloserverthread (Socket server){
		this.server = server;
	}
	
	//多线程具体运行的实体，放在run中重写
	public void run(){
	
		try{

		InputStream inputtemp = server.getInputStream();
		OutputStream outputtemp = server.getOutputStream();
		
		BufferedReader input = new BufferedReader(new InputStreamReader(inputtemp));
		PrintWriter output = new PrintWriter(new OutputStreamWriter(outputtemp),true);
		
		//线程中的工作为分析传过来的指令，一直保持循环知道客户端不传了为null的时候跳出循环，然后关闭socket
		while(true){
		String cmd = input.readLine();
		if (cmd == null)
	          break;
		System.out.println(cmd);
    
    //为什么要用startwith，猜测传输string后面还会有其他的符号，因为会有flush函数，会有换行符之类的
    //为什么要转成大写，可能与startwith函数有关，这个api说明没细看
		cmd = cmd.toUpperCase ();
		if(cmd.startsWith("HELLO")){
			output.println("收到hello");
		}
		else if(cmd.startsWith("BYE")){
			output.println("收到bye");
		}
		else if(cmd.startsWith("END")){
			output.println("收到end");
			
		}
		}
		//while循环结束
	}
	catch(Exception e){
		System.out.println("接受 error"+e);
	}
	finally{
		try{
			
		server.close();
		}
		catch(Exception e){
			System.out.println("close error"+e);
		}
	}
	}
}

 class helloserver {

	public static void main(String[] args) throws IOException {
		//端口绑定不能放在循环中，绑定一次就可以了
		int ip = 8888;
		ServerSocket serverso = new ServerSocket(ip);
		
		//while循环是必须的，否则会connection refused
		//个人理解，因为有多个客户，所以不能有一个accept就完事，要一直监听accept，有一个accept就加入一个多线程的start
		while(true){	
			
		Socket fin =serverso.accept();
		new helloserverthread(fin).start();
		
	}
}
}
