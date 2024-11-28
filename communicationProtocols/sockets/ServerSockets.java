import java.net.*;
import java.io.*;

class Position {
    public Position(String literal){
        this.literal = literal;
        this.jointLiteral = literal.substring(1, literal.length() - 1).split(",");
        jointArr = new Float[jointLiteral.length];
        for (int i = 0; i < jointLiteral.length; i++){
            jointArr[i] = Float.parseFloat(jointLiteral[i]);
        }
    }
    String literal;
    String[] jointLiteral;
    Float[] jointArr;
    public void modifyPose(Float plus){
        for (int i = 0; i < jointArr.length; i++){
            jointArr[i] += plus;
        }
    }

    //@Override
    public String toSting(){
        StringBuilder literal = new StringBuilder();
        literal.append("[");
        for (Float joint : jointArr){
            literal.append(Float.toString(joint)).append(" ,");
        }
        literal = new StringBuilder(literal.substring(0, literal.length() - 2));
        literal.append("]");
        return literal.toString();
    }
}

public class ServerSockets {
    // initialize socket and input stream
    private Socket socket = null;
    private ServerSocket server = null;
    private DataOutputStream outClient = null;
    private DataInputStream inClient = null;

    // Constructor with port
    public ServerSockets(int port) throws IOException {
        // Create server socket
        server = new ServerSocket(port);
        System.out.println("Server started");

        System.out.println("Waiting for a client ...");

        // Accept client connection
        socket = server.accept();
        System.out.println("Client accepted");

        // Output stream to client
        outClient = new DataOutputStream(socket.getOutputStream());

        // Send greeting message to client
        //outClient.writeUTF("Hi! I'm the server. Send \"Bye\" to close the connection.\n");

        // Input stream from client
        inClient = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

        String line = "";
        String readPosition = "";
       // Loop to receive messages from client
        while (!line.equals("vull dades")) {
            line = inClient.readLine();
            System.out.println("Client says: " + line);
            if(line.charAt(0) == '['){
                readPosition = line;
            }
        }
        Position pos = new Position(readPosition);
        pos.modifyPose(0.3f);

        System.out.println("Sent position: " + pos.toSting());
        for (Float joint : pos.jointArr){
            outClient.writeUTF(joint.toString());
        }
        System.out.println("Closing connection");

        // Close the streams and socket
        inClient.close();
        outClient.close();
        socket.close();
    }

    public static void main(String[] args) throws IOException {
        ServerSockets server = new ServerSockets(30001); // Create server on port 30001
    }
}
