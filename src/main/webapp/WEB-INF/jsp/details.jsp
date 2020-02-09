<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hello ${name}!</title>
    <link href="/css/main.css" rel="stylesheet">
</head>
<body>
    <h1>View details for:</h1>
    <form action="getdetails" method="post">
        <input type="number" name="instruktor_id">
        <input type="submit" value="Find">
    </form>
</body>
</html>