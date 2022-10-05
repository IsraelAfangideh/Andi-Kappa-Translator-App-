const url = "http://localhost:7777/kappa"

window.onload = function() {
    document.getElementById("language").value = "Search English Word"
  }


document.getElementById("language").onclick = languagecheck
document.getElementById("submit").onclick = getEnglishword

// document.getElementById("submit").onclick = getayenecontext


function languagecheck (){
    console.log(document.getElementById("language").value)

if (document.getElementById("language").value == "Search Efik Word") {

   
    window.location.href = "getEfik.html"

    

}else if (document.getElementById("language").value == "Add New Translation") {

   
    window.location.href = "addTranslation.html"

    

}


}
async function getEnglishword(){

    document.getElementById("tablebody").innerHTML = ""
let Englishword = document.getElementById("Englishword").value

if (Englishword == ""){
    alert("Type in an English Word First dummy");
}
console.log("hii")
    let response = await fetch (url + "/ikoh/getEnglish/" + Englishword,{
      
    })
    console.log(response.json)

    if (response.status == 200){
        let data = await response.json();

        console.log(data)

        for (let englishword of data){
            let row = document.createElement("tr");
      let cell = document.createElement("td");
      cell.innerHTML = englishword.efikword

      let cell2 = document.createElement("td")
      cell2.innerHTML =englishword.wordtype

      let cell3 = document.createElement("td")
      cell3.innerHTML = englishword.context
            row.appendChild(cell)
      row.appendChild(cell2)
      row.appendChild(cell3)

      document.getElementById("tablebody").appendChild(row);


        }
    }else{
       // alert("Something went wrong, try again");
    }

    getayeneenglish();
}

async function getayeneenglish(){
    
    document.getElementById("tablebody").innerHTML = ""
let englishword = document.getElementById("Englishword").value
console.log("containsenglishfunctionaccessed")
    let response = await fetch (url + "/ikoh/ayeneEnglish/" + englishword,{
      
    })
    console.log(response.json)

    if (response.status == 200){
        let data = await response.json();

        console.log(data)

        for (let englishword of data){
            let row = document.createElement("tr");
      let cell = document.createElement("td");
      cell.innerHTML = englishword.efikword

      let cell2 = document.createElement("td")
      cell2.innerHTML =englishword.wordtype

      let cell3 = document.createElement("td")
      cell3.innerHTML = englishword.context
            row.appendChild(cell)
      row.appendChild(cell2)
      row.appendChild(cell3)

      document.getElementById("tablebody").appendChild(row);


        }
    }else{
        alert("Something went wrong, try again");
    }
getayenecontext();
}

async function getayenecontext(){
    
    document.getElementById("tablebody").innerHTML = ""
let englishword = document.getElementById("Englishword").value
console.log("contextfunctionaccessed")
    let response = await fetch (url + "/ikoh/ayeneContext/" + englishword,{
      
    })
    console.log(response.json)

    if (response.status == 200){
        let data = await response.json();

        console.log(data)

        for (let englishword of data){
            let row = document.createElement("tr");
      let cell = document.createElement("td");
      cell.innerHTML = englishword.englishword

      let cell2 = document.createElement("td")
      cell2.innerHTML =englishword.wordtype

      let cell3 = document.createElement("td")
      cell3.innerHTML = englishword.context
            row.appendChild(cell)
      row.appendChild(cell2)
      row.appendChild(cell3)

      document.getElementById("tablebody").appendChild(row);


        }
    }else{
        
    }

}

//Need to add/Append the contains methods here, starting with ayeneefik, then ayene context. We will add them to row.appendChild cell, cell2, cell3. 