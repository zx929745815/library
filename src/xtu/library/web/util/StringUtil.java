package xtu.library.web.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class StringUtil {
	
	public static String renameFileName(String fileName){
		//获取当前时间的字符串
		String dateStr = new SimpleDateFormat("yyMMddHHmmss").format(new Date());
		int random = new Random().nextInt(10000);
		String extension =fileName.substring(fileName.lastIndexOf("."));
		return dateStr+random+extension;
	}

}
