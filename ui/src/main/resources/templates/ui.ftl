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
            <td>ID</td>
            <td>Name</td>
        </tr>
    </thead>

    <tbody>
        <#list dramas as drama>
        <tr>
            <td>${drama.id}</td>
            <td>${drama.name}</td>
        </tr>
        </#list>
    </tbody>
</table>
</body>
</html>