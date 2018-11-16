package grading;


public class Missing {
	private static final double DEFAULT_MISSING_VALUE = 0.0;
	public static double doubleValue(Double number) {
	
		return (number==null ? DEFAULT_MISSING_VALUE : number);
	}
	
	public static double doubleValue(Double number, double missingValue) {
		
		return (number==null ? missingValue : number);
	}
}
