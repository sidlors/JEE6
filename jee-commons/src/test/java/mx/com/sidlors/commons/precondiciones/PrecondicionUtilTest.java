package mx.com.sidlors.commons.precondiciones;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class PrecondicionUtilTest {

	@Test(expected=NullPointerException.class)
	public void testNotNull() {
		PrecondicionUtil.validaNulo(null);
	}
	
	@Test(expected=NullPointerException.class)
	public void testNotNullObjs() {
		PrecondicionUtil.validaNulo(null,new Date(),null);
	}


}
