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


// const apiFetch = async function(user){

  
//   const response = await fetch("http://localhost:8080/users/create_user", {
//         method: "POST",
//         headers: {"Content-Type" : "application/json"},
//         body: JSON.stringify(user)
//   })
  
//   const user_local_storage = localStorage;

//   user_local_storage.setItem('user', user)

// }

const btnRegistrar = document.getElementById('btn_registrar')

btnRegistrar.addEventListener('click', ()=>{
    // apiFetch(user);
      const user_local_storage = localStorage;

     user_local_storage.setItem('user', user)
})


    

