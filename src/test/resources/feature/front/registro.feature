Feature: Crear cuenta para el portal web automationpractice


  @Registro_exitoso
  Scenario: 001- Creacion de una cuenta para el porta web AutomationPractice
    Given que el usuario ingresa a la pagina web para la creacion de una cuenta en automationpractice
    When ingresa el modulo de registro y llena todo el formulario de datos personas y direccion
    Then el usuario crea su cuenta automationpractice con exito
