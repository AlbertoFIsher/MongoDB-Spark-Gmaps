$(function() {


    var datos;
    var nombreCalle = [];
    var objCalles = [];
    var prefijo = 'p';
    /*$('#buttonSum').click(function(){
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
    });*/


    //Obtiene las calles mapeadas
    $('#buttonCalles').click(function(){

        $.ajax({
            url: '/api/getAllCalles',
            success: function(data) {

                construyeCalles(data);
                //console.log(data);
            }
        });

    });

    function construyeCalles(data){

        for(var i in data){

            for(var j in data[i].geometria[0].coordinates){
               data[i].geometria[0].coordinates[j].reverse();

            }
        }
        for(var i in data){

            nombreCalle.push(data[i].nombreCalle);
            //console.log(i);
            var path = data[i].geometria[0].coordinates;
            //console.log(path);

            //Solución -> https://stackoverflow.com/questions/23315481/gmaps-js-adding-a-click-function-for-each-marker
            //Explicación -> https://stackoverflow.com/questions/1552941/how-does-a-function-in-a-loop-which-returns-another-function-work
            window[prefijo+(i).toString()] = mapObj.drawPolyline({
                path: path,
                useGeoJSON: true,
                strokeColor: '#76f',
                strokeOpacity: .3,
                strokeWeight: 7,
                editable: false,
                click: ((d) => {
                    return () => {
                alertify.alert(d.nombreCalle);
                    }
                })(data[i])
            });
        }
        //console.info(p1);
        //mapObj.removePolyline(p0);

        for(var i in nombreCalle){
            //console.log(nombreCalle[i]);
        }
        //mapObj.removePolyline(pl);
    }

    $('#buttonColonia').click(function(){

        $.ajax({
            url: '/api/getColonia',
            success: function(data) {

                //console.log(data);
                construyeColonia(data);
                //console.log(data);
            }
        });

    });

    function construyeColonia(data){
        console.log("ArrayInicial************************************************************");
        var path = data[0].geografia[0].coordinates;
       console.log(path);
        mapObj.drawPolygon({
            paths: path,
            useGeoJSON: true,
            strokeColor: '#000000',
            strokeOpacity: 0.3,
            strokeWeight: 2,
            fillColor: '#00e676',
            fillOpacity: 0.4
        });

    }

    $('#buttonSecciones').click(function(){

        $.ajax({
            url: '/api/getSecciones',
            success: function(data) {

                //console.log(data);
                construyeSecciones(data);
                //console.log(data);
            }
        });

    });

    function construyeSecciones(data){
        console.log("ArrayInicialSecciones************************************************************");

        //console.log(data[0].geografia[0].coordinates[0][0]);
        //console.log(data[0].geografia[0].coordinates[0][1]);
        for(var i in data) {


            var path = data[i].geografia[0].coordinates;
            mapObj.drawPolygon({
                paths: path,
                useGeoJSON:true,
                strokeColor: '#000000',
                strokeOpacity: 0.3,
                strokeWeight: 2,
                fillColor: getRandomColor(),
                fillOpacity: 0.4
            });
        }

    }

    function getRandomColor() {
        var letters = '0123456789ABCDEF';
        var color = '#';
        for (var i = 0; i < 6; i++) {
            color += letters[Math.floor(Math.random() * 16)];
        }
        return color;
    }

    $('#buttonEP').click(function(){

        $.ajax({
            url: '/api/getAllEP',
            success: function(data) {

                construyeEP(data);

            }
        });

    });

    function construyeEP(data){
        console.log(data);
        for(var i in data){
            data[i].geometria[0].coordinates.reverse();
            mapObj.addMarker({
                lat: data[i].geometria[0].coordinates[0],
                lng: data[i].geometria[0].coordinates[1],
                click: ((d) => {
                return () => {
                    var pre = '<div><h3>Lugares Disponibles: '+d.lugaresDisponibles+'<br>\n ' +
                        '<h4>Quieres reservar un lugar? </div>';

            alertify.confirm(pre, function(){
                alertify.success('Lugar Reservado');
            },function(){
                alertify.error('Sin Reservar');
            }).set({labels:{ok:'Aceptar', cancel: 'Ahora no!'}, padding: false});
            }
        })(data[i])
            });

            /*
            * var pre = document.createElement('pre');
//custom style.
pre.style.maxHeight = "400px";
pre.style.margin = "0";
pre.style.padding = "24px";
pre.style.whiteSpace = "pre-wrap";
pre.style.textAlign = "justify";
pre.appendChild(document.createTextNode($('#la').text()));
//show as confirm
alertify.confirm(pre, function(){
        alertify.success('Accepted');
    },function(){
        alertify.error('Declined');
    }).set({labels:{ok:'Accept', cancel: 'Decline'}, padding: false});
            *
            *
            * */
        }
        //console.log(data[0].geometria[0].coordinates);
    }

    //Trae todos los parquimetros
    $('#buttonParq').click(function(){

        $.ajax({
            url: '/api/getAllParquimetros',
            success: function(data) {

                //console.log(data);
                construyeParquimetros(data);
                //console.log(data);
            }
        });

    });

    function construyeParquimetros(data){

        console.log(data);
        var color;
        for(var i in data) {


            var path = data[i].geometria[0].coordinates;
            if(data[i].activo==1){
               color = '#EE2F07'
            }else{
                color = '#06E912'
            }

            mapObj.drawPolygon({
                paths: path,
                useGeoJSON:true,
                strokeColor: '#000000',
                strokeOpacity: 0.7,
                strokeWeight: 2,
                fillColor: color,
                fillOpacity: 0.7
            });
        }
    }

    $('#buttonSecc1').click(function(){

        var seccion =1 ;
        $.ajax({
            url: '/api/getSeccion?a=' + seccion,
            success: function(data) {

                construyeSeccion(data);
            }
        });

    });

    function construyeSeccion(data){
        console.log(data);
        var path = data[0].geografia[0].coordinates;
        console.log(data[0].geografia[0].coordinates);
        mapObj.drawPolygon({
            paths: path,
            useGeoJSON:true,
            strokeColor: '#000000',
            strokeOpacity: 0.3,
            strokeWeight: 2,
            fillColor: getRandomColor(),
            fillOpacity: 0.4
        });
    }

    $('#buttonPS1').click(function(){

        mapObj.removeMarkers();
        mapObj.removePolygons();
        mapObj.removePolylines();

        var seccion =1 ;
        $.ajax({
            url: '/api/getSeccion?a=' + seccion,
            success: function(data) {

                construyeSeccion(data);
            }
        });
        $.ajax({
            url: '/api/getEPSeccion?a=' + seccion,
            success: function(data) {

                construyeEP(data);
            }
        });



    });

    $('#buttonPS2').click(function(){

        mapObj.removeMarkers();
        mapObj.removePolygons();
        mapObj.removePolylines();

        var seccion =2 ;
        $.ajax({
            url: '/api/getSeccion?a=' + seccion,
            success: function(data) {

                construyeSeccion(data);
            }
        });
        $.ajax({
            url: '/api/getEPSeccion?a=' + seccion,
            success: function(data) {

                construyeEP(data);
            }
        });



    });

    $('#buttonPS3').click(function(){

        mapObj.removeMarkers();
        mapObj.removePolygons();
        mapObj.removePolylines();

        var seccion =3 ;
        $.ajax({
            url: '/api/getSeccion?a=' + seccion,
            success: function(data) {

                construyeSeccion(data);
            }
        });
        $.ajax({
            url: '/api/getEPSeccion?a=' + seccion,
            success: function(data) {

                construyeEP(data);
            }
        });



    });

    $('#buttonPS4').click(function(){

        mapObj.removeMarkers();
        mapObj.removePolygons();
        mapObj.removePolylines();

        var seccion = 4 ;
        $.ajax({
            url: '/api/getSeccion?a=' + seccion,
            success: function(data) {

                construyeSeccion(data);
            }
        });
        $.ajax({
            url: '/api/getEPSeccion?a=' + seccion,
            success: function(data) {

                construyeEP(data);
            }
        });



    });

    $('#buttonPS5').click(function(){

        mapObj.removeMarkers();
        mapObj.removePolygons();
        mapObj.removePolylines();

        var seccion = 5 ;
        $.ajax({
            url: '/api/getSeccion?a=' + seccion,
            success: function(data) {

                construyeSeccion(data);
            }
        });
        $.ajax({
            url: '/api/getEPSeccion?a=' + seccion,
            success: function(data) {

                construyeEP(data);
            }
        });



    });






});