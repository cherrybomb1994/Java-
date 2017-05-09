package hello;

class tree {
	
	//打印信息
	public void print(Object oPara)
	  {
	    System.out.println(oPara);
	  }

	//树根信息
	public void root(){
		String a = "土壤中";
		String b = "吸收养份";
		this.print("位置："+a);
		this.print("功能："+b);
		
	}
	
	//树干信息
	public void bolo(){
		String sSite = "地面";
	    String sFunction = "传递养份";
	    print("位置："+sSite);
	    print("功能："+sFunction);
	}
	
	//树枝信息
	public void branch()
	  {
	    String sSite = "树干上";
	    String sFunction = "传递养份";
	    print("位置："+sSite);
	    print("功能："+sFunction);
	  }
	
	//树叶信息
	public void leaf()
	  {
	    String sSite = "树梢";
	    String sFunction = "光合作用";
	    String sColor = "绿色";
	    print("位置："+sSite);
	    print("功能："+sFunction);
	    print("颜色："+sColor);
	  }
	public static void main(String[] args) {
	    tree t = new tree();
	    t.print("描述一棵树：");
	    t.print("树根：");
	    t.root();
	    t.print("树干：");
	    t.bolo();
	    t.print("树枝：");
	    t.branch();
	    t.print("树叶：");
	    t.leaf();
	}

}

public class hello extends tree{
	
	
	//为原方法重载
	public void leaf()
	  {
		//若想将父类的原方法引入，要加super，否则直接leaf()就会默认是子类在调用自己
		super.leaf();    
	    String sShape = "长形";
	    //若子类中没有复写print方法，则会自动向上层父类中寻找。如果子类中复写print函数，则不用super时调用子类中的方法
	    print("形状："+sShape);    
	  }
	
	//扩展一个新方法
	 public void flower()
	  {
	    print("哈哈，柳树没有花！！");
	  }
	public static void main(String[] args){
		   hello o = new hello();
		    o.print("柳树树根：");
		    o.root();
		    o.print("柳树树干：");
		    o.bolo();
		    o.print("柳树树枝：");
		    o.branch();
		    o.print("柳树树叶：");
		    o.leaf();
		    o.print("柳树花：");
		    o.flower();
	}
}
