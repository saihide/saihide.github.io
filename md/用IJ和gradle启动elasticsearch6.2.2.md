### 环境准备
1. jdk9
2. idea2018.2
### 从git clone源码
git clone .....
### 切换到6.2.2的tag
git checkout v6.2.2
### github上的说明
JDK 9 is required to build Elasticsearch. You must have a JDK 9 installation
with the environment variable `JAVA_HOME` referencing the path to Java home for
your JDK 9 installation. By default, tests use the same runtime as `JAVA_HOME`.
However, since Elasticsearch, supports JDK 8 the build supports compiling with
JDK 9 and testing on a JDK 8 runtime; to do this, set `RUNTIME_JAVA_HOME`
pointing to the Java home of a JDK 8 installation. Note that this mechanism can
be used to test against other JDKs as well, this is not only limited to JDK 8.

Elasticsearch uses the Gradle wrapper for its build. You can execute Gradle
using the wrapper via the `gradlew` script in the root of the repository.

IntelliJ users can automatically configure their IDE: `./gradlew idea`
then `File->New Project From Existing Sources`. Point to the root of
the source directory, select
`Import project from external model->Gradle`, enable
`Use auto-import`. In order to run tests directly from
IDEA 2017.2 and above, it is required to disable the IDEA run launcher in order to avoid
`idea_rt.jar` causing "jar hell". This can be achieved by adding the
`-Didea.no.launcher=true` [JVM
option](https://intellij-support.jetbrains.com/hc/en-us/articles/206544869-Configuring-JVM-options-and-platform-properties).
Alternatively, `idea.no.launcher=true` can be set in the
[`idea.properties`](https://www.jetbrains.com/help/idea/file-idea-properties.html)
file which can be accessed under Help > Edit Custom Properties (this will require a
restart of IDEA). For IDEA 2017.3 and above, in addition to the JVM option, you will need to go to
`Run->Edit Configurations->...->Defaults->JUnit` and verify that the `Shorten command line` setting is set to
`user-local default: none`. You may also need to [remove `ant-javafx.jar` from your
classpath](https://github.com/elastic/elasticsearch/issues/14348) if that is
reported as a source of jar hell.

### 一步一步来
1. 在elasticsearch的根目录下执行 ./gradlew idea，结果显示BUILD SUCCESSFUL表示成功。
2. 在idea中打开项目，选择gradle wapper, 勾选use auto-import。gradle会编译一边，等待一会。
3. 在edit configurations里添加application，配置如下
   
     > Main class: 
     >> org.elasticsearch.bootstrap.Elasticsearch
     
     > VM options: 
	 >>	-Des.path.home=...\elasticsearch\distribution\src\main\resources
     >> -Des.path.conf=...\elasticsearch\distribution\src\main\resources\config
     >> -Dlog4j2.disable.jmx=true
     >> -Des.security.manager.enabled=false
     >> -Djava.security.policy=...\elasticsearch\distribution\src\main\resources\config\java.policy
     
     > working directory
     >>...\elasticsearch
4. 勾选Include dependencies with "Provided" scope
5. 在...\elasticsearch\distribution\src\main\resources\config\目录下添加java.policy文件
   ```
    grant {
    permission java.lang.RuntimePermission "createClassLoader";
    };
   ```
6. 把6.2.2的发布包的modules和plugins复制到...\elasticsearch\distribution\src\main\resources\目录下
7. 修改...\elasticsearch\distribution\src\main\resources\config目录下的elasticsearch.yml文件
	
	> cluster.name
	> node.name
	> path.data
	> path.logs
	> bootstrap.memory_lock
	> network.host
	> http.enabled

#### 以上都搞定之后，就可以启动项目了
启动成功入下图：

![](https://saihide.github.io/image/idea.png)

在浏览器访问：http://localhost:9200/

![](https://saihide.github.io/image/es.png)




