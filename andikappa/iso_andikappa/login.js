const url = "http://3.145.155.9/"
//"http://127.0.0.1:8080/"

document.getElementById("loginbutton").onclick = login
document.getElementById("registerbutton").onclick = redirect

function redirect (){

 window.location.href = '/signup.html'

}

if (localStorage.getItem('authorized') =='null' ){
    document.getElementById("alert").innerText = "please login or sign up in order to access the app"
}

async function login (){
    let username = document.getElementById("username").value
    let password = document.getElementById("password").value

    let authorjson = {
        username: username,
        password: password,
      

    }//remember variables must match Java Object

    

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

       document.getElementById("alert").innerText = ("Welcome " + data[0].firstname)

       

       localStorage.setItem("num", data[0].userid)
       localStorage.setItem("authorized", 'authorized')
       localStorage.setItem('clickedauthorid', data[0].userid);



       window.location.href = '/index.html'
               
    }else{
        alert("Failed to login, try again")
       
    }


}