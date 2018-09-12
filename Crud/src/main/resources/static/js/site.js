jQuery(document).ready(function ($) {
    //edit button
    $(document).on('click', 'button.edit', function (id) {
        var id = $(this).attr("id");
        console.info("Editing " + id);
        editProduct(id);
    });
});

function editProduct(id) {
    var name = $('tr#' + id + ' td#name').text();
    var price = $('tr#' + id + ' td#price').text();
    var stock = $('tr#' + id + ' td#stock').text();
    var description = $('tr#' + id + ' td#description').text();

    $('#edit-title').text("Editing " + id);
    $('#edit-id').val(id);
    $('#edit-name').val(name);
    $('#edit-price').val(price);
    $('#edit-stock').val(stock);
    $('#edit-description').val(description);
}