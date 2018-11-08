package powerSimulation;

public class SimulationMain {
	

	public static void main(String[] args) {
		
		Orbit orbit = new Orbit(1);
		Battery battery = new Battery(10000);
		
		Mode mode = new StartMode(orbit, battery);
		
		while(mode!=null) {
			mode=mode.simulateStep();
		}
		
		battery.plot();
	}

}
