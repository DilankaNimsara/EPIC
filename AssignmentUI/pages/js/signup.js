$(document).ready(function () {
    $.ajax({
        url: "http://localhost:9090//api/v1/user_role",
        method: "GET",
        success: function (res) {
            let data = res.data;
            if (res.responseCode == 200) {
                for (i in data) {
                    let option = `<option  value='${data[i].urid}'  >${data[i].user_role}</option>`;
                    $('#role').append(option)
                }
            }
        },
        error: function (err) {
            console.log(err)
        }
    })
})


$('#btnsignup').click(function () {

    if ($('#username').val() != "" && $('#password').val() != "" && $('#role').val() != "") {

        let userrole = {
            urid: $('#role').val()
        }
        let object = {
            username: $('#username').val(),
            password: $('#password').val(),
            userRole: userrole
        }

        console.log($('#role').val())
        $.ajax({
            url: "http://localhost:9090//api/v1/users",
            method: "POST",
            contentType: "application/json",
            data: JSON.stringify(object),
            success: function (res) {
                console.log(res)
                if (res.responseCode == 0) {
                    alert("username already exits");
                    return;
                } else if (res.responseCode == 2) {
                    alert("Password should have more than 6 characters")
                } else {
                    alert("Your Account has been created.")
                    window.location.href = "index.html";
                }
            },
            error: function (err) {
                console.log(err)
            }
        })
    }
    if ($('#username').val() == "") {
        $('#erruname').empty()
        $('#erruname').append("username filed cannot be null")
    } else {
        $('#erruname').empty()
    }
    if ($('#password').val() == "") {
        $('#errpass').empty()
        $('#errpass').append("password filed cannot be null")
    } else {
        $('#errpass').empty()
    }
    if ($('#user_role').val() == "") {
        $('#errrole').empty()
        $('#errrole').append("user role filed cannot be null")
    } else {
        $('#errrole').empty()
    }
})