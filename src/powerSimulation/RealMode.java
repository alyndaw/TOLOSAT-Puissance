package powerSimulation;

import java.util.ArrayList;

public abstract class RealMode extends Mode {

	public RealMode(Orbit orbit, Battery battery) {
		super(orbit, battery);
		activeFunctionList = new ArrayList<Function>();
		inactiveFunctionList = new ArrayList<Function>();
		
		for(Function f : Function.values())
			inactiveFunctionList.add(f);
	}
	
	protected ArrayList<Function> activeFunctionList;
	protected ArrayList<Function> inactiveFunctionList;
	
	protected abstract void update();
	
	private void computeStep() {
		double budget = 0;
		for(Function f : activeFunctionList)
			budget+=f.getActiveBudget(orbit.dt);
		for(Function f : inactiveFunctionList)
			budget+=f.getInactiveBudget(orbit.dt);
			
		battery.update(orbit.getDate(), budget);
		orbit.nextStep();
	}
	
	protected abstract Mode nextMode();

	@Override
	public Mode simulateStep() {
		update();
		computeStep();
		return nextMode();
	}
	
	protected void activateFunction(Function f) {
		if(inactiveFunctionList.contains(f)) {
			inactiveFunctionList.remove(f);
			activeFunctionList.add(f);
		}
	}
	
	protected void deactivateFunction(Function f) {
		if(activeFunctionList.contains(f)) {
			activeFunctionList.remove(f);
			inactiveFunctionList.add(f);
		}
	}

}
