function openModel(id) {
    $('#myModel').modal('show');
    viewHistory(id);
}

function openUpdateModal(id) {
    $('#updatemodal').modal('show');

    $.ajax({
        url: "http://localhost:9090//api/v1/users/" + id,
        method: "GET",
        success: function (res) {
            $('#updateForm').empty()
            $('#userTitle').empty()
            $('#userTitle').append("User - [" + res.data.username + "]")

            let UN_toupate = res.data.username;
            let UP_toupdate = res.data.password;

            $.ajax({
                url: "http://localhost:9090//api/v1/user_role",
                method: "GET",
                success: function (response) {
                    let data = response.data;
                    if (response.responseCode == 200) {
                        for (i in data) {
                            if (res.data.userRole.urid == data[i].urid) {
                                let option = `<option value='${data[i].urid}' selected >${data[i].user_role}</option>`;
                                $('#roletoupdate').append(option)
                            } else {
                                let option = `<option value='${data[i].urid}'  >${data[i].user_role}</option>`;
                                $('#roletoupdate').append(option)
                            }
                        }
                    }
                },
                error: function (err) {
                    console.log(err)
                }
            })
            let form = `
                    <div class="mb-3">
                    <input type="hidden" class="form-control" id="currnetUser" value='${UN_toupate}'>
                    <input type="hidden" class="form-control" id="uid" value='${id}'>
                        <label class="form-label justify-content-center " style="">Username</label>
                        <input type="text" class="form-control" id="usernametoupdate" value='${UN_toupate}'>
                        <p style="color: red" id="errunameupdate"></p>
                        </div>
                        <div class="mb-3">
                            <label class="form-label justify-content-center " style="">Password</label>
                            <input type="password" class="form-control" id="passwordtoupdate" value='${UP_toupdate}'>
                            <p style="color: red" id="errpasswordtoupdate"></p>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">User Role</label>
                            <select class="form-control" id="roletoupdate">
                            </select>
                            <p style="color: red" id="errroleupdate"></p>
                        </div>
                        <div class="mb-3">
                            <label class="form-label justify-content-center " style="">Conform Password</label>
                            <input type="password" class="form-control" id="confirmpasswordtoupdate">
                             <p style="color: red" id="errconfirmpassword"></p>
                        </div>
                             <p style="color: red" id = "common_err"></p>           `

            $('#updateForm').append(form);

        }
    })
}

$('#btnupdateUsers').click(function () {
    let role = $('#roletoupdate').val()
    let username = $('#usernametoupdate').val()
    let password = $('#passwordtoupdate').val()
    let confirmPassword = $('#confirmpasswordtoupdate').val()
    let id = $('#uid').val()
    let currentUser = $('#currnetUser').val();


    if (password == confirmPassword && password != "") {
        $('#common_err').empty()
        let object = {
            id: id,
            username: username,
            password: password,
            userRole: {
                urid: role
            }
        }

        $.ajax({
            url: "http://localhost:9090//api/v1/users/" + id,
            method: "PUT",
            contentType: "application/json",
            data: JSON.stringify(object),
            success: function (res) {
                console.log(res)
                if (currentUser != username) {
                    alert("Your username or password has been changed..! please login with new username or password")
                    location.href = "logout.html"
                } else {
                    window.location.href = "users.html"
                }
            },
            error: function (err) {
                console.log(err)
            }
        })

    } else {
        $('#common_err').empty()
        $('#common_err').append("Password does not match.!")
    }

    if (password == "") {
        $('#common_err').empty()
        $('#errpasswordtoupdate').empty()
        $('#errpasswordtoupdate').append("password filed cannot be null")
    } else {
        $('#common_err').empty()
        $('#errpasswordtoupdate').empty()
    }
    if (username == "") {
        $('#common_err').empty()
        $('#errunameupdate').empty()
        $('#errunameupdate').append("username filed cannot be null")
    } else {
        $('#common_err').empty()
        $('#errunameupdate').empty()
    }

})

function closeModal() {
    $('#myModel').modal('hide');
    $('#updatemodal').modal('hide');
}

$('#loginnewuser').click(function () {
    window.location.href = "logout.html"
})

var username = getCookie("username");
$('#logged_name').append("Logged as : " + username + " ")


function myfunction(id) {
    $.ajax({
        url: "http://localhost:9090//api/v1/users/delete/" + id,
        method: "DELETE",
        success: function (res) {
            console.log(res)
        },
        error: function (err) {
            console.log(err)
        }
    })
    alert("User account deleted");
    location.href = "users.html"
}

function viewHistory(id) {
    $('#tbodyloghistory').empty()
    $.ajax({
        url: "http://localhost:9090//api/v1/login_history/id/" + id,
        method: "GET",
        success: function (res) {
            let data = res.data;
            let x = 0;
            if (res.responseCode == 200) {
                for (i in data) {
                    x++;
                    $('#title').empty();
                    $('#title').append("Login History : " + `<b>${data[i].users.username} </b> --:
                        <input style="float: right;" type="button" class="btn btn-primary btn-sm" value="Generate Report">`
                    );
                    $('#tbodyloghistory').append(
                        `<tr>
                                <td>${new Date(data[i].time)}</td>
                            </tr>`
                    )

                }

                if (x == 0) {
                    $('#tbodyloghistory').append(
                        `<tr>
                            <td>No data found</td>
                        </tr>`
                    )
                }
            }
        },
        error: function (err) {
            console.log(err)
        }
    })

}

$(document).ready(function () {
    $.ajax({
        url: "http://localhost:9090//api/v1/users",
        method: "GET",
        success: function (res) {
            let data = res.data;
            if (res.responseCode == 200) {
                for (i in data) {
                    let row = `<tr>
                            <td>${data[i].id}</td>
                            <td>${data[i].username}</td>
                            <td>${data[i].userRole.user_role}</td>
                            <td><button onclick="openModel(${data[i].id})"  class="btn btn-outline-info" type="button">View</button></td>
                            <td><button onclick="openUpdateModal(${data[i].id})"  class="btn btn-outline-success" type="button">Update</button></td>
                            <td><input onclick = " myfunction(${data[i].id})"  type="button"  class="btn btn-outline-danger" value="Delete"></td>
                         </tr>`;
                    $('#tbody').append(row)
                }
            }
        },
        error: function (err) {
            console.log(err)
        }
    })
})

function updateUserAccount(id) {

}


$(document).ready(function () {
    $.ajax({
        url: "http://localhost:9090//api/v1/user_role",
        method: "GET",
        success: function (res) {
            let data = res.data;
            if (res.responseCode == 200) {
                for (i in data) {
                    let option = `<option value='${data[i].urid}'  >${data[i].user_role}</option>`;
                    $('#role').append(option)
                }
            }
        },
        error: function (err) {
            console.log(err)
        }
    })
})

$('#btncreatNewUser').click(function () {

    if ($('#username').val() != "" && $('#password').val() != "" && $('#role').val() != "Select a role") {

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
                if (res.responseCode == 200) {
                    alert("Your Account has been created.")
                    location.href = "users.html"
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
    if ($('#user_role').val() == "Select a role") {
        $('#errrole').empty()
        $('#errrole').append("user role filed cannot be null")
    } else {
        $('#errrole').empty()
    }
})