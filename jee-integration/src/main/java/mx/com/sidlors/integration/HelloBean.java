package mx.com.sidlors.integration;

import javax.ejb.Stateless;

import mx.com.sidlors.integration.api.HelloBeanLocal;
import mx.com.sidlors.integration.api.HelloBeanRemote;

/**
 * Session Bean implementation class HelloBean
 */
@Stateless
public class HelloBean implements HelloBeanRemote, HelloBeanLocal {

  @Override
  public String saidHello( String nombre ) {
    return "Hola "+nombre;
  }

}
