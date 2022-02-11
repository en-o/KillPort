package cn.tannn.portadmin.entity;

import java.util.Objects;

/**
 * netstat -aon 命令输出
 *
 * @author tn
 * @date 2022-01-13 13:32
 */
public class NetStatEntity {

    /**
     * pid
     */
    private String pid;

    /**
     * 协议
     */
    private String protocol;
    /**
     * 本地地址
     */
    private String localAddress;
    /**
     * 外部地址
     */
    private String foreignAddress;

    /**
     * 状态
     */
    private String status;

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

    public String getLocalAddress() {
        return localAddress;
    }

    public void setLocalAddress(String localAddress) {
        this.localAddress = localAddress;
    }

    public String getForeignAddress() {
        return foreignAddress;
    }

    public void setForeignAddress(String foreignAddress) {
        this.foreignAddress = foreignAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NetStatEntity)) {
            return false;
        }
        NetStatEntity that = (NetStatEntity) o;
        return Objects.equals(getPid(), that.getPid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPid(), getProtocol(), getLocalAddress(), getForeignAddress(), getStatus());
    }

    @Override
    public String toString() {
        return "NetStatEntity{" +
                "pid='" + pid + '\'' +
                ", protocol='" + protocol + '\'' +
                ", localAddress='" + localAddress + '\'' +
                ", foreignAddress='" + foreignAddress + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
