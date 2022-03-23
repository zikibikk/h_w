<!doctype html>
<html>
<head>
    <link rel="stylesheet" href="style/style.css">
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <script src="js/ajax.js"> </script>
    <title>Add product</title>
    <style>
        .form-style-3 {
            max-width: 450px;
            font-family: "Lucida Sans Unicode", "Lucida Grande", sans-serif;
        }

        .form-style-3 label {
            display: block;
            margin-bottom: 10px;
        }

        .form-style-3 label > span {
            float: left;
            width: 100px;
            color: #F072A9;
            font-weight: bold;
            font-size: 13px;
            text-shadow: 1px 1px 1px #fff;
        }

        .form-style-3 fieldset {
            border-radius: 10px;
            -webkit-border-radius: 10px;
            -moz-border-radius: 10px;
            margin: 0px 0px 10px 0px;
            border: 1px solid #FFD2D2;
            padding: 20px;
            background: #FFF4F4;
            box-shadow: inset 0px 0px 15px #FFE5E5;
            -moz-box-shadow: inset 0px 0px 15px #FFE5E5;
            -webkit-box-shadow: inset 0px 0px 15px #FFE5E5;
        }

        .form-style-3 fieldset legend {
            color: #FFA0C9;
            border-top: 1px solid #FFD2D2;
            border-left: 1px solid #FFD2D2;
            border-right: 1px solid #FFD2D2;
            border-radius: 5px 5px 0px 0px;
            -webkit-border-radius: 5px 5px 0px 0px;
            -moz-border-radius: 5px 5px 0px 0px;
            background: #FFF4F4;
            padding: 0px 8px 3px 8px;
            box-shadow: -0px -1px 2px #F1F1F1;
            -moz-box-shadow: -0px -1px 2px #F1F1F1;
            -webkit-box-shadow: -0px -1px 2px #F1F1F1;
            font-weight: normal;
            font-size: 12px;
        }

        .form-style-3 textarea {
            width: 250px;
            height: 100px;
        }

        .form-style-3 input[type=text],
        .form-style-3 input[type=date],
        .form-style-3 input[type=datetime],
        .form-style-3 input[type=number],
        .form-style-3 input[type=search],
        .form-style-3 input[type=time],
        .form-style-3 input[type=url],
        .form-style-3 input[type=email],
        .form-style-3 select,
        .form-style-3 textarea {
            border-radius: 3px;
            -webkit-border-radius: 3px;
            -moz-border-radius: 3px;
            border: 1px solid #FFC2DC;
            outline: none;
            color: #F072A9;
            padding: 5px 8px 5px 8px;
            box-shadow: inset 1px 1px 4px #FFD5E7;
            -moz-box-shadow: inset 1px 1px 4px #FFD5E7;
            -webkit-box-shadow: inset 1px 1px 4px #FFD5E7;
            background: #FFEFF6;
            width: 50%;
        }

        .form-style-3 input[type=submit],
        .form-style-3 input[type=button] {
            background: #EB3B88;
            border: 1px solid #C94A81;
            padding: 5px 15px 5px 15px;
            color: #FFCBE2;
            box-shadow: inset -1px -1px 3px #FF62A7;
            -moz-box-shadow: inset -1px -1px 3px #FF62A7;
            -webkit-box-shadow: inset -1px -1px 3px #FF62A7;
            border-radius: 3px;
            border-radius: 3px;
            -webkit-border-radius: 3px;
            -moz-border-radius: 3px;
            font-weight: bold;
        }

        .required {
            color: red;
            font-weight: normal;
        }
    </style>
</head>
<body>
<div class="form-style-3">
    <fieldset>
        <legend>Add product</legend>
        <label for="title"><span>Название товара<span class="required">*</span></span><input type="text"
                                                                                            class="input-field"
                                                                                            name="title"
                                                                                            id="title"
                                                                                            value=""/></label>
        <br>
        <label for="description"><span>Описание товара<span class="required">*</span></span><input type="text"
                                                                                            class="input-field"
                                                                                            name="description"
                                                                                            id="description"
                                                                                            value=""/></label>
        <br>
        <label for="cost"><span>Стоимость<span class="required">*</span></span><input type="number"
                                                                                      step="0.01"
                                                                                    class="input-field"
                                                                                    name="cost"
                                                                                    id="cost"
                                                                                    value=""/></label>
        <br>
    </fieldset>
    <fieldset>
        <label><span> </span><button type="submit" value="Submit" onclick="sendProduct()">Добавить</button></label>
    </fieldset>

</div>
<script>
    function sendProduct() {
        let title = document.getElementById("title").value
        let description = document.getElementById("description").value
        let cost = document.getElementById('cost').value

        var productDto = {
            productDto: {
                title: title,
                description: description,
                cost: cost
            }
        }
        console.log(JSON.stringify(productDto))

        $.ajax({
            url: '/products',
            method: 'POST',
            // dataType: 'json',
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(productDto),
            success: function (data) {
                alert(data);
            }
        })
    }</script>
</body>
</html>