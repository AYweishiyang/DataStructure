package com.ay.test01;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;

/**
 * @author ay
 * @create 2020-07-29 17:17
 */
public class news {
    public static String USER_AGENT = "User-Agent";
    public static String USER_AGENT_VALUE = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.106 Safari/537.36";
    public static void main(String[] args) throws IOException {

        String url = "https://www.nvshens.net/g/";
        news crawlerBase = new news();
        for (int i = 33235; i < 33236; i++) {
            for (int j = 0; j < 60; j++) {
                String fullUrl = url  + i + "/"+ j + ".html";
                System.out.println(fullUrl);
//                Connection.Response execute = Jsoup.connect(url).execute();
//                byte[] bytes = execute.bodyAsBytes();
                crawlerBase.jsoupList(fullUrl);
            }
        }
      //  crawlerBase.jsoupList(url);
    }
    /**
     * jsoup方式 获取虎扑新闻列表页
     * @param url 虎扑新闻列表页url
     */
    public void jsoupList(String url){
        try {
            Connection connection = Jsoup.connect(url);
            connection.header(USER_AGENT,USER_AGENT_VALUE);
            Document document = connection.get();
            // 使用 css选择器 提取列表新闻 a 标签
            // <a href="https://voice.hupu.com/nba/2484553.html" rel="external nofollow" target="_blank">霍华德：夏休期内曾节食30天，这考验了我的身心</a>
            Elements elements = document.select("div#high > div.photos > div.gallery_wrapper > ul > img");
            for (Element element:elements){
//                System.out.println(element);
                // 获取详情页链接
                String d_url = element.attr("src");
                String alt = element.attr("alt");
                Connection connect = Jsoup.connect(d_url);
                connect.header(USER_AGENT,USER_AGENT_VALUE);
                Connection.Response execute = connect.execute();


                byte[] bytes = execute.bodyAsBytes();
                savaImage(bytes,"D:\\meitu",alt);
                System.out.println(d_url + alt);


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void savaImage(byte[] img,String filePath,String fileName) {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        File dir = new File(filePath);
        try {
            //判断文件目录是否存在
            if(!dir.exists() && dir.isDirectory()){
                dir.mkdir();
            }
            file = new File(filePath+"\\"+fileName);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(img);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            if(bos!=null){
                try {
                    bos.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

}
