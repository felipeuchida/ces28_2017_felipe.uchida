import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import Q4.ptc.ControladorPTC;
import Q4.ptc.Datacenter;
import Q4.ptc.PainelCondutor;
import Q4.ptc.Sensor;

public class ControladorPTCTest {

	@Test
	// Questão 4 letra (a)
	public void WhenInitiateThenIsOK() {
		Sensor sensoDummy = mock(Sensor.class);
		Datacenter datacenterDummy = mock(Datacenter.class);
		PainelCondutor painelCondDummy = mock(PainelCondutor.class);
		ControladorPTC controladorPTC = new ControladorPTC(sensoDummy, datacenterDummy, painelCondDummy);
		assertTrue(controladorPTC instanceof ControladorPTC);
	}
	
	@Test
	// Questão 4 letra (b)
	public void WhenTrainIsntCrossingThenisCruzamentoReturnFalse() {
		Sensor sensorStub = mock(Sensor.class);
		when(sensorStub.isCruzamento()).thenReturn(false);
		assertFalse(sensorStub.isCruzamento());
	}
	
	@Test
	// Questão 4 letra (c)
	public void WhenTrainIsCrossingAndVellocityBiggerThen100ThenenviaMsgPrioritariaPainelReturnTrue() {
		Sensor sensorStub = mock(Sensor.class);
		when(sensorStub.isCruzamento()).thenReturn(true);
		when(sensorStub.getVelocidade()).thenReturn(101.0);
		assertTrue(sensorStub.isCruzamento());
		assertTrue(sensorStub.getVelocidade()>100);
		
		Datacenter datacenterDummy = mock(Datacenter.class);
		PainelCondutor painelCondDummy = mock(PainelCondutor.class);
		ControladorPTC controladorPTC = new ControladorPTC(sensorStub, datacenterDummy, painelCondDummy);
		
		when(controladorPTC.enviaMsgPrioritariaPainel("",painelCondDummy)).thenReturn(true);
		assertTrue(controladorPTC.enviaMsgPrioritariaPainel("",painelCondDummy));
	}
	
	@Test
	// Questão 4 letra (d)
	public void WhenTrainIsCrossingAndVellocitySmallerThen20ThenenviaMsgPrioritariaPainelReturnFalse() {
		Sensor sensorStub = mock(Sensor.class);
		when(sensorStub.isCruzamento()).thenReturn(true);
		when(sensorStub.getVelocidade()).thenReturn(19.0);
		assertTrue(sensorStub.isCruzamento());
		assertTrue(sensorStub.getVelocidade()<20);
		
		Datacenter datacenterDummy = mock(Datacenter.class);
		PainelCondutor painelCondDummy = mock(PainelCondutor.class);
		ControladorPTC controladorPTC = new ControladorPTC(sensorStub, datacenterDummy, painelCondDummy);
		
		when(controladorPTC.enviaMsgPrioritariaPainel("",painelCondDummy)).thenReturn(false);
		assertFalse(controladorPTC.enviaMsgPrioritariaPainel("",painelCondDummy));
	}
}
