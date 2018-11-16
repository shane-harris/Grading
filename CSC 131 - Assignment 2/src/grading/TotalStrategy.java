package grading;

import java.util.List;

public class TotalStrategy extends WeightedTotalStrategy{
	public TotalStrategy() {}
	
	public Grade calculate(String key, List<Grade> grades) throws SizeException{
		if(grades == null || grades.size()==0) {
			throw new SizeException();
		}
		Double total=0.0;
		for(int i=0;i<grades.size();i++)
			total +=  Missing.doubleValue(grades.get(i).getValue());
		Grade gr = new Grade(key,total);
		return gr;
	};
}
