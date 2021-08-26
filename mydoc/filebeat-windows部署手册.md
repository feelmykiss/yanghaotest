# Filebeat在windows下安装使用  

## 一、 windows下安装 Filebeat  
* 安装包在 `filebeat部署文档`下的`安装文件`目录中   

1. 解压到`filebeat-7.4.0-windows-x86_64.zip`指定目录(例:D:\develop\filebeat-7.4.0-windows-x86_64)  

2. 打开解压后的目录,打开(D:\develop\filebeat-7.4.0-windows-x86_64\)

3. 将`安装文件`目录下的 `filebeat.yml`文件和`startFilebeat.bat`文件拷贝到 filebeat安装根目录下即 `D:\develop\filebeat-7.4.0-windows-x86_64\`目录下

4. 启动: 
注意:启动前必须先修改 `filebeat.yml`文件,
①将 `filebeat.inputs:`下对应的日志监控路径`paths:`修改为需要监控的路径
②将 `output.logstash:`下的 host 修改为 logstash 部署服务器的host

* 启动方式1:默认启动方式: 双击 `startFilebeat.bat`文件 即可启动 filebeat. 如需关闭, `$ ctrl + c`即可关闭(注: .bat方式启动,cmd窗口必须始终打开, 如果关闭 cmd 窗口会导致 filebeat 关闭)

  说明:`startFilebeat.bat`和 `filebeat.yml`文件必须放在 filebeats 安装目录根目录下(例:D:\develop\filebeat-7.4.0-windows-x86_64下) 
  
  
  
* 启动方式2:安装为服务启动方式:
  [注意:系统必须有 PowerShell，因为官方安装包中提供的脚本只能在 PowerShell 中运行，若是 win10 系统，可忽略，因为它已经自带了 PowerShell， 否则请下载 PowerShell 并安装]
  1.将解压后的filebeat安装包(例:D:\develop\filebeat-7.4.0-windows-x86_64)移动到:C:\Program Files  
  2.重命名`filebeat-7.4.0-windows-x86_64`为`Filebeat`。  
  3.以 管理员 身份运行PowerShell,在PowerShell中运行以下命令:  
  ① `$ cd 'C:\Program Files\Filebeat'`  
  ② `$ .\install-service-filebeat.ps1`  
  注：如果此处提示你没有权限，请运行以下的命令注册 Filebeat 服务 ：  
  `$ PowerShell.exe -ExecutionPolicy UnRestricted -File .\install-service-filebeat.ps1`  
  至此，已经将 Filebeat 成功注册为系统服务，当下一次开机时它会自动启动，当然也可以手动通过服务控制面板启动它。

## 二、 Filebeat 配置(filebeat.yml） 
注意:  .yml 格式配置文件,严格要求格式,空格多余或缺失都会导致 filebeat 正常无法启动.建议直接复制解压后目录中的 `安装文件`目录下的`filebeat.yml`文件

配置文件部分示例(#后边是注释说明):   
文件详情可查看`filebeat部署文档`中的`安装文件`目录下的`filebeat.yml`文件
参数说明:
1. 日志监控输入配置:(filebeat.inputs:)    
参数说明: 
* paths: 配置下的 `- D:\file\csvlog\*.csv`需要改为 alias 为 `ML-ASSY-001` 的日志保存的路径(windows电脑的绝对路径)
* alias 为 `ML-ASSY-002`和`ML-ASSY-003` 的日志监控,需要解除  注释`# alias 为 ML-ASSY-002 的日志示例` 和 `# alias 为 ML-ASSY-003 的日志示例` 下的部分配置文件的注释,并将其路径改为相应的日志存储路径
* `encoding:` 需要设为 `encoding: GB2312` (注意 冒号后的空格,有且只能有一个空格) 用以支持中文,否则在 logstash 接收到 filebeat 解析过的文件会造成中文乱码. 并且配置的中文表头无法 drop 
```yaml
filebeat.inputs:
# alias 为 ML-ASSY-001 的日志示例
- type: log
  # 向当前配置下解析到的日志添加标签:用以给当前日志添加唯一标识
  # tags: ["ML-ASSY-001"] 说明: tags固定,["ML-ASSY-001"]双引号内的内容,是和日志接收方:logstash 约定好的固定的value
  tags: ["ML-ASSY-001"]
  # Change to true to enable this input configuration.
  # enable 启用由 false 改为 true 才能启用当前的日志监控
  enabled: true
  # Paths that should be crawled and fetched. Glob based paths.
  paths:
  # 日志监控路径,可配置多个
    # - D:\file\csvlog\*.csv 意味着Filebeat将获取D:\file\csvlog\目录下所有以test1开头,以.csv结尾的日志文件
    - D:\file\csvlog\*.csv
    #- c:\programdata\elasticsearch\logs\*
  # 配置 encoding 以避免出现中文乱码的问题
  encoding: GB2312
  
	# alias 为 ML-ASSY-002 的日志示例
#- type: log
#  tags: ["ML-ASSY-002"]
#  enabled: true
#  paths:
#    - D:\file\csvlog2\*.csv
#  encoding: GB2312
  
	# alias 为 ML-ASSY-003 的日志示例
# - type: log
#  tags: ["ML-ASSY-003"]
#  enabled: true
#  paths:
#    - D:\file\csvlog3\*.csv
#  encoding: GB2312
```

2. 配置输出到 Logstash      
Outputs 有 elasticsearch，logstash。只能配置一个输出。默认是ElasticSearch

①. 注释: `output.elasticsearch：` 配置  

```yaml
#output.elasticsearch:
  # Array of hosts to connect to.
  #hosts: ["localhost:9200"]
```
②. 解除注释:  `output.logstash：` 配置  

```yaml
output.logstash:
  # The Logstash hosts
  # localhost:5044 此处需要改动为 logstash 部署服务器的 host
  hosts: ["localhost:5044"]
```

