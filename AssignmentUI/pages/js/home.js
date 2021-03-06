/**
 * set username to cookie variable
 * @type {string|string}
 */
var username = getCookie("username");
$('#logged_name').append("Logged as : " + username + " ")
$('#user_loged').append(username)

/***
 * login validation
 */
$(document).ready(function () {
    if (username == "") {
        window.location.href = "logout.html"
    }
})

/**
 * fetch login history of one user
 */
$(document).ready(function () {
    $.ajax({
        url: "http://localhost:9090//api/v1/login_history/" + username,
        method: "GET",
        success: function (res) {
            let data = res.data;
            if (res.responseCode == 200) {
                for (i in data) {
                    let row = `<tr>
                            <td>${new Date(data[i].time)}</td>
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

/**
 *
 * add new role
 */
$('#btnadd').click(function () {
    let object = {
        user_role: $('#user_role').val()
    }

    if ($('#user_role').val() != "") {
        $.ajax({
            url: "http://localhost:9090//api/v1/user_role",
            method: "POST",
            contentType: "application/json",
            data: JSON.stringify(object),
            success: function (res) {
                if (res.responseCode == 200) {
                    alert("User role added")
                    location.href = "home.html"
                }
            },
            error: function (err) {
                console.log(err)
            }
        })
    } else {
        $('#error').empty();
        $('#error').append("User role cannot be null")
        // alert("User role cannot be null")
    }
})

/**
 * delete role
 * @param id
 */
function deletefunc(id) {
    $.ajax({
        url: "http://localhost:9090//api/v1/user_role/" + id,
        method: "DELETE",
        success: function (res) {
            console.log(res)
            alert("A role deleted")
            location.href = "home.html"
        },
        error: function (err) {
            alert("You cant delete this role. It is already using..")
        }
    })

}

/**
 * get login history of currently logged user
 */
$(document).ready(function () {
    $.ajax({
        url: "http://localhost:9090//api/v1/user_role",
        method: "GET",
        success: function (res) {
            let data = res.data;
            if (res.responseCode == 200) {
                for (i in data) {
                    let row = `<tr>
                            <td>${data[i].user_role}</td>
                            <td><input type="button" value="Delete" onclick = "deletefunc(${data[i].urid})" class="btn btn-outline-danger"></td>
                         </tr>`;
                    $('#tbodyuserrole').append(row)

                }
            }
        },
        error: function (err) {
            console.log(err)
        }
    })
})