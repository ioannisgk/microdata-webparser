<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${type == 'microdata'}">
${htmlCode}
</c:if>
<c:if test="${type == 'rdfa'}">
<xmp>${htmlCode}</xmp>
</c:if>
<c:if test="${type == 'jsonld'}">
<xmp>${htmlCode}</xmp>
</c:if>