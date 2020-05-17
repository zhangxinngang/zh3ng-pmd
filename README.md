# zh3ng-pmd
一个基于alibaba p3c项目的代码规范项目的一个java代码规范检查工具,添加了原p3c中没有的规范检查功能


### build

命令行： 
mvn clean package

生成 zh3ng-pmd-{version}-jar-with-dependecies.jar


如何使用：

命令
java -cp zh3ng-pmd-{version}-jar-with-dependecies.jar 
-d {代码检查目录或文件，多个目录或文件用,分隔} 
-R {规则配置文件，source/rulesets/xxxxx.xml 例如 rulesets/ali-comment.xml,xxxx.xml}

