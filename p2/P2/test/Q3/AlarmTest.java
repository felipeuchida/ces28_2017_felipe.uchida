package Q3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import Q3.TireMonitor.Alarm;
import Q3.TireMonitor.CheckAlarm;
import Q3.TireMonitor.LimitsAlarm;
import Q3.TireMonitor.RealSensor;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class AlarmTest {
	RealSensor sensorDummy;
	Alarm alarm;
	
	@Before
	public void setUp(){
		sensorDummy = mock(RealSensor.class);
	}
	
	@Test
	public void WhenPressureOutsideLimitsThenCheckReturnsTrue() {
		CheckAlarm checkAlarm = new CheckAlarm(29);
		assertTrue(checkAlarm.check());
	}
	
	@Test
	public void WhenPressureInsideLimitsThenCheckReturnsFalse() {
		CheckAlarm checkAlarm = new CheckAlarm(18);
		assertFalse(checkAlarm.check());
	}
	
	@Test
	public void WhenSuperiorLimitIs21ThenIsOk() {
		LimitsAlarm limits = new LimitsAlarm(); 
		assertEquals(limits.getHighPressureThreshold(),21.0,0.0);
	}
	
	@Test
	public void WhenInferiorLimitIs17ThenIsOk() {
		LimitsAlarm limits = new LimitsAlarm(); 
		assertEquals(limits.getLowPressureThreshold(),17.0,0.0);
	}
	
	@Test
	public void WhenPressureInsideLimitsThenAlarmIsOff() {
		when(sensorDummy.PressureValue()).thenReturn(19.0);
		alarm = new Alarm(sensorDummy);
		assertFalse(alarm.isAlarmOn());
	}
	
	@Test
	public void WhenPressureOutsideLimitsThenAlarmIsOn() {
		when(sensorDummy.PressureValue()).thenReturn(22.0);
		alarm = new Alarm(sensorDummy);
		assertTrue(alarm.isAlarmOn());
	}
}
