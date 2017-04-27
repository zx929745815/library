package xtu.library.web.util;

import java.util.Calendar;
import java.util.Date;
/**
 * 日期工具类
 * @author 郑旭
 * 下午1:06:21
 */
public class DateUtil {
	/**
	 * 返回两个日期类型之间的天数
	 * @param fDate
	 * @param oDate
	 * @return
	 */
	public static int daysBetween(Date fDate, Date oDate) {
	       Calendar aCalendar = Calendar.getInstance();
	       aCalendar.setTime(fDate);
	       int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);
	       aCalendar.setTime(oDate);
	       int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);
	       return day2 - day1;
	    }
}
