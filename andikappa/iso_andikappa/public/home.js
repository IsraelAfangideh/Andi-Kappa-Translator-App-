const url = "http://localhost:7777/kappa"

document.getElementById("loginbtn").onclick = gologin

document.getElementById("signupbtn").onclick = gosignup

function gologin (){
window.location.href = "login.html"
}



function gosignup (){
    console.log("hi")
window.location.href = "signup.html"
}