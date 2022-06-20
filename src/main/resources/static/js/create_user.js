const user = {
    "username" : "",
    "email" : "",
    "password": ""
}

const setUsername = (username)=>{
    user.username = username
}
const setEmail = (email)=>{
    user.email = email
}
const setPassword = (password)=>{
    user.password = password
}


const createUser = async function(user){

  const response = await fetch("http://localhost:8080/users/create_user", {
        method: "POST",
        headers: {"Content-Type" : "application/json"},
        body: JSON.stringify(user)
  })
  
  const user_local_storage = localStorage;
  
  const api_response = await response.json();

  if (api_response.exist){
      user_local_storage.setItem('user_logged_data', JSON.stringify(api_response.user));
      window.location.href = "/home";
  }
  else{
      alert("Deu pau!");
  }
  

}

const btnRegistrar = document.getElementById('btn_registrar')

btnRegistrar.addEventListener('click', ()=>{
    createUser(user);      
})


    

