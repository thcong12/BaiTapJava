package BaiTap.Cau1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    static int PortClienet = 4000, PortServer = 8888;

    public static void SendDataToServer(byte[] data, DatagramSocket socket) throws IOException {
        InetAddress LocalHost = InetAddress.getByName("localhost");
        DatagramPacket SendDataToServer = new DatagramPacket(data, data.length, LocalHost, PortServer);
        socket.send(SendDataToServer);
    }

    public static void GetDataFromServer(byte[] data, DatagramSocket socket) throws IOException {
        InetAddress LocalHost = InetAddress.getByName("localhost");
        DatagramPacket SendDataToServer = new DatagramPacket(data, data.length, LocalHost, PortServer);
        socket.send(SendDataToServer);
    }

    public static void main(String[] args) throws IOException {
        DatagramSocket Client = new DatagramSocket(PortClienet);
        Scanner InputData = new Scanner(System.in);
        int a = 0;
        boolean checkA = false;
        while (!checkA) {
            try {
                System.out.println("Please Input Your Integer");
                a = InputData.nextInt();
                checkA = true;
            } catch (Exception err) {
                InputData.nextLine();
            }
        }
        byte[] IntergerString = Integer.toString(a).getBytes();
        GetDataFromServer(IntergerString, Client);

        byte[] IntergerStringFromServer = new byte[256];
        // DatagramPacket GetDataFromServer = new
        // DatagramPacket(IntergerStringFromServer,
        // IntergerStringFromServer.length);
        // Client.receive(GetDataFromServer);
        String OutPut = new String(GetDataFromServer.getData(), 0, GetDataFromServer.getLength());
        System.out.println("Tong cac so la: " + OutPut);
    }
}
