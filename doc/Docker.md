* 挂载路径:

```shell
docker run -it -v /home/ceshi:/home centos /bin/bash
```

* mysql启动:

```shell
docker run -d -p 3310:3306 -v /home/mysql/conf:/etc/mysql/conf.d -v /home/mysql/data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=123456 --name mysql01 mysql:5.7
```

* 匿名挂载,只写容器内名字,不写容器外名字:

```shell
docker run -d -P --name nginx01 -v /etc/nginx nginx
```

* 具名挂载: -v 卷名:容器内路径

```shell
docker run -d -P --name nginx02 -v juming-nginx:/etc/nginx nginx
```

* 查看具名挂载具体路径:

```shell
docker volume inspect juming-nginx
```

* /var/lib/docker/volumes 固定
* /var/lib/docker/volumes/juming-nginx/_data

* 容器内权限:

* ro readonly 只能通过宿主机更改

* rw readwrite

```shell
docker run -d -P --name nginx02 -v juming-nginx:/etc/nginx:ro nginx
docker run -d -P --name nginx02 -v juming-nginx:/etc/nginx:rw nginx
```

* 查看所有卷

```shell
docker volume ls
```


# 数据卷容器

* 启动 docker01
```shell
docker run -it --name docker01 yanghao/centos:1.0
```
* 退出当前容器
```shell
ctrl + p + q 
```
* 启动 docker02 挂载到 docker01
* docker01 叫 数据卷容器
```shell
--volumes-from docker01
```
```shell
docker run -it --name docker02 --volumes-from docker01 yanghao/centos:1.0
```
* 容器之间配置信息的传递,数据卷容器的生命周期一直持续到没有容器使用为止

# Dockerfile
 Dockerfile 是用来构建docker镜像的文件,命令参数脚本.
## 基础知识
1. 每个保留关键字都必须是大写字母
2. 执行顺序从上到下执行
3. 没一个指令都会创建提交一个新的镜像层
构建步骤:
1. 编写 dockerfile文件
2. docker build 构建成为镜像
3. docker run 运行镜像
4. docker push 发布镜像
```shell
FROM centos

VOLUME ["volume01","volume02"]

CMD echo "--------end--------"

CMD /bin/bash
```
* build
```shell
docker build -f /home/docker-test-volume/dockerfile1 -t yanghao/centos:1.0 .
```
```shell
FROM          # 基础镜像,一切从这里构建
MAINTAINER    # 镜像是谁写的: 姓名+邮箱
RUN           # 镜像构建时,需要运行的命令
ADD           # 步骤: Tomcat 镜像,这个tomcat压缩包! 添加内容
WORKDIR       # 镜像的工作目录
VOLUME        # 挂载的目录
EXPOSE        # 保留端口配置
CMD           # 指定这个容器启动时候需要运行的命令,只有最后一个会生效,可被替代
ENTRYPOINT    # 指定这个容器启动时候需要运行的命令,可以直接追加命令
ONBUILD       # 当构建一个被继承的 Dockerfile 时,会运行 ONBUILD 的指令
COPY          # 复制,类似 add ,将文件拷贝到镜像中
ENV           # 构建时候设置环境变量

```

* docker build -f dockerfile文件路径 -t 镜像名:[tag]


# Docker0

* 
```shell
# 随机端口启动 Tomcat
docker run -d -P --name tomcat01 tomcat
docker run -d -P --name tomcat02 tomcat
# 查看 Tomcat ip
docker exec -it tomcat01 ip addr
```

* 每启动一个 docker 容器, Docker就会给容器分配一个IP. 桥接模式
* veth-pair 技术

* tomcat01 和 tomcat02 是共用一个路由器,docker0
所有的容器不指定网络的情况下,都是 docker0 路由的, docker会给容器分配一个默认的可用IP
  Docker使用的是linux的桥接,宿主机中是一个Docker容器的网桥 docker0
* Docker 中所有的网络接口都是虚拟的,虚拟的转发效率高.

# --link
```shell
docker run -d -P --name tomcat03 --link tomcat02 tomcat
# 可以ping通
docker exec -it tomcat03 ping tomcat02
# 反向无法ping通

docker network false 

```

# 自定义网络
容器互联
* 网络模式
bridge: 桥接(默认)
none: 不配置
host: 与宿主机共享
container: 容器网络连通  
  
```shell
# 直接启动 --net bridge
docker run -d -P --name tomcat01 tomcat
docker run -d -P --name tomcat01 --net bridge tomcat

# docker0特点: 默认,域名不能访问, --link 可以打通.

# 自定义网络
# --driver bridge 桥接
# --subnet 192.168.0.0/16 子网
# --gateway 192.168.0.1 网关
docker network create --driver bridge --subnet 192.168.0.0/16 --gateway 192.168.0.1 mynet

# 查看docker所有网络
docker network ls

# 查看 自己创建的网络
docker network inspect mynet

# 使用自己网卡启动
docker run -d -P --name tomcat-net-01 --net mynet tomcat
docker run -d -P --name tomcat-net-02 --net mynet tomcat

# 不使用 --link 也可以通过容器名ping通
docker exec -it tomcat-net-01 ping tomcat-net-02
```
* 自定义网络好处
保证不同的集群使用不同的网络,保证集群安全健康
  

# 网络连通
```shell
docker network connect  mynet tomcat01
# 连通之后就是将  tomcat01 放到了 mynet 下
# 一个容器,两个IP地址
# 阿里云服务: 公网ip 私网ip
 docker exec -it tomcat01 ping tomcat-net-02
```
* 结论: 跨网络操作,需要 docker network connect
