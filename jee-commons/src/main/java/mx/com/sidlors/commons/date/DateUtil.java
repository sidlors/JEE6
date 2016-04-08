package mx.com.sidlors.commons.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.apache.log4j.Logger;

public class DateUtil {

	private static final Logger logger = Logger.getLogger(DateUtil.class);

	private DateUtil() {
	}

	public static Date createDate(int day, int month, int year) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.set(Calendar.DAY_OF_MONTH, day);
		gc.set(Calendar.MONTH, month - 1);
		gc.set(Calendar.YEAR, year);
		gc.set(Calendar.HOUR_OF_DAY, 0);
		gc.set(Calendar.MINUTE, 0);
		gc.set(Calendar.SECOND, 0);
		gc.set(Calendar.MILLISECOND, 0);
		return new Date(gc.getTimeInMillis());
	}

	public static String dateToString(Date date, SimpleDateFormat sdf) {
		String dateReturn = null;
		try {
			dateReturn = sdf.format(date);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return dateReturn;
	}

	public static Date StringToDate(String dateInString, SimpleDateFormat sdf) {
		Date date = null;
		try {
			date = sdf.parse(dateInString);
		} catch (ParseException e) {

			logger.error(e.getMessage());
		}
		return date;

	}
}
