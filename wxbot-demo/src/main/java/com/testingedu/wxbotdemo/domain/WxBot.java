package com.testingedu.wxbotdemo.domain;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.Data;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

@Data
public class WxBot {
    private CloseableHttpClient httpClient;
    private File qrCodeFile = new File("qrcode.jpeg");

    private String uuid;
    private String redirectUri;
    private String baseUrl;
    private String skey;
    private String wxsid;
    private String wxuin;
    private String passTicket;
    private String deviceId;
    private String userName;
    private int retcode;
    private int selector;

    private JsonParser jsonParser = new JsonParser();
    private JsonObject syncKeyJsonObject;
    // 特殊账号
    private List<String> specialUsers = Arrays.asList("newsapp", "fmessage", "filehelper", "weibo", "qqmail",
            "fmessage", "tmessage", "qmessage", "qqsync", "floatbottle", "lbsapp", "shakeapp", "medianote", "qqfriend",
            "readerapp", "blogapp", "facebookapp", "masssendapp", "meishiapp", "feedsapp", "voip", "blogappweixin",
            "weixin", "brandsessionholder", "weixinreminder", "wxid_novlwrv3lqwv11", "gh_22b87fa7cb3c",
            "officialaccounts", "notification_messages", "wxid_novlwrv3lqwv11", "gh_22b87fa7cb3c", "wxitil",
            "userexperience_alarm", "notification_messages");


    public WxBot() {
        System.setProperty("jsse.enableSNIExtension", "false");
        System.setProperty("https.protocols", "TLSv1");

        try {
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(SSLContext.getDefault(),
                    new String[] { "TLSv1" }, null, SSLConnectionSocketFactory.getDefaultHostnameVerifier());
            httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
