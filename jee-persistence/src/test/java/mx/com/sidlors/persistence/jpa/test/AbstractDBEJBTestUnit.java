package mx.com.sidlors.persistence.jpa.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;



import org.junit.After;
import org.junit.Before;

import mx.com.sidlors.commons.reflection.ReflectionHelper;

public abstract class AbstractDBEJBTestUnit {

  public Map<Class<?>, Class<?>> mapDAO;
  private EntityManager em;

  @Before
  public void setUp() {
    if( em == null ){
      System.out.println( "----> Creando Entity manager" );
      EntityManagerFactory emf = Persistence.createEntityManagerFactory( "PersistenceUnitTest" );
      em = emf.createEntityManager();
      // Agregar la relación de daos y sus implementaciones
      this.mapDAO = MapDAO.init();
      // Llamar la inicialización de los catálogos
      initializeData( "sql/catalog/export.sql" );
    }
  }

  public void initializeData( String path ) {
    if( !em.getTransaction().isActive() ){
      em.getTransaction().begin();
    }

    InputStream is = ClassLoader.getSystemResourceAsStream( path );
    InputStreamReader isr = new InputStreamReader( is );
    BufferedReader br = new BufferedReader( isr );

    String line;
    Query query = null;
    try{
      line = br.readLine();
      while( line != null ){
        if( line.length() > 20 && line.indexOf( "//" ) != 0 ){
          query = em.createNativeQuery( line );
          query.executeUpdate();
          em.flush();
        }
        line = br.readLine();
      }
    }
    catch( IOException e ){
      e.printStackTrace();
    }
    finally{
      safeCloseBufferedReader( br );
    }
  }

  private void safeCloseBufferedReader( BufferedReader br ) {
    if( br != null ){
      try{
        br.close();
      }
      catch( IOException e ){
        br = null;
      }
    }
  }

  protected void connect( Object o ) {
    connect( o, 3 );
  }

  protected void connect( Object o, int n ) {
    if( n > 0 ){
      try{

        Field[] fields = o.getClass().getDeclaredFields();

        for( Field field : fields ){
          PersistenceContext persistenceContext = field.getAnnotation( PersistenceContext.class );
          if( persistenceContext != null ){
            ReflectionHelper.set( this.em, field.getName(), o );
          }

          EJB ejb = field.getAnnotation( javax.ejb.EJB.class );
          if( ejb != null ){
            String className = field.getType().getCanonicalName();
            System.out.println( className );

            Class<?> clazz = Class.forName( className );

            if( this.mapDAO.containsKey( clazz ) ){
              Constructor<?> ctor = this.mapDAO.get( clazz ).getConstructor();
              Object dao = ctor.newInstance();

              Field[] fieldDAOs = dao.getClass().getDeclaredFields();
              for( Field fieldDAO : fieldDAOs ){
                persistenceContext = fieldDAO.getAnnotation( PersistenceContext.class );
                if( persistenceContext != null ){
                  ReflectionHelper.set( this.em, fieldDAO.getName(), dao );
                  ReflectionHelper.set( dao, field.getName(), o );
                  break;
                }
              }
              connect( dao, n - 1 );
            }

          }

        }
      }
      catch( ClassNotFoundException e ){
        e.printStackTrace();
      }
      catch( SecurityException e ){
        e.printStackTrace();
      }
      catch( NoSuchMethodException e ){
        e.printStackTrace();
      }
      catch( IllegalArgumentException e ){
        e.printStackTrace();
      }
      catch( InstantiationException e ){
        e.printStackTrace();
      }
      catch( IllegalAccessException e ){

      }
      catch( InvocationTargetException e ){
        e.printStackTrace();
      }
    }

  }

  @After
  public void tearDown() {
    if( em != null ){
      em.getTransaction().rollback();
    }

  }

  public EntityManager getEntityManager() {
    return this.em;
  }
}
