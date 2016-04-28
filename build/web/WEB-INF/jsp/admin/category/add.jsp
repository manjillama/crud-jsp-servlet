<%@include file="../header.jsp" %>
<div class="page-title">
    <h2>Add Category</h2>
</div>

<form role="form" method="post" action="${pageContext.request.contextPath}/Admin/Category/Add">
    <label>Name</label>
    <input type="text" name="name" placeholder="Enter Category Name" required="required" class="form-control"/>
    
    <label>Description</label>
    <textarea name="description" placeholder="Enter Category Description" required="required" class="form-control" style="height:150px"></textarea>
    <div class="checkbox">
        <label>
            Status
        </label>
        <label><input type="checkbox" name="status" value="1"/> Active </label>
    </div>
    <a href="${pageContext.request.contextPath}/Admin/Category" class="btn btn-sm btn-danger"><span class="glyphicon glyphicon-arrow-left"></span>Back</a>
    
    <button type="submit" class="btn btn-sm btn-success">
        <span class="glyphicon glyphicon-disk"></span> Save
    </button>
        
</form>

<%@include file="../footer.jsp" %>