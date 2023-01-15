// CONSTANTS

const url = "http://3.145.155.9/"
//http://127.0.0.1:8080/"
//"http://18.222.31.44/"
//"http://3.19.55.28/"
// const propernoun = document.getElementById("wordtype-").innerText

//Redirects
document.getElementById("addbutton").onclick = function (){window.location.href = "add.html"} 
document.getElementById("fetchbutton").onclick = function (){window.location.href = "/fetch.html"} 
// FUNCTION CALLS
  document.getElementById("submitNewTranslation").onclick = addtranslation
    document.getElementById("ö").onclick = addö
   document.getElementById("ñ").addEventListener ('click', function() { 
    document.getElementById("efikword").value = document.getElementById("efikword").value += "ñ"})

  

      //DIVORCED FUNCTIONS
   function addñ(){

    document.getElementById("efikword").value = document.getElementById("efikword").value += "ñ"

   }

   function addö(){
 document.getElementById("efikword").value = document.getElementById("efikword").value += "ö"
}
   


async function addtranslation () {


  

let translationjson = {
    "englishword": document.getElementById("englishword").value,
    "efikword": document.getElementById("efikword").value,
    "example": document.getElementById("example").value,
    "authorid" :[localStorage.getItem("num")]
}

let tss = JSON.stringify(translationjson)

console.log(translationjson)
    let response = await fetch(url + "add",{
        method: "POST",
        headers: {"Content-type": "application/json;charset=UTF-16"},
        body: tss,
        credentials: "same-origin"
    })


console.log(response.body)



if (response.status == 202){
   
   document.getElementById("directiveh1").innerHTML = ("You have added the following translation:" + tss)
// setTimeout(handler:document )
   
}
else{
document.getElementById("directiveh1").innerText = "unsuccessful, try again"
}
}

 
 