package py.una.server.udp;


import java.io.*;
import java.net.*;

import py.una.entidad.Cambio;
import py.una.entidad.CambioJSON;

class UDPClient {

    public static void main(String a[]) throws Exception {

        // Datos del servidor
        String direccionServidor = "127.0.0.1";

        if (a.length > 0) {
            direccionServidor = a[0];
        }

        int puertoServidor = 9876;
        
        try {
        	//Buffers de entrada y salida para UDP
            BufferedReader inFromUser =
                    new BufferedReader(new InputStreamReader(System.in));

            DatagramSocket clientSocket = new DatagramSocket();

            InetAddress IPAddress = InetAddress.getByName(direccionServidor);
            System.out.println("Intentando conectar a = " + IPAddress + ":" + puertoServidor +  " via UDP...");

            byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[1024];

            //Ingresando los valores para nuestro objeto Cambio
            System.out.print("Ingrese el nombre del banco/financiera (cadena): ");
            String strIdenti = inFromUser.readLine();
            String identi = "";
            try {
            	identi = strIdenti;
            }catch(Exception e1) {
            	
            }
            
            //Ingresando los valores para nuestro objeto Cambio
            System.out.print("El valor del dolar a la compra (debe ser numérico): ");
            String strCompra = inFromUser.readLine();
            Integer compra = (int) 0L;
            try {
            	compra = Integer.parseInt(strCompra);
            }catch(Exception e1) {
            	
            }
            //Ingresando los valores para nuestro objeto Cambio
            System.out.print("El valor del dolar a la venta (debe ser numérico): ");
            String strVenta = inFromUser.readLine();
            Integer venta = (int) 0L;
            try {
            	venta = Integer.parseInt(strVenta);
            }catch(Exception e1) {
            	
            }
            //Se crea el objeto con los datos ingresados
            Cambio p = new Cambio(identi, compra, venta);
            
            //Se empaqueta el objeto en una representacion JSON Sring y se calcula el tamaño
            String datoPaquete = CambioJSON.objetoString(p);
            sendData = datoPaquete.getBytes();

            //Descripción del paquete a enviar
            System.out.println("Enviar " + datoPaquete + " al servidor. ("+ sendData.length + " bytes)");
            DatagramPacket sendPacket =
                    new DatagramPacket(sendData, sendData.length, IPAddress, puertoServidor);
            //Enviamos el paquete
            clientSocket.send(sendPacket);

            DatagramPacket receivePacket =
                    new DatagramPacket(receiveData, receiveData.length);

            System.out.println("Esperamos si viene la respuesta.");
            
            clientSocket.setSoTimeout(10000);

            try {
                // ESPERAMOS LA RESPUESTA, BLOQUENTE
                clientSocket.receive(receivePacket);

                String respuesta = new String(receivePacket.getData());
                Cambio presp = CambioJSON.stringObjeto(respuesta.trim());
                
                InetAddress returnIPAddress = receivePacket.getAddress();
                int port = receivePacket.getPort();                

            } catch (SocketTimeoutException ste) {

                System.out.println("TimeOut: El paquete udp se asume perdido.");
            }
            clientSocket.close();
        } catch (UnknownHostException ex) {
            System.err.println(ex);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
} 

