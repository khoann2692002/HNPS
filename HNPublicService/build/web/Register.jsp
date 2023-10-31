<%-- 
    Document   : Register
    Created on : Oct 19, 2023, 6:50:31 PM
    Author     : Nguyen Nguyen Khoa
--%>

<!DOCTYPE html>
<html>
    <head>
        <title>Created New Account</title>
        <meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
        <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="Register.css"/>
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        <link rel="shortcut icon" href="./img/logo.jpg" type="image/x-icon">
    </head>
    <body>

        <div class="box2">
            <div class="container2">
                <div class="top2">
                    <span>Have an account?</span>
                    <header>HNPS Register</header>
                </div>
                <form action="Register" method="post">
                    <div class="input-field2">
                        <input type="text" class="input2" placeholder="Enterprise Name" id="" name="name" required value="${param.name}">
                        <i class='bx bx-user'></i>
                    </div>
                    <div class="input-field2">
                        <input type="email" class="input2" placeholder="Email Address" id="" name="email" required value="${param.email}">
                        <i class='bx bx-envelope' ></i>
                    </div>
                    <div class="input-field2">
                        <input type="password" class="input2" placeholder="Password"  id="password"  name="pass" required value="${param.pass}">
                        <i class='bx bx-lock-alt'></i>
                    </div>
                    <div class="input-field2">
                        <input type="password" class="input2" id="confirm_password" placeholder="Re_Enter Password" name="repeatpass" required " onkeyup="myFunction()">
                        <i class='bx bx-lock-alt'></i>
                    </div>
                    <div class="input-field2">
                        <input type="text" class="input2" placeholder="Phone Number" id="" name="phone" required value="${param.phone}">
                        <i class='bx bx-phone-call' ></i>
                    </div>
                    <div class="input-field2">
                        <input type="text" class="input2" placeholder="Address" id="" name="address" required value="${param.address}">
                        <i class='bx bxs-map'></i>
                    </div>
                    <div>
                        <p style="margin-left: 10px" id='message'></p>
                    </div>
                    <p style="color: red; padding-left: 90px">${mess}</p>
                    <p style="color: red;padding-left: 90px">${mess1}</p>
                    <div class="input-field2">
                        <input type="submit" class="submit2" value="Sign Up" id="" style="background: #02B875;">
                    </div>
                </form>
                <div class="two-col2">
                    <div class="one2">
                        <label><a href="login.jsp">Login</a></label>
                    </div>
                    <div class="two2">
                        <label><a href="forgotpass.jsp">Forgotten Password?</a></label>
                    </div>
                </div>
            </div>
        </div>
        <script>
            function myFunction() {
                if (document.getElementById('password').value ===
                        document.getElementById('confirm_password').value) {
                    document.getElementById('message').style.color = 'green';
                    document.getElementById('message').innerHTML = 'Matching';
                } else {
                    document.getElementById('message').style.color = 'red';
                    document.getElementById('message').innerHTML = 'Not matching';
                }
            }
        </script>

    </body>
</html>