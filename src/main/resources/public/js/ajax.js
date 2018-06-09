$(function() {
    $('#buttonSum').click(function(){
        var a = $('#a').val();
        var b = $('#b').val();
        console.log(a);
        console.log(b);
        var json = {"a":a,"b":b};
        $.ajax({
            url: '/api/sum?a=' + a + '&b='+b,
            success: function(data) {
                $('#result').text(data);
            }
        });
    });

    //Prueba enviando JSON.
    $('#buttonSum2').click(function(){
        var a = $('#a').val();
        var b = $('#b').val();
        console.log(a);
        console.log(b);
        var json = {'a':a,'b':b};
        $.ajax({
            method: 'POST',
            url: '/api/json',
            data:json,
            success: function(data) {
                $('#result').text(data);
            }
        });
    });


    //Prueba ConexionMongo.
    $('#buttonMongo').click(function(){
        var a = $('#a').val();
        var b = $('#b').val();
        console.log(a);
        console.log(b);
        var json = {'a':a,'b':b};
        $.ajax({
            url: '/api/mongodb',
            success: function(data) {
                $('#result').text(data);
            }
        });
    });
});