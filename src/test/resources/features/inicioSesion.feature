#Author: Haider Fabian Tique
#Date:  23-09-2023

@EPXStandarCore
@InicioSesion
Feature: Se requiere hacer pruebas a la parte del ingreso a EPX

  @InicioSesion
  Scenario Outline: Inicio de sesion exitoso
    Given Se ingresa a la URL de EpxStandardCore <fila>
      | Ruta Excel                              | Pestana      |
      | src/test/resources/data/dataPrueba.xlsx | inicioSesion |
    When Se diligencia los campos de inicio de sesion
    Then Se valida el inicio de sesion exitoso
    Examples:
      | fila |
      | 1    |