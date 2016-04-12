package mx.com.sidlors.commons.precondiciones;

import com.google.common.base.Preconditions;

public class PrecondicionUtil {

	private PrecondicionUtil() {
	}

	public static void validaNulo(Object o) {
		Preconditions.checkNotNull(o, "Illegal Argument passed: Parameter is Null.");

	}

	public static void validaNulo(Object o, Object... objs) {
		Preconditions.checkNotNull(o, "Illegal Argument passed: First parameter is Null.");
		for (Object object : objs) {
			Preconditions.checkNotNull(object, "Illegal Argument passed: Parameter is Null.");
		}

	}

	public static void checaValores(int... values) {
		
		for (int k=0;k<values.length ; k++) {
			Preconditions.checkArgument(values[k]<values[k+1], "El argumento %s es mayor que %s",k,k+1 );
		}
		
	}
	
	public static void checkPositive(double input){
	      Preconditions.checkArgument(input > 0.0,"Illegal Argument passed: Negative value %s.", input);
	}
	
	
	public static void checaValores(double... values) {

	}

}
