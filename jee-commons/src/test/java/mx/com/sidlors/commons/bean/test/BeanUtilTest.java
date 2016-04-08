package mx.com.sidlors.commons.bean.test;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import mx.com.sidlors.commons.bean.BeanUtil;
import mx.com.sidlors.commons.bean.object.test.PerroEntity;
import mx.com.sidlors.commons.bean.object.test.PerroVO;

public class BeanUtilTest {

  private static final Logger logger = Logger.getLogger( BeanUtilTest.class );
  private PerroEntity perroEntity = null;
  private PerroVO perroVO = null;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
  }

  @Before
  public void setUp() throws Exception {
    perroVO = new PerroVO();
    perroEntity = new PerroEntity();
    perroEntity.setEdad( 1 );
    perroEntity.setId( 1 );
    perroEntity.setNombre( "Firulais" );
    perroEntity.setRaza( "Pitbull" );

  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testCreateDate() {
    BeanUtil.copyProperties(perroVO,perroEntity );
    logger.info( BeanUtil.printBean( perroEntity ) );
    logger.info( BeanUtil.printBean( perroVO ) );
  }

}
