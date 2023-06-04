package cn.com.mooyea.blive.system;

import cn.hutool.core.io.StreamProgress;
import cn.hutool.core.lang.Console;
import cn.hutool.http.HttpUtil;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.io.*;


@Slf4j
public class InstallPython {

    public static final String PYTHON_VERSION = "python --version";
    public static final String VERSION = "Python 3";
    public static final String PYTHON_DOWNLOAD_URL = "https://www.python.org/ftp/python/3.8.3/python-3.8.3.exe";
    public static final String PYTHON_LOCAL_PATH = "D:\\PythonTest\\Python-3.8.3.exe";
    public static final String INSTALL_BILIBILI_API = "pip3 install bilibili-api-python";
    final static Runtime runtime = Runtime.getRuntime();

    /**
     * 检验环境
     * @return 是|否
     */
    public static boolean checkEnv(){
        boolean flag = false;
        String execStr = null;
        try {
            Process process = runtime.exec(PYTHON_VERSION);
            InputStream fis=process.getInputStream();
            //用一个读输出流类去读
            InputStreamReader isr=new InputStreamReader(fis);
            //用缓冲器读行
            BufferedReader br=new BufferedReader(isr);
            String line=null;
            //直到读完为止
            while((line=br.readLine())!=null) {
                execStr = line;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (execStr != null && execStr.contains(VERSION)){
            flag = true;
        }
        return flag;
    }

    public static boolean installPython(String url, String outputDir){
        boolean flag = false;
        HttpUtil.downloadFile(url, new File(outputDir),new StreamProgress(){
            @Override
            public void start() {
                Console.log("开始下载。。。。");
            }
            @Override
            public void progress(long l, long l1) {
                String person = Math.floor((l1*1.0/l)*100)+"%";
                progress(person);
            }
            public void progress(String person) {
                Console.log("已下载：{}", person);
            }
            @Override
            public void finish() {
                Console.log("下载完成！");
            }
        });
        try {
            log.info("开始执行休眠,等待系统释放资源");
            Thread.sleep(5000);
            log.info("结束休眠..");
            Process process = runtime.exec(PYTHON_LOCAL_PATH);
            InputStream in = process.getInputStream();
            InputStreamReader isr=new InputStreamReader(in);
            //用缓冲器读行
            BufferedReader br=new BufferedReader(isr);
            String line=null;
            //直到读完为止
            while((line=br.readLine())!=null) {
                log.info(line);
            }
            flag= true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return flag;
    }

    public static boolean installBilibiliApi(){
        try {
            Process process = runtime.exec(INSTALL_BILIBILI_API);
            InputStream fis=process.getInputStream();
            //用一个读输出流类去读
            InputStreamReader isr=new InputStreamReader(fis);
            //用缓冲器读行
            BufferedReader br=new BufferedReader(isr);
            String execStr = null;
            String line;
            //直到读完为止
            while((line=br.readLine())!=null) {
                execStr = line;
            }
            log.info(execStr);
            if (execStr!=null && (execStr.contains("Successfully installed") || execStr.contains("Requirement already satisfied"))){
                return true;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }



    public static void main(String[] args) {
        System.out.println(checkEnv());
        JTextArea logger = new JTextArea();
        installPython(PYTHON_DOWNLOAD_URL,PYTHON_LOCAL_PATH);
//        log.info("安装结果：{}",installBilibiliApi());
    }

}