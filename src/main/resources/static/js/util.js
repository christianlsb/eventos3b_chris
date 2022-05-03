function id_cep(){

    var id_cep = document.getElementById('id_cep')
    if(id_cep.value.length == 5){
        id_cep.value = id_cep.value += "-"
    }
  
  $('.cep_with_callback').mask('00000-0000', id_cep);
}