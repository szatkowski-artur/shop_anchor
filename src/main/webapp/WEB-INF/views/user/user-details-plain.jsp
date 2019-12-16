<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 16.12.2019
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<section class="section">
    <div class="container">
        <div class="columns">
            <div class="column">
                <div class="box is-light">
                    <br>
                    <br>
                    <strong>Username: </strong> ${userData.username}<br>
                    <strong>Email: </strong> ${userData.email}
                        <br>
                        <br>
                </div>
            </div>
            <div class="column">
                <div class="box">
                    <br>
                    <strong>First name: </strong> ${userData.detailsFirstName}<br>
                    <strong>Last name: </strong>${userData.detailsLastName}<br>
                    <strong>Birthday: </strong>${userData.detailsBirthday}<br>
                    <strong>Gender: </strong>${userData.detailsGender}
                    <br>
                </div>
            </div>
            <div class="column">
                <div class="box">
                    <strong>Country: </strong>${userData.detailsCountry}<br>
                    <strong>Postal code: </strong>${userData.detailsPostalCode}<br>
                    <strong>Street: </strong>${userData.detailsStreetName}<br>
                    <strong>Street number: </strong>${userData.detailsStreetNumber}<br>
                    <strong>Flat number: </strong>${userData.detailsFlatNumber}
                </div>
            </div>
        </div>
    </div>
</section>