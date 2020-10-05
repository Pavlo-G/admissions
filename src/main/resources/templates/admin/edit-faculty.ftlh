<#import "../fragments/error-login.ftl" as error/>
<!doctype html>
<html lang="en">
<head>
    <#include "../fragments/bootsrap-links.ftl"/>

    <title>Faculty Edit</title>
</head>
<body>

<#include "../fragments/nav-bar.ftl" />
<br>
<main class="registration-form">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header">Create new faculty</div>
                    <div class="card-body">
                        <@error.error_login/>
                        <form action="/admin/faculty/edit/${faculty.getId()}" method="POST">

                            <div class="form-group row">
                                <label for="name" class="col-md-4 col-form-label text-md-right">Faculty Name </label>
                                <div class="col-md-6">
                                    <input type="text" id="name" class="form-control" name="name" value="${faculty.getName()}"
                                           required autofocus>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="description" class="col-md-4 col-form-label text-md-right">Description</label>
                                <div class="col-md-6">
                                    <input type="text" id="description" class="form-control" name="description" value="${faculty.getDescription()}" required>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="budgetCapacity" class="col-md-4 col-form-label text-md-right"> Budget Capacity </label>
                                <div class="col-md-6">
                                    <input type="number" id="budgetCapacity" class="form-control" name="budgetCapacity" value="${faculty.getBudgetCapacity()}"
                                           required >
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="totalCapacity" class="col-md-4 col-form-label text-md-right">Total Capacity</label>
                                <div class="col-md-6">
                                    <input type="number" id="totalCapacity" class="form-control" name="totalCapacity" value="${faculty.getTotalCapacity()}" required>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="requiredSubject1" class="col-md-4 col-form-label text-md-right">Required Subject1 </label>
                                <div class="col-md-6">
                                    <input type="text" id="requiredSubject1" class="form-control" name="requiredSubject1"  value="${faculty.getRequiredSubject1()} "required>
                                </div>
                            </div>


                            <div class="form-group row">
                                <label for="requiredSubject2" class="col-md-4 col-form-label text-md-right">Required Subject2 </label>
                                <div class="col-md-6">
                                    <input type="text" id="requiredSubject2" class="form-control" name="requiredSubject2" value="${faculty.getRequiredSubject2()} " required>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="requiredSubject3" class="col-md-4 col-form-label text-md-right">Required Subject3 </label>
                                <div class="col-md-6">
                                    <input type="text" id="requiredSubject3" class="form-control" name="requiredSubject3" value="${faculty.getRequiredSubject3()} " required>
                                </div>
                            </div>



                            <div class="col-md-6 offset-md-4">
                                <button type="submit" class="btn btn-primary">
                                  Save
                                </button>
                            </div>

                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</main>


</body>
</html>

</body>
</html>