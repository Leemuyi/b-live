package cn.com.mooyea.blive.windows;

import cn.com.mooyea.blive.listenter.BilibiliListener;
import cn.com.mooyea.blive.system.InstallPython;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
    private JButton stop;
    private JButton start;
    private JButton wordCloud;
    private JButton statistics;
    private JTextField biliJct;
    private JTextField sessData;
    private JTextField userId;
    private JTextField buvId3;
    private JTextField welCome;
    private JTextField roomId;
    private JLabel title;
    public JTextArea logger;
    private JButton systemCheck;


    public BilibiliLiveMonitorWindow() {
        stop.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        start.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (start.isEnabled()) {
                    logger.setText("start被点啦");
                }
                super.mouseClicked(e);
            }
        });
        wordCloud.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        statistics.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        systemCheck.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (systemCheck.isEnabled()) {
                    BilibiliListener.systemCheck(stop,start,wordCloud,statistics,systemCheck,logger,e);
                }
            }
        });
    }

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
        JFrame jFrame = new JFrame("Bilibili 直播监控");
        jFrame.setVisible(true);
        jFrame.setBackground(Color.BLUE);
        jFrame.setBounds(377, 377, 800, 300);
        jFrame.add(this.panel1);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        BilibiliLiveMonitorWindow.getInstance().initUi();
    }

}
