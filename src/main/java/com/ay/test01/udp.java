package com.ay.test01;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author ay
 * @create 2020-03-10 17:42
 */
public class udp {

    public static void receiver() throws IOException {
        DatagramSocket socket = new DatagramSocket(9090);

        byte[] buffer = new byte[100];
        DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);

        socket.receive(packet);

        System.out.println(new String(packet.getData(),0,packet.getLength()));

        socket.close();
    }

    public static void main(String[] args) {
        System.out.println("begin");
        try {
            receiver();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
