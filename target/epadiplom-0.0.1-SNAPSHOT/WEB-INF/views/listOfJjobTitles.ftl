<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Job titles</title>
</head>
<body>
<h1>Job titles list</h1>
<table>
    <tr>
        <th>Id</th>
        <th>Name of title</th>
    </tr>
    <#list job_title as job_title>
        <tr>
            <td><a href="/job_title/${job_title.id}">${job_title.id}</a></td>
            <td>${job_title.job_title_name}</td>
        </tr>
    </#list>
    <a href="http://localhost:8080/"> Go back </a>
</table>
</body>
</html>