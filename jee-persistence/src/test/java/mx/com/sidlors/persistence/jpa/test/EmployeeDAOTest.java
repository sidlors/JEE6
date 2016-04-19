package mx.com.sidlors.persistence.jpa.test;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import mx.com.sidlors.persistence.dao.EmployeeDAO;
import mx.com.sidlors.persistence.dao.impl.EmployeeDAOImpl;

public class EmployeeDAOTest extends AbstractDBEJBTestUnit {

  private EmployeeDAO employeeDAO;

  private static final Logger logger = Logger.getLogger( EmployeeDAOTest.class );


  @Before
  public void setUp() {
    employeeDAO = new EmployeeDAOImpl();
    super.setUp();
    connect( employeeDAO );
  }


  @Test
  public void getAlltest() {
    //List<CatalogTO> tos = 
//        EmployeeDAO.getAll();
//    assertNotNull( tos );
//    assertFalse( tos.isEmpty() );
//    for( CatalogTO to : tos )
//    {
//      LOG.debug( StringUtils.EMPTY, to );
//    }
//  
    }

}
