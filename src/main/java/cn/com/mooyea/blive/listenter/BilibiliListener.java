package cn.com.mooyea.blive.listenter;

import cn.com.mooyea.blive.entity.ParameterEntity;
import cn.com.mooyea.blive.system.InstallPython;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

@Slf4j
public class BilibiliListener{
    private static ParameterEntity createEntity(JTextField biliJct, JTextField sessData, JTextField userId, JTextField buvId3,
                                         JTextField welCome, JTextField roomId){
        ParameterEntity entity = new ParameterEntity();
        entity.setSessData(sessData.getText());
        entity.setBiliJct(biliJct.getText());
        entity.setBuvId3(buvId3.getText());
        entity.setDedeUserId(userId.getText());
        entity.setRoomId(roomId.getText());
        entity.setWelcome(welCome.getText());
        return entity;
    }

    public static boolean start(JTextField biliJct, JTextField sessData, JTextField userId, JTextField buvId3,
                                JTextField welCome, JTextField roomId){
        ParameterEntity entity = createEntity(biliJct,sessData,userId,buvId3,welCome,roomId);
        return false;

    }

    public static boolean stop(JTextField biliJct, JTextField sessData, JTextField userId, JTextField buvId3,
                               JTextField welCome, JTextField roomId){
        ParameterEntity entity = createEntity(biliJct,sessData,userId,buvId3,welCome,roomId);
        return false;
    }

    public static String wordCloud(JTextField biliJct, JTextField sessData, JTextField userId, JTextField buvId3,
                                   JTextField welCome, JTextField roomId){
        ParameterEntity entity = createEntity(biliJct,sessData,userId,buvId3,welCome,roomId);
        return null;
    }

    public static String statistics(JTextField biliJct, JTextField sessData, JTextField userId, JTextField buvId3,
                                    JTextField welCome, JTextField roomId){
        ParameterEntity entity = createEntity(biliJct,sessData,userId,buvId3,welCome,roomId);
        return null;
    }


    public static void systemCheck(JButton stop, JButton start, JButton wordCloud, JButton statistics, JButton systemCheck, JTextArea logger, MouseEvent event){
        log.info("自检按钮被点击!");
        logger.append("正在进行系统自检,请稍后......");
        if (InstallPython.checkEnv()){
            logger.append("\n缺少Python环境，正在安装.....");
            if (InstallPython.installPython(InstallPython.PYTHON_DOWNLOAD_URL,InstallPython.PYTHON_LOCAL_PATH)) {
                logger.append("\nPython环境安装完成！");
            }else {
                logger.append("\nPython环境安装失败！系统将在3秒后退出!");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Component cmp = event.getComponent();
                while (!(cmp instanceof JFrame) || cmp.getParent() != null) {
                    cmp = cmp.getParent();
                }
                ((JFrame) cmp).dispose();
            }
        }
        logger.append("\n系统自检完成!已就绪.....");
        systemCheck.setEnabled(false);
        start.setEnabled(true);
        stop.setEnabled(true);
        statistics.setEnabled(true);
        wordCloud.setEnabled(true);
    }

}
