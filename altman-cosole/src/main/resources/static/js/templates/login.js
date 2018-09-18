function login() {
    alert("11111111");
    var username = "userName_0";
    var password = "1";
    $.post("/login.do", {
            "username": username,
            "password": password
        }, function (data) {
            alert(data);
            window.location.href = "/index.do";
        }
    )
}