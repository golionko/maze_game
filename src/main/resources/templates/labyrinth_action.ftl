<!doctype html>
<html lang="${.locale?replace('_', '-')}">
<#include "./partials/head.ftl">
<body>
<#include "./partials/header.ftl">
    <div class ="container">

        <div class="sidebar-left">
        </div>

        <div class="sidebar-right">
        </div>

        <h1>Labyrinth ${action}!!</h1>
        <p>Id: ${labyrinth.id}, Name: ${labyrinth.name}</p>

    </div>
<#include "./partials/footer.ftl">
</body>
</html>