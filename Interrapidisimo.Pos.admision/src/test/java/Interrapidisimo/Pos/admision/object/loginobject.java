package Interrapidisimo.Pos.admision.object;

import java.awt.peer.RobotPeer;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import org.openqa.selenium.By;

import Interrapidisimo.Pos.admision.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.windows.WindowsDriver;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Window.Type;
import java.awt.event.KeyEvent;

public class loginobject extends Base{
	
	
	private static WindowsDriver driver;
	static Properties loadProperty = new Properties();
	
	//Parametrizacion de localizadores, se declara las variables
	static By preaplicacion = By.name("PrecargaWindow"); 
	//static By closepreaplicacion = By.name("cerrar");
	static By aplicacion = By.name("POS INTERRAPIDISIMO");
	static By usuario = By.id("txtNombreUsuario");
	static By contraseña = By.id("txtPassword") ;
	static By btentrar = By.id("btnLogin");
	static By ventana = By.id("MenuView");
	static By facturar = By.id("btnMensajeria");
	static By internacional = By.id("btnInternacional");	
	static By vguiainternacional = By.id("winInternacional"); 
	static By txtpaisdestino = By.id("PART_Editor");
	static By txtlistapaises = By.name("WPF.Comun.EntidadesNegocio.Parametros.PaisDHLDC");
	static By selectpais = By.name("CANADA");
	static By txtciudaddestino = By.id("PART_Editor");
	static By txtlistaciudades = By.name("WPF.Comun.EntidadesNegocio.Parametros.CiudadesDHL");
	static By selectciudad = By.name("M4E2Z, TORONTO");
	
	
	
	
//constructor
	public loginobject(WindowsDriver driver)  {
		super(driver);
	}
	
	public static void abrirAplicacion() throws IOException, InterruptedException, AWTException {
		loginobject winDriver = new loginobject(driver);
		driver = winDriver.connectionDriver();
		System.out.println("Se conecto con la app");

	
			
		if (isDisplayed(preaplicacion)) {
			Thread.sleep(3000);

		        System.out.println("Encontre la pantalla Pre aplicacion");

				Robot robot=new Robot();
				robot.keyPress(KeyEvent.VK_ALT);
				robot.keyPress(KeyEvent.VK_ESCAPE);
				robot.keyRelease(KeyEvent.VK_ALT);
				robot.keyRelease(KeyEvent.VK_ESCAPE);
		

				Thread.sleep(3000);											
								
				System.out.println("termine gestion de ventanas");
				
				if(isDisplayed(aplicacion)) {
					
					System.out.println("Encontre pantalla de login de la aplicacion Pos");
				
				}

		    }else {
		    	
		    	System.out.println("he fallado ingreso o localizacion de pantalla ");


		
			}
		
		
		
	}



	public static void ingresarDatos() throws InterruptedException, IOException, AWTException {
		Thread.sleep(2000);
		
		loadProperty.load(new FileReader("./params.properties"));
		
		
			driver.findElement(aplicacion);{			
			System.out.println("Lo logre, Lo he encontrado");
			
			
		}
		
		
		
			if (isDisplayed(aplicacion)) {
		    Thread.sleep(2000);
//		    driver.findElement(usuario).click();
//		    driver.findElement(contraseña).sendKeys(loadProperty.getProperty("password"));
		    type(loadProperty.getProperty("user"), usuario);
			type(loadProperty.getProperty("password"), contraseña);
//			type(loadProperty.getProperty("user"), usuario);
//			type(loadProperty.getProperty("password"), contraseña);
			click(btentrar);
			Thread.sleep(20000);			
//			click(sucursal);
//			Thread.sleep(1000);			
//			click(btingresar);
			System.out.println("Dio Click en entrar al POS");
			
			
			
			if (isDisplayed(facturar)){
				
				System.out.println("Entro a Validar Pantalla");
				click(internacional);
				Thread.sleep(5000);
				System.out.println("Entro a Formulario Internacional");
				Robot robot=new Robot();
				robot.keyPress(KeyEvent.VK_TAB);
				robot.keyRelease(KeyEvent.VK_TAB);
				robot.keyPress(KeyEvent.VK_TAB);
				robot.keyRelease(KeyEvent.VK_TAB);
				robot.keyPress(KeyEvent.VK_TAB);
				robot.keyRelease(KeyEvent.VK_TAB);
				System.out.println("Estoy en el campo de texto Pais Destino");
				
			}else {
				System.out.println("Error al dar click en Internacional");
				//closeDriver();
			}
				
				
		
		} else  {
		System.out.println("Error en la aplicación");
		//closeDriver();
	}
		
		
				

		}
	
	
	public static void validarPantalla() throws InterruptedException, IOException , AWTException {
	
		loadProperty.load(new FileReader("./params.properties"));
			
	
			System.out.println("Entro al escenario validar pantalla");	
			type(loadProperty.getProperty("DataPaisDestino"), txtpaisdestino);
			System.out.println("Ingreso data en campo Pais destino");
			if (isDisplayed(txtlistapaises)){
				
			System.out.println("Se desplego la lista de paises");
			click(selectpais);
			System.out.println("Selecciono el pais");
			Robot robot=new Robot();
			System.out.println(selectpais);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
					
		
		
		
		if (isDisplayed(txtlistaciudades)){
			
			System.out.println("Encontro campo ciudades ");
			type(loadProperty.getProperty("DataCiudadDestino"), txtciudaddestino);
	
			
			if (isDisplayed(txtlistapaises))
				System.out.println("Se desplego la lista de paises");	
				click(selectciudad);
				robot.keyPress(KeyEvent.VK_TAB);
				robot.keyPress(KeyEvent.VK_ALT);
				robot.keyRelease(KeyEvent.VK_TAB);
				robot.keyRelease(KeyEvent.VK_ALT);
				System.out.println("Encontro campo codigo postal");
				
		}
		
	} else {
		System.out.println("Error nbo encontro campo pais de destino");
	//closeDriver();
		
	}
		
	}		
			
		
		
//		
//		robot.keyPress(KeyEvent.VK_TAB);
//		robot.keyRelease(KeyEvent.VK_TAB);
//		type("TORONTO",txtPaisDestino);
		
//		String txtPais = txtPaisDestino.toString();
//		System.out.println(txtPais);
//		if (txtPais.contains("Pais")) {
//			click(txtPaisDestino);
//			type("CAN",txtPaisDestino);
//		}
		


		
		
//			
//		if (isDisplayed(vguiainternacional)) {
//		
////			System.out.println("Entro a Pantalla Guia Internacional");
////		String txtPais = txtpaisdestino.toString();
////		System.out.println(txtpaisdestino);
////		if (txtPais.contains("Pais")) {
////			click(txtpaisdestino);
////			type("CAN",txtpaisdestino);
////		}
////			/*Robot robot=new Robot();
////			robot.keyPress(KeyEvent.VK_TAB);
////			robot.keyRelease(KeyEvent.VK_TAB);
////			robot.keyPress(KeyEvent.VK_TAB);
////			robot.keyRelease(KeyEvent.VK_TAB);
////			robot.keyPress(KeyEvent.VK_TAB);
////			robot.keyRelease(KeyEvent.VK_TAB);
////			
////			//type(loadProperty.getProperty("DataPaisDestino"));
////			
////			*/
//				
//			
//		} else {
//			System.out.println("Ingreso NO éxitoso a Formulario Guia Internacional ");
//		closeDriver();
			
	}

