<!doctype html>
<html lang="${.locale?replace('_', '-')}">
<#include "./partials/head.ftl">
<body>
    <#include "./partials/header.ftl">
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

    <#include "./partials/footer.ftl">
</body>
</html>