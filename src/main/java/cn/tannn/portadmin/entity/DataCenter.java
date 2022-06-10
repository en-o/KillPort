package cn.tannn.portadmin.entity;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * 全局变量
 *
 * @author tn
 * @date 2022-01-12 10:08
 */
public class DataCenter {

    /**
     * 待杀的 PID
     */
    public static  String KILL_PID;
    /**
     * 待杀的 Image
     */
    public static String KILL_IMAGE;


    /**
     * win PID 数据
     */
    public static List<PortEntity> NOTE_LIST = new ArrayList<>();

    /**
     * 表头
     */
    public static String[] HEADER = {"PID","image","协议","状态"};

    /**
     * 数据模型
     *
     */
    public static DefaultTableModel TABLE_MODEL = new DefaultTableModel(null, HEADER);

    /**
     * 清空 NOTE_LIST，TABLE_MODEL内容
     */
    public static void reset(){
        TABLE_MODEL.setDataVector(null,HEADER);
    }

}
