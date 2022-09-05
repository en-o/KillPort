package cn.tannn.portadmin.noitf;

import com.intellij.notification.NotificationGroup;
import com.intellij.notification.NotificationGroupManager;
import com.intellij.notification.impl.NotificationGroupEP;
import com.intellij.openapi.project.Project;
import groovyjarjarantlr4.v4.runtime.misc.Nullable;

/**
 * 消息通知
 *
 * @author tn
 */
public class PluginNotify {


    public static void notification(@Nullable Project project,
                                    NotifyEntity notify) {

        /**
         * 弹出通知
         * 1. id
         * 2. 弹出的消息样式： BALLOON 气泡
         * 3. 事件记录 (右下角中的event log 中是否记录)
         */
        NotificationGroupManager.getInstance()
                /* id  */
                .getNotificationGroup(notify.getPluginId())
                /*  消息 + 消息的类型 */
                .createNotification(notify.getMessages(), notify.getNotificationType())
                /* 显示 */
                .notify(project);
    }
}
