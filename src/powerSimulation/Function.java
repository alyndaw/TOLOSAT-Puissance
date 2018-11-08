package powerSimulation;

public enum Function {
	Antenna(500d,0d),
	SolarPanel(-1000d,0d);
	
	private final double activePowerConsumption; // in mW
	private final double inactivePowerConsumption;
	
	Function(double activePowerConsumption, double inactivePowerConsumption){
		this.activePowerConsumption=activePowerConsumption;
		this.inactivePowerConsumption=inactivePowerConsumption;
	}
	
	public double getActiveBudget(double dt) {
		return activePowerConsumption*dt;
	}
	
	public double getInactiveBudget(double dt) {
		return inactivePowerConsumption*dt;
	}

}
