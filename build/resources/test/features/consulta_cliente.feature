@tag
Feature: consulta y peticiones a un servicio de productos


  @pruebaServicio
  Scenario Outline: consulta de un cliente
    Given que Carolina ingresa a la pagina de DX Hotel
    When busca un paquete economico con la informacion de reserva
      |  destino  |  fechaEntrada  |  fechaSalida  |
      | <destino> | <fechaEntrada> | <fechaSalida> |
    Then valida que el valor del la reserva sea <valorReserva> en la totalidad de <dias> dias

    Examples:
      |    destino      | fechaEntrada | fechaSalida | valorReserva | dias |
      |   New York      |  3/15/2020   |  4/4/2020   |   119        |  21  |
      |   San Francisco |  3/31/2020   |  4/10/2020  |   299        |  11  |
