function sendProduct() {
    let title = document.getElementById("title").value
    let description = document.getElementById("description").value
    let cost = document.getElementById('cost').value

    var product = {
        title: title,
        description: description,
        cost: cost
    }

    $.ajax({
        url: '/products',
        method: 'POST',
        dataType: 'json',
        data: JSON.stringify(product),
        success: function (data) {
            alert(data);
        }
    })
}