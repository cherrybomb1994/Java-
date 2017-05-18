package hello;

import java.io.*;
import java.net.*;
//当有多个线程的时候，会进行排队，前面的线程进入sleep的状态，后面的线程会开始执行。
//后面的线程一旦开始运行，那么之前的线程即使sleep完了也要进行等待
//除非有其他的设置，比如有优先级啥的，或者其他的方法让第一个继续开始，否则都是平级的

class secondthread extends Thread {

//这个类为自己创建的线程，没啥需要传递的参数以及准备工作，这里就不重写构造函数了
//这里让自己创建的线程2也循环执行sleep，目的是这样当线程1睡完后，可以在线程2sleep的间隔内继续执行
//否则要等到线程2全部执行完才会输出"线程1结束"
 public void run() { 
   System.out.println("创建第二个线程");
   try{
	   System.out.println("线程2要睡了");
	   for(int i=0;i<5;i++){
		   System.out.println("线程2睡了"+i+"秒");
		   Thread.currentThread().sleep(1000);
	   }
   }
   catch(Exception e){
	   System.out.println(e);
   }
   finally{
	   System.out.println("线程2结束");
   }
 } 
}


public class hello{
 public static void main(String args[])  {
	 Thread t1 = Thread.currentThread();
	 System.out.println("创建第一个线程——睡了");
	 
	 //创建自己的新线程，注意要先创建，让它存在并排队等待，这样当主线程sleep的时候它才会自动跟上运行
	 Thread t2 = new secondthread();
	 t2.start();
	 
	 try{
	 t1.sleep(3000);
	 }
	 catch(Exception e){
		 System.out.println(e);
	 }
	 finally{
		 System.out.println("线程1结束");
	 }
   
 } 
}

