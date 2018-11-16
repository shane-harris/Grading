package grading;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class DropFilter implements Filter{
	private boolean shouldDropLowest;
	private boolean shouldDropHighest;
	public DropFilter(){
		this(true,true);
	}
	public DropFilter(boolean shouldDropLowest, boolean shouldDropHighest){
		this.shouldDropLowest=shouldDropLowest;
		this.shouldDropHighest=shouldDropHighest;
	}
	
	public List<Grade> apply(List<Grade> grades) throws SizeException{
		if(grades == null || grades.size()<=2) {
			throw new SizeException();
		}
		
		List<Grade> weightedGrade = new ArrayList<Grade>();
		
		for(int i=0; i<grades.size(); i++) {
			weightedGrade.add(grades.get(i));
		}
		Collections.sort(weightedGrade);
		if(shouldDropLowest) {
			weightedGrade.remove(0);
		}
		if(shouldDropHighest) {
			weightedGrade.remove(weightedGrade.size()-1);
		}
		
		return weightedGrade;
	}

}
