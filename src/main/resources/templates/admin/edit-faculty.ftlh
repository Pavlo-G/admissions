<#import "../fragments/error.ftl" as error/>
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
                    <div class="card-header"><@spring.message "admin.edit_faculty"/></div>
                    <div class="card-body">
                        <@error.error/>

                        <form action="/admin/faculty/edit/${faculty.getId()}" method="POST">


                            <div class="form-group row">
                                <label for="nameEn" class="col-md-4 col-form-label text-md-right"><@spring.message "faculty.name.en"/></label>
                                <div class="col-md-6">
                                    <input type="text" id="nameEn" class="form-control" name="nameEn"
                                           value="${faculty.getNameEn()}"
                                           required autofocus>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="nameUk" class="col-md-4 col-form-label text-md-right"><@spring.message "faculty.name.uk"/></label>
                                <div class="col-md-6">
                                    <input type="text" id="nameUk" class="form-control" name="nameUk"
                                           value="${faculty.getNameUk()}"
                                           required autofocus>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="descriptionEn"
                                       class="col-md-4 col-form-label text-md-right"><@spring.message "faculty.description.en"/></label>
                                <div class="col-md-6">
                                    <input type="text" id="descriptionEn" class="form-control" name="descriptionEn"
                                           value="${faculty.getDescriptionEn()}" required>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="descriptionUk"
                                       class="col-md-4 col-form-label text-md-right"><@spring.message "faculty.description.uk"/></label>
                                <div class="col-md-6">
                                    <input type="text" id="descriptionUk" class="form-control" name="descriptionUk"
                                           value="${faculty.getDescriptionUk()}" required>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="budgetCapacity" class="col-md-4 col-form-label text-md-right"> <@spring.message "faculty.budget_capacity"/></label>
                                <div class="col-md-6">
                                    <input type="number" id="budgetCapacity" class="form-control" name="budgetCapacity"
                                           value="${faculty.getBudgetCapacity()}"
                                           required>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="totalCapacity" class="col-md-4 col-form-label text-md-right"><@spring.message "faculty.budget_capacity"/></label>
                                <div class="col-md-6">
                                    <input type="number" id="totalCapacity" class="form-control" name="totalCapacity"
                                           value="${faculty.getTotalCapacity()}" required>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="requiredSubject1En" class="col-md-4 col-form-label text-md-right"><@spring.message "faculty.required_subject1_en"/> </label>
                                <div class="col-md-6">
                                    <input type="text" id="requiredSubject1" class="form-control"
                                           name="requiredSubject1En" value="${faculty.getRequiredSubject1En()} " required>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="requiredSubject1Uk" class="col-md-4 col-form-label text-md-right"> <@spring.message "faculty.required_subject1_uk"/></label>
                                <div class="col-md-6">
                                    <input type="text" id="requiredSubject1" class="form-control"
                                           name="requiredSubject1Uk" value="${faculty.getRequiredSubject1Uk()} " required>
                                </div>
                            </div>


                            <div class="form-group row">
                                <label for="requiredSubject2En" class="col-md-4 col-form-label text-md-right"><@spring.message "faculty.required_subject2_en"/></label>
                                <div class="col-md-6">
                                    <input type="text" id="requiredSubject2En" class="form-control"
                                           name="requiredSubject2En" value="${faculty.getRequiredSubject2En()} " required>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="requiredSubject2Uk" class="col-md-4 col-form-label text-md-right"><@spring.message "faculty.required_subject2_uk"/></label>
                                <div class="col-md-6">
                                    <input type="text" id="requiredSubject2En" class="form-control"
                                           name="requiredSubject2Uk" value="${faculty.getRequiredSubject2Uk()} " required>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="requiredSubject3En" class="col-md-4 col-form-label text-md-right"><@spring.message "faculty.required_subject3en"/> </label>
                                <div class="col-md-6">
                                    <input type="text" id="requiredSubject3" class="form-control"
                                           name="requiredSubject3En" value="${faculty.getRequiredSubject3En()} " required>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="requiredSubject3Uk" class="col-md-4 col-form-label text-md-right"><@spring.message "faculty.required_subject3_uk"/></label>
                                <div class="col-md-6">
                                    <input type="text" id="requiredSubject3Uk" class="form-control"
                                           name="requiredSubject3Uk" value="${faculty.getRequiredSubject3Uk()} " required>
                                </div>
                            </div>


                            <div class="col-md-6 offset-md-4">
                                <button type="submit" class="btn btn-primary">
                                    <@spring.message "profile.edit.save"/>
                                </button>
                            </div>
                                                        <input type="hidden" id="admissionOpen" class="form-control"
                                                               name="admissionOpen" value="${faculty.admissionOpen?string}">
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