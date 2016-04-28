<%@include file="../header.jsp" %>
        <h1>Categories</h1>
        <div class="pull-right">
            <p><a href="${pageContext.request.contextPath}/Admin/Category/Add" class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-plus"></span></a></p>
        </div>
        
        <select name="category_id">
            <option value="">Select Category</option>
            <c:forEach var="category" items="${requestScope.categories}">
                <option value="${category.id}">${category.name}</option>
            </c:forEach>
        </select>
        <table class="table table-bordered table-striped table-hover">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Description</th>
                <th>Added Date</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
            
            
            
            <c:forEach var="category" items="${requestScope.categories}">
                <tr>
                    <td>${category.id}</td>
                    <td>${category.name}</td>
                    <td>${category.description}</td>
                    <td>${category.addedDate}</td>
                    <td>
                        <c:choose>
                            <c:when test="${category.status==true}">
                                <span class="label label-success">Active</span>
                            </c:when>
                            <c:otherwise>
                                <span class="label label-danger">Inactive</span>
                            </c:otherwise>    
                        </c:choose>
                        
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/Admin/Category/Edit?id=${category.id}" class="btn btn-success btn-sm"><span class="glyphicon glyphicon-pencil"></span></a>
                        <a href="${pageContext.request.contextPath}/Admin/Category/Delete?id=${category.id}" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure to delete?')"><span class="glyphicon glyphicon-trash"></span></a>
                    </td>
                </tr>
            </c:forEach>
            
        </table>
<%@include file="../footer.jsp" %>
