<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>


<%-- 
  This example insert a definition defined in another jsp file.
  First, it include jsp file containing definition.
  Second, it do an insert where it want the definition to be rendered.
--%>

<%@ include file="definitionsConfig.jsp" %>

<tiles:insert beanName="masterLayout" beanScope="request" />

