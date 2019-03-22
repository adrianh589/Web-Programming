<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<title>Y Combinator: Bookmarklet</title>
</head>

<body bgcolor=#ffffff>
<center>
<br><br>
<table width=500 cellpadding=0>
<tr><td bgcolor=#fafaf0>
<a href="mainMenu.jsp"><img src="img/yc500.gif" border=0 width=500 height=100></a>
<br><br>
<b>Bookmarklet</b>
<br><br>
<div id="main">

<p id="first">
Thanks to Phil Kast for writing this bookmarklet for submitting
links to <a href="mainMenu.jsp">Hacker News</a>.
When you click on the bookmarklet, it will submit the page you're on.
To install, drag this link to your browser toolbar:
<br><br>
</p>
<center>
<!-- <div style="margin: auto; padding: 16px; width: 30%; background: #f7f7f7;">
-->
<a style="color: #777; font-size: 2em;" rel="nofollow" href="javascript:window.location=%22http://news.ycombinator.com/submitlink?u=%22+encodeURIComponent(document.location)+%22&t=%22+encodeURIComponent(document.title)">post to HN</a>
<!-- </div> -->
</center>

<br><br>
<table width=100% bgcolor=#ff6600 cellpadding=0><tr><td></td></tr></table>

<p align=center>
<span class=foot>

<br><br>
</span>
</td></tr></table>
</center>
</body>