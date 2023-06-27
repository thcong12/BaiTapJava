package BaiTap.Cau1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class GetSendData {
    public static DatagramPacket SendData(byte[] data, DatagramSocket socket, int Port, InetAddress ip)
            throws IOException {
        byte guitong[] = new byte[256];
        guitong = String.valueOf(tong).getBytes();
        InetAddress LocalHost = InetAddress.getByName("localhost");
        DatagramPacket SendData = new DatagramPacket(data, data.length, (ip != null) ? ip : LocalHost, Port);
        socket.send(SendData);
        return SendData;
    }

    public static DatagramPacket GetData(byte[] data, DatagramSocket socket, int Port) throws IOException {
        DatagramPacket GetData = new DatagramPacket(data, data.length);
        socket.receive(GetData);
        return GetData;
    }
}
