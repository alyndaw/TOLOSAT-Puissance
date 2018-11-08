package powerSimulation;

import java.util.ArrayList;

public class ComponentSet {
	
	private ArrayList<Function> activeFunctionList;
	private ArrayList<Function> inactiveFunctionList;
	
	public ComponentSet(Function[] activeFunction) {
		activeFunctionList = new ArrayList<Function>();
		inactiveFunctionList = new ArrayList<Function>();
		
		for(Function f : Function.values())
			inactiveFunctionList.add(f);
	}
	
	public void activateFunction(Function f) {
		if(inactiveFunctionList.contains(f)) {
			inactiveFunctionList.remove(f);
			activeFunctionList.add(f);
		}
	}
	
	public void deactivateFunction(Function f) {
		if(activeFunctionList.contains(f)) {
			activeFunctionList.remove(f);
			inactiveFunctionList.add(f);
		}
	}
	
	public double getConsumedCharge(double dt) {
		double budget = 0;
		for(Function f : activeFunctionList)
			budget+=f.getActiveBudget(dt);
		for(Function f : inactiveFunctionList)
			budget+=f.getInactiveBudget(dt);
		return budget;
	}

}
