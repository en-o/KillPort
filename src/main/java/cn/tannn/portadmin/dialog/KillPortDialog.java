package cn.tannn.portadmin.dialog;

import cn.tannn.portadmin.entity.DataCenter;
import cn.tannn.portadmin.noitf.NotifyEntity;
import cn.tannn.portadmin.noitf.PluginNotify;
import cn.tannn.portadmin.util.CmdUtil;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.ui.EditorTextField;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

/**
 * 对话框 kill
 *
 * @author tn
 * @date 2022-01-12 09:34
 */
public class KillPortDialog extends DialogWrapper {

    /**
     * 标题
     */
    EditorTextField tfPID;


    public KillPortDialog() {
        super(true);
        setTitle("kill 吗 ?");
        init();
    }

    /**
     * 主体面板
     */
    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        // 创建面板
        JPanel jPanel = new JPanel(new BorderLayout());
        JLabel imageLabel = new JLabel(DataCenter.KILL_IMAGE);
        jPanel.add(imageLabel,BorderLayout.NORTH);

        tfPID = new EditorTextField(DataCenter.KILL_PID);
        JLabel pidLabel = new JLabel("PID:");
        jPanel.add(pidLabel,BorderLayout.WEST);
        jPanel.add(tfPID,BorderLayout.CENTER);
        return jPanel;
    }

    /**
     * 添加的按钮
     * （createSouthPanel 下边的）
     */
    @Override
    protected JComponent createSouthPanel() {
        // 新建面板  (输入框，按钮等
        JPanel jPanel = new JPanel();
        // 按钮内容
        JButton jButton = new JButton("kill");
        // 设置点击事件
        jButton.addActionListener( e -> {
            // 获取编辑编辑框的内容
            String pidText = tfPID.getText();
            String killMessage = CmdUtil.killPid(pidText);
            PluginNotify.notification(
                     NotifyEntity.success("winkillport_id",
                             "kill "+pidText +"====>"+killMessage));
            // 关闭消息框
            KillPortDialog.this.dispose();
        });
        // 将按钮添加到面板中
        jPanel.add(jButton);
        return jPanel;
    }
}
