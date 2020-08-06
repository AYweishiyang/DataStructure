package com.ay.mqtt;

import org.fusesource.mqtt.client.*;

/**
 * @author ay
 * @create 2020-07-28 23:32
 */
public class ESP8266 {
    /**
     * MQTT 的 IP 地址
     */
    public static final String  MQTT_SERVER_URL="39.96.33.151";

    public static void main(String[] args) throws Exception {
        MQTT mqtt = new MQTT();
        mqtt.setHost(MQTT_SERVER_URL, 1883);
        BlockingConnection connection = mqtt.blockingConnection();
        connection.connect();
        Topic[] topics = {new Topic("outTopic", QoS.AT_LEAST_ONCE)};
        byte[] qoses = connection.subscribe(topics);
        Message message = connection.receive();
        System.out.println(message.getTopic());
        byte[] payload = message.getPayload();
        System.out.println("打印接收到的消息："+new String(payload));
        message.ack();
        connection.disconnect();
    }
}

