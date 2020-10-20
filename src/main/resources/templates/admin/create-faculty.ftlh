<#import "../fragments/errors.ftlh" as errors/>
<!doctype html>
<html lang="en">
<head>
    <#include "../fragments/bootsrap-links.ftl"/>

    <title>Login</title>
</head>
<body>

<#include "../fragments/nav-bar.ftl" />
<br>
<main class="registration-form">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header"><@spring.message "admin.create_new_faculty"/></div>
                    <div class="card-body">
                        <@errors.errors/>
                        <form action="/admin/faculty/add" method="POST">
                            <div class="form-group row">
                                <label for="nameEn" class="col-md-4 col-form-label text-md-right"><@spring.message "faculty.name.en"/></label>
                                <div class="col-md-6">
                                    <input type="text" id="nameEn" class="form-control" name="nameEn"
                                           required autofocus>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="nameUk" class="col-md-4 col-form-label text-md-right"><@spring.message "faculty.name.uk"/></label>
                                <div class="col-md-6">
                                    <input type="text" id="nameUk" class="form-control" name="nameUk"
                                           required autofocus>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="descriptionEn" class="col-md-4 col-form-label text-md-right"><@spring.message "faculty.description.en"/></label>
                                <div class="col-md-6">
                                    <input type="text" id="descriptionEn" class="form-control" name="descriptionEn">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="descriptionUk" class="col-md-4 col-form-label text-md-right"><@spring.message "faculty.name.uk"/></label>
                                <div class="col-md-6">
                                    <input type="text" id="descriptionUk" class="form-control" name="descriptionUk">
                                </div>
                            </div>



                            <div class="form-group row">
                                <label for="budgetCapacity" class="col-md-4 col-form-label text-md-right"> <@spring.message "faculty.budget_capacity"/> </label>
                                <div class="col-md-6">
                                    <input type="number" id="budgetCapacity" class="form-control" name="budgetCapacity"
                                           required >
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="totalCapacity" class="col-md-4 col-form-label text-md-right"><@spring.message "faculty.total_capacity"/></label>
                                <div class="col-md-6">
                                    <input type="number" id="totalCapacity" class="form-control" name="totalCapacity" required>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="requiredSubject1En" class="col-md-4 col-form-label text-md-right"><@spring.message "faculty.required_subject1_en"/> </label>
                                <div class="col-md-6">
                                    <input type="text" id="requiredSubject1En" class="form-control" name="requiredSubject1En" required>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="requiredSubject1Uk" class="col-md-4 col-form-label text-md-right"><@spring.message "faculty.required_subject1_uk"/> </label>
                                <div class="col-md-6">
                                    <input type="text" id="requiredSubject1Uk" class="form-control" name="requiredSubject1Uk" required>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="requiredSubject2En" class="col-md-4 col-form-label text-md-right"><@spring.message "faculty.required_subject2_en"/> </label>
                                <div class="col-md-6">
                                    <input type="text" id="requiredSubject2En" class="form-control" name="requiredSubject2En" required>
                                </div>
                            </div>


                            <div class="form-group row">
                                <label for="requiredSubject2Uk" class="col-md-4 col-form-label text-md-right"><@spring.message "faculty.required_subject2_uk"/> </label>
                                <div class="col-md-6">
                                    <input type="text" id="requiredSubject2Uk" class="form-control" name="requiredSubject2Uk" required>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="requiredSubject3En" class="col-md-4 col-form-label text-md-right"><@spring.message "faculty.required_subject3_en"/> </label>
                                <div class="col-md-6">
                                    <input type="text" id="requiredSubject3En" class="form-control" name="requiredSubject3En" required>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="requiredSubject3Uk" class="col-md-4 col-form-label text-md-right"><@spring.message "faculty.required_subject3_uk"/> </label>
                                <div class="col-md-6">
                                    <input type="text" id="requiredSubject3UK" class="form-control" name="requiredSubject3Uk" required>
                                </div>
                            </div>



                            <div class="col-md-6 offset-md-4">
                                <button type="submit" class="btn btn-primary">
                                    <@spring.message "faculty.create"/>
                                </button>
                            </div>

                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</main>

<#include "../fragments/footer.ftlh" />
</body>
</html>

</body>
</html>