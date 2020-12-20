<%--
  Created by IntelliJ IDEA.
  User: Dilanka Nimsara
  Date: 2020-12-20
  Time: 4:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home Page</title>
</head>
<body style="background-color:lavender">
<center>

    <BR/>
    <h1 style="color: royalblue">ISO Message Unpack</h1>
    <hr width = "60%">
    <BR/>

    <div class="container" style="width: 50%">
        <div class="row" >
            <div class="col-sm">
                <form method="post" action="readF" enctype="multipart/form-data"  > <br/>
                    <b>Choose ISO message text file : </b>
                    <div class="form-group">
                        <input class="form-control"  type="file" name="file" /><br/>
                        <input type="submit" value="Unpack" class="btn btn-primary"/>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <br/>
    <br/>
    <br/>
    <div class="container" style="width: 50%">
        <div class="row" >
            <div class="col-sm">
                <form method="post" action="unpacktext" >
                    <br/>
                    <b>Enter your ISO message : </b>
                    <br/>
                    <textarea name="message" class="form-control" rows="4" cols="50">
                        </textarea>
                    <br/>
                    <!--<input type="input" name="message" />-->
                    <input type="submit" value="Unpack" class="btn btn-primary" />
                </form>
            </div></div></div>
</center>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
</body>
</html>
