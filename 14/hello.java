package hello;

import java.io.*;
import java.net.*;
//创建多个线程

class multithread extends Thread {

	private int count;
	multithread(int count){
		this.count = count;
		System.out.println("创建第"+count+"个线程");
	}
	
 public void run() { 
	 try{
		 System.out.println("第"+count+"个线程sleep");
		 sleep(20-count);
		 
	 }
	 catch(Exception e){
		 System.out.println(e);
	 }
	 finally{
		 System.out.println("第"+count+"个线程退出");
	 }

}

}
public class hello{
 public static void main(String[] args){
	for(int i=1;i<6;i++){
	 new multithread(i).start();
	}
	} 
}

