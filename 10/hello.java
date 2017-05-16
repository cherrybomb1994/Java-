package hello;

import java.net.InetAddress;

public class hello{

	public void say(){
		try{
			//InetAddress类为static，用的时候不用构造，就是不用new，直接拿来调用方法就可以
			InetAddress i = InetAddress.getLocalHost();
			//会打印名称+IP，是一个封装好的对象
			System.out.println(i);
			//利用返回的InetAddress对象的方法，只返回IP地址
			System.out.println(i.getHostAddress());
			//利用返回的对象的方法，只返回主机名
			System.out.println(i.getHostName());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
  public static void main(String[] args){
       hello ha = new hello();
       ha.say();
   }
} 
