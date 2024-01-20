package cn.tannn.portadmin.noitf;

import com.intellij.notification.NotificationType;

/**
 * 消息通知
 * (BALLOON)
 * @author tn
 * @date 2022-01-12 14:23
 */

public class NotifyEntity {

    /**
     * id
     */
    private String pluginId;

    /**
     * 消息
     */
    private String messages;


    /**
     * <a href="https://jetbrains.design/intellij/controls/notifications/">通知类型</a>
     *
     */
    private NotificationType notificationType;


    public static NotifyEntity success(String pluginId, String messages) {
        NotifyEntity notif = new NotifyEntity();
        notif.setPluginId(pluginId);
        notif.setMessages(messages);
        notif.setNotificationType(NotificationType.INFORMATION);
        return  notif;
    }


    public String getPluginId() {
        return pluginId;
    }

    public void setPluginId(String pluginId) {
        this.pluginId = pluginId;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }
}
