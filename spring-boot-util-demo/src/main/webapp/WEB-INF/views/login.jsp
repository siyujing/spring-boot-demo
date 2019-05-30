<%--
  Created by IntelliJ IDEA.
  User: lzx
  Date: 16/7/26
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Standard Meta -->
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

    <!-- Site Properities -->
    <title>my-app</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/semantic-ui-1.11.5/dist/semantic.css">
    <script src="${pageContext.request.contextPath}/js/pub/jquery-1.9.1.js"></script>
    <script src="${pageContext.request.contextPath}/style/semantic-ui-1.11.5/dist/semantic.js"></script>

    <script type="text/javascript">
        $(document).ready(function () {

            $('.ui.form').form({
                        userName: {
                            identifier: 'userName',
                            rules: [
                                {
                                    type: 'empty',
                                    prompt: 'Please enter a username'
                                }
                            ]
                        },
                        password: {
                            identifier: 'password',
                            rules: [
                                {
                                    type: 'empty',
                                    prompt: 'Please enter a password'
                                },
                                {
                                    type: 'length[6]',
                                    prompt: 'Your password must be at least 6 characters'
                                }
                            ]
                        }
                    },
                    {
                        inline: true,
                        on: 'blur',
                        onSuccess: submitForm
                    }
            );

            $('.ui.form').submit(function (e) {
                return false;
            });
            //checkbox init
            $('.ui.checkbox').checkbox();

        });

        function submitForm() {
            var username = $('input[name="username"]').val();
            localStorage.setItem('username',username);
            document.getElementById("login").submit();
//            var formData = $('.ui.form input').serializeArray(); //or .serialize();
//            $.ajax({
//                async:false,
//                type: 'POST',
//                url: 'customLogin',
//                data: formData
//            });
        }
    </script>

    <style type="text/css">
        body {
            font-family: Verdana, Arial, Helvetica, sans-serif;
            margin: 0;
            background-color: #fff;
        }

        .ui.grid {
            margin: 0;
        }

        .header-row1 {
            height: 100px;
        }

        .login-header {
            background-color: #0066b1;
            height: 160px;
        }

        .ui.white {
            color: #fff;
        }

        .text-center {
            justify-content: center;
        }

        .ui.login-div {
            margin: 30px 0 0 0;
        }
    </style>

</head>
<body class="">
<div class="ui login-header">
    <div class="ui grid">
        <div class="row header-row1"></div>
        <div class="row text-center" style="justify-content:center">
            <h1 class="ui header white">
                <i class="settings icon"></i>
                my-app-龙泽-内容后台管理
            </h1>
        </div>
    </div>
</div>
<div class="ui three column stackable grid login-div">
    <div class="column"></div>
    <div class="column">
        <form id="login" class="ui fluid form segment" action="customLogin" method="post">
            <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>

            <div class="field">
                <label class="">用户名</label>

                <div class="ui left icon input">
                    <input type="text" name="username" placeholder="">
                    <i class="user icon"></i>

                    <div class="ui corner label">
                        <i class="icon asterisk"></i>
                    </div>
                </div>
            </div>
            <div class="field">
                <label class="">密码</label>

                <div class="ui left icon input">
                    <input type="password" name="password" placeholder="">
                    <i class="lock icon"></i>

                    <div class="ui corner label">
                        <i class="icon asterisk"></i>
                    </div>
                </div>
            </div>
            <div class="inline field">
                <h4 class="ui red header">${sessionScope["failure_msg"]}</h4>
            </div>
            <%--<div class="inline field">--%>
            <%--<div class="ui checkbox">--%>
            <%--<input type="checkbox" name="terms">--%>
            <%--<label>记住密码</label>--%>
            <%--</div>--%>
            <%--</div>--%>
            <div class="inline field">
                <div class="ui blue submit button">登录</div>
            </div>

        </form>
    </div>
    <div class="column"></div>
</div>
</body>
</html>
