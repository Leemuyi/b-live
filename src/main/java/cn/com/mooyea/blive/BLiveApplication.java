package cn.com.mooyea.blive;

import cn.com.mooyea.blive.windows.BilibiliLiveMonitorWindow;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author mooye
 */
@SpringBootApplication
public class BLiveApplication {

    public BLiveApplication() {
        BilibiliLiveMonitorWindow.getInstance().initUi();
    }
    public static void main(String[] args) {
        SpringApplication.run(BLiveApplication.class, args);
    }

}
