
function logout(){
    localStorage.clear()
    console.log("bye :( " + localStorage.length)
    window.location.reload
}

document.addEventListener("DOMContentLoaded", function() {
    logoutbutton();
  });
  
  window.onunload = function(){
    console.log(document.getElementsByTagName("a")[4])
  }

function logoutbutton(){
    //if we are not logged in
    if (localStorage.length == 0){
        // console.log(document.firstElementChild.lastChild.firstElementChild.lastChild)

        //Make the logout button disappear
        //  document.getElementById("logoutbutton").innerText = ''
        console.log(document.getElementsByTagName("a").item(4))
    }
}


