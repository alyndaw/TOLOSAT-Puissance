package powerSimulation;

public class Orbit {
	
	private double date;
	public  final double dt;
	private boolean eclipse;
	
	public Orbit(double dt) {
		this.dt=dt;
		date=0;
		eclipse=false;
	}
	
	public double getDate() {
		return date;
	}
	
	public void nextStep() {
		date+=dt;
	}
	
	public boolean isEclipse() {
		return eclipse;
	}

}
