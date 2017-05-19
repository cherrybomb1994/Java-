package hello;

import java.io.*;
import java.net.*;
//创建多个线程

public class hello{
	public static void main(String[] arg){
	    new twothread(10);
	  }
}

//创建一个总的线程，包括两个独立线程的创建与start
class twothread extends Thread{
	int line =0;
	public static int flag =0;
	twothread(int i){
		this.line = i;
	
		Thread t1 = new threadone(line);
		Thread t2 = new threadtwo(line);
	
		t1.start();
		t2.start();
	
		flag=1;
	}
	
	//第一个独立线程，功能使打印空格
class threadone extends Thread{
	int line;
	threadone(int i){
		this.line = i;
	}
	public void run(){
		while(true){
			if(line<0) break;
			if(flag==1){
				for(int i=0;i<line;i++){
					System.out.print(" ");
				}
				line--;
				flag=2;
			}
		}
	}
}

//第二个独立线程，功能使打印星号
class threadtwo extends Thread{
	int line;
	int count=0;
	threadtwo(int i){
		this.line = i;
	}
	public void run(){
		while(true){
			if(line<0) break;
		if(flag==2){
			for(int i=0;i<(2*count+1);i++){
				System.out.print("*");
				
			}
			System.out.print("\n");
			line--;
			count++;
			flag=1;
		}
	}
		
	}
}	
}

