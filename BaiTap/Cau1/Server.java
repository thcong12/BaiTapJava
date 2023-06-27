package BaiTap.Cau1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server extends GetSendData {
    static int ServerPort = Constanst.PortServer;

    public static void main(String[] args) throws SocketException, IOException {
        DatagramSocket Server = new DatagramSocket(ServerPort);
        System.out.println("Server is running");
        while (true) {
            byte[] DataInput = new byte[256];
            DatagramPacket GetDataFromClient = GetData(DataInput, Server, ServerPort);
            String DataString = new String(GetDataFromClient.getData(), 0, GetDataFromClient.getLength()).trim();
            byte[] Data = new byte[256];
            InetAddress ip = GetDataFromClient.getAddress();
            DatagramPacket SendDataToClient = new DatagramPacket(Data, Data, ip, Port);
            Server.send(SendDataToClient);
        }

    }
}
