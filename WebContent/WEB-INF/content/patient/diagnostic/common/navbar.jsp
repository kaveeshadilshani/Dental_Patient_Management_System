<%--
  Created by IntelliJ IDEA.
  User: Namila
  Date: 11/19/2017
  Time: 9:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="container">


    <div class="row">
        <nav class="navbar navbar-inverse navbar-first" style="background-color: #85CB9C;border-color: #4AC071; color: #4AC071;">
            <div class="container-fluid ">
                <div class="navbar-header">

                    <ul class="nav navbar-nav" >
                        <li class="home"><a href="">Home</a></li>
                        <li class="pastdentalhistory"><a href="#">Past Dental History</a></li>
                        <li class="medicalrecord" ><a href="#">Medical Record</a></li>
                        <li class="drughistory"><a href="#">Drug history </a></li>
                        <li class="investigations"><a href="#">Investigations</a></li>
                        <li class="habits"><a href="#">Habits</a></li>



                        <li>
                            <s:url var="plaqueControl" action="" namespace="/patient"></s:url>
                            <s:a  href="%{#plaqueControl}">Plaque control & Brushing Habits</s:a>
                        </li>
                        <li>
                            <s:url var="dietary_history" action="dietary_history" namespace="/patient"></s:url>
                            <s:a href="%{#dietary_history}">Dietary History</s:a>

                        </li>
                        <li class="hardtissue"><a href="#">Hard Tissue Examination</a></li>
                        <li class="occlusal"><a href="#">Occlusal Relationship</a></li>
                        <li class="treatmentplan"><a href="#">Treatment  Plan</a></li>

                    </ul>
                </div>
            </div>  <!-- container-fluid -->
        </nav>
    </div>
</div>
