// CONSTANTS

const url = "http://localhost:7777/kappa"
const propernoun = document.getElementById("wordtype-").innerText

// FUNCTION CALLS
  document.getElementById("submitNewTranslation").onclick = addtranslation
  document.getElementById("language").onclick = languagecheck
  document.getElementById("ö").onclick = addö


document.getElementById("englishword").onchange = convertcase
  document.getElementById("efikword").onchange = convertcase
  document.getElementById("wordtype").onchange = convertcase
   document.getElementById("context").onchange = convertcase



  // IN LINE FUNCTIONS
  window.onload = function() {
    document.getElementById("language").value = "Add New Translation"
  }

   document.getElementById("ñ").addEventListener ('click', function() { 
    document.getElementById("efikword").value = document.getElementById("efikword").value += "ñ"})

  

      //DIVORCED FUNCTIONS
   function addñ(){

    document.getElementById("efikword").value = document.getElementById("efikword").value += "ñ"

   }

   function addö(){
 document.getElementById("efikword").value = document.getElementById("efikword").value += "ö"
}
   


  function languagecheck (){
    console.log(document.getElementById("language").value)

if (document.getElementById("language").value == "Search English Word") {

    console.log("englishdetected")
    window.location.href = "getEnglish.html"


    
}else if (document.getElementById("language").value == "Search Efik Word") {

   
    window.location.href = "getEfik.html"

    

}
}



function convertcase(){
    console.log(propernoun)
    document.getElementById("englishword").textContent.toLowerCase
    if (propernoun == "Proper Noun"){
        console.log("is proper noun")
       document.getElementById("englishword").textContent.toLowerCase
    }else if (propernoun != "Proper Noun"){
        console.log("is NOT proper noun")
        document.getElementById("englishword").textContent.toUpperCase   
    }
    }
async function addtranslation () {


let translationjson = {
    "englishword": document.getElementById("englishword").value,
    "efikword": document.getElementById("efikword").value,
    "wordtype": document.getElementById("wordtype").value,
    "context": document.getElementById("context").value

}
console.log(translationjson)
let tss = JSON.stringify(translationjson)

console.log(translationjson)
    let response = await fetch(url + "/ikoh/add",{
        method: "POST",
        headers: {"Content-type": "application/json;charset=UTF-16"},
        body: tss,
        credentials: "same-origin"
    })


console.log(response.body)



if (response.status == 202){
   
   document.getElementById("directiveh1").innerHTML = ("You have added the following translation:" + tss)

   
}
else{
document.getElementById("directiveh1").innerText = "unsuccessful, try again"
}
}

 
 