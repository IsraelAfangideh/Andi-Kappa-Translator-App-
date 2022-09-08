const url = "http://localhost:7778/kappa"

document.getElementById("directiveh1").innerText = "Add New Translation"
document.getElementById("submitNewTranslation").onclick = addtranslation

document.getElementById("englishword").onchange = grammercheck
document.getElementById("efikword").onchange = grammercheck
document.getElementById("wordtype").onchange = grammercheck
 document.getElementById("context").onchange = grammercheck

 let englishword = document.getElementById("englishword").value
let efikword = document.getElementById("efikword").value
let wordtype = document.getElementById("wordtype").value
let context = document.getElementById("context").value

let englishinput = document.getElementById("englishword")
let efikinput = document.getElementById("efikword")
let wordinput = document.getElementById("wordtype")
let contextinput = document.getElementById("context")


 function grammercheck(){
    console.log("grammerchack initiated")
const propernoun = document.getElementById("wordtype").value

if (propernoun != "Proper Noun"){
    englishinput.setAttribute("pattern", "[a-z]{0,20}")
    efikinput.setAttribute("pattern", "[a-z]{0,20}")
    contextinput.setAttribute("pattern", "[a-z]{0,20}")
}else{

    englishinput.setAttribute("pattern", "[A-Za-z]{0,20}")
    efikinput.setAttribute("pattern", "[A-Za-z]{0,20}")
    contextinput.setAttribute("pattern", "[A-Za-z]{0,20}")
}

}
async function addtranslation () {


// console.log(englishwordd)
// let englishword =   englishwordd.toLowerCase
// let efikword = efikwordd.toLowerCase
// let wordtype = wordtypee.toLowerCase
// let context = contextt.toLowerCase

let translationjson = {
    "englishword": englishword,
    "efikword": efikword,
    "wordtype": wordtype,
    "context": context

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
 