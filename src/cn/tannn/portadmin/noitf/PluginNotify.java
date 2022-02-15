package cn.tannn.portadmin.noitf;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationGroup;
import com.intellij.notification.Notifications;

/**
 * 消息通知
 * @author tn
 */
public class PluginNotify {


    public  static  void notification(NotifyEntity notify) {
        /**
         * 弹出通知
         * 1. id
         * 2. 弹出的消息样式： BALLOON 气泡
         * 3. 事件记录 (右下角中的event log 中是否记录)
         */
        NotificationGroup notificationGroup = new NotificationGroup(notify.getPluginId(), notify.getNotificationDisplayType(), notify.isLogBuDefault());
        /*  消息 + 消息的类型 */
        Notification notification = notificationGroup.createNotification(notify.getMessages(), notify.getMessageType());
        /* 显示 */
        Notifications.Bus.notify(notification);
    }
}
