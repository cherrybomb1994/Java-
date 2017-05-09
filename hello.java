package hello;

//定义一个接口，接口中变量均为常量（public static final），方法全为抽象的（abstract）
//但是写的时候不用写 public static final， 以及方法前面也不用加abstract。直接写就可以
interface player_one{
	int a = 10;
	void play();//播放
	void pause();//暂停
	void stop();//停止 
}

//再定义另外一个接口
interface player_two{
	int b = 20;
	void start();
	void end();
}

//定义一个抽象类，如果一个类中存在抽象方法，那么这个类就为抽象类，class前面要加abstract。
//当然这个类中还可以有正常方法
abstract class playing{
	//正常的方法
	public void display(Object oPara)
	 {
	   System.out.println(oPara);  
	 }
	//抽象的方法，就是只声明，不实现。 必须被继承由子类实现
	abstract void winRun();
}

//在这个类中将抽象类中的抽象方法实现（前提是当然要先继承它），Java中没有多重继承，所以一个子类最多只能实现一个抽象类
//但是一个类中可以实现多个接口，因为接口为抽象的方法（功能），它可以有很多个功能
//继承类=“是不是”   接口=“有没有”
//只能是一种东西，但是可以有很多
//接口和抽象类都不能实例化，只能在将他们都实现了的类中，通过子类的实例化，才能调用这些抽象方法。
public class hello extends playing implements player_one,player_two{
	
	public void play()
	  {
	    display("接口1的 newPlay.play()");//这里只是演示，去掉了代码。
	  }
	  public void pause()
	  {
	     display("接口1的 newPlay.pause()");//这里只是演示，去掉了代码。
	  }
	  public void stop()
	  {
	    display("接口1的 newPlay.stop()");//这里只是演示，去掉了代码。
	  }
	  void winRun()
	  {
	    display("抽象类的 newPlay.winRun()");//这里只是演示，去掉了代码。
	  }
	  public void start()
	  {
	    display("接口2的 newPlay.start()");//这里只是演示，去掉了代码。
	  }
	  public void end()
	  {
	     display("接口2的 newPlay.end()");//这里只是演示，去掉了代码。
	  }
	public static void main(String[] args) {
		hello p = new hello();
	    p.play();
	    p.pause();
	    p.stop();
	    p.winRun();
	    p.start();
	    p.end();
	    p.display(a);   //在接口中定义的全局常量，可以直接拿来用
	    p.display(b);
	}

}

