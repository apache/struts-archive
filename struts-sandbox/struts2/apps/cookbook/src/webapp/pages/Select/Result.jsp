<%@ taglib prefix="ww" uri="/webwork" %>
<html>
<head>
    <title>Cookbook - Complex Input Form using Select Controls</title>
    <link rel="stylesheet" type="text/css" href="<ww:url value="/css/cookbook.css" />">
</head>

<body>
<ww:include value="/header-result.jsp"/>

<h1>Input Result</h1>
<table>
    <ww:label label="Name" name="name"/>
    <ww:label label="Birthday" name="birthday"/>
    <ww:label label="Biography" name="bio"/>
    <ww:label label="Favourite Color" name="favouriteColor"/>
    <ww:label label="Friends" name="friends"/>
    <ww:label label="Legal Age" name="legalAge"/>
    <ww:label label="Region" name="region"/>
    <ww:label label="State" name="state"/>
    <ww:label label="Picture" name="picture"/>
    <ww:label label="Favourite Language" name="favouriteLanguage"/>
    <ww:label label="Favourite Vehical Type" name="favouriteVehicalType"/>
    <ww:label label="Favourite Vehical Specific" name="favouriteVehicalSpecific"/>
    <tr>
        <td>Favourite Cartoon Characters (Left):</td>
        <td>
            <ww:iterator value="leftSideCartoonCharacters" status="stat">
                <ww:property value="%{#stat.count}"/>.<ww:property value="top"/>&nbsp;
            </ww:iterator>
        </td>
    </tr>
    <tr>
        <td>Favourite Cartoon Characters (Right):</td>
        <td>
            <ww:iterator value="rightSideCartoonCharacters" status="stat">
                <ww:property value="%{#stat.count}"/>.<ww:property value="top"/>&nbsp;
            </ww:iterator>
        </td>
    </tr>
</table>

</body>
</html>
