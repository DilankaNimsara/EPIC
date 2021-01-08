/**
 *
 * login function
 *
 */

$('#btnlogin').click(function () {

    let username = $('#username').val();
    let password = $('#password').val();

    if (username != "" && password != "") {

        $.ajax({
            url: "http://localhost:9090//api/v1/users/" + username + "/" + password,
            method: "GET",
            success: function (res) {
                console.log(res.responseCode)
                if (res.responseCode = 200) {
                    console.log(res.data)
                    let user = {
                        id: res.data
                    }
                    let object = {
                        time: new Date(),
                        users: user
                    }
                    $.ajax({
                        url: "http://localhost:9090//api/v1/login_history",
                        method: "POST",
                        contentType: "application/json",
                        data: JSON.stringify(object),
                        success: function (res) {
                            document.cookie = "username=" + username + "; path=/";

                            window.location.href = "home.html"
                        },
                        error: function (err) {
                            console.log(err)
                        }
                    })
                } else {
                    window.location.href = "index.html"
                }
            },
            error: function (err) {
                console.log(err)
                alert("Your username or password invalid")

            }
        })
    }

    /**
     *
     * form validation
     *
     */

    if (username == "") {
        $('#erruname').empty()
        $('#erruname').append("username filed cannot be null")
    } else {
        $('#erruname').empty()
    }
    if (password == "") {
        $('#errpass').empty()
        $('#errpass').append("password filed cannot be null")
    } else {
        $('#errpass').empty()
    }
})
