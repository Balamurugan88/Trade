<%-- 
    Document   : add
    Created on : Feb 20, 2017, 8:28:32 PM
    Author     : VISALI V
--%>
<div class="text-left heading col-sm-12">Add Category</div>
<form  id="addForm" name="addForm" method="post" action="<%=request.getContextPath()%>/category/saveUpdate">
    <input type="hidden" name="articleCode" value="${category.articleCode}"/>
    <div class="form-group col-sm-8">
        <label for="name">Category</label>
        <input value="${category.name}" type="text" class="form-control" id="name" name="name" required maxlength="20">
    </div>
    <div style="clear:both;"></div>
    <div class="col-sm-2">
        <input type="submit" class="btn btn-default" value="Submit"/>
    </div>
</form>
<script type="text/javascript">
    $(document).ready(function () {
        $("#addForm").validate();
    });
</script>    

