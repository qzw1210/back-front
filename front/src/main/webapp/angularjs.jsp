<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="userService">
<head>
    <meta http-equiv="Access-Control-Allow-Origin" content="*" charset=UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript" src="js/jquery-1.10.2.js"></script>
    <script type="text/javascript" src="js/angular.js"></script>
    <script type="text/javascript" src="js/angular-resource.js"></script>
    <script type="text/javascript" src="js/angular-my.js"></script>
    <style type="text/css"></style>
</head>
<body ng-controller="userController">
<div id="save"
     style="display: block; margin-left: auto; margin-right: auto;">
    <table>
        <tr style="display: none">
            <td>用户id</td>
            <td><input type="text" name="user.id" ng-model="saveUser.id"/></td>
        </tr>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="user.username"
                       ng-model="saveUser.username"/></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="user.password"
                       ng-model="saveUser.password"/></td>
        </tr>
        <tr>
            <td>用户姓名</td>
            <td><input type="text" name="user.cs"
                       ng-model="saveUser.realname"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="button" value="添加"
                                   ng-click="addUserClick()"/></td>
        </tr>
    </table>
</div>
<div id="userList" style="margin-left: auto; margin-right: auto;">
    <table border="1" style="margin-left: auto; margin-right: auto;">
        <tr>
            <th>序号</th>
            <th>用户id</th>
            <th>用户名称</th>
            <th>用户密码</th>
            <th>用户姓名</th>
            <th>用户操作</th>
        </tr>
        <tr ng-repeat="user in mydata" ng-class-even="'even'"
            ng-class-odd="'odd'">
            <td>{{$index + 1}}</td>
            <td>{{user.id}}</td>
            <td>{{user.username}}</td>
            <td>{{user.password}}</td>
            <td>{{user.realname}}</td>
            <td><a href="" ng-click="updateUser(user)">修改</a> &nbsp; <a
                    href="" ng-click="deleteUser(user)">删除</a></td>
        </tr>
    </table>
</div>
<div id="update"
     style="display: block; margin-left: auto; margin-right: auto;">
    <table>
        <tr style="display: none">
            <td>用户id</td>
            <td><input type="text" id="id" name="user.id"
                       ng-model="modifyUser.id"/></td>
        </tr>
        <tr>
            <td>用户名</td>
            <td><input type="text" id="username" name="user.username"
                       ng-model="modifyUser.username"/></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" id="password" name="user.password"
                       ng-model="modifyUser.password"/></td>
        </tr>
        <tr>
            <td>用户姓名</td>
            <td><input type="text" id="cs" name="user.cs"
                       ng-model="modifyUser.realname"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="button" value="更新"
                                   ng-click="updateUserClick()"/></td>
        </tr>
    </table>
</div>
</body>
</html>