const url = "http://localhost:7778/kappa"


document.getElementById("submitNewTranslation").onclick = addtranslation

async function addtranslation () {

var englishword = document.getElementById("englishword").value
console.log(englishword)
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
    let response = await fetch(url + "/ikoh",{
        method: "POST",
      
        body: translationjson,
        credentials: "same-origin",
        headers: { 
            'Accept': 'application/json',
            'Content-Type': 'application/json' 
        }
    })


console.log(response.body)



if (response.status == 202){
    document.getElementById("directiveh1").innerHTML()
}

document.getElementById("directiveh1").innerHTML("unsuccessful, try again")

}