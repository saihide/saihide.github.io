### 环境准备
1. jdk
2. gradle3.3+
3. idea
4. git
### 从git clone源码
git checkout v5.4.3
### 打开项目
##### 1. 在edit configurations添加new configuration
###### Main class: 
```
org.elasticsearch.bootstrap.Elasticsearch
```
###### VM options:
```
 -Des.path.home=D:\elasticsearch-5.4.3\elasticsearch\distribution\src\main\resources
-Djava.security.policy=D:\elasticsearch-5.4.3\elasticsearch\distribution\src\main\resources\config\elasticsearch.policy
-Des.path.conf=D:\elasticsearch-5.4.3\elasticsearch\distribution\src\main\resources\config
-Des.security.manager.enabled=false
-Dlog4j2.disable.jmx=true
-Dfile.encoding=UTF-8
```
###### working directory:
```
D:\elasticsearch-5.4.3\elasticsearch
```

##### 2. 在es源码的跟目录执行gradle idea
漫长的build时间 wait...........

##### 3. 添加项目到gradle
import包

##### 4. 将名为modules的subproject 
build, 漫长的build时间
将打好的jar包和plugin-descriptor.properties文件放到
D:\elasticsearch-5.4.3\elasticsearch\distribution\src\main\resources\modules 这个目录下的对应的module文件夹下

#### 5. 一些启动需要的
在这个文件夹下需要的目录D:\elasticsearch-5.4.3\elasticsearch\distribution\src\main\resources
bin config data lib logs modules plugins

#### 以上都搞定之后，就可以启动项目了

#### 安装head 插件
localhost:9100
用head连接刚才起的es localhost:9200



