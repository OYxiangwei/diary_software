# diary_software
JAVA编写日记软件
1、设计GUI界面->面板JPanel->new IndexGUI()实例化frame->main->init->新建类对象调用构造函数->对登陆和注册事件进行私有方法封装
2、实体类User 设置get和set方法
3、新建UserInfo.xml 添加根标签（root）Users
4、在util文件夹建JDOM.java主要包含了两个方法，write() 和 read() 方法，分别用于将用户信息写入到 xml 文档中和读出用户信息,xml文档的路径->将xml文档封装成file->使用默认的sax解析器saxbuilder->声明document文档
5、在util文件夹建register.java验证都没有错误信息，则执行写入用户信息xml
6、建立Diary.java 类文件，实现写入日记文件和读取日记文件功能

