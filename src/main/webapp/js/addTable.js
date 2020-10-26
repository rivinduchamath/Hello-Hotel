
$("#btnAdd").click(function () {
    $("#tblOrder tr").off("dblclick");
    var itemCode = $('#itemCode').val();
    var itemName = $("#itemName").val();
    var itemPrice = $('#price').val();
    var buyAmount = $('#qty').val();
    var customerId = $('#customerId').val();
    var total = itemPrice * buyAmount;


    if (itemCode == "" || itemName == "") {
        alert("Please Select Item In Table");
        return;
    }
    if (buyAmount == "") {
        alert("Buy Amount is Empty");
        return;
    }
    if (itemPrice == "") {
        alert("Item Price Is Empty");
        return;
    }
    var s = myCheck(itemCode)
    $("#cId").val(customerId);
    if (!s) {
        return;
    }
    var row =
        "<tr>" +
        "<td>" + itemCode + "</td>" +
        "<td>" + itemName + "</td>" +
        "<td>" + itemPrice + "</td>" +
        "<td>" + buyAmount + "</td>" +
        "<td>" + total + "</td>" +
        '<td><div><i class="fa fa-trash"></i></div></td>' +
        "</tr>";
    app(row);

    $("#tblOrder tr td:last-child div").off("click");
    $("#tblOrder tr td:last-child div").click(function () {
        if (confirm("Are you sure whether you want to delete this Student?")) {
            $(this).parents("tr").fadeOut(1000, function () {
                $(this).remove();
            });
        }

    });
});


function app(a) {
    $("#tblOrder").append(a);
    return;

}

function myCheck(selectId) {
    var numberofRows = $("#tblOrder tr").length;

    var itemCode = $('#itemCode').val();
    var itemName = $("#itemName").val();
    var itemPrice = $('#price').val();
    var buyAmount = $('#qty').val();
    var total = itemPrice * buyAmount;

    for (var i = 0; i < numberofRows; i++) {
        var id = $("#tblOrder tr:nth-child(" + (i + 1) + ") td:nth-child(1)").text();

        if (selectId == id) {
            var oldqty = $("#tblOrder tr:nth-child(" + (i + 1) + ") td:nth-child(4)").text();
            var oldtotal = $("#tblOrder tr:nth-child(" + (i + 1) + ") td:nth-child(5)").text();

            var buyAmount1 = $('#qty').val();
            buyAmount = parseInt(buyAmount1);
            oldqty = parseInt(oldqty);
            oldtotal = parseInt(oldtotal);
            buyAmount = oldqty + buyAmount;
            total = oldtotal + total;


            var table = document.getElementById("tblOrder");
            table.rows[i].cells[0].innerHTML = itemCode;
            table.rows[i].cells[1].innerHTML = itemName;
            table.rows[i].cells[2].innerHTML = itemPrice;
            table.rows[i].cells[3].innerHTML = buyAmount;
            table.rows[i].cells[4].innerHTML = total;

            return false;
        }
    }
    return true;
}

function getValue() {

    var list = [];

    var numberOfRows = $("#tblOrder tr").length;
    var odId = $("#barIdNo").text();
    var cId = $("#customerId").text();
    var str,stre ="";
    for (var i = 0; i < numberOfRows; i++) {
        var itemId = $("#tblOrder tr:nth-child(" + (i + 1) + ") td:nth-child(1)").text();
        var name = $("#tblOrder tr:nth-child(" + (i + 1) + ") td:nth-child(2)").text();
        var price = $("#tblOrder tr:nth-child(" + (i + 1) + ") td:nth-child(3)").text();
        var qty = $("#tblOrder tr:nth-child(" + (i + 1) + ") td:nth-child(4)").text();
        var total = $("#tblOrder tr:nth-child(" + (i + 1) + ") td:nth-child(5)").text();


        if (i >= 0) {
            list.push({
                itemCode: name,
                itemName: itemId,
                itemPrice: price,
                qty: qty,
                totalPrice: total

            });
             str =  itemId+" "+price+" "+qty+" ";
             stre += str;
        }
    }

    $("#itemPay").val(stre);

}
