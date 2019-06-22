var ul = $('.dropdown-search-box');
var input = ul.find('input');
var li = ul.find('li.result');

input.keyup(function(){
    var val = $(this).val();

    if ( val.length > 1 ) {
        li.hide();
        li.filter(':contains("'+ val +'")').show();
    } else {
        li.show();
    }
});