<!doctype html>
<html lang="${.locale?replace('_', '-')}">
<#include "./partials/head.ftl">
<body>
        <#include "./partials/header.ftl">
        <div class ="index-container">

            <div class="sidebar-left">
            </div>

            <div class="main-page">
                <#if user??>
                    <div id="avatars-table" >
                        <h4>${user.name}s avatars:</h4>
                        <table style="width:50%">
                            <tr>
                                <th>Id</th>
                                <th>Name</th>
                                <th>Level</th>
                            </tr>
                            <#list user.avatars as avatar>
                                <tr>
                                    <td>${avatar.id}</td>
                                    <td><a href="/avatar/${avatar.id}">${avatar.name}</a></td>
                                    <td>${avatar.level}</td>
                                </tr>
                            </#list>
                        </table>
                    </div>
                </#if>
            </div>
            <div class="sidebar-right">
            </div>
        </div>
        <#include "./partials/footer.ftl">
</body>
</html>