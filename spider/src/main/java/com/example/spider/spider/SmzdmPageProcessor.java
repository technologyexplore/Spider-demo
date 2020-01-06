package com.example.spider.spider;



import com.example.spider.pipeline.ConsolePipeline;
import org.jsoup.nodes.Document;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author windows 10
 */
public class SmzdmPageProcessor implements PageProcessor {

    private static final String BAIDU_UA = "Mozilla/5.0 (compatible; Baiduspider-render/2.0; +http://www.baidu.com/search/spider.html)";
    private static final String URL1 = "https://www.smzdm.com/p/16827887/";
    private static final String URL2 = "https://www.smzdm.com/p/16939361/";
    private Site site = Site.me()
            .setRetryTimes(3)
            .setSleepTime(1000)
            .setTimeOut(10000)
            .setUserAgent(BAIDU_UA);

    @Override
    public void process(Page page) {
        // 第二个url跳过
        if (page.getUrl().toString().equals(URL2)) {
            page.setSkip(true);
        }
        // 使用正则，添加更多的链接
        page.addTargetRequests(page.getHtml().links().regex("xxxxxx").all());
        Document doc = page.getHtml().getDocument();
        // jsoup 语法
        String source = doc.select("div.other-link-box a.other-link").attr("href");
        // xpath 语法
        String title = page.getHtml().xpath("//h1[@class='title J_title']/text()").toString();
        String name = page.getHtml().xpath("//div[@class='author-info J_author_info']/span[@class='time']/text()").toString();
        page.putField("title", title);
        page.putField("name", name);
        page.putField("source", source);
    }

    public static void main(String[] args) {
        List<Pipeline> pipelineList = new ArrayList<>();
        pipelineList.add(new ConsolePipeline());
        Spider.create(new SmzdmPageProcessor())
                .addUrl(URL1)
                .addUrl(URL2)
                .setPipelines(pipelineList)
                .thread(5)     // 多线程
                .run();         // 启动

    }

    @Override
    public Site getSite() {
        return site;
    }

}
