package mx.com.sidlors.integration.test;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;
import mx.com.sidlors.integration.api.HelloBeanRemote;

public class HelloBeanTest {

  private static EJBContainer ejbContainer;
  private static Context ctx;
  

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    Map<String, Object> properties = new HashMap<String, Object>();
    properties.put( "org.glassfish.ejb.embedded.glassfish.installation.root", "./src/test/resources/glassfish" );
    ejbContainer = EJBContainer.createEJBContainer( properties );
    ctx = ejbContainer.getContext();

    System.out.println( "Starting the container" );
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {

    ejbContainer.close();
    System.out.println( "Closing the container" );
  }

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testRemote() throws NamingException {
    HelloBeanRemote helloBeanRemote = (HelloBeanRemote) ctx.lookup("java:global/jee-integration/"
        + "HelloBean!mx.com.sidlors.integration.api.HelloBeanRemote");
    String msg=helloBeanRemote.saidHello( "Yisus" );
    System.out.println( msg );
    

    assertNotNull( msg );
  }

}
