<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/static/layui/css/layui.css"/>
    <script src="/static/layui/layui.js"></script>
</head>

<!--修改的表单-->
<div  id="updateDiv">
    <form class="layui-form" action="/doLogin1" lay-filter="dataFrm" id="dataFrm">
        <div class="layui-form-item">
            <label class="layui-form-label">用户名:</label>
            <div class="layui-input-block">
                <input type="text" name="username" placeholder="请输入用户名" autocomplete="off"
                       class="layui-input"><span style="color: red;">${error}</span>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码:</label>
            <div class="layui-input-block">
                <input type="password" name="password" placeholder="请输入密码" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"></label>
            <div class="layui-input-block">
                <input type="checkbox" name="rememberMe" value="true" title="记住我">
            </div>
        </div>


        <div class="layui-form-item" style="text-align: center;">
            <div class="layui-input-block">
                <input type="submit" class="layui-btn layui-btn-normal layui-btn-sm layui-icon layui-icon-release"
                        lay-filter="doSubmit" value="提交" lay-submit="提交">
                </input>
                <button type="reset" class="layui-btn layui-btn-warm layui-btn-sm layui-icon layui-icon-refresh">重置
                </button>
            </div>
        </div>
    </form>

</div>


<!--2.编写js，通过异步请求去查数据
    layui通过table组件，把数据封装到页面的表格中
-->
<script>
    //导入table组件   easyUI  bootstrap-table
    //内置jquery
    layui.use(["layer","jquery","form",],function(){
        var layer = layui.layer;//弹出框组件
        var $ = layui.jquery;//jquery组件
        var form = layui.form;//表单组件
        //监听提交表单   lay-filter="doSubmit"
    });
</script>
</body>
</html>
