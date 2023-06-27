import java.io.*;
import java.net.*;
import java.util.*;

public class Client {

    public static void main(String[] args) throws IOException {
        DatagramSocket client = new DatagramSocket();

        // Giai đoạn 3: trao đổi dữ liệu
        // Giai đoạn 3.1: client nhập và tạo packet gửi đi
        Scanner sc = new Scanner(System.in);
        boolean checka = false;
        boolean checkb = false;
        int a = 0, b = 0;
        while (checka == false) {
            try {
                System.out.println("Nhập số a:");
                a = sc.nextInt();
                checka = true;
            } catch (Exception i) {
                sc.nextLine();
            }
        }
        while (checkb == false) {
            try {
                System.out.println("Nhập số b:");
                b = sc.nextInt();
                checkb = true;
            } catch (Exception i) {
                sc.nextLine();
            }
        }
        byte mangab[] = new byte[256];
        String ab = a + " " + b;
        mangab = ab.getBytes();

        // Send data
        InetAddress ip = InetAddress.getByName("localhost");
        int port = 8989;
        DatagramPacket guiab = new DatagramPacket(mangab, mangab.length, ip, port);
        client.send(guiab);
        // Receive Data
        byte nhantong[] = new byte[256];
        DatagramPacket nhansotong = new DatagramPacket(nhantong, nhantong.length);
        client.receive(nhansotong);
        String tongso = new String(nhansotong.getData(), 0, nhansotong.getLength());
        System.out.println("Tong cac so la: " + tongso);

    }
}