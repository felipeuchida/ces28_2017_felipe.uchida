package Q3.TireMonitor;


public class Alarm
{
	double psiPressureValue;
	public Alarm(RealSensor pressure){
		psiPressureValue = pressure.PressureValue();
	}
	
    public boolean isAlarmOn()
    {
    	CheckAlarm checkAlarm = new CheckAlarm(psiPressureValue);
        return checkAlarm.check(); 
    }
}