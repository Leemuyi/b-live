package cn.com.mooyea.blive.socket;

import cn.hutool.json.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.enums.ReadyState;
import org.java_websocket.handshake.ServerHandshake;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.socket.WebSocketHandler;


import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * <h1>SocketClient<h1>
 * <p>Copyright (C), 星期五,02,6月,2023</p>
 * <br/>
 * <hr>
 * <h3>File Info:</h3>
 * <p>FileName: SocketClient</p>
 * <p>Author:   mooye</p>
 * <p>Work_Email： lidy@skyvis.com.cn</p>
 * <p>E-mail： mooyeali@yeah.net</p>
 * <p>Date:     2023/6/2</p>
 * <p>Description: websocket client</p>
 * <hr>
 * <h3>History:</h3>
 * <hr>
 * <table>
 *  <thead>
 *  <tr><td style='width:100px;' center>Author</td><td style='width:200px;' center>Time</td><td style='width:100px;' center>Version_Number</td><td style='width:100px;' center>Description</td></tr>
 *  </thead>
 *  <tbody>
 *    <tr><td style='width:100px;' center>mooye</td><td style='width:200px;' center>11:32 2023/6/2</td><td style='width:100px;' center>v_1.0.0</td><td style='width:100px;' center>创建</td></tr>
 *  </tbody>
 * </table>
 * <hr>
 * <br/>
 *
 * @author mooye
 */

@Slf4j
public class SocketClient extends WebSocketClient {

    public SocketClient(URI serverUri, Map<String,String> header) {
        super(serverUri,header);
    }


    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.putOpt("uid", 670598709);
        jsonObject.putOpt("roomid", 27794218);
        jsonObject.putOpt("protover", 3);
        jsonObject.putOpt("buvid", "49B7DD2E-8DD3-1A23-9A10-D45D4817F8DA43144infoc");
        jsonObject.putOpt("platform", "web");
        jsonObject.putOpt("type", 2);
        jsonObject.putOpt("key", "XE0y_fVgkE-KAFKwqj70cRDHVZcy_eYb9VbfIDsMbI3hUVyWnG8Dj2frZ_np7Py2BWQMcFC1PyThAQ6lVcgtg2gOfvSd44rIN_VPX_u269vnk7GjQSiOYc7U9TLWiarBnQsu5UQm6Zzz_J4zZwBUBJkwIA==");
        this.send(jsonObject.toString());
        log.info("onOpen- status:{}\nHttpStatusMessage:{}", serverHandshake.getHttpStatus(),serverHandshake.getHttpStatusMessage());
    }

    @Override
    public void onMessage(String s) {
        log.info("onMessage:{}", s);
    }

    @Override
    public void onClose(int i, String s, boolean b) {
        log.info("onClose:{}", s);
    }

    @Override
    public void onError(Exception e) {
        log.info("onError:{}", e.getMessage());
    }

    public static void main(String[] args) {
        Map<String,String> jsonObject = new HashMap<>();
        jsonObject.put("uid", 670598709+"");
        jsonObject.put("roomid", 27794218+"");
        jsonObject.put("protover", 3+"");
        jsonObject.put("buvid", "49B7DD2E-8DD3-1A23-9A10-D45D4817F8DA43144infoc");
        jsonObject.put("platform", "web");
        jsonObject.put("type", 2+"");
        jsonObject.put("key", "XE0y_fVgkE-KAFKwqj70cRDHVZcy_eYb9VbfIDsMbI3hUVyWnG8Dj2frZ_np7Py2BWQMcFC1PyThAQ6lVcgtg2gOfvSd44rIN_VPX_u269vnk7GjQSiOYc7U9TLWiarBnQsu5UQm6Zzz_J4zZwBUBJkwIA==");
//        SocketClient socketClient = new SocketClient(URI.create("wss://tx-gz-live-comet-05.chat.bilibili.com/sub"));
        SocketClient socketClient = new SocketClient(URI.create("wss://broadcastlv.chat.bilibili.com:2245/sub"),jsonObject);
        socketClient.connect();
        log.info("ReadyState:{}",socketClient.getReadyState());
    }
}
