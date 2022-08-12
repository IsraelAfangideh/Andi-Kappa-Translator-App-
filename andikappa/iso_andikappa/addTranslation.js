const url = "http://localhost:7778/kappa"

document.getElementById("submitNewTranslation").onclick = addtranslation

async function addtranslation () {

var englishword = document.getElementById("englishword").value.toLowerCase
let efikword = document.getElementById("efikword").value.toLowerCase
let wordtype = document.getElementById("wordtype").value.toLowerCase
let context = document.getElementById("context").value.toLowerCase

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


    let response = await fetch(url + "/ikoh",{

        method: "POST",
        body: translationjson,
        credentials: "same-origin"
    })


console.log(response.body)



if (response.status == 202){
    document.getElementById("directiveh1").innerHTML()
}

document.getElementById("directiveh1").innerHTML("unsuccessful, try again")

}