<%@ tag language="java" pageEncoding="ISO-8859-1"%>

<%@ attribute name="code" required="true" rtexprvalue="true" %>
<%@ attribute name="width" required="true" rtexprvalue="true" %>
<%@ attribute name="height" required="true" rtexprvalue="true" %>

<table>
<tr><td align="center">
<object style="height: ${height}px; width: ${width}px">
	<param name="movie" value="http://www.youtube.com/v/${code}">
	<param name="allowFullScreen" value="true">
	<param name="allowScriptAccess" value="always">
	<embed src="http://www.youtube.com/v/${code}" 
		type="application/x-shockwave-flash" 
		allowfullscreen="true" 
		allowScriptAccess="always" 
		width="${width}" 
		height="${height}">
</object>
</td></tr>
<tr><td align="center">
<jsp:doBody />
</td></tr>
</table>