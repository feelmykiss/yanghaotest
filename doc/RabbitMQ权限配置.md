## docker 命令

* 查询docker容器: `docker ps|grep rabbitmq`
* 进入docker 容器: `docker exec -it 8439a1430ef8 /bin/bash`
* 退出容器: exit

## RabbitMQ 命令

* 查看所有用户: `rabbitmqctl list_users`
* 添加用户: `rabbitmqctl add_user developer developer`
* 查看用户权限: `rabbitmqctl list_user_permissions developer`
* 角色分类: none、management、policymaker、monitoring、administrator
* 设置用户tag: `rabbitmqctl set_user_tags developer1 monitoring`

## 赋权:

* 例1:
  用户: user_admin vhost: /vhost1 configure: 所有 write: 所有 read: 所有

```shell
rabbitmqctl  set_permissions -p "/vhost1"  "user_admin" ".*"  ".*"  ".*"
```

* 例1:
  用户: developer vhost: / configure: 不允许(不匹配任何资源) write: 所有 read: 所有

```shell
rabbitmqctl set_permissions -p "/" "developer" "^$" ".*" ".*"
```

结果:

```text
rabbitmqctl  list_user_permissions developer
Listing permissions for user "developer" ...
vhost	configure	write	read
/	^$	.*	.*
```

