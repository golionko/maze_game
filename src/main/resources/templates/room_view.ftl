<!doctype html>
<html lang="${.locale?replace('_', '-')}">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Maze</title>
    <meta name="description" content="Find your way out.">
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />
</head>

<body>
    <header>
        <a href="#" class="logo"></a>
        <nav>
            <ul class="main-nav">
                <li><a href="#">Link 1</a></li>
                <li><a href="#">Link 2</a></li>
                <li><a href="#">Link 3</a></li>
                <li><a href="#">Link 4</a></li>
                <li class="push"><a href="#">Log In</a></li>
            </ul>
        </nav>
    </header>

    <div class ="container">

        <div class="sidebar-left">
            <h2>Character Stats:</h2>
            <p>User Id: ${roomView.avatar.id}</p>
            <p>Name: ${roomView.avatar.name}</p>
            <p>XP: ${roomView.avatar.xp}</p>
            <p>HP: ${roomView.avatar.hp}</p>
            <p>Energy: ${roomView.avatar.energy}</p>
            <p>Level: ${roomView.avatar.level}</p>
            <p>Strength: ${roomView.avatar.strength}</p>
            <p>Dexterity: ${roomView.avatar.dexterity}</p>
            <p>Luck: ${roomView.avatar.luck}</p>
            <p>Constitution: ${roomView.avatar.constitution}</p>

        </div>

        <div class="sidebar-right">
        </div>


        <#assign gridRoom = roomView.room >
        <div class="room room-in" style="border: 10px solid ${gridRoom.roomColor?lower_case}">
            <h2>Room Data:</h2>
            <p>Location: (${gridRoom.XLocation}, ${gridRoom.YLocation}, ${gridRoom.ZLocation})</p>
            <p>Origin: (${gridRoom.XOrigin}, ${gridRoom.YOrigin}, ${gridRoom.ZOrigin})</p>
            <p>Color: ${gridRoom.roomColor}</p>
        </div>

        <#list roomView.surroundingRooms?keys as gridRoomKey>
            <#assign gridRoom = roomView.surroundingRooms[gridRoomKey] >
            <div class="room room-${gridRoomKey?lower_case}" style="border: 10px solid ${gridRoom.roomColor?lower_case}">
                <h2>${gridRoomKey?lower_case}:</h2>
                <p>Location: (${gridRoom.XLocation}, ${gridRoom.YLocation}, ${gridRoom.ZLocation})</p>
                <p>Origin: (${gridRoom.XOrigin}, ${gridRoom.YOrigin}, ${gridRoom.ZOrigin})</p>
                <p>Color: ${gridRoom.roomColor}</p>
                <form method="post" action="/avatar/${roomView.avatar.id}/move/${gridRoomKey}" class="inline">
                    <button type="submit" class="link-button">
                        Move Here
                    </button>
                </form>
            </div>
        </#list>
    </div>

    <footer>Made by golionko</footer>
</body>
</html>