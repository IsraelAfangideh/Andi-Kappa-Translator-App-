const url = "http://localhost:7777/kappa"

document.getElementById("language").onclick = languagecheck

document.getElementById("submit").onclick = getefikword

function languagecheck (){
    console.log(document.getElementById("language").value)

if (document.getElementById("language").value == "Search English Word") {

    console.log("englishdetected")
    window.location.href = "getEnglish.html"


    
}else if (document.getElementById("language").value == "Add New Translation") {

   
    window.location.href = "addTranslation.html"

    

}
 
}



async function getefikword(){
    
    document.getElementById("tablebody").innerHTML = ""
let efikword = document.getElementById("efikword").value
console.log("hii")
    let response = await fetch (url + "/ikoh/getEfik/" + efikword,{
      
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
        alert("Something went wrong, try again");
    }

}