<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <s:include value="/WEB-INF/content/common/meta-tags.jsp"></s:include>
    <title><s:text name="global.application.title"/></title>
    <s:include value="/WEB-INF/content/common/css-include.jsp"></s:include>
</head>

<body class="nav-md">
<div class="container body">
    <div class="main_container">

        <s:include value="/WEB-INF/content/common/title-bar.jsp"></s:include>
        <s:include value="/WEB-INF/content/common/top-bar.jsp"></s:include>

        <!-- page content -->
        <div class="right_col" role="main">

            <s:include value="/WEB-INF/content/patient/header.jsp"></s:include>
            <h4>Patient Registration</h4>
            <hr>

            <s:form namespace="/patient" action="registration-save" method="post">

                <s:hidden name="patient.id" value="%{patient.id}"></s:hidden>
                <div>

                    <div class="form-group required">
                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-6">
                                <label class="control-label" for="name">Patient Name:</label>
                            </div>
                            <div class="col-md-2 col-sm-4 col-xs-12">
                                <s:select cssClass="form-control" name="patient.title"
                                          list="#{'Mr':'Mr.','Ms':'Ms.','Rev':'Rev.','Dr':'Dr.',' ':' '}"/>

                            </div>
                            <div class="col-md-3 col-sm-4 col-xs-12">
                                <s:textfield required="required" title="Surname" type="text" cssClass="form-control"
                                             id="name"
                                             name="patient.surname" placeholder="Surname"
                                             style="text-transform:capitalize"/>
                            </div>
                            <div class="col-md-3 col-sm-4 col-xs-12">
                                <s:textfield title="Initials" type="text" cssClass="form-control" id="name"
                                             name="patient.initials" placeholder="Initials"
                                             style="text-transform:uppercase"/>
                            </div>
                            <div class="col-md-3 col-sm-4 col-xs-12">
                                <s:textfield title="First name" type="text" cssClass="form-control" id="name"
                                             name="patient.firstName" placeholder="First name"
                                             style="text-transform:capitalize"/>
                            </div>
                        </div>
                    </div>
                    <!--  -->


                    <div class="form-group">
                        <div class="row">
                            <s:if test="patient.id != null">
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-md-2 col-sm-2 col-xs-12">
                                            <label for="ethnicity">File No.: </label>
                                        </div>

                                        <div class="col-md-3 col-sm-3 col-xs-12">
                                            <s:textfield type="text" cssClass="form-control" id="fileNumber"
                                                         name="patient.fileNumber"/>
                                        </div>

                                    </div>
                                </div>
                            </s:if>
                            <div class="col-md-2 col-sm-2 col-xs-12">
                                <label for="checkbox">Child</label>
                                <s:checkbox
                                        name="patient.child" cssClass="checkbox-inline" id="check_child"
                                        value="child"/>
                            </div>

                            <!-- 								<div class="col-md-1 col-sm-2 col-xs-12">
                                                                <label for="serialNumber">NIC No.:</label>
                                                            </div> -->
                            <div class="col-md-3 col-sm-3 col-xs-12">
                                <s:textfield type="text" pattern=".{10,15}"
                                             title="NIC should be between 10 to 15 digits!" cssClass="form-control"
                                             id="nic" name="patient.nic"
                                             placeholder="NIC number"/>
                            </div>

                        </div>

                    </div>
                    <script>
                        document.getElementById('check_child').onchange = function () {
                            document.getElementById('nic').disabled = this.checked;
                        };
                    </script>

                    <div class="form-group required">
                        <div class="row">
                            <div class="col-md-2 col-sm-2 col-xs-12">
                                <label for="birthDay" class="control-label">Date of Birth:</label>
                            </div>
                            <div class="col-md-3 col-sm-4 col-xs-12">
                                <input type="date" required="required" class="form-control" id="bday"
                                       name="patient.birthDayString"
                                       value="<s:property value='%{patient.birthDayString}' />">
                            </div>
                        </div>
                    </div>

                    <div class="form-group required">
                        <div class="row">
                            <div class="col-md-2 col-sm-2 col-xs-12">
                                <label for="sex" class="control-label">Sex: </label>
                            </div>
                            <div class="col-md-3 col-sm-4 col-xs-12">
                                <div class="form-control">
                                    <s:radio required="required" label="Answer" name="patient.sex"
                                             list="#{'Male':'Male','Female':'Female','Other':'Other'}"/>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="row">
                            <div class="col-md-2 col-sm-2 col-xs-4">
                                <label for="ethnicity">Ethnicity: </label>
                            </div>

                            <div class="col-md-3 col-sm-4 col-xs-8">
                                <s:select cssClass="form-control" name="patient.ethnicity"
                                          list="#{'Sinhala':'Sinhala','Tamil':'Tamil','Muslim':'Muslim', 'Other':'Other'}"/>
                            </div>

                        </div>
                    </div>

                    <div class="form-group">
                        <div class="row">
                            <div class="col-md-2 col-sm-2 col-xs-4">
                                <label for="district">District:</label>
                            </div>

                            <div class="col-md-3 col-sm-4 col-xs-8">
                                <s:select cssClass="form-control" name="patient.districtId" listKey="id"
                                          listValue="name" list="districts" value="14"/>
                            </div>
                            <div class="col-md-2 col-sm-2 col-xs-4">
                                <label for="country">Nationality: </label>
                            </div>
                            <div class="col-md-3 col-sm-4 col-xs-8">
                                <s:select name="patient.country" cssClass="form-control"
                                          list="#{'Sri Lankan':'Sri Lankan','Non Sri Lankan':'Non Sri Lankan'}">
                                </s:select>
                            </div>
                        </div>
                    </div>
                    <br>
                    <div class="form-group">
                        <div class="row">
                            <div class="col-md-2 col-sm-2 col-xs-12">
                                <label for="phone">Phone number:</label>
                            </div>
                            <div class="col-md-3 col-sm-4 col-xs-12">
                                <input type="text" class="form-control" id="phoneNo" pattern=".{10,}"
                                       title="Phone number should be 10 or more characters" name="patient.mobile"
                                       value="<s:property value='%{patient.mobile}' />">
                            </div>
                            <div class="col-md-2 col-sm-2 col-xs-12">
                                <label for="mail">E-mail:</label>
                            </div>
                            <div class="col-md-3 col-sm-4 col-xs-12">
                                <input type="email" class="form-control" id="mail"
                                       name="patient.email" value="<s:property value='%{patient.email}' />"/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="row">
                            <div class="col-md-2 col-sm-2 col-xs-12">
                                <label for="address">Address:</label>
                            </div>
                            <div class="col-md-3 col-sm-4 col-xs-12">
									<textarea class="form-control" id="address"
                                              name="patient.address"><s:property value='%{patient.address}'/></textarea>
                            </div>
                        </div>
                    </div>
                    <div class="form-group" id="remarks-div">
                        <div class="row">

                            <div class="col-md-2 col-sm-2 col-xs-12">
                                <label for="checkbox">Referral</label>
                                <input type="checkbox" class="checkbox-inline" id="check-referral" value="referral">

                            </div>
                            <div class="col-md-3 col-sm-3 col-xs-12">
                                <s:hidden name="patientAdditionalProperties[0].nameKey" value="Rererral"></s:hidden>
                                <s:textfield type="text" cssClass="form-control" id="remarks"
                                             name="patientAdditionalProperties[0].propertyValue"
                                             placeholder="Referral Body"/>
                            </div>
                            <div class="col-md-3 col-sm-3 col-xs-12">
                                <s:hidden name="patientAdditionalProperties[1].nameKey"
                                          value="Rererral-Remarks"></s:hidden>
                                <s:textfield type="text" cssClass="form-control" id="remarks"
                                             name="patientAdditionalProperties[1].propertyValue" placeholder="Remarks"/>
                            </div>

                                <%-- <s:if test="patient.id != null">
                                    <div class="col-md-3 col-sm-3 col-xs-12">
                                        <s:hidden name="patientAdditionalProperties[2].nameKey" value="Payment"></s:hidden>

                                        <s:textfield type="text" cssClass="form-control" id="remarks" name="patientAdditionalProperties[2].propertyValue" placeholder="Payments" />
                                    </div>
                                </s:if> --%>
                        </div>

                    </div>
                    <script>
                        document.getElementById('check-referral').onchange = function () {
                            document.getElementById('remarks-div').hide = this.checked;
                        };
                    </script>

                    <hr>
                    <div class="form-group">
                        <div class="row">
                            <div class="col-md-2 col-sm-2 col-xs-12"></div>
                            <s:if test="patient.id != null && !patient.id.empty">
                                <div class="col-md-3 col-sm-2 col-xs-12">
                                    <s:submit cssClass="btn btn-warning" value="Update"></s:submit>
                                </div>
                            </s:if>

                            <s:else>

                                <div class="col-md-3 col-sm-3 col-xs-12">
                                    <s:submit cssClass="btn btn-success" value="Register and Finish"></s:submit>
                                </div>
                            </s:else>

                        </div>
                    </div>

                </div>

            </s:form>

            <div class="col-md-3 col-sm-3 col-xs-12">
                <s:url var="diagno" action="diagnostic" namespace="/patient"></s:url>
                <s:a href="%{#diagno}">
                    <button class="btn btn-primary"> Add Diagnostic Report</button>
                </s:a>
            </div>

        </div>
        <!-- /page content -->

    </div>
</div>
<div class="row">
    <br>
</div>
<s:include value="/WEB-INF/content/common/footer.jsp"></s:include>
<!-- Custom Theme Scripts -->
<s:include value="/WEB-INF/content/common/js-include.jsp"></s:include>
</body>
</html>
