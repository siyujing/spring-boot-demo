package com.testingedu.wxbotdemo.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.testingedu.wxbotdemo.domain.WxBot;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.http.util.TextUtils;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class WxBotService {

    private void getUuid(WxBot wxBot) {
        String url = "https://login.weixin.qq.com/jslogin";
        CloseableHttpResponse response = null;
        try {
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            list.add(new BasicNameValuePair("appid", "wx782c26e4c19acffb"));
            list.add(new BasicNameValuePair("fun", "new"));
            list.add(new BasicNameValuePair("lang", "zh_CN"));
            list.add(new BasicNameValuePair("_", Long.toString(System.currentTimeMillis())));

            URIBuilder urlBuilder = new URIBuilder();
            urlBuilder.setPath(url);
            urlBuilder.setParameters(list);
            URI uri = urlBuilder.build();

            HttpGet httpGet = new HttpGet(uri);
            System.out.println("获取uuid");
            System.out.println(httpGet.getRequestLine());
            response = wxBot.getHttpClient().execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();
                String responseContent = EntityUtils.toString(entity, "UTF-8");
                System.out.println(responseContent);
                if (!TextUtils.isBlank(responseContent)) {
                    String code = this.findStr("window.QRLogin.code = (\\d+);", responseContent);
                    if (!TextUtils.isEmpty(code) && code.equals("200")) {
                        wxBot.setUuid(this.findStr("window.QRLogin.uuid = \"(.*)\";", responseContent));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String findStr(String regex, String str) {
        Matcher matcher = Pattern.compile(regex).matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    private String r() {
        return Integer.toString(~((int) System.currentTimeMillis()));// 转换成int后取反，因为js位运算只支持32位
    }

    private void downQrCode(WxBot wxBot) {
        String url = "https://login.weixin.qq.com/qrcode/" + wxBot.getUuid();
        CloseableHttpResponse response = null;
        try {
            HttpGet httpGet = new HttpGet(url);
            System.out.println("下载二维码图片");
            System.out.println(httpGet.getRequestLine());
            response = wxBot.getHttpClient().execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();
                InputStream is = entity.getContent();
                FileOutputStream fos = new FileOutputStream(wxBot.getQrCodeFile());
                int l = -1;
                byte[] b = new byte[1024];
                while ((l = is.read(b)) != -1) {
                    fos.write(b, 0, l);
                }
                fos.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void showQrCode(WxBot wxBot) {
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                if (desktop.isSupported(Desktop.Action.BROWSE)) {
                    desktop.browse(wxBot.getQrCodeFile().toURI());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean checkLogin(String tip, long currentTimeMillis, WxBot wxBot) {
        String url = "https://login.wx.qq.com/cgi-bin/mmwebwx-bin/login";
        CloseableHttpResponse response = null;
        try {
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            list.add(new BasicNameValuePair("loginicon", "true"));
            list.add(new BasicNameValuePair("uuid", wxBot.getUuid()));
            list.add(new BasicNameValuePair("tip", tip));
            list.add(new BasicNameValuePair("r", this.r()));
            list.add(new BasicNameValuePair("_", Long.toString(currentTimeMillis)));

            URIBuilder urlBuilder = new URIBuilder();
            urlBuilder.setPath(url);
            urlBuilder.setParameters(list);
            URI uri = urlBuilder.build();

            HttpGet httpGet = new HttpGet(uri);
            System.out.println("检测登录");
            System.out.println(httpGet.getRequestLine());
            response = wxBot.getHttpClient().execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();
                String responseContent = EntityUtils.toString(entity, "UTF-8");
                System.out.println(responseContent);
                if (!TextUtils.isBlank(responseContent)) {
                    String code = this.findStr("window.code=(\\d+);", responseContent);
                    if (TextUtils.isEmpty(code)) {

                    } else if (code.equals("200")) {// 点击登录后执行
                        wxBot.setRedirectUri(this.findStr("window.redirect_uri=\"(\\S+?)\";", responseContent));
                        wxBot.setBaseUrl(wxBot.getRedirectUri().substring(0, wxBot.getRedirectUri().lastIndexOf("/")));
                        System.out.println("登录成功");
                        return true;
                    } else if (code.equals("201")) {// 扫描成功，还未点击登录
                        System.out.println("扫描成功，请点击登录");
                    } else if (code.equals("408")) {// 二维码未扫描，登录超时

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private void login(WxBot wxBot) {
        String tip = "1";// 首次时为1
        long currentTimeMillis = System.currentTimeMillis();// 首次时为系统时间，之后每次请求加1
        while (!this.checkLogin(tip, currentTimeMillis, wxBot)) {
            tip = "0";
            currentTimeMillis++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void wxNewLoginPage(WxBot wxBot) {
        CloseableHttpResponse response = null;
        try {
            HttpGet httpGet = new HttpGet(wxBot.getRedirectUri() + "&fun=new&version=v2");
            System.out.println("跳转到新的登录页面");
            System.out.println(httpGet.getRequestLine());
            response = wxBot.getHttpClient().execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();
                String responseContent = EntityUtils.toString(entity, "UTF-8");
                System.out.println(responseContent);

                wxBot.setSkey(this.findStr("<skey>(\\S+)</skey>", responseContent));
                wxBot.setWxsid(findStr("<wxsid>(\\S+)</wxsid>", responseContent));
                wxBot.setWxuin(findStr("<wxuin>(\\S+)</wxuin>", responseContent));
                wxBot.setPassTicket(findStr("<pass_ticket>(\\S+)</pass_ticket>", responseContent));

//                 List<Cookie> cookies = cookieStore.getCookies();
//                 if (cookies.isEmpty()) {
//                 System.out.println("获取Cookie失败");
//                 } else {
//                 System.out.println("获取并保存Cookie");
//                 for (int i = 0; i < cookies.size(); i++) {
//                 System.out.println(cookies.get(i).toString());
//                 }
//                 }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void wxInit(WxBot wxBot) {
        String url = wxBot.getBaseUrl() + "/webwxinit";
        CloseableHttpResponse response = null;
        try {
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            list.add(new BasicNameValuePair("r", this.r()));
            list.add(new BasicNameValuePair("lang", "zh_CN"));
            list.add(new BasicNameValuePair("pass_ticket", wxBot.getPassTicket()));

            URIBuilder urlBuilder = new URIBuilder();
            urlBuilder.setPath(url);
            urlBuilder.setParameters(list);
            URI uri = urlBuilder.build();

            wxBot.setDeviceId("e" + System.currentTimeMillis() + wxBot.getWxuin().substring(0, 2));// 生成15位随机数
            String json = "{\"BaseRequest\":{\"Uin\":\"" + wxBot.getWxuin() + "\",\"Sid\":\"" + wxBot.getWxsid() + "\"," + "\"Skey\":\""
                    + wxBot.getSkey() + "\",\"DeviceID\":\"" + wxBot.getDeviceId() + "\"}}";
            StringEntity stringEntity = new StringEntity(json, ContentType.APPLICATION_JSON);

            HttpPost httpPost = new HttpPost(uri);
            httpPost.setEntity(stringEntity);
            System.out.println("微信初始化");
            System.out.println(httpPost.getRequestLine());
            response = wxBot.getHttpClient().execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();
                String responseContent = EntityUtils.toString(entity, "UTF-8");
                JsonObject jsonObject = wxBot.getJsonParser().parse(responseContent).getAsJsonObject();
                wxBot.setSyncKeyJsonObject(jsonObject.getAsJsonObject("SyncKey"));
                System.out.println(wxBot.getSyncKeyJsonObject());
                wxBot.setUserName(jsonObject.getAsJsonObject("User").get("UserName").getAsString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void wxStatusNotify(WxBot wxBot) {
        String url = wxBot.getBaseUrl() + "/webwxstatusnotify";
        CloseableHttpResponse response = null;
        try {
            String json = "{\"BaseRequest\":{\"Uin\":\"" + wxBot.getWxuin() + "\",\"Sid\":\"" + wxBot.getWxsid() + "\"," + "\"Skey\":\""
                    + wxBot.getSkey() + "\",\"DeviceID\":\"" + wxBot.getDeviceId() + "\"},\"Code\":3," + "\"FromUserName\":" + wxBot.getUserName()
                    + ",\"ToUserName\":" + wxBot.getUserName() + ",\"ClientMsgId\":"
                    + System.currentTimeMillis() + "}";
            StringEntity stringEntity = new StringEntity(json, ContentType.APPLICATION_JSON);

            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(stringEntity);
            System.out.println("开始微信状态通知");
            System.out.println(httpPost.getRequestLine());
            response = wxBot.getHttpClient().execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();
                String responseContent = EntityUtils.toString(entity, "UTF-8");
                JsonObject jsonObject = wxBot.getJsonParser().parse(responseContent).getAsJsonObject();
                int ret = jsonObject.getAsJsonObject("BaseResponse").get("Ret").getAsInt();
                if (ret == 0) {
                    System.out.println("开始微信状态通知: 成功");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void listenMsg(WxBot wxBot) {
        while (true) {
            this.syncCheck(wxBot);
            if (wxBot.getRetcode() == 0) {
                if (wxBot.getSelector() == 0) {// 0为正常
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else if (wxBot.getSelector() == 2) {// 新消息
                    this.wxSync(wxBot);
                } else if (wxBot.getSelector() == 6) {

                } else if (wxBot.getSelector() == 7) {

                }

            } else if (wxBot.getRetcode() == 1100) {// 1100暂不处理，再请求一次同步
                System.out.println(1100);
            }
        }
    }

    private void syncCheck(WxBot wxBot) {
        String url = "https://webpush." + wxBot.getBaseUrl().substring(8, wxBot.getBaseUrl().length()) + "/synccheck";
        CloseableHttpResponse response = null;
        try {
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            list.add(new BasicNameValuePair("r", this.r()));
            list.add(new BasicNameValuePair("skey", wxBot.getSkey()));
            list.add(new BasicNameValuePair("sid", wxBot.getWxsid()));
            list.add(new BasicNameValuePair("uin", wxBot.getWxuin()));
            list.add(new BasicNameValuePair("deviceid", wxBot.getDeviceId()));
            list.add(new BasicNameValuePair("synckey", this.getSyncKeyStr(wxBot)));
            list.add(new BasicNameValuePair("_", Long.toString(System.currentTimeMillis())));

            URIBuilder urlBuilder = new URIBuilder();
            urlBuilder.setPath(url);
            urlBuilder.setParameters(list);
            URI uri = urlBuilder.build();

            HttpGet httpGet = new HttpGet(uri);
            System.out.println("消息检查");
            System.out.println(httpGet.getRequestLine());
            response = wxBot.getHttpClient().execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();
                String responseContent = EntityUtils.toString(entity, "UTF-8");
                System.out.println(responseContent);
                if (!TextUtils.isBlank(responseContent)) {
                    String retcodeStr = this.findStr("retcode:\"(\\d+)\"", responseContent);
                    String selectorStr = this.findStr("selector:\"(\\d+)\"}", responseContent);
                    if (!TextUtils.isBlank(retcodeStr) && !TextUtils.isBlank(selectorStr)) {
                        wxBot.setRetcode(Integer.valueOf(retcodeStr));
                        wxBot.setSelector(Integer.valueOf(selectorStr));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void wxSync(WxBot wxBot) {
        String url = wxBot.getBaseUrl() + "/webwxsync";
        CloseableHttpResponse response = null;
        try {
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            list.add(new BasicNameValuePair("sid", wxBot.getWxsid()));
            list.add(new BasicNameValuePair("skey", wxBot.getSkey()));

            URIBuilder urlBuilder = new URIBuilder();
            urlBuilder.setPath(url);
            urlBuilder.setParameters(list);
            URI uri = urlBuilder.build();

            String json = "{\"BaseRequest\":{\"Uin\":\"" + wxBot.getWxuin() + "\",\"Sid\":\"" + wxBot.getWxuin() + "\",\"Skey\":\""
                    + wxBot.getSkey() + "\",\"DeviceID\":\"" + wxBot.getDeviceId() + "\"},\"SyncKey\":" + wxBot.getSyncKeyJsonObject().toString()
                    + ",\"rr\":" + this.r() + "}";
            StringEntity stringEntity = new StringEntity(json, ContentType.APPLICATION_JSON);

            HttpPost httpPost = new HttpPost(uri);
            httpPost.setEntity(stringEntity);
            System.out.println("获取最新消息");
            System.out.println(httpPost.getRequestLine());
            response = wxBot.getHttpClient().execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();
                String responseContent = EntityUtils.toString(entity, "UTF-8");
                // System.out.println(responseContent);
                if (!TextUtils.isBlank(responseContent)) {
                    JsonObject jsonObject = wxBot.getJsonParser().parse(responseContent).getAsJsonObject();
                    wxBot.setSyncKeyJsonObject(jsonObject.getAsJsonObject("SyncKey"));
                    JsonArray jsonArray = jsonObject.getAsJsonArray("AddMsgList");
                    for (int i = 0; i < jsonArray.size(); i++) {
                        JsonObject obj = (JsonObject) jsonArray.get(i);
                        int msgType = obj.get("MsgType").getAsInt();
                        String fromUserName = obj.get("FromUserName").getAsString();
                        String toUserName = obj.get("ToUserName").getAsString();
                        if (msgType == 1) {// 普通消息
                            if (wxBot.getSpecialUsers().contains(toUserName)) {// 如果是特殊账号
                                continue;
                            }
                            if (toUserName.indexOf("@@") != -1) {// 群消息
                                continue;
                            }
                            if (toUserName.equals(wxBot.getUserName())) {// 必须是发给我的，我才回复
                                String msg = this.getMsg(fromUserName, obj.get("Content").getAsString());
                                this.wxSendMsg(fromUserName, msg, wxBot);
                            }

                        } else if (msgType == 3) {// 图片

                        } else if (msgType == 34) {// 语音

                        } else if (msgType == 42) {// 名片

                        } else if (msgType == 51) {// 微信初始化消息

                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 如果有需要发送的消息，重写此方法
    private String getMsg(String fromUserName, String content) {

        return null;
    }

    public void wxSendMsg(String toUserName, String msg, WxBot wxBot) {
        if (TextUtils.isBlank(toUserName) || TextUtils.isBlank(msg)) {
            return;
        }
        String url = wxBot.getBaseUrl() + "/webwxsendmsg";
        CloseableHttpResponse response = null;
        try {
            String randomId = String.valueOf(System.currentTimeMillis());
            Random random = new Random();
            for (int i = 0; i < 4; i++) {
                randomId += random.nextInt(10);
            }
            String json = "{\"BaseRequest\":{\"Uin\":\"" + wxBot.getWxuin() + "\",\"Sid\":\"" + wxBot.getWxsid() + "\"," + "\"Skey\":\""
                    + wxBot.getSkey() + "\",\"DeviceID\":\"" + wxBot.getDeviceId() + "\"},\"Msg\":{\"Type\":1,\"Content\":\"" + msg
                    + "\",\"FromUserName\":\"" + wxBot.getUserName() + "\",\"ToUserName\":\"" + toUserName + "\",\"LocalID\":\""
                    + randomId + "\",\"ClientMsgId\":\"" + randomId + "\"},\"Scene\":0}";
            StringEntity stringEntity = new StringEntity(json, ContentType.APPLICATION_JSON);
            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(stringEntity);
            // System.out.println("发送消息：" + msg);
            System.out.println(httpPost.getRequestLine());
            response = wxBot.getHttpClient().execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                // HttpEntity entity = response.getEntity();
                // String responseContent = EntityUtils.toString(entity, "UTF-8");
                // System.out.println(responseContent);
                System.out.println("发送成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String getSyncKeyStr(WxBot wxBot) {
        String syncKeyTmp = "";
        JsonArray jsonArray = wxBot.getSyncKeyJsonObject().getAsJsonArray("List");
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject obj = (JsonObject) jsonArray.get(i);
            syncKeyTmp += obj.get("Key") + "_" + obj.get("Val") + "|";
        }
        if (syncKeyTmp.length() > 0) {
            syncKeyTmp = syncKeyTmp.substring(0, syncKeyTmp.length() - 1);
        }
        return syncKeyTmp;
    }

    public void start(WxBot wxBot) {
        this.getUuid(wxBot);// 获取uuid
        if (!TextUtils.isBlank(wxBot.getUuid())) {
            this.downQrCode(wxBot);// 下载二维码图片
            this.showQrCode(wxBot);// 显示二维码图片
        }
        this.login(wxBot);// 登录操作

        if (!TextUtils.isBlank(wxBot.getRedirectUri())) {// 跳转到登录后页面
            this.wxNewLoginPage(wxBot);
        }
        if (!TextUtils.isBlank(wxBot.getSkey())) {// 初始化微信
            this.wxInit(wxBot);
        }
        if (wxBot.getSyncKeyJsonObject() != null) {// 开启微信状态通知
            this.wxStatusNotify(wxBot);
            this.listenMsg(wxBot);
        }
    }

}
