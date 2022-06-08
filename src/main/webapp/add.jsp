
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление медикамента</title>
    <style>
        body {background-color: #64e7f7;}
        h1   {color: #1515eb; font-size: 70px; font-style: oblique;
            font-family: "Century Gothic"; text-align: center}
        h2 {color: #e2270f; font-style: oblique;
            font-family: "Century Gothic"; text-align: center;
            font-size: 50px
        }

    </style>
</head>
<link href="/css/styles.css" rel="stylesheet" type="text/css">
<body>
<h1>Добавление медикамента</h1>

    <div class="form-style-6">
        <form method="post" action="/list">
            <input type="text" name="name" required placeholder="Название медикамента" />
            <input type="text" name="date" required placeholder="Срок годности (дд.мм.гггг)" />
            <input type="submit" value="Отправить" />
        </form>
    </div>

</body>
</html>
