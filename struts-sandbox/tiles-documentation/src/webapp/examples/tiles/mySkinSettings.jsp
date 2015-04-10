<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>


<tiles:importAttribute name="catalog" />
<tiles:useAttribute name="selected" />

<html:form action="/mySkinSettings.do"  >


  
  
	  <ul>
	    <li>Current skin is highlighted.</li>
		<li>Select and validate to change skin</li>
		<li>Reload page to see result</li>
	  </ul>
  <table align="center">
  <tr>
    <td align="right">
	  Available Skins
	  <br>
	  <html:select property="selected" multiple="false" value="<%=(String)selected%>" >
	    <html:options name="catalog" property="keys" labelName="catalog" labelProperty="names" />
	  </html:select>

	</td>
    <td align="left">
      <html:submit property="validate" value="validate" /></div>
	</td>
  </tr>
  </table>
	  <ul>
	    <li>In the examples, only this page is affected by skin change. 
		</li>
		<li>It is possible to affect all pages by changing
		  root layout definition in configuration file.
		</li>
	  </ul>
  
  

  
</html:form>
