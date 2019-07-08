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
        <div class="top-nav">
            <div class="container">
                <a href="#" class="logo"></a>
                <nav>
                    <ul>
                        <li><a href="#">Link 1</a>
                            <ul>
                                <li><a href="#">Sub Link 1</a></li>
                                <li><a href="#">Sub Link 2</a></li>
                                <li><a href="#">Sub Link 3</a></li>
                                <li><a href="#">Sub Link 4</a></li>
                                <li><a href="#">Sub Link 5</a></li>
                            </ul>
                        </li>
                        <li><a href="#">Link 2</a></li>
                        <li><a href="#">Link 3</a>
                            <ul>
                                <li><a href="#">Sub Link 1</a></li>
                            </ul>
                        </li>
                        <li><a href="#">Link 4</a></li>
                        <li><a href="#">Link 5</a></li>
                    </ul>
                </nav>
            </div>
        </div>
        <section>
            <h1>Room Data:</h1>
            <p>Location: (${roomView.room.XLocation}, ${roomView.room.YLocation}, ${roomView.room.ZLocation})</p>
            <p>Origin: (${roomView.room.XOrigin}, ${roomView.room.YOrigin}, ${roomView.room.ZOrigin})</p>
            <p>Color: ${roomView.room.roomColor}</p>
        </section>
    </header>



    <footer>

    </footer>
</body>
</html>