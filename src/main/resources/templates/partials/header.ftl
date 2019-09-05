<header>
    <a href="#" class="logo"></a>
    <nav>
        <ul class="main-nav">
            <li><a href="/admin/items">Admin-Items</a></li>
            <li><a href="#">Link 2</a></li>
            <li><a href="#">Link 3</a></li>
            <li><a href="#">Link 4</a></li>
            <#if user??>
                <li class="push"><a href="/logout">Log Out</a></li>
            <#else>
                <li class="push"><a href="/login">Log In</a></li>
            </#if>
        </ul>
    </nav>
</header>