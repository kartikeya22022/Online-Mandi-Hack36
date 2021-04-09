package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    public static void main(String[] args) {
        UserTable.getInstance().open();
        ServerSocket serverSocket;
        Socket socket;
        ArrayList<String> currentlyActiveUser = new ArrayList<>();
        ArrayList <HandleClientRequest> clientHandlers= new ArrayList<>();
        try {
            serverSocket=new ServerSocket(6963);
            System.out.println("Server started");
        }
        catch (IOException e) {
            e.printStackTrace();
            return;
        }
        while(true) {
            try {
                socket=serverSocket.accept();
                System.out.println("Client Connected");

                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                String phoneNumber = ois.readObject().toString();
                String password = ois.readObject().toString();

                //Authentication now
                FullNameProfilePic fnpc = UserTable.getInstance().authentication(password,phoneNumber);
                oos.writeObject(fnpc.getFullName());

                if(fnpc != null) {
                    currentlyActiveUser.add(phoneNumber);
                    HandleClientRequest clientHandler = new HandleClientRequest(fnpc.getFullName(),fnpc.getImage(),phoneNumber,socket,ois,oos);
                    clientHandlers.add(clientHandler);
                    Thread t = new Thread(clientHandler);
                    t.start(); //starting new thread to handle client request
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                return;
            }
        }
    }
}
