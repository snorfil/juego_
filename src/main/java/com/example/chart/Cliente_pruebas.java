package com.example.chart;

import java.io.*;
import java.net.Socket;

public class Cliente_pruebas extends Thread {

    PrintWriter writer;
    BufferedReader reader;

    public Cliente_pruebas()
    {
        this.start();
    }

    @Override
    public void run() {
        super.run();
        Socket sk ;

        String dato;
        try {
            sk = new Socket("127.0.0.1",1568);
            writer = new PrintWriter(new PrintStream(sk.getOutputStream()));
            reader = new BufferedReader(new InputStreamReader(sk.getInputStream()));
            System.out.println("Conectando a la partida.....");
            dato = reader.readLine();

            reader.close();
            writer.close();
            int puerto = Integer.parseInt(dato);

            sk = new Socket("localhost",puerto);
            System.out.println("Cliente________ esperando a iniciar partida");

            reader = new BufferedReader(new InputStreamReader(sk.getInputStream()));
            writer = new PrintWriter(new PrintStream(sk.getOutputStream()));

            reader.readLine();
            System.out.println("Cliente________"+ this.getName() + " Comienza la partida!!!!!!");

            while (true)
            {
                /**
                 * cada toque debera ejecutar este codigo de escribir
                 * sera el botón.................
                 */
                writer.println("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public void pulsar()
    {
        writer.println("\n");
    }
}
