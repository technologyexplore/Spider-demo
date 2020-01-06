package com.example.spider.spider;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 * @author windows 10
 */
public class SeleniumDemo {

    public static void main(String[] args) {
        //调用本地driver
        System.setProperty("webdriver.gecko.driver", ".\\lib\\geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        //调用浏览器
        options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        WebDriver webDriver = new FirefoxDriver();

        // 访问百度
        webDriver.get("https://www.baidu.com");
        // 输出标题、当前url、页面源代码等
        System.out.println("标题：" + webDriver.getTitle());
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("当前地址：" + webDriver.getCurrentUrl());
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("页面源码：" + webDriver.getPageSource());
    }

}
