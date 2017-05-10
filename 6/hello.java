package hello;

//通过继承Exception这个已有的异常处理类，来写自己的一个异常处理类

class MyException extends Exception {
  //在自定义类中写两个简单的抛出异常的方法
  //第一个是带有用户自定义的抛出信息msg的，到时候会显示在异常信息中
  public MyException(String msg) {
    super(msg);
  }
  
  //第二个再写一个带有错误码的抛出异常的方法
  //像这种方法可以随意写，就是相当于一群重载，到时候抛出的格式符合哪个就调用哪个
  public MyException(String msg, int x) {
    super(msg);
    System.out.println("error code: " + x);
  } 
}

public class hello {
	
    static int a =0;

   //写两个函数，自带抛出异常的
    public static void b() throws MyException {
    System.out.println(
      "Throwing MyException from b()");
    throw new MyException("Originated in b()");
  }

  public static void c() throws MyException {
    System.out.println(
      "Throwing MyException from c()");
    throw new MyException(
      "Originated in c()", 47);
  }
  
  //在主函数main中进行调用
  public static void main(String[] args) throws MyException {
    //直接抛出的的写法
//    	if(a==0)
//    	{
//    	    throw new MyException("hahaha");
//    	  
//    	}
//    	else{
//    		System.out.println( "cc");
//    	}
//    	
   //放在try-catch块中的写法
    try {
    	b();
    } catch(MyException e) {
        
    	e.getMessage();   //接受抛出来的信息，getMessage方法时继承父级的
    }
    try {
      c();
    } catch(MyException e) {
      e.printStackTrace();  //也是显示详细信息的父级的方法
    }
  }
} 
