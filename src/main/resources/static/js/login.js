const user_login = {
    "email" : "",
    "password": ""
}

const setEmail = function(email){
    user_login.email = email;
}
const setPassword = function(password){
    user_login.password = password;
}


const loginVerification = async function(user_login){
    
    const response = await fetch("http://localhost:8080/login_verification", {
        method: "POST",
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(user_login)
    })

    const api_response = await response.json();
    
    const user_local_storage = localStorage;

    if (api_response.exist){
        user_local_storage.setItem('user_logged_data', JSON.stringify(api_response.user));
        window.location.href = "/home";
    }
    else{
        alert("Email ou Senha invalidos!");
    }
}

const btnLogin = document.getElementById('btn_login')

btnLogin.addEventListener('click', ()=>{
    loginVerification(user_login)
})