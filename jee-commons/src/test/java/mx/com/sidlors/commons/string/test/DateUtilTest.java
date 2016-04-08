package mx.com.sidlors.commons.string.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import mx.com.sidlors.commons.date.DateUtil;

public class DateUtilTest {
	
	
	private static final Logger logger = Logger.getLogger(DateUtilTest.class);
	private Date fecha = null;
	private SimpleDateFormat sdf=null;
	private String strFecha=null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		fecha = DateUtil.createDate(1, 12, 2016);
		sdf=new SimpleDateFormat("yyyy-mm-dd");
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateDate() {
		
		assertNotNull(fecha);
		logger.info(fecha);
		
	}

	@Test
	public void testDateToString() {
		strFecha=DateUtil.dateToString(fecha, sdf);
		assertNotNull(strFecha);
		logger.info(strFecha);
	}

	@Test
	public void testStringToDate() {
		strFecha="1985-03-24";
		Date fechaDate=DateUtil.StringToDate(strFecha, sdf);
		assertNotNull(fechaDate);
		logger.info(fechaDate);
	}

}
