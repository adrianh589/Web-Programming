<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html op="submit">
<head>
<meta name="referrer" content="origin">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="../css/styles.css">
<link rel="shortcut icon" href="../img/y18.gif">
<title>Submit | Hacker News</title>
</head>
<body>
	<center>
		<table id="hnmain" border="0" cellpadding="0" cellspacing="0"
			width="85%" bgcolor="#f6f6ef">
			<tr>
				<td bgcolor="#ff6600"><table border="0" cellpadding="0"
						cellspacing="0" width="100%" style="padding: 2px">
						<tr>
							<td style="width: 18px; padding-right: 4px"><a
								href="https://news.ycombinator.com"><img src="../img/y18.gif"
									width="18" height="18" style="border: 1px #ffffff solid;"></a></td>
							<td style="line-height: 12pt; height: 10px;"><span
								class="pagetop"><b>Submit</b></span></td>
						</tr>
					</table></td>
			</tr>
			<tr style="height: 10px"></tr>
			<tr>
				<td><form method="get" action="../../publicacion">
						<input type="hidden" name="fnid" value="2pt8uABk1Oh8znE73bPA9c"><input
							type="hidden" name="fnop" value="submit-page">
						<script type="text/javascript">
							function tlen(el) {
								var n = el.value.length - 80;
								el.nextSibling.innerText = n > 0 ? n
										+ ' too long' : '';
							}
						</script>
						<table border="0">
							<tr>
								<td>title</td>
								<td><input type="text" name="title" value="" size="50"
									oninput="tlen(this)" onfocus="tlen(this)" required><span
									style="margin-left: 10px"></span></td>
							</tr>
							<tr>
								<td>url</td>
								<td><input type="text" name="url" value="" size="50"></td>
							</tr>
							<tr>
								<td></td>
								<td><b>or</b></td>
							</tr>
							<tr>
								<td>text</td>
								<td><textarea name="text" rows="4" cols="49"></textarea></td>
							</tr>
							<tr>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td></td>
								<td><input type="submit" value="submit"></td>
							</tr>
							<tr style="height: 20px"></tr>
							<tr>
								<td></td>
								<td>Leave url blank to submit a question for discussion. If
									there is no url, the text (if any) will appear at the top of
									the thread.<br>
								<br> You can also submit via <a href="bookmarklet.html"
									rel="nofollow"><u>bookmarklet</u></a>.
								</td>
							</tr>
						</table>
					</form></td>
			</tr>
		</table>
	</center>
</body>
</html>