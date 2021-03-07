package Model;

import java.util.Comparator;

public class Matter {

	String id;
	String name;
	int credits;
	
	
	public Matter(String id, String name, int credits) {
		
		this.id = id;
		this.name = name;
		this.credits = credits;
	}
	
	public static Comparator<Matter> compId=new Comparator<Matter>() {

		@Override
		public int compare(Matter arg0, Matter arg1) {
			return arg0.getId().compareTo(arg1.getId());
		}
		
	};
	
	public static Comparator<Matter> compName=new Comparator<Matter>() {

		@Override
		public int compare(Matter arg0, Matter arg1) {
			return arg0.getName().compareTo(arg1.getName());
		}
		
	};
	public static Comparator<Matter> compCredits=new Comparator<Matter>() {

		@Override
		public int compare(Matter arg0, Matter arg1) {
			return arg1.getCredits() - arg0.getCredits();
		}
		
	};
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}

	@Override
	public String toString() {
		return "Matter [id=" + id + ", name=" + name + ", credits=" + credits+ "]";
	}
	
	
}
