package cn.com.mooyea.blive.windows;

import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.net.HttpCookie;
import java.util.*;

/**
 * <h1>BilibiliLiveMonitorWindow<h1>
 * <p>Copyright (C), 星期五,02,6月,2023</p>
 * <br/>
 * <hr>
 * <h3>File Info:</h3>
 * <p>FileName: BilibiliLiveMonitorWindow</p>
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
 *    <tr><td style='width:100px;' center>mooye</td><td style='width:200px;' center>09:21 2023/6/2</td><td style='width:100px;' center>v_</td><td style='width:100px;' center></td></tr>
 *  </tbody>
 * </table>
 * <hr>
 * <br/>
 *
 * @author mooye
 */

@Slf4j
public class BilibiliLiveMonitorWindow {
    public static BilibiliLiveMonitorWindow instance = null;
    private JPanel panel1;
    private JTextField cookie;
    private JTextField textField1;
    private JTextField textField2;

    public static BilibiliLiveMonitorWindow getInstance(){
        if (instance == null){
            instance = new BilibiliLiveMonitorWindow();
        }
        return instance;
    }

    /**
     * 初始化UI
     */
    public void initUi() {
    }

}
