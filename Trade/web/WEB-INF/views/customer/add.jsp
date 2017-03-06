<%-- 
    Document   : add
    Created on : Feb 20, 2017, 8:21:32 PM
    Author     : VISALI V
--%>

<div class="text-left heading col-sm-12">Add Customer</div>
<form  id="addForm" name="addForm" method="post" action="<%=request.getContextPath()%>/admin/customer/saveUpdate">
    <input type="hidden" name="id" value="${customer.id}"/>
    <div class="form-group col-sm-8">
        <label for="name">Customer*</label>
        <input value="${customer.name}" type="text" class="form-control" id="name" name="name" required maxlength="55">
    </div>
    <div class="form-group col-sm-8">
        <label for="desc">Dob*</label>
        <div class="input-group date" data-provide="datepicker">
            <input type="text" class="form-control" value="${customer.dob}" name="dob" readonly>
            <div class="input-group-addon">
                <span class="glyphicon glyphicon-th"></span>
            </div>
        </div>
    </div>
    <div class="form-group col-sm-8">
        <label for="desc">Email*</label>
        <input value="${customer.email}" type="text" class="form-control email" id="email" name="email" required maxlength="55">
    </div>
    <div style="clear:both;"></div>
    <div class="col-sm-2">
        <input type="submit" class="btn btn-default btn-primary" value="Submit"/>
    </div>
</form>
<script type="text/javascript">
    $(document).ready(function () {
        $("#addForm").validate();
        $("#dob").datepicker();
    });
</script>

