package hello;

public class hello {
	int[] iday = {31,28,31,30,31,30,31,31,30,31,30,31};
	char inum[] = {'1','2','3','4','5','6','7','8','9','0'};
	char ichar[] = {'a','b','c','d','e','f','g','h',
            'i','j','k','l','m','n','o','p',
            'q','r','s','t','u','v','w','x','y','z'};
	String[] sMail = {"@","."};
	
	//检查是否为数字，注意输入的是字符串，所以num为string类型。要不就切割然后转为int，要不就之前定义好char
	//型的inum[]数组，将string[i]转成char型再比较。注意string型与char型是不一样的！
	//!!!!这种循环最后也不对，只能测有没有，不能测是不是全为数字，最后用下面的checknum中自带的函数写了
	public boolean checkdaynum(String num){
		boolean fin = true;
		for(int i =0;i<num.length();i++){
			char numtemp = num.charAt(i);  
			for(int j=0;j<inum.length;j++){
				if(numtemp==inum[j]){
					break;
				}
				else {
					fin = false;
				}
			}
		}
		return fin;
	}
	//用Java自带的检测是否为数字的方法写了
	public void checknum(String sPara){
		boolean fin = true;
		
	   	 int iPLength = sPara.length();
	   	 for(int i=0;i<iPLength;i++){
	   		if (!Character.isDigit(sPara.charAt(i))){
	   		    fin = false;
	   		   }
	   }
	   	 if(fin)
	   	  { System.out.println("is num");
	   		 
	   	 }
	   	  else{
	   	 System.out.println("not num");
	   	  }
	}
	//检查是否为字母，类比同上
	public void checkchar(String chars){
		String fin = "is char";
		for(int i =0;i<chars.length();i++){
			char numtemp = chars.charAt(i);  
			for(int j=0;j<ichar.length;j++){
				if(numtemp!=ichar[j]){
					fin = "not char";
				}
			}
		}
		
		System.out.println(fin);
		
	}
	
	//检查邮箱地址，简易版，就是检查输入的字符串有无@与.,注意给定的数组尾string类型，不是char了。所以直接indexof
	//不用string转char了，charAt
	public void checkmail(String mail){
		String fin = "is email";
		for(int i =0;i<sMail.length;i++){
			if(mail.indexOf(sMail[i])==-1){
				fin = "not email";
			}
		}
		
		System.out.println(fin);
	}
	
	//检查是否为闰年的方法
	public boolean checkyear(int year){
		boolean fin = false;
		if((year%100==0)&&(year%4==0)){
			fin=true;
		}
		return fin;
	}
	
	//检查年份的格式
	public void checkday(String day){
		String fin = "correct";
		String syear = day.substring(0, 4);
		String smonth = day.substring(5, 7);
		String sdate = day.substring(8, 10);
		if(checkdaynum(syear)&&checkdaynum(sdate)&&checkdaynum(smonth)){
			fin = "wrong";
		}
		
		int iyear = Integer.parseInt(syear);
		int imonth = Integer.parseInt(smonth);
		int idate = Integer.parseInt(sdate);
		if(checkyear(iyear)){
			if(imonth==2){
				if(idate>29){
					fin = "wrong";
				}
			}
		}
		else{
			if(idate>iday[imonth-1]){
				fin = "wrong";
			}
		}
		System.out.println(fin);
	}
	
	public static void main(String[] args) {
		hello ha =new hello();
		ha.checknum("12334556");
		ha.checknum("123asd");
//		ha.checkchar("asdsdf");
//		ha.checkchar("123asd");
//		ha.checkmail("123@123.com");
//		ha.checkmail("123.asd");
//		ha.checkday("1994-02-11");
//		ha.checkday("1994-02-32");
//		ha.checkday("2000-02-29");
//		ha.checkday("1994-01-40");
		
	}

}
