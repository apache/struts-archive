<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>
        <s:text name="index.title"/>
    </title>
</head>

<body>
<h3>MailReader Options</h3>

<ul>
    <li><a href="<s:url action="Register!input"/>">
        <s:text
                name="index.registration"/>
    </a></li>
    <li><a href="<s:url action="Login!input"/>">
        <s:text
                name="index.login"/>
    </a></li>
</ul>

<h3>Language Options</h3>
<ul>
    <li><a href="<s:url action="Welcome?request_locale=en"/>">English</a></li>
    <li><a href="<s:url action="Welcome?request_locale=ja"/>">Japanese</a></li>
    <li><a href="<s:url action="Welcome?request_locale=ru"/>">Russian</a></li>
</ul>

</body>
</html>

