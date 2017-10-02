package Q3.TireMonitor;

public class LimitsAlarm {
	private final double LowPressureThreshold = 17.0;
	private final double HighPressureThreshold = 21.0;

	public double getLowPressureThreshold() {
		return LowPressureThreshold;
	}
	
	public double getHighPressureThreshold() {
		return HighPressureThreshold;
	}
}
