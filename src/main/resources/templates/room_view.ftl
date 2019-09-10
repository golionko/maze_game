<!doctype html>
<html lang="${.locale?replace('_', '-')}">
<#include "./partials/head.ftl">
<body>
    <#include "./partials/header.ftl">
    <div class ="container">
        <div class="sidebar-left">
            <div style="margin:10px; padding:10px; background-color: bisque">
                <h2><b>Character Stats:</b></h2>
                <p>User Id: ${roomView.avatar.id}</p>
                <p>Name: ${roomView.avatar.name}</p>
                <p>XP: ${roomView.avatar.xp}</p>
                <p>HP:</p>
                <div style="width: 100%; background-color: green;">
                    <div style="width: ${roomView.avatar.hp / roomView.avatar.maxHp * 100}%; height: 30px; background-color: red; text-align: center; line-height: 30px; color: white;"></div>
                </div>
                <p>Energy:</p>
                <div style="width: 100%; background-color: green;">
                    <div style="width: ${roomView.avatar.energy / roomView.avatar.maxEnergy * 100}%; height: 30px; background-color: blue; text-align: center; line-height: 30px; color: white;"></div>
                </div>
                <p>Level: ${roomView.avatar.level}</p>
                <p>Strength: ${roomView.avatar.strength}</p>
                <p>Dexterity: ${roomView.avatar.dexterity}</p>
                <p>Luck: ${roomView.avatar.luck}</p>
                <p>Constitution: ${roomView.avatar.constitution}</p>
            </div>
            <div>
                <h3>Equipped Items:</h3>
                <#list roomView.avatar.equipped as equipment>
                    <p>${equipment.item.name}</p>
                </#list>
            </div>
        </div>
        <div class="sidebar-right">
            <div>
                <h3>Creatures:</h3>
                <#list roomView.creatures as creature>
                    <p>${creature.name}</p>
                </#list>
            </div>
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