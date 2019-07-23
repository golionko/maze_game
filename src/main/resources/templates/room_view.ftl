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
                <form method="post" action="/avatar/${roomView.avatarId}/move/${gridRoomKey}" class="inline">
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