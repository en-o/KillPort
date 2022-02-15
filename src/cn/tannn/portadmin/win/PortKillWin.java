package cn.tannn.portadmin.win;

import cn.tannn.portadmin.dialog.KillPortDialog;
import cn.tannn.portadmin.entity.DataCenter;
import cn.tannn.portadmin.entity.PortEntity;
import cn.tannn.portadmin.util.CmdUtil;
import cn.tannn.portadmin.util.PortUtil;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.MessageDialogBuilder;
import com.intellij.openapi.wm.ToolWindow;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;

/**
 * @author tn
 * @date 2022-01-13 09:25
 */
public class PortKillWin {
    private JPanel contentPanel;
    private JTextField tfPort;
    private JTable tbContent;
    private JButton btnSearch;


    /**
     * 初始化参数
     */
    public void init(){
        tbContent.setModel(DataCenter.TABLE_MODEL);
        tbContent.setEnabled(true);
    }

    public PortKillWin(Project project, ToolWindow toolWindow) {
        // 初始化
        init();

        /**
         * 输入框回车搜索
         */
        tfPort.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                //按回车键执行相应操作;
                if(keyEvent.getKeyCode()==KeyEvent.VK_ENTER){

                    btnSearch.doClick();
                }
            }
        });

        /**
         * 搜索按钮点击事件
         */
        btnSearch.addActionListener(e -> {
            // 清空数据
            DataCenter.reset();
            // 获取输入的端口
            String portText = tfPort.getText().trim();
            if(Boolean.TRUE.equals(PortUtil.verifyPort(portText))){
                return;
            }
            // 处理两边空格
            portText = portText.trim();
            List<PortEntity> portEntity = CmdUtil.getPortEntity(portText);
            if(portEntity.isEmpty()){
                MessageDialogBuilder.yesNo("操作结果", portText+"端口无进程占用").show();
            }
            DataCenter.NOTE_LIST.addAll(portEntity);
            // 给自定的win传内容
            portEntity.forEach(it -> {
                DataCenter.TABLE_MODEL.addRow(it.getRow());
            });
        });
        /**
         *  右击 kill
         */
        tbContent.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                // InputEvent.META_MASK (左)
                if (evt.getModifiers()== InputEvent.META_MASK){
                    int selectedRow = tbContent.getSelectedRow();
                    // 没选择不操作
                    if(selectedRow >= 0 ){
                        DataCenter.KILL_PID  = tbContent.getValueAt(selectedRow, 0).toString();
                        DataCenter.KILL_IMAGE = tbContent.getValueAt(selectedRow, 1).toString();
                        KillPortDialog addNoteDialog = new KillPortDialog();
                        addNoteDialog.show();
                    }
                }
            }
        });
    }





    public JPanel getContentPanel() {
        return contentPanel;
    }
}
