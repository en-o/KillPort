package cn.tannn.portadmin.util;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.MessageDialogBuilder;
import org.codehaus.groovy.control.messages.WarningMessage;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

/**
 * @author tn
 * @date 2022-01-13 11:05
 */
public class PortUtil {


    /**
     * 验证端口是否正确
     * @return  true 不合规
     */
    public static Boolean verifyPort(String portStr, @NotNull Project project){
        Boolean ok = false;
        if("".equals(portStr)|| Objects.isNull(portStr)){
            MessageDialogBuilder.yesNo("操作结果", "要输入值才能使用哦").ask(project);
            ok = true;
        }
        if(!isNumber(portStr)){
            MessageDialogBuilder.yesNo("操作结果", "端口是数字哦").ask(project);
            ok = true;
        }else {
            try {
               Integer port = Integer.valueOf(portStr);
                // 0-65535
                Integer maxPort = 65535;
                Integer minPort = 0;
                // 大于 return 1
                if(port.compareTo(maxPort) > 0 || port.compareTo(minPort) < 0){
                    MessageDialogBuilder.yesNo("操作结果", "端口范围是0-65535哦").ask(project);
                    ok = true;
                }
           }catch (Exception e){
               MessageDialogBuilder.yesNo("操作结果", "你在干什么，都溢出了！").ask(project);
           }
        }
        return ok;

    }


    /**
     * 验证数字
     * @param str
     * @return
     */
    public static boolean isNumber(String str) {
        Pattern pattern = compile("-?[0-9]+.?[0-9]+");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

}
