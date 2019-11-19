/**
 * @author Tarcisio da Rocha (Prof. DCOMP/UFS)
 */
package br.ufs.dcomp.ExemploTcpJava;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class TCPServer{
    public static void main(String[] args){
        
        try {
            System.out.print("[ Iniciando Servidor TCP    .........................  ");
            ServerSocket ss = new ServerSocket(3300, 5, InetAddress.getByName("127.0.0.1"));
            System.out.println("[OK] ]");
            
            System.out.print("[ Aquardando pedidos de conexão    ..................  ");
            Socket sock = ss.accept(); // Operação bloqueante (aguardando pedido de conexão)
            System.out.println("[OK] ]");
            
            InputStream is = sock.getInputStream(); //Canal de entrada de dados
            OutputStream os = sock.getOutputStream(); //Canal de saída de dados
            byte[] buf = new byte[100]; // buffer de recepção
            Scanner se = new Scanner(System.in);

            while(true){
                int t = is.read(buf); // Operação bloqueante (aguardando chegada de dados)
                String msg = new String(buf, 0, t); // Mapeando vetor de bytes recebido para String
                System.out.println("Cliente: " + msg);
            
                System.out.print("Servidor: ");
                msg = se.nextLine();
                byte[] bufResposta = msg.getBytes();
                os.write(bufResposta);
            }

        }catch(Exception e){System.out.println(e);}    
        System.out.println("[ FIM ]");
    }
}