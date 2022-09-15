const url = "http://localhost:7777/kappa"

window.onload = function() {
    document.getElementById("language").value = "Add New Translation"
  }

document.getElementById("directiveh1").innerText = "Add New Translation"
document.getElementById("submitNewTranslation").onclick = addtranslation

document.getElementById("englishword").onchange = grammercheck
document.getElementById("efikword").onchange = grammercheck
document.getElementById("wordtype").onchange = grammercheck
 document.getElementById("context").onchange = grammercheck

//  let englishword = document.getElementById("englishword").value
// let efikword = document.getElementById("efikword").value
// let wordtype = document.getElementById("wordtype").value
// let context = document.getElementById("context").value

let englishinput = document.getElementById("englishword")
let efikinput = document.getElementById("efikword")
let wordinput = document.getElementById("wordtype")
let contextinput = document.getElementById("context")

// function ght (){
//     alert(document.getElementById("englishword").value)
// }
 function grammercheck(){
    console.log("grammerchack initiated")
const propernoun = document.getElementById("wordtype").value

if (propernoun != "Proper Noun"){
    englishinput.setAttribute("pattern", "[a-z]{0,20}")
    efikinput.setAttribute("pattern", "[a-z]{0,20}")
    contextinput.setAttribute("pattern", "[a-z ]{0,100}")
}else{

    englishinput.setAttribute("pattern", "[A-Za-z]{0,20}")
    efikinput.setAttribute("pattern", "[A-Za-z]{0,20}")
    contextinput.setAttribute("pattern", "[A-Za-z ]{0,100}")
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
 
 