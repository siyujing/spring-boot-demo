<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta content="spm-id" name="a21bo">
    <!--<link rel="shortcut icon" href="favicon.ico" type="image/x-icon">-->
    <!--<link rel="stylesheet" href="./semantic/dist/semantic.min.css">-->
    <!--<script type="text/javascript" src="./static/jquery.js"></script>-->
    <!--<script type="text/javascript" src="./semantic/dist/semantic.min.js"></script>-->
</head>
<style>
    body {
        text-align: center
    }

    div {
        margin: 0 auto;
        width: 240px;
        height: 100px;
        border: 0px solid #F00
    }

    li {
        margin: 0 auto;
    }

    /* css注释：为了观察效果设置宽度 边框 高度等样式 */
</style>
<body>
<div class="ui container">
    <div style="margin-top: 50px">
        <h2>请登录</h2>
        <form class="form1" action="/service/demo" method="get" name="denglu">
            <table>
                <tr>
                    <td>
                        用户名：
                    </td>
                    <td>
                        <input type="text" id="t1" name="username"><br>
                    </td>
                </tr>
                <tr>
                    <td>
                        密 码：
                    </td>
                    <td>
                        <input type="password" id="p1" name="password">
                    </td>
                </tr>
                <tr>
                    <td colspan="1">
                        <input type="submit" id="tijiaoid" value="提交">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
