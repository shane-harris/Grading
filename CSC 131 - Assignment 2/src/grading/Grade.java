package grading;

public class Grade implements Comparable<Grade>{
	private String key;
	private Double value=0.0;
	@Override
	public int compareTo(Grade other) {
		// TODO Auto-generated method stub
		//implement the method for grade here
		if(this.value == null && other.value!=null) {
			return -1;
		}
		if(this.value == null && other.value==null) {
			return 0;
		}
		if(this.value != null && other.value==null) {
			return 1;
		}
		else {
			return this.value.compareTo(other.getValue());
		}

	}
	public Grade(String key) {
		if(key==null || key=="") {
			throw new IllegalArgumentException("Key cannot be empty!");
		}
		else {
			this.key=key;
			this.value=0.0;
		}
		
	}
	public Grade(String key, double value) {
		this(key);
		this.value=value;
	}
	public Grade(String key, Double value) {
		this(key);
		this.value=value;
	}
	
	public String getKey() {
		return this.key;
	}
	
	public Double getValue() {
		return this.value;
	}
	
	public String toString() {
		//Need to format spacing properly
		String str;
		
		if(this.getValue()!=null) {
			str=this.getKey()+": "+String.format("%5.1f", this.getValue());	
		}
		else {
			String NA="NA";
			str= this.getKey()+": "+String.format("%5s",NA);
		}

		return str;
	}

}
