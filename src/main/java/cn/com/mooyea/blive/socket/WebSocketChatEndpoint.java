package cn.com.mooyea.blive.socket;

/**
 * <h1>SocketTest<h1>
 * <p>Copyright (C), 星期五,02,6月,2023</p>
 * <br/>
 * <hr>
 * <h3>File Info:</h3>
 * <p>FileName: SocketTest</p>
 * <p>Author:   mooye</p>
 * <p>Work_Email： lidy@skyvis.com.cn</p>
 * <p>E-mail： mooyeali@yeah.net</p>
 * <p>Date:     2023/6/2</p>
 * <p>Description: </p>
 * <hr>
 * <h3>History:</h3>
 * <hr>
 * <table>
 *  <thead>
 *  <tr><td style='width:100px;' center>Author</td><td style='width:200px;' center>Time</td><td style='width:100px;' center>Version_Number</td><td style='width:100px;' center>Description</td></tr>
 *  </thead>
 *  <tbody>
 *    <tr><td style='width:100px;' center>mooye</td><td style='width:200px;' center>16:42 2023/6/2</td><td style='width:100px;' center>v_</td><td style='width:100px;' center></td></tr>
 *  </tbody>
 * </table>
 * <hr>
 * <br/>
 *
 * @author mooye
 */


import cn.hutool.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/chat")
public class WebSocketChatEndpoint extends Endpoint {

    private Session session;

    public static void main(String[] args) {
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        try {
            String uri = "wss://broadcastlv.chat.bilibili.com:2245/sub";
            JSONObject jsonObject = new JSONObject();
            jsonObject.putOpt("uid", 670598709);
            jsonObject.putOpt("roomid", 27794218);
            jsonObject.putOpt("protover", 3);
            jsonObject.putOpt("buvid", "49B7DD2E-8DD3-1A23-9A10-D45D4817F8DA43144infoc");
            jsonObject.putOpt("platform", "web");
            jsonObject.putOpt("type", 2);
            jsonObject.putOpt("key", "XE0y_fVgkE-KAFKwqj70cRDHVZcy_eYb9VbfIDsMbI3hUVyWnG8Dj2frZ_np7Py2BWQMcFC1PyThAQ6lVcgtg2gOfvSd44rIN_VPX_u269vnk7GjQSiOYc7U9TLWiarBnQsu5UQm6Zzz_J4zZwBUBJkwIA==");
            WebSocketChatEndpoint endpoint = new WebSocketChatEndpoint();
            endpoint.start(container, new URI(uri), jsonObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException | DeploymentException e) {
            throw new RuntimeException(e);
        }
    }

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Connected to endpoint: " + session.getBasicRemote());
        this.session = session;
    }

    @OnMessage
    public void onMessage(String message) {
        System.out.println("Received message: " + message);
    }

    @OnClose
    public void onClose(CloseReason reason) {
        System.out.println("Disconnected from endpoint: " + session.getBasicRemote());
    }

    public void start(WebSocketContainer container, URI uri, String authMessage) throws IOException, DeploymentException {
        Session response = container.connectToServer(authMessage, uri);
        if (response != null) {
            System.out.println("Authentication successful");
            session.addMessageHandler(new MessageHandler.Whole<String>() {
                @Override
                public void onMessage(String message) {
                    System.out.println("Received message: " + message);
                }
            });
        } else {
            System.out.println("Authentication failed");
        }
    }

    @Override
    public void onOpen(Session session, EndpointConfig endpointConfig) {

    }
}

