# primer_parcial_sd - Derlis Cáceres 4.290.382
-Crear base de datos sql llamada "cambios_sd" (modificado en la clase CambioDAO.java\n
-Agregar una tabla llamada cambios con tres columnas (identi char var, compra int, venta int)\n
-Conectar la base de datos\n
-Iniciar la clase UDPServer.java y esperar al cliente\n
-Iniciar la clase UDPClient.java\n
-Ingresar los datos del banco/financiera (String)\n
-Ingresar los datos de compra (numerico)\n
-Ingresar los datos de venta (numerico)\n
-Verificar en la terminal de ejecucion del server la operación\n
(el cliente ya cumplió su función, cierra)\n
-Abrir de nuevo otro cliete (UDPClient.java)\n
-Ingresar de nuevo los datos solicitados\n
-Volver a verificar en la terminal del server la operación\n

#Modificaciones
-Cambié el nombre de la base de datos a conectar (cambios_bd), mismo user y pass que el proyecto original.\n
-Cambié la clase Persona a Cambio con los atributos:\n
    *identi: nombre de la entidad*\n
    *compra: valor del dolar a la compra*\n
    *venta: valor del colar a la venta*\n
-Ajusté la representación JSON de la clase Cambio\n
-El formato en el que se imprime en los terminales.\n
