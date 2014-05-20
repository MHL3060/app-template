<%@ include file="/common/taglibs.jsp"%>

<c:choose>
    <c:when test="${empty pageContext.request.remoteUser}">
        <c:redirect url="/login"/>
    </c:when>
    <c:otherwise>
        <c:redirect url="/home"/>
    </c:otherwise>
</c:choose>

