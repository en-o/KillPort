package cn.tannn.portadmin.util;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

/**
 * 命令工具類
 *
 * @author tn
 * @version 1
 * @date 2021-11-23 14:52
 */
public class CommandUtil {



    /**
     * 运行 命令
     *
     * @param commands 命令
     * @return boolean
     */
    public static Set<String> commandRunStr(String... commands) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.redirectErrorStream(true);
            processBuilder.command(commands);
            Process start = processBuilder.start();
//            Set<String> result = commandResult(start.getInputStream(), StandardCharsets.UTF_8);
            Set<String> result = commandResult(start.getInputStream(), Charset.forName("GBK"));
            start.waitFor();
            start.destroy();
            return result;
        } catch (InterruptedException | IOException e) {
            if(e instanceof InterruptedException){
                Thread.currentThread().interrupt();
            }
            e.printStackTrace();
            return null;
        }
    }



    /**
     * 运行 命令
     *
     * @param commands 命令
     * @return boolean
     */
    public static Set<String> commandRunStr(Charset charsets, String... commands) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.redirectErrorStream(true);
            processBuilder.command(commands);
            Process start = processBuilder.start();
            Set<String> result = commandResult(start.getInputStream(), charsets);
            start.waitFor();
            start.destroy();
            return result;
        } catch (InterruptedException | IOException e) {
            if(e instanceof InterruptedException){
                Thread.currentThread().interrupt();
            }
            e.printStackTrace();
            return null;
        }
    }




    /**
     * 运行 命令
     *
     * @param commands 命令
     * @return boolean
     */
    public static Set<String> commandRunStr(File file, String... commands) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.redirectErrorStream(true);
            processBuilder.command(commands);
            processBuilder.directory(file);
            Process start = processBuilder.start();
            Set<String> result = commandResult(start.getInputStream(), StandardCharsets.UTF_8);
            start.waitFor();
            start.destroy();
            return result;
        } catch (InterruptedException | IOException e) {
            if(e instanceof InterruptedException){
                Thread.currentThread().interrupt();
            }
            e.printStackTrace();
            return null;
        }
    }









    /**
     * 输出 Process 返回的内容
     *    GBK
     * @param inputStream inputStream
     * @param charsets  StandardCharsets.UTF_8
     * @return message
     */
    public static Set<String> commandResult(InputStream inputStream, Charset charsets) throws IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(inputStream, charsets));

        String line;
        Set<String> hashSet = new HashSet<>();
        while((line = reader.readLine()) != null) {
            hashSet.add(line);
        }
        return hashSet;
    }





}
