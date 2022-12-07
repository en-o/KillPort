package cn.tannn.portadmin.win;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

/**
 * windows 串口布局
 *
 * @author tn
 * @date 2022-01-13 09:24
 */
public class PortAdminWinFactory implements ToolWindowFactory {

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        // 创建窗口对象
        PortKillWin portAdminWin = new PortKillWin(project, toolWindow);
        // 获取内容工厂的实例
        ContentFactory contentFactory = toolWindow.getContentManager().getFactory();
        // 获取用于toolwindow显示的内容
        Content content = contentFactory.createContent(portAdminWin.getContentPanel(), "", false);
        // 给 toolwindow设置内容
        toolWindow.getContentManager().addContent(content);


    }


}
