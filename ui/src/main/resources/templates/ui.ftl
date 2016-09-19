<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>UI</title>

    <link rel="stylesheet" href="/webjars/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="/webjars/jquery/1.11.3/jquery.min.js"></script>
    <script src="/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>

<body>
<table class="table table-striped table-bordered table-hover">
    <thead>
        <tr>
            <td>操作数 (L)</td>
            <td>运算符</td>
            <td>操作数 (R)</td>
            <td>结果</td>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>${left}</td>
            <td>+</td>
            <td>${right}</td>
            <td>${add}</td>
        </tr>
        <tr>
            <td>${left}</td>
            <td>-</td>
            <td>${right}</td>
            <td>${minus}</td>
        </tr>
        <tr>
            <td>${left}</td>
            <td>*</td>
            <td>${right}</td>
            <td>${time}</td>
        </tr>
        <tr>
            <td>${left}</td>
            <td>/</td>
            <td>${right}</td>
            <td>${div}</td>
        </tr>
        <tr>
            <td>${left}</td>
            <td>%</td>
            <td>${right}</td>
            <td>${mod}</td>
        </tr>
    </tbody>
</table>
</body>
</html>