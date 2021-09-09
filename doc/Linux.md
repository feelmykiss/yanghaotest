# cat命令：

* 一次显示整个文件。

```shell
$ cat filename
```

* 从键盘创建一个文件。 只能创建新文件,不能编辑已有文件.

```shell
$ cat > filename  
```

* 关键字查询

1. 查找搜索目标所在行数

```shell
$ cat xxx.log | grep -n  "查询关键字"
```

2. 查看搜索目标后2行数据

```shell
$ cat xxx.log | grep -A 2  "查询关键字"
```

3. 查看搜索目标前2行数据

```shell
$ cat xxx.log | grep -B 2  "查询关键字"
```

4.同时查看搜索目前 前2行和 后2行数据

```shell
$ cat xxx.log | grep -C 2  "查询关键字"
```

5.查看文件指定行数区间内容

```shell
$ sed -n '查询关键字' xxx.log 
```

* 查看log,按照关键字过滤.

```shell
# more:逐页阅读,空格键换页
  cat -n spring.log |grep "LF20200426-00101-0001" |more
```

* 将几个文件合并为一个文件：

```shell
$ cat file1 file2 > file

参数：
-n 或 --number 由 1 开始对所有输出的行数编号
-b 或 --number-nonblank 和 -n 相似，只不过对于空白行不编号
-s 或 --squeeze-blank 当遇到有连续两行以上的空白行，就代换为一行的空白行
-v 或 --show-nonprinting
```

例：

* 把 textfile1 的档案内容加上行号后输入 textfile2 这个档案里

```shell
cat -n textfile1 > textfile2
```

* 把 textfile1 和 textfile2 的档案内容加上行号（空白行不加）之后将内容附加到 textfile3 里。

```shell
cat -b textfile1 textfile2 >> textfile3
```

* 把test.txt文件扔进垃圾箱，赋空值test.txt

```shell
cat /dev/null > /etc/R_WIP_PRODUCT.sql 
``` 

二、 将文字输出到指定文件

* 条件： 文件名称： CloudPayment.log  
  搜索内容：1805 或 1905  
  输出文件： out.log

1、满足一个条件(包含 “TJ”  )的语句：

```shell
grep '1805' CloudPayment.log  > out.log

cat  CloudPayment.log | grep '1805' > out.log
```

2、满足两个条件中的一个条件（包含“1805” 或者 包含“1905”）的命令：

```shell
egrep '18051905' CloudPayment.log > out.log

grep -E '1805|1905' CloudPayment.log > out.log

cat CloudPayment.log | grep -E '1805|1905'  > out.log
```

3、同时满足两个条件中（包含“1805” 和 “1905”）的命令：

```shell
grep '1805' CloudPayment.log | grep '1905'  > out.log

egrep '1805.*1905| 1905.*1805' CloudPayment.log > out.log

cat CloudPayment.log | grep "1805"  | grep "1905"  > out.log
```

* PS: 符号“>”表示擦除后写入文档 ; “>>”表示追加到文档  
  部分字符需要使用斜杠转译，如减号等

4、grep和tee结合：

```shell
# 在文件 CloudPayment.log中搜索订单号1905， 并将搜索结果输出到out.log 
grep '18051114551940610000' CloudPayment.log | tee -a out.log
```