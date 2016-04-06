package mx.com.sidlors.commons.bean;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.log4j.Logger;

public class BeanUtil {

  private static final Logger logger = Logger.getLogger( BeanUtil.class );

  private BeanUtil() {
  }

  public static void copyProperties( Object bean2, Object bean1 ) {
    try{
      BeanUtils.copyProperties( bean2, bean1 );
    }
    catch( IllegalAccessException | InvocationTargetException e ){
      logger.error( e.getMessage() );
    }

  }

  public static String printBean( Object bean1 ) {
    return ToStringBuilder.reflectionToString( bean1 );

  }

}
