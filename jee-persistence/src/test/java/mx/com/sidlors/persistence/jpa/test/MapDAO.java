package mx.com.sidlors.persistence.jpa.test;

import java.util.HashMap;
import java.util.Map;

public final class MapDAO
{

  public static Map<Class<?>, Class<?>> init()
  {
    Map<Class<?>, Class<?>> mapDAO = new HashMap<Class<?>, Class<?>>();
    mapDAO.put( mx.com.sidlors.persistence.dao.EmployeeDAO.class, mx.com.sidlors.persistence.dao.impl.EmployeeDAOImpl.class );  
    
    return mapDAO;
  }
}
