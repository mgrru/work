$(document).ready(() => {

    $("#passname").onblur()
    var name = $("#password").val()
    if (name != null){
        var result = name.match("^\w+.?\w+*")
        if(result!=null){

        }
    }
})