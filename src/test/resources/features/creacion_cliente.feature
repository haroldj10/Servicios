@tag
Feature: crear clientes en web service servicio


  #@creacionCliente
  Scenario Outline: creación exitosa de un usuario
    Given que Harold consulta el servicio <url>
    When hace el registro con los datos
      |  email  |  password  |
      | <email> | <password> |
    Then valida el codigo de respuesta <response>

    Examples:
      |    email                    | password        | url                              | response |
      |   eve.holt@reqres.in        |  micontrasena   |  https://reqres.in/api/register  | 200      |
      #|   segundo1_correo@gmail.com |  micontrasena   |  https://reqres.in/api/register  | 201      |



  #@creacionCliente
  Scenario Outline: creación fallida de un usuario
    Given que Harold consulta el servicio <url>
    When hace el registro con los datos
      |  email  |  password  |
      | <email> | <password> |
    Then valida el codigo de respuesta <response>

    Examples:
      |    email                    | password        | url                              | response |
      |   primer1_correo@gmail.com  |                 |  https://reqres.in/api/register  | 400      |
      |                             |  12345          |  https://reqres.in/api/register  | 400      |


  @creacionCliente
  Scenario Outline: login exitoso de un cliente
    Given que Harold consulta el servicio <url>
    When hace el logueo con los datos
      |  email  |  password  |
      | <email> | <password> |
    Then valida el codigo de respuesta <response>

    Examples:
      |    email                    | password        | url                           | response |
      |   eve.holt@reqres.in        |  micontrasena   |  https://reqres.in/api/login  | 200      |


  #@creacionCliente
  Scenario Outline: login fallido de un cliente
    Given que Harold consulta el servicio <url>
    When hace el logueo con los datos
      |  email  |  password  |
      | <email> | <password> |
    Then valida el codigo de respuesta <response>

    Examples:
      |    email                    | password        | url                           | response |
      |   eve.holt@reqres.in        |                 |  https://reqres.in/api/login  | 400      |


