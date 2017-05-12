package hello;

import java.io.*;
import java.util.*;
public class hello{

	//删除文件
	public boolean delete(String path){
		
		try{
			File sfile = new File(path);
			boolean fin = sfile.delete();
			if(fin==false){
				System.out.println("删除失败");
				return false;
			}
			else{
				System.out.println("成功删除");
				return true;
			}
		}
		catch(Exception e){
			System.out.println(e);
			return false;
		}
	}
	
	//获取文件信息
	public String[] info(String path){
		try{
		File file = new File(path);
	      //获取文件修改日期（返回的是毫秒）
	      long modifiedTime = file.lastModified();
	      //获取文件长度（单位：Bite）
	      long filesize = file.length();
	      //测试文件是否可读
	      boolean cr = file.canRead();
	      //测试文件是否可写
	      boolean cw = file.canWrite();
	      //测试文件是否隐藏
	      boolean ih = file.isHidden();
	      
	      String[] sTemp = new String[6];
	      sTemp[0] = String.valueOf(filesize);
	      //因为用lastModified返回的是从19几几年至今度过的所有毫秒数，所以写了一个时间转换函数
	      sTemp[1] = changetime(modifiedTime);  
	      sTemp[2] = String.valueOf(cr);
	      sTemp[3] = String.valueOf(cw);
	      sTemp[4] = String.valueOf(ih);
	      sTemp[5] = String.valueOf(file.getCanonicalPath());
	      return sTemp;
		}
		catch(Exception e){
			System.out.println(e);
		    return null;
		}
	}
	
	//时间转换函数的实现
	public static String changetime(long sec){
		if(sec < 0) return  "";
	    //下面这个Date类可以直接用long型的毫秒时间创建，直接转换出年月日时分秒，而且提供各自调用的方法
	    Date date = new Date(sec);
	    //这里讲Date转换成了calender类，二者都是表示时间的类
	    Calendar rightNow = Calendar.getInstance();
	    rightNow.setTime(date);
	    int year = rightNow.get(Calendar.YEAR);
	    int month = rightNow.get(Calendar.MONTH);
	    int day = rightNow.get(Calendar.DAY_OF_MONTH);
	    int hour = rightNow.get(Calendar.HOUR_OF_DAY);
	    int min = rightNow.get(Calendar.MINUTE);

	    return year + "-" + (month <10 ? "0" + month : "" + month) + "-" 
	           +  (day <10 ? "0" + day : "" + day)
	           +  (hour <10 ? "0" + hour : "" + hour)+":"
	           + (min <10 ? "0" + min : "" + min);
	}
  public static void main(String[] args){
    //这里将会给main函数传参数，具体做法见博文。在run configeration里面设置argument
    try{
        hello fileoperation = new hello();
        if(args.length==0){
          return;
        }else{
          String cmd = args[0];
          if(cmd.equals("del")){
            boolean bdel = fileoperation.delete(args[1]);
            System.out.println(bdel);
          }else if(cmd.equals("info")){
            String[] sTemp = fileoperation.info(args[1]);
            for(int i=0;i<sTemp.length;i++)
              System.out.println(sTemp[i]);
          }
        
        }
      }catch(Exception e){
        return;
      }
   }
} 
