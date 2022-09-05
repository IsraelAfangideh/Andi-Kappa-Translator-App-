const url = "http://localhost:7778/kappa"

document.getElementById("submit").onclick = getEnglishword

async function getEnglishword(){

    document.getElementById("tablebody").innerHTML = ""
let Englishword = document.getElementById("Englishword").value
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
        alert("Something went wrong, try again");
    }

}