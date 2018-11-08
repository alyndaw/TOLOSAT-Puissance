package powerSimulation;

import java.util.ArrayList;

public abstract class RealMode extends Mode {

	ComponentSet componentSet;
	
	public RealMode(Orbit orbit, Battery battery, Function[] activeFunctions) {
		super(orbit, battery);
		componentSet = new ComponentSet(activeFunctions);
	}
	
	
	protected abstract void update();
	
	private void computeStep() {
		battery.update(orbit.getDate(), componentSet.getConsumedCharge(orbit.dt));
		orbit.nextStep();
	}
	
	protected abstract Mode nextMode();

	@Override
	public Mode simulateStep() {
		update();
		computeStep();
		return nextMode();
	}

}
