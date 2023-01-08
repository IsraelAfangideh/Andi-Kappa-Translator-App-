const url = "http://127.0.0.1:8080/"

document.getElementById("loginbutton").onclick = login

async function login (){
    let username = document.getElementById("username").value
    let password = document.getElementById("password").value

    let authorjson = {
        username: username,
        password: password,
      

    }//remember variables must match Java Object

    console.log(authorjson)

    let response = await fetch(url + "author/login",{

        method: "POST",
        body: JSON.stringify(authorjson),
        headers: {
            'Content-Type': 'application/json'
          },
    })

    console.log(response.status)

    if (response.status === 202){
        let data = await response.json()

       console.log(data)
        
    }else{
        alert("Failed to login, try again")
       
    }


}