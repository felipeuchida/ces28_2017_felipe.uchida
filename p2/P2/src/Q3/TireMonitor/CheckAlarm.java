package Q3.TireMonitor;

public class CheckAlarm {
	double psiPressureValue;
	LimitsAlarm limits = new LimitsAlarm();
	
	public CheckAlarm(double pressure){
		psiPressureValue = pressure;
	}
	
	public boolean check()
	{
		if (psiPressureValue < limits.getLowPressureThreshold() || limits.getHighPressureThreshold() < psiPressureValue)
		{
			return true;
		}
		return false;
	}
}
