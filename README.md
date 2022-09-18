# primer_parcial_sd - Derlis Cáceres 4.290.382
>-Crear base de datos sql llamada "cambios_sd" (modificado en la clase CambioDAO.java
-Agregar una tabla llamada cambios con tres columnas (identi char var, compra int, venta int)
-Conectar la base de datos
-Iniciar la clase UDPServer.java y esperar al cliente
-Iniciar la clase UDPClient.java
-Ingresar los datos del banco/financiera (String)
-Ingresar los datos de compra (numerico)
-Ingresar los datos de venta (numerico)
-Verificar en la terminal de ejecucion del server la operación
(el cliente ya cumplió su función, cierra)
-Abrir de nuevo otro cliete (UDPClient.java)
-Ingresar de nuevo los datos solicitados
-Volver a verificar en la terminal del server la operación<

#Modificaciones#
>-Cambié el nombre de la base de datos a conectar (cambios_bd), mismo user y pass que el proyecto original.
-Cambié la clase Persona a Cambio con los atributos:
    *identi: nombre de la entidad*
    *compra: valor del dolar a la compra*
    *venta: valor del colar a la venta*
-Ajusté la representación JSON de la clase Cambio
-El formato en el que se imprime en los terminales.<
