let path_selected
let id_selected

const showModalDeletar = function(path, id){
    path_selected = path
    id_selected = id
    $('#modalDeletar').modal('show')
}

const isSave = (save)=>{
    if (save == true)
    $('#modalSave').modal('show')
}

const isFail = (fail)=>{
    if (fail == true)
    $('#modalFail').modal('show')
}

const deletar = ()=>{
    if (path_selected != "" && id_selected != ""){
        window.location.href='/' + path_selected + '/delete' + id_selected
    }
}



//upar foto
function readURL(input) {

    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#blah').attr('src', e.target.result);
        }

        reader.readAsDataURL(input.files[0]);
    }
}

$("#imgInp").change(function(){
    readURL(this);
}) 

//upar foto
