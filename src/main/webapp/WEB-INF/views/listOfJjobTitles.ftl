<!DOCTYPE html>
<html>
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
    <#list list_of_job_titles as job_title>
        <tr>
            <td>${job_title.id}</td>
            <td>${job_title.job_title_name}</td>
        </tr>
    </#list>
</table>
<br>
<a href="http://localhost:8080/"> Go back </a>
</body>
</html>
