
import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    public static void main(String[] arg) throws SocketException, IOException {
        DatagramSocket server = new DatagramSocket(8989);
        System.out.println("Server đang chạy đợi chút");
        while (true) {
            byte nhanabso[] = new byte[256];
            DatagramPacket nhanab = new DatagramPacket(nhanabso, nhanabso.length);
            server.receive(nhanab);
            String ab = new String(nhanab.getData(), 0, nhanab.getLength()).trim();
            String[] acatb = ab.split(" ");
            int a = Integer.parseInt(acatb[0]);
            int b = Integer.parseInt(acatb[1]);
            int tong = a + b;
            byte guitong[] = new byte[256];
            guitong = String.valueOf(tong).getBytes();
            InetAddress ip = nhanab.getAddress();
            int port = nhanab.getPort();
            DatagramPacket guitong1 = new DatagramPacket(guitong, guitong.length, ip, port);
            server.send(guitong1);
        }
    }
}
