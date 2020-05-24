# zh3ng-pmd
a program management document based alibaba p3c-pmd developed with custom rules


### install

maven package   ->  zh3ng-pmd-${version}-jar-with-dependecies.jar

```$xslt
$root    mvn clean package
```

run this command

```$xslt
java -cp ./target/zh3ng-pmd-${version}-jar-with-dependecies.jar
 com.zh3ng.club.pmd.custom.Main -d ${your path to check code} -R ${rulesets/zh3ng_loop_rule.xml ext...}
```

some params descriptions:

* -cp : the java run .jar. In this case it is zh3ng-pmd-${version}-jar-with-dependecies.jar & MainClass  in target path。
 
```
for example:
-cp ./target/zh3ng-pmd-1.0.SNAPSHOT-jar-with-dependecies.jar com.zh3ng.club.pmd.custom.Main
```

* -d  : the .java file to be check. It can be filename or path.

```$xslt
for example:
-d ./src/test/java/WhileLoopTest.java
```

* -R  : the checking rules. It is the *-rule.xml in resource/rulesets/* 。
```
for example:
for example: -R rulesets/zh3ng_loop_rule.xml,rulesets/some_rule.xml,...
```  


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

