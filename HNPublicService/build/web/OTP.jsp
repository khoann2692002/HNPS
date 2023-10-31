<%-- 
    Document   : OTP
    Created on : Oct 19, 2023, 6:50:40 PM
    Author     : Nguyen Nguyen Khoa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="OTP.css"/>
        <link rel="shortcut icon" href="./img/ODB_ Online_Debt_Book.png" type="image/x-icon">
        <title>Enter OTP</title>
    </head>
    <body>
        <div class="box1">
            <div class="container1">
                <div class="top1">
                    <header style="color: black"> Enter OTP </header>
                </div>
                <form action="Activeaccount" method="post">
                    <div class="input-field1">
                        <input type="text" id="otp" class="input1" name="otp" placeholder="Enter OTP" required="required">
                    </div> 
                    <div>
                        <div style="display: none">
                            <input style="display: none" name="email" value="${email} ">${email}           
                        </div>
                    </div>
                    <div class="input-field1">
                        <button style="margin-top: 20px; background: #02B875;" type="submit" class="submit1" id="login-btn"  value="Active Account"> Active Accounnt</button>
                    </div>
                    <p style="color: red;" id="messforgotpassword" tilte="${mess}">${mess}</p>
                </form>
            </div>
        </div>

    </body>
</html>

