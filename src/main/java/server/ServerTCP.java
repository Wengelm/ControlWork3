package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ServerTCP {



    public static void main(String[] args) throws IOException {
        int countClients = 0;
        ServerSocket sock = null;
        InputStream is = null;
        OutputStream os = null;

        try {
          sock = new ServerSocket(123);
          while (true) {
              Socket client = sock.accept();
              countClients++;
              System.out.println("Client " + countClients + " connected");
              is = client.getInputStream();
              os = client.getOutputStream();


              boolean flag = true;

              while (flag) {
                  byte[] bytes = new byte[1024];
                  is.read(bytes);
                  String str = new String(bytes, "UTF-8");
                  String result = sortChars(str);
                  bytes = new byte[1024];
                  bytes = result.getBytes();
                  os.write(bytes);

              }
          }
        }
        catch (Exception e) {

            System.out.println("Error " + e.toString()); }
        finally {
            is.close();
            os.close();
            sock.close();
            System.out.println("Client " + countClients + " disconnected");


        }
    }


    private static String sortChars(String s) {
        return Arrays.stream(s.split("")).sorted().collect(Collectors.joining());
    }
}
