<%-- 
    Document   : add
    Created on : Feb 20, 2017, 8:21:32 PM
    Author     : VISALI V
--%>

<div class="text-left heading col-sm-12">Add Customer</div>
<form  id="addForm" name="addForm" method="post" action="<%=request.getContextPath()%>/customer/saveUpdate">
    <input type="hidden" name="customerId" value="${customer.id}"/>
    <div class="form-group col-sm-8">
        <label for="name">Customer</label>
        <input value="${customer.name}" type="text" class="form-control" id="name" name="name" required maxlength="20">
    </div>
    <div class="form-group col-sm-8">
        <label for="desc">Dob</label>
        <input value="${customer.dob}" type="text" class="form-control" id="desc" name="dob" required maxlength="20">
    </div>
    <div class="form-group col-sm-8">
        <label for="desc">Email</label>
        <input value="${customer.email}" type="text" class="form-control" id="desc" name="email" required maxlength="20">
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

