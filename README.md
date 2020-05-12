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

 
 