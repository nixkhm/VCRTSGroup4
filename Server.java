import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import BackEnd.Entities.CloudController;

public class Server {

    private static final String CloudController = null;
    static ServerSocket serverSocket;
    static Socket socket;
    static DataInputStream inputStream;
    static DataOutputStream outputStream;

    public static void main(String[] args) {

        String messageIn = "";
        String messageOut = "";
        Scanner keyInput;

        try {

            System.out.println("This is the server of of VCRTS");
            System.out.println("wating for client to connect...");
            // creating the server
            ServerSocket serverSocket = null;
            Socket socket = null;

            try {
                serverSocket = new ServerSocket(8000);
            } catch (IOException e) {
                e.printStackTrace();
            }

            while (true) {
                try {
                    socket = serverSocket.accept();
                } catch (IOException e) {
                    System.out.println("I/O error: " + e);
                }

                inputStream = new DataInputStream(socket.getInputStream());
                outputStream = new DataOutputStream(socket.getOutputStream());

                // extract the message from client
                messageIn = inputStream.readUTF();
                // server prints the message received from client to console
                System.out.println("message received from client: " + "\"" + messageIn + "\"");
            }

        } catch (

        Exception e) {

            e.printStackTrace();
        }

        String infoToBeAdded = messageIn;
        Path file = FileSystems.getDefault().getPath("GUI/Transcripts/allPendingVehicleApps.txt");
        File allVehiclesTranscript = file.toFile();

        String str = "";
        try {
            str = readFile(allVehiclesTranscript, StandardCharsets.UTF_8);
        } catch (IOException e2) {
            e2.printStackTrace();
        }

        try {
            FileWriter regTranscript = new FileWriter(allVehiclesTranscript);
            regTranscript.write(str);
            regTranscript.write(infoToBeAdded + "\n");
            regTranscript.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public static String readFile(File file, Charset charset) throws IOException {
        return new String(Files.readAllBytes(file.toPath()), charset);
    }

    public class EchoThread extends Thread {
        protected Socket socket;

        public EchoThread(Socket clientSocket) {
            this.socket = clientSocket;
        }

        public void run() {
            InputStream inp = null;
            BufferedReader brinp = null;
            DataOutputStream out = null;
            try {
                inp = socket.getInputStream();
                brinp = new BufferedReader(new InputStreamReader(inp));
                out = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                return;
            }
            String line;
            while (true) {
                try {
                    line = brinp.readLine();
                    if ((line == null) || line.equalsIgnoreCase("QUIT")) {
                        socket.close();
                        return;
                    } else {
                        out.writeBytes(line + "\n\r");
                        out.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }
}
