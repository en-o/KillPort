package cn.tannn.portadmin.noitf;

import com.intellij.notification.NotificationDisplayType;
import com.intellij.openapi.ui.MessageType;

/**
 * 消息通知
 *
 * @author tn
 * @date 2022-01-12 14:23
 */

public class NotifyEntity {

    private String pluginId;
    private String messages;
    private boolean logBuDefault;
    private NotificationDisplayType notificationDisplayType;
    private MessageType messageType;


    public static NotifyEntity success(String pluginId, String messages) {
        NotifyEntity notif = new NotifyEntity();
        notif.setPluginId(pluginId);
        notif.setMessages(messages);
        notif.setLogBuDefault(true);
        notif.setNotificationDisplayType(NotificationDisplayType.BALLOON);
        notif.setMessageType(MessageType.INFO);
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


    public void setLogBuDefault(boolean logBuDefault) {
        this.logBuDefault = logBuDefault;
    }

    public boolean isLogBuDefault() {
        return logBuDefault;
    }

    public NotificationDisplayType getNotificationDisplayType() {
        return notificationDisplayType;
    }

    public void setNotificationDisplayType(NotificationDisplayType notificationDisplayType) {
        this.notificationDisplayType = notificationDisplayType;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }
}
