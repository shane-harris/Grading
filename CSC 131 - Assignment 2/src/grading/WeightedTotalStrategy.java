package grading;
import java.util.List;
import java.util.Map;

public class WeightedTotalStrategy implements GradingStrategy{
	private Map<String,Double> weights;
	
	public WeightedTotalStrategy(){
		this(null);
	}
	public WeightedTotalStrategy(Map<String,Double> weights){
		this.weights = weights;
	}
	
	public Grade calculate(String key, List<Grade> grades) throws SizeException{
		if(grades == null || grades.size() == 0) {
			throw new SizeException();
		}
		double grade=0.0;
		for(int i=0; i<grades.size();i++) {
			System.out.println(grades.get(i).toString());
			grade += Missing.doubleValue(grades.get(i).getValue()) * Missing.doubleValue(weights.get(grades.get(i).getKey()),1);
		}
		return new Grade(key, grade);
	}
	

}
