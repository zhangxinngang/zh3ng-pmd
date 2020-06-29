# zh3ng-pmd

一个基于alibaba p3c项目的代码规范项目的一个java代码规范检查工具,添加了原p3c中没有的规范检查功能


### 打包

maven package   ->  zh3ng-pmd-${version}-jar-with-dependecies.jar

```$xslt
$root    mvn clean package
```

运行如下命令进行代码检查

```$xslt
java -cp ./target/zh3ng-pmd-${version}-jar-with-dependecies.jar
 com.zh3ng.club.pmd.custom.Main -d ${your path to check code} -R ${rulesets/zh3ng_loop_rule.xml ext...}
```

一些参数的说明:

* -cp : the java run .jar. In this case it is zh3ng-pmd-${version}-jar-with-dependecies.jar & MainClass  in target path。
 
```
for example:
-cp ./target/zh3ng-pmd-1.0.SNAPSHOT-jar-with-dependecies.jar com.zh3ng.club.pmd.custom.Main
```

* -d  : the .java file to be check. It can be filename or path.

```$xslt
for example:
-d ./src/test/java/WhileLoopTest.java, TTTssTest.java
```

* -R  : the checking rules. It is the *-rule.xml in resource/rulesets/* 。
```
for example:
for example: -R rulesets/zh3ng_loop_rule.xml,rulesets/some_rule.xml,xxx.xml...
```  


