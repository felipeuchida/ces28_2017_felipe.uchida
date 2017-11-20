package View;

import java.io.File;

import Model.CubicSpline;
import Model.InterpolationMethod;
import Model.Lagrange;

public interface ViewInterface {
	// RESPONSABILITY: ESCOLHER O METODO DE INTERPOLACAO DESEJADO E CRIAR O OBJETO CORRESPONDENTE
	public void calculateResult(float value, File file);
}
