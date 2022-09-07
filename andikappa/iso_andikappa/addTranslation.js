const url = "http://localhost:7778/kappa"

document.getElementById("directiveh1").innerText = "Add New Translation"
document.getElementById("submitNewTranslation").onclick = addtranslation

async function addtranslation () {

var englishword = document.getElementById("englishword").value
let efikword = document.getElementById("efikword").value
let wordtype = document.getElementById("wordtype").value
let context = document.getElementById("context").value

// let englishword = englishwordmixedcase.toLowerCase()
// let efikword = efikwordmixedcase.toLowerCase()
// let wordtype = wordtypemixedcase.toLowerCase()
// let context = contextmixedcase.toLowerCase()

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