package cn.com.mooyea.blive;

import cn.com.mooyea.blive.system.InstallPython;
import cn.com.mooyea.blive.windows.BilibiliLiveMonitorWindow;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.swing.*;

/**
 * @author mooye
 */
@SpringBootApplication
public class BLiveApplication {


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BilibiliLiveMonitorWindow window = BilibiliLiveMonitorWindow.getInstance();
            window.initUi();
        });
        SpringApplication.run(BLiveApplication.class, args);
    }

}
