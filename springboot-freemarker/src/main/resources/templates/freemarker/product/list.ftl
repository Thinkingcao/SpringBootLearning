<html lang="zh-CN">
<head>
    <meta charset="UTF-8"/>
    <title>FreeMarker展示list数据</title>
</head>
<body>
<table cellspacing="3" cellpadding="2" border="1" align="left">
    <tr>
        <td>商品编号</td>
        <td>商品名称</td>
        <td>商品描述</td>
        <td>商品价格</td>
        <td>商品数量</td>
    </tr>
    <#list productList as product>
    <tr>
        <td>${product.productNo}</td>
        <td>${product.productName}</td>
        <td>${product.productDesc}</td>
        <td>${product.productPrice}</td>
        <td>${product.productNum}</td>
        </#list>
    </tr>
</table>
</body>
</html>
