/**
 * @author Tarcisio da Rocha (Prof. DCOMP/UFS)
 */
package br.ufs.dcomp.ExemploTcpJava;

import java.net.*;
import java.io.*;
import java.util.Scanner;
public class TCPClient{
    public static void main(String[] args){
        try {
            System.out.print("[ Conectando com o Servidor TCP    ..................  ");
            Socket sock = new Socket("127.0.0.1", 3300);
            System.out.println("[OK] ]");
            
            InputStream is = sock.getInputStream(); // Canal de entrada de dados
            OutputStream os = sock.getOutputStream(); // Canal de saída de dados
            byte[] buf = new byte[100]; // buffer de recepção
            Scanner se = new Scanner(System.in);
            
            while(true){
                System.out.print("Cliente: ");
                String msg = se.nextLine();
                byte[] bufResposta = msg.getBytes();
                os.write(bufResposta);
                
                int t = is.read(buf); // Operação bloqueante (aguardando chegada de dados)
                msg = new String(buf, 0, t); // Mapeando vetor de bytes recebido para String
                System.out.println("Servidor: " + msg);
            }
            
        }catch(Exception e){System.out.println(e);}    
        System.out.println("[ FIM ]");
    }
}