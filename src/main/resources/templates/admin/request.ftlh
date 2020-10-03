
<head>
    <#include "../fragments/bootsrap-links.ftl"/>
    <link rel="stylesheet" href="css/stylesheet.css">
<title>Request Approval form</title>
</head>


<body>
<#include "../fragments/nav-bar.ftl" />
<br>

<div class="container">
    <div class="row">
        <h2 class="text-danger">Approve Request</h2>


        <table class="table table-bordered success">
            <thead>
            <tr>
                <th>Full Name</th>
                <td>${request.candidate.getUsername()}</td>
            </tr>
            <tr>
                <th class="info">Address</th>
                <td>addres</td>
            </tr>
            <tr>
                <th class="info">Email</th>
                <td>>${request.candidate.getEmail()}</td>
            </tr>
            <tr>
                <th class="info">Contact</th>
                <td>+91 9999955555</td>
            </tr>

            <tr>
                <th class="info">State</th>
                <td>Maharashtra</td>
            </tr>
            <tr>
                <th class="info">City</th>
                <td>Pune</td>
            </tr>
            <tr>
                <th class="info">Service List</th>
                <td>Service 1 , Service 2 , Serive 3</td>
            </tr>
            <tr>
                <th valign="top" class="info">Machine</th>
                <td>Machine1 , Machine2 , Machine3</td>
            </tr>
            <tr>
                <th class="info">Brand</th>
                <td>Audi</td>
            </tr>
            <tr>
                <th class="info">Specialization</th>
                <td>Lorem Ipsum that is dollor sign to write</td>
            </tr>

            <tr>
                <th class="info">Approval Status</th>
                <td><b>Active</b></td>
            </tr>

            <tr>
                <th class="info bg-info">Approval Date</th>
                <td class="bg-primary">14/12/2018</td>
            </tr>
            <tr>
                <th class="info bg-primary">Register Date</th>
                <td class="bg-info">10/12/2018 12:00:45</td>
            </tr>
            <tr>

                <form>

                    <th class="info">Action To Approval</th>
                    <td><select id="approv_status" name="approv_status" class="form-control">
                            <option value="">Select</option>
                            <option value="active"><b>Active</b></option>
                            <option value="inactive"><b>Inactive</b></option>
                        </select></td>

            </tr>
            <tr>
                <th colspan="1"></th>
                <td>
                    <input type="hidden" name="hidden_id" id="hidden_id" value="<?php echo $value->id; ?>">
                    <input type="hidden" name="folder_name" id="folder_name" value="<?php echo $value->email; ?>">
                    <a href="<?php echo base_url()?>module_c/approval_manager/service_provider_display"
                       class="btn btn-warning">Back</a>
                    <input type="button" id="approve_btn" class="btn btn-info" name="approve_btn" value="Approve"></td>
                </form>
            </tr>
            </thead>

        </table>
    </div>
</div>
</body>