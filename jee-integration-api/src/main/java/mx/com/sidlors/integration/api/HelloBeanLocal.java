package mx.com.sidlors.integration.api;

import javax.ejb.Local;

@Local
public interface HelloBeanLocal {
  
  public String saidHello(String nombre);

}
