# Created by adria at 4/10/2025
Feature: como usuario deseo autenticarme en la aplicacion web de OrangeHRM
  # Enter feature description here
  @test
  Scenario: como usuario deseo iniciar sesion en la aplicacion web de OrangeHRM
    Given Lizeth incia sesion en la plataforma de OrangeHRM
    When agrega un nuevo empleado desde la opcion del menu "PIM"
    Then podra buscar el empleado agregado desde la opcion "Directory"
