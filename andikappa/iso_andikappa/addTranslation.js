const url = "http://localhost:7778/kappa"

document.getElementById("directiveh1").innerText = "Add New Translation"
document.getElementById("submitNewTranslation").onclick = addtranslation

async function addtranslation () {

var englishwordd = document.getElementById("englishword").value
let efikwordd = document.getElementById("efikword").value
let wordtypee = document.getElementById("wordtype").value
let contextt = document.getElementById("context").value
console.log(englishwordd)
let englishword =   englishwordd.toLowerCase
let efikword = efikwordd.toLowerCase
let wordtype = wordtypee.toLowerCase
let context = contextt.toLowerCase
fetch(englishword).then
let translationjson = {
    "englishword": englishword,
    "efikword": efikword,
    "wordtype": wordtype,
    "context": context

}
console.log(translationjson)
let tss = JSON.stringify(translationjson)
tss.toLowerCase
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