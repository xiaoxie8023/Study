package demo1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-17
 * Time: 10:19
 */
import java.io.*;
import java.net.*;
public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("localhost", 6789);
        PrintWriter outToServer = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String sentenceToSend;
        sentenceToSend = "Hello from Client.";
        outToServer.println(sentenceToSend);
        String modifiedSentence;
        modifiedSentence = inFromServer.readLine();
        System.out.println("FROM SERVER:" + modifiedSentence);
        inFromServer.close();
        outToServer.close();
        clientSocket.close();
    }
}