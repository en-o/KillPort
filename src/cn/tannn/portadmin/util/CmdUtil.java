package cn.tannn.portadmin.util;

import cn.tannn.portadmin.entity.NetStatEntity;
import cn.tannn.portadmin.entity.PortEntity;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * cmd
 *
 * @author tn
 * @date 2022-01-13 13:00
 */
public class CmdUtil {

    public static String  netStat = " netstat -aon|findstr  %s ";
//    public static String  qprocess = " qprocess %s "; // 有些环境不能用
    public static String findPidName = " tasklist /fi \"pid eq %s\" ";
    public static String  taskKill = " taskkill /f /t /pid  %s ";
    public static String  jpsl = " jps -l ";

    public static List<NetStatEntity> getNetStat(String port ){
        List<NetStatEntity> results = new ArrayList<>();
        Set<String> inputStr = CommandUtil.commandRunStr("cmd",
                "/c",
                String.format(netStat, port));

        inputStr.forEach(it -> {
            String[] split = StringUtils.split(it, " ");
            NetStatEntity netStatEntity = new NetStatEntity();
            netStatEntity.setProtocol(split[0]);
            netStatEntity.setLocalAddress(split[1]);
            netStatEntity.setForeignAddress(split[2]);

            if(split.length==5){
                netStatEntity.setStatus(split[3]);
                netStatEntity.setPid(split[4]);
            }else {
                netStatEntity.setStatus("");
                netStatEntity.setPid(split[3]);
            }
            if(!results.contains(netStatEntity) && !netStatEntity.getPid().equals("0")){
                results.add(netStatEntity);
            }
        });
        return results;
    }

    /**
     * 获取 进程的名字
     * @param pid  pid
     * @return iamge
     */
    public static String getPidName(String pid){
        try {
            Set<String> inputStr = CommandUtil.commandRunStr("cmd",
                    "/c",
                    String.format(findPidName, pid));
            assert inputStr != null;
            List<String> asList = new ArrayList<>(inputStr);
            String pid_name =  StringUtils.split(asList.get(3), " ")[0];
            if("java.exe".equalsIgnoreCase(pid_name)){
                return getJpsName(pid);
            }
            return pid_name;
        }catch (Exception e){
            e.printStackTrace();
        }
        return "进程名未知";
    }

    /**
     * jps -l  (java命令)
     * @return
     */
    public static List<String> jspl(){
        Set<String> inputStr = CommandUtil.commandRunStr("cmd",
                "/c",
                jpsl);
        return new ArrayList<>(inputStr);
    }


    /**
     * jps -l  (java命令)
     * @param pid  pid)
     * @return  java进程名
     */
    public static String getJpsName(String pid){
        List<String> jspl = jspl();
        for (int i = 0; i < jspl.size(); i++) {
            String[] javas = StringUtils.split(jspl.get(i), " ");
            if(javas[0].equals(pid)){
                String imag = javas[1];
                return imag;
            }
        }
        return "进程名未知";
    }


    /**
     * 获取 进程的名字
     * @param port  port
     * @return iamge
     */
    public static List<PortEntity> getPortEntity(String port){
        List<PortEntity> results = new ArrayList<>();
        getNetStat(port).forEach(i -> {
            PortEntity portEntity = new PortEntity(i.getPid(),i.getProtocol(), getPidName(i.getPid()),i.getStatus());
            results.add(portEntity);
        });
        return results;
    }


    /**
     * 杀进程
     * @param pid
     * @return
     */
    public static String killPid(String pid){
        Set<String> inputStr = CommandUtil.commandRunStr(Charset.forName("GBK"),"cmd",
                "/c",
                String.format(taskKill, pid));
        assert inputStr != null;
        return Arrays.toString(inputStr.toArray());
    }

}
