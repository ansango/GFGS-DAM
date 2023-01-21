package UF3_Sockets;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//EJECUTAMOS PRIMERO EL SERVIDOR ANTES DE CONECTAR CLIENTES

public class Server {
    public static void main(String[] args) {

        //Creamos un objeto servidor y ejecutamos el mismo.

        Server server = new Server();
        server.run();
    }

    //Variables y objetos para establecer el contador de clientes:

    //1 - Contador de clientes

    int counter;

    //2 - Socket servidor - Socket cliente

    ServerSocket ssckt;
    Socket clientSckt;

    //3 - Flujo output --> datos al cliente

    DataOutputStream output;

    public Server() {
        try {

            //Fijamos el puerto en el 5000

            ssckt = new ServerSocket(5000);

        } catch (IOException e) {
            e.printStackTrace();
        }
        counter = 0;
        clientSckt = null;
    }

    //Ejecución

    public void run() {
        System.out.println("El servidor se encuentra escuchando en el puerto 5000.");

        while (true) {
            try {

                // Escuchando hasta que entra cliente.

                clientSckt = ssckt.accept();
                System.out.println("Ha accedido un nuevo cliente");


                //Intercambio de datos con el cliente:

                output = new DataOutputStream(clientSckt.getOutputStream());

                //Sumamos un cliente, enviamos contador al cliente (que es su identificador)

                output.writeInt(++counter);

                //Cerramos el output y el socket cliente

                output.close();
                clientSckt.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
