<!doctype html>
<html lang="en">
<head>
    <title>
        Log In
    </title>

    <style>
        button {
        color: white;
        text-align: center;
        position: absolute;
        margin-top: 10%;
        left: 32%;
        padding-top: 15px;
        padding-left: 20px;
        padding-right: 20px;
        padding-bottom: 15px;
        border-radius: 12px;
        width: 100px;
        background-color: #000000;
        }


        div {
            position: absolute;
            left: 50%;
            top: 50%;
            -webkit-transform: translate(-50%, -50%);
            transform: translate(-50%, -50%);
            border: 0.3px solid black;
            border-radius: 20px;
            background-color: #B1D6F1;
        }

        form {
            margin-top: 15%;
            margin-bottom: 30%;
            width: 300px;
        }

        .textView{
            height: 30px;
            width: 270px;
            margin-left: 4%;
            border: 1px solid black;
            border-radius: 2px;
            padding-left: 5px;
        }




    </style>

<body>
<div id = "box">
    <div id = "form">
    <form action="/acceptUser" ><br>
        <input type="text" name="name" class = "textView" placeholder="USERNAME e.g: Roman"><br>
        <input type="password" name="password" class = "textView" style="margin-top: 1%" placeholder="PASSWORD"><br>
        <button type="submit" value="Sign Up" class="button">
            Sign Up
        </button>
    </form>
</div>
</div>
<p style ="color: red"> ${failed}</p>
<p style ="color: green"> ${success}</p>
</body>
</html>
