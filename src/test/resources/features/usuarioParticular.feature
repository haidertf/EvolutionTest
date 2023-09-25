#Author: Haider Fabian Tique
#Date:  23-09-2023

@EPXStandarCore
@UsuarioParticular
Feature: Se requiere hacer pruebas a la parte de creación, edición y eliminación de usuario particular

  @CrearUsuarioParticular
  Scenario Outline: Crear un usuario particular
    Given Se ingresa a la URL de EpxStandardCore <fila>
      | Ruta Excel                              | Pestana      |
      | src/test/resources/data/dataPrueba.xlsx | inicioSesion |
    When Se diligencia los campos de inicio de sesion
    And Se da clic en el menu Personalizar
    And Se da clic en particulares
    And Se da clic en el boton Nuevo Contacto
    And Se diligencia los campos obligatorios <fila>
      | Ruta Excel                              | Pestana         |
      | src/test/resources/data/dataPrueba.xlsx | creacionUsuario |
    And Se da clic en Guardar
    Then Se valida la pantalla de creacion exitosa
    Examples:
      | fila |
      | 1    |


  @EliminarUsuarioParticular
  Scenario Outline: Eliminar un usuario particular
    Given Se ingresa a la URL de EpxStandardCore <fila>
      | Ruta Excel                              | Pestana      |
      | src/test/resources/data/dataPrueba.xlsx | inicioSesion |
    When Se diligencia los campos de inicio de sesion
    And Se da clic en el menu Personalizar
    And Se da clic en particulares
    And Se ingresa el texto del usuario a eliminar <fila>
      | Ruta Excel                              | Pestana         |
      | src/test/resources/data/dataPrueba.xlsx | eliminarUsuario |
    And Se da clic en el boton eliminar
    Then Se valida la pantalla de eliminacion exitosa
    Examples:
      | fila |
      | 1    |