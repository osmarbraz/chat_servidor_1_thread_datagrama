
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Principal {

    public static void main(String args[]) {
        try {
            DatagramSocket con = new DatagramSocket(4444); //conexao(porta)
            while (true) {	//Configura o pacote
                byte dado[] = new byte[100];
                //Configura o pacote
                DatagramPacket pacote = new DatagramPacket(dado, dado.length);

                System.out.println("Inicio servidor");
                String mensagem = "";
                while (!mensagem.equals("fim")) {
                    //espera pacote
                    con.receive(pacote);
                    //processa o pacote
                    System.out.println("\n\nPacote recebido do Cliente :"
                            + "\n do Host: " + pacote.getAddress()
                            + "\n da Porta: " + pacote.getPort()
                            + "\n de Tamanho: " + pacote.getLength()
                            + "\n contendo: ");
                    //Recupera o texto recebido
                    mensagem = new String(pacote.getData(), 0, pacote.getLength());
                    //escreve mensagem
                    System.out.println("   " + mensagem);
                }
            }
        } catch (IOException io) {
            System.err.println("Problemas de IO");
        }
    }
}