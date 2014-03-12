$(function() {
$( "input#button" ).click(function() {
var value = $("select#source_select" ).val();
$.each(value, function (i, data) {
    $("select#dest_select" ).append('<option value="' + data + '">' + data + '</option>');
});
$("select#dest_select").val(value);
});

$( "input#gen_button" ).click(function() {
var value = $("select#dest_select" ).val();
    alert( value );
    jsRoutes.controllers.Spellings.generate().ajax({
        type: 'GET',
        data : JSON.stringify({value : value}),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function() {
            $("div#gen_output").html("<p>success</p>");
        },
        error: function() {
            $("div#gen_output").html("<p>failed</p>");
        }
    });
});
})