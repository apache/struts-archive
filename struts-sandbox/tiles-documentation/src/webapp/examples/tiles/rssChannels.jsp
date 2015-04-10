<%--
/**
 * Summarize channels as unadorned HTML.
 *
 * @param CHANNELS List of channels
 * @version $Revision: 1.2 $ $Date$
 */
--%>

<%@ page language="java" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<div align="center"><font size="+1"><b>

<tiles:importAttribute name="CHANNELS" scope="page"/>

<logic:iterate name="CHANNELS" id="CHANNEL" >
<TABLE border="0" cellspacing="0" cellpadding="4" width="100%" align="center" >
<TR>
<TD class="spanhd" ><logic:present name="CHANNEL" property="image">
  <a href="<bean:write name="CHANNEL" property="link"/>">
    <img src="<bean:write name="CHANNEL" property="image.URL"/>"></logic:present></a>
</TD>
<TD class="spanhd" width="100%"><bean:write name="CHANNEL" property="title"/> <a href="<bean:write name="CHANNEL" property="link"/>">[home]</a></TD>
</TR>
<TD class="yellow" colspan="2"><bean:write name="CHANNEL" property="description"/></TD>
</TR>

<TR>
<TD class="datagrey" colspan="2">
<logic:iterate name="CHANNEL" property="items" id="ITEM">
<br><b><bean:write name="ITEM" property="title"/></b>
<br><bean:write name="ITEM" property="description"/>
<br>&nbsp;&nbsp;[ <a href="<bean:write name="ITEM" property="link"/>">more</a> ]
<br>
</logic:iterate>
</TD>
</TR>
</TABLE>
<br>
</logic:iterate>

</b></font></div>
