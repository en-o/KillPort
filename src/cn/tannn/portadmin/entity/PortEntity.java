package cn.tannn.portadmin.entity;

/**
 * 端口
 *
 * @author tn
 * @date 2022-01-13 10:54
 */
public class PortEntity {

    /**
     * pid
     */
    private String pid;

    /**
     * 协议
     */
    private String protocol;

    /**
     * 进程名
     */
    private String iamge;

    /**
     * 状态
     */
    private String status;

    /**
     * 将数据转换成数组
     */
    public String[] getRow(){
//         {"PID","image","协议","状态"};
        String[] raw = new String[4];
        raw[0] = this.pid;
        raw[1] = this.iamge;
        raw[2] = this.protocol;
        raw[3] = this.status;
        return raw;
    }

    public PortEntity(String pid, String protocol, String iamge, String status) {
        this.pid = pid;
        this.protocol = protocol;
        this.iamge = iamge;
        this.status = status;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getIamge() {
        return iamge;
    }

    public void setIamge(String iamge) {
        this.iamge = iamge;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PortEntity{" +
                "pid='" + pid + '\'' +
                ", protocol='" + protocol + '\'' +
                ", iamge='" + iamge + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
