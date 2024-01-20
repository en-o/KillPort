# 官方文档
> 使用 IntelliJ IDEA 2023.3 或更高版本时，必须从 JetBrains Marketplace（插件主页）安装 Plugin DevKit 插件，因为它不再与 IDE 捆绑在一起。
https://plugins.jetbrains.com/docs/intellij/developing-plugins.html#gradle-intellij-plugin



# 运行
右侧工具栏gradle -> 运行配置 -> run plugin

# 部署/打包/发布
1. 打包：右侧工具栏gradle -> intellij -> buildPlugin
2. 打包后的插件就在\build\distributions目录下
3. 打开File -> Settings -> Plugins，选择齿轮按钮，选择Install Plugin from Disk
4. 发布: https://plugins.jetbrains.com/plugin/18615-killport -> Upload plugin提交插件
