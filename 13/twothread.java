/**
 * <p>Title: 实现Runnable接口，获得线程。</p>
 * <p>Description: 通过实现Runnable接口来获得自己的线程（t2）。</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Filename: twothread.java</p>
 * @author 杜江
 * @version 1.0
 */
public class twothread implements Runnable {
/**
 *<br>方法说明：构造器。实际线程，并启动这个线程。
 *<br>输入参数：
 *<br>返回类型：
 */
	//相当于重写了构造方法，当new hello之后会跳到这里
	//一般在这里写需要传的参数，例如上个通信的例子，或者写一些准备的条件
	//个人感觉其实可以提出来放到main函数中写，效果应该一样
 twothread() { 
	 //实现两个线程，第一个就是原有的这个线程，第二个线程我们自己创建，就会用到run中的部分
   Thread t1 =Thread.currentThread(); 
   t1.setName("The first main thread"); 
   System.out.println("The running thread:" + t1); 
   //通过将本类（Runnable接口）和名称构造一个线程
   Thread t2 = new Thread(this,"the second thread"); 
   System.out.println("creat another thread"); 
   //启动线程
   t2.start(); 
   try { 
     System.out.println("first thread will sleep"); 
     Thread.sleep(3000); 
   }catch (InterruptedException e) {
     System.out.println("first thread has wrong"); 
   } 
   System.out.println("first thread exit"); 
 } 
/**
 *<br>方法说明：线程主体。实现run方法。
 *<br>输入参数：
 *<br>返回类型：
 */
 public void run() { 
   try { 
     for (int i=0;i<5;i++) { 
       System.out.println("Sleep time for thread 2:"+i); 
       Thread.sleep(1000); 
     }
  } catch (InterruptedException e) {
    System.out.println("thread has wrong"); 
  }
  System.out.println("second thread exit"); 
 } 
/**
 *<br>方法说明：主方法
 *<br>输入参数：
 *<br>返回类型：
 */
 public static void main(String args[]) { 
   new twothread(); 
 } 
}

