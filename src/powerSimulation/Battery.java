package powerSimulation;

import java.util.HashMap;

public class Battery {
	
	private double capacity;
	private double charge;
	
	private HashMap<Double,Double> chronogramme;
	
	public Battery(double capacity) {
		this.capacity=capacity;
		charge=capacity;
		chronogramme = new HashMap<Double,Double>();
	}
	
	public void update(double date, double powerBudget) {
		charge+=powerBudget;
		if(charge>capacity)
			charge=capacity;
		
		chronogramme.put(date,charge);
	}
	
	public void plot() {
		
	}
	
}
