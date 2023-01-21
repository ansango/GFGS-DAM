package UF3_Sockets;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

//EJECUTAMOS PRIMERO EL SERVIDOR ANTES DE CONECTAR CLIENTES

public class Client {

    public static void main(String[] args) {

        //Creamos un objeto cliente y ejecutamos el mismo.

        Client client = new Client();
        client.run();
    }

    //Objetos Socket y flujo:

    //1 - Socket cliente que se conecta al servidor

    Socket clientSckt;

    //2 - Stream de entrada que recibe los datos del servidor

    DataInputStream input;

    public Client() {

        try {

            //Conexion al puerto donde escucha el servidor

            clientSckt = new Socket("localhost", 5000);

            //Flujo de entrada, obteniendo datos del servidor

            input = new DataInputStream(clientSckt.getInputStream());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Ejecución

    public void run() {
        try {

            //Imprimimos los datos que nos llegan del servidor

            System.out.println("Tu código de cliente es: " + input.readInt());

            //Se cierra el stream y el socket

            input.close();

            clientSckt.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
