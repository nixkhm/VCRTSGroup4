package BackEnd.Entities;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class JobServer {

    static ServerSocket serverSocket2;
    static Socket socket2;
    static DataInputStream inputStream2;
    static DataOutputStream outputStream2;

    public static void main(String[] args) {

        while (true) {

            String messageIn = "";

            CloudController cc = new CloudController();
            try {

                System.out.println("This is the server of of VCRTS");
                System.out.println("wating for client to connect...");

                try {
                    serverSocket2 = new ServerSocket(1000);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                while (true) {
                    try {
                        socket2 = serverSocket2.accept();
                    } catch (IOException e) {
                        System.out.println("I/O error: " + e);
                    }

                    inputStream2 = new DataInputStream(socket2.getInputStream());

                    messageIn = inputStream2.readUTF();

                    System.out.println(messageIn);

                    String infoToBeAdded = messageIn;
                    Path file = FileSystems.getDefault().getPath("GUI/Transcripts/allPendingJobApps.txt");
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
            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }

    public static String readFile(File file, Charset charset) throws IOException {
        return new String(Files.readAllBytes(file.toPath()), charset);
    }

}