Feature: Login Feature
  Verificar si el usuario se puede loguear correctamente

  Scenario: Ingresar con usuario correcto
    Given Usuario en aplicacion Admisiones Pos
    When Usuario ingresa usuario, contraseña y al modulo DHL
    Then Ingresa a Modulo internacional DHL he ingresa datos en el formulario
