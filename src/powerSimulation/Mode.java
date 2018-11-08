package powerSimulation;

public abstract class Mode {
	
	public Mode(Orbit orbit, Battery battery) {
		this.orbit = orbit;
		this.battery = battery;
	}

	Orbit orbit;
	Battery battery;
	
	public abstract Mode simulateStep();

}
