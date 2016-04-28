<%@include file="../header.jsp" %>
<div class="page-title">
    <h2>Edit Category</h2>
</div>

<form role="form" method="post" action="${pageContext.request.contextPath}/Admin/Category/Edit">
    <label>Name</label>
    <input type="text" name="name" placeholder="Enter Category Name" required="required" class="form-control" value="${requestScope.category.name}"/>
    
    <label>Description</label>
    <textarea name="description" placeholder="Enter Category Description" required="required" class="form-control" style="height:150px">${requestScope.category.description}</textarea>
    <div class="checkbox">
        <label>
            Status
        </label>
        <label><input type="checkbox" name="status" value="1" <c:if test="${requestScope.category.status==true}">checked="checked"</c:if> /> Active </label>
    </div>
    <a href="${pageContext.request.contextPath}/Admin/Category" class="btn btn-sm btn-danger"><span class="glyphicon glyphicon-arrow-left"></span>Back</a>
    <input type="hidden" name="id" value="${requestScope.category.id}"/>
    <button type="submit" class="btn btn-sm btn-success">
        <span class="glyphicon glyphicon-disk"></span> Save
    </button>
        
</form>

<%@include file="../footer.jsp" %>