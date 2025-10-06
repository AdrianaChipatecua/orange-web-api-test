# Created by adria at 4/10/2025
Feature: Como usuario deseo validar las peticiones a la API de OrangeHRM

  @test-api
  Scenario: como usuario de la API deseo autenticarme
    Given Lizeth inicia la conexion a la API para obtener un token de autenticacion
    When ella realiza la peticion al request "/auth/validate"
    Then podra ver el mensaje de redireccion exitosa