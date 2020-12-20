<%--
  Created by IntelliJ IDEA.
  User: Dilanka Nimsara
  Date: 2020-12-20
  Time: 4:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.io.PrintWriter" %>
<%@ page import="org.jpos.iso.ISOMsg" %>
<!DOCTYPE html>

<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Unpacked Message</title>
</head>

<body style="background-color:lavender">
<br/>
<center>
    <h1 style="color: royalblue">Unpacked ISO Message</h1>
    <hr width="60%">
</center>

<div class="container" style="width: 95%">
    <div class="row">
        <div class="card" style="background-color: whitesmoke">
            <div class="card-body">
                <p class="card-text">
                    <b>Message : </b>
                    <span style="color: darkblue">${msg}
                    </span>
                </p>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="card" style="background-color: whitesmoke">
            <div class="card-body">
                <p class="card-text">
                    <b>MTI : </b>
                    <span style="color: darkblue">${mti} </span>
                </p>
            </div>
        </div>
    </div>

    <%
        ISOMsg imMsg = (ISOMsg) request.getAttribute("imMsg");
        for (int i = 1; i <= imMsg.getMaxField(); i++) {
            if (imMsg.hasField(i)) {
    %>
    <div class="row">
        <div class="card">
            <div class="card-body">
                <p class="card-text">
                    <b><%="Field (" + i + ") = "%>
                    </b>
                    <span style="color: darkblue"><%=imMsg.getString(i)%> </span>
                </p>
            </div>
        </div>
    </div>

    <% }
    }%>


</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
        crossorigin="anonymous"></script>

</body>

