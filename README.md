# Spider-demo
网络爬虫

概念：

网络爬虫（又称为网页蜘蛛，网络机器人，在FOAF社区中间，更经常的称为网页追逐者），是一种按照一定的规则，自动地抓取万维网信息的程序或者脚本。另外一些不常使用的名字还有蚂蚁、自动索引、模拟程序或者蠕虫。

爬虫的具体步骤：

1、数据采集，经过一定的逻辑和策略，循环抓取网页上的数据，工作过程就像Ctrl+a -> Ctrl+c -> Ctrl+v；

2、解析，分析采集到的数据集，使用一定的规则或语法，提取相关的信息；

3、存储，将提取出的信息以我们想要的方式存储到数据库中，方便后续使用。

WebMagic：

WebMagic是一个简单灵活的Java爬虫框架，项目代码分为核心和扩展两部分。核心部分(webmagic-core)是一个精简的、模块化的爬虫实现，而扩展部分则包括一些便利的、实用性的功能。（http://webmagic.io/）

WebMagic的结构分为Downloader、PageProcessor、Scheduler、Pipeline四大组件，并由Spider将它们彼此组织起来。这四大组件对应爬虫生命周期中的下载、处理、管理和持久化等功能。

WebMagic的四个组件:

1.Downloader 访问URL，下载页面。WebMagic默认使用了Apache HttpClient作为下载工具。

2.PageProcessor 负责解析页面并抽取信息，以及发现新的链接。提供多种解析HTML的工具，Jsoup和基于Jsoup开发的Xpath工具Xsoup。

3.Scheduler 负责管理待抓取的URL与URL去重。WebMagic默认提供了JDK的内存队列来管理URL，并用HashSet进行去重。也支持使用RedisScheduler编写分布式爬虫。

4.Pipeline Pipeline负责抽取结果的处理，包括计算、持久化到文件、数据库等。WebMagic默认提供了“输出到控制台”和“保存到文件”两种结果处理方案。

一般情况下，在编写爬虫的过程中，只需要使用者定制PageProcessor和Pipeline即可。

注意事项：

1、做好防反爬的准备，防止IP被封。

2、考虑服务器的负载，控制好爬取频率。

3、做好URL 的管理和调度，避免重复爬取。