const url = "http://127.0.0.1:8080/"

document.getElementById("signupbutton").onclick = signup


async function signup (){
    let username = document.getElementById("username").value
    let password = document.getElementById("password").value
    let firstname = document.getElementById("firstname").value
    let surname = document.getElementById("surname").value
    let email = document.getElementById("email").value
    let dob = document.getElementById("dob").value
    let sex = document.getElementById("sex").value


    
//remember variables must match Java Object
    let authorjson = {
        firstname: firstname,
        surname: surname,
        email: email,
        DOB: dob,
        sex: sex,
        username: username,
        password: password    

    }
    
    

    try {
        let response = await fetch(url + "author/register",{
          method: "POST",
          body: JSON.stringify(authorjson),
          headers: {
              'Content-Type': 'application/json'
          },
        });
        console.log(response.status)

        if (response.status === 202){
            let author  = await response.json()
    
           console.log(author)
    
           document.getElementById("alert").innerText = ("Welcome " + author.firstname)
    
           
    
           localStorage.setItem("num", author.userid)
    
    
           window.location.href = '../fetch/fetch.html'
                   
        }else if(response.status === 409){
    
            document.getElementById("alert").innerText = ("Username " + username + " Is already Taken")
    
        }else{
            alert("Failed to login, try again")
           
        }
        // Do something with the successful response data
      } catch (error) {
            if(error == "TypeError: Failed to fetch")
        document.getElementById("alert").innerText = ("The back-end of this application is unavailable, Please notify israelafangideh@gmail.com or try again later")
        document.getElementById("alert").style = ("color: red;")
        console.error('Error:', error);
      }
      

   
}