package Interrapidisimo.Pos.admision.steps;

import java.awt.AWTException;
import java.io.IOException;

import Interrapidisimo.Pos.admision.object.loginobject;

public class loginsteps {

	
	public static void abrirAplicacion() throws IOException, InterruptedException, AWTException {
		// TODO Auto-generated method stub
		loginobject.abrirAplicacion();
	}

	public static void ingresarDatos() throws InterruptedException, IOException , AWTException {
		// TODO Auto-generated method stub
		loginobject.ingresarDatos();
		
	}

	public static void validarPantalla() throws InterruptedException, IOException , AWTException {
		// TODO Auto-generated method stub
		loginobject.validarPantalla();
	}

	
	
	
}
