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
