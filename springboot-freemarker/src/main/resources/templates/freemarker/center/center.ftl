<html lang="zh-CN">
<head>
    <meta charset="UTF-8"/>
    <title>${title}</title>
    <style>
        table {
            width: 50%;
            font-size: .938em;
            border-collapse: collapse;/*边框合并*/
        }
        th {
            text-align: left;
            padding: .5em .5em;
            font-weight: bold;
            background: #66677c;color: #fff;
        }

        td {
            padding: .5em .5em;
            border-bottom: solid 1px #ccc;
        }

        table,table tr th, table tr td { border:1px solid #0094ff; }/*设置边框*/
    </style>
</head>
<body>
<table>
    <tr>
        <th>姓名</th>
        <th>年龄</th>
        <th>电话</th>
    </tr>
        <#list users as user>
            <tr>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.phone}</td>
            </tr>
        </#list>
</table>
</body>
</html>
