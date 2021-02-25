package Interrapidisimo.Pos.admision.definition;

import Interrapidisimo.Pos.admision.steps.loginsteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class loginDefinitions {


	@Given("^Usuario en aplicacion Admisiones Pos$")
	public void usuario_en_aplicacion_Admisiones_Pos() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
	loginsteps.abrirAplicacion();
}

@When("^Usuario ingresa usuario, contraseña y al modulo DHL$")
public void usuario_ingresa_usuario_contraseña_y_al_modulo_DHL() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
	loginsteps.ingresarDatos();
}

@Then("^Ingresa a Modulo internacional DHL he ingresa datos en el formulario$")
public void ingresa_a_Modulo_internacional_DHL_he_ingresa_datos_en_el_formulario() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
	loginsteps.validarPantalla();
}

		
	
}
