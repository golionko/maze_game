<!doctype html>
<html lang="${.locale?replace('_', '-')}">
<#include "./partials/head.ftl">
<body>
<#include "./partials/header.ftl">
<div class ="index-container">
    <div class="sidebar-left">
    </div>

    <div class="main-page">
        <h2>Add new item:</h2>
        <form method="post" action="/item">
            <label>
                <textarea rows="50" cols="200" name="data"></textarea>
            </label><br>
            <button type="submit" class="link-button">
               Submit
            </button>
        </form>
    </div>
    <div class="sidebar-right">
    </div>
</div>
<#include "./partials/footer.ftl">
</body>
</html>