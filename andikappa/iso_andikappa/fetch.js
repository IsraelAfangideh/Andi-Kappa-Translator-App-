const url = "http://18.222.31.44/"
//"http://3.19.55.28/"

// document.getElementById("language").onclick = languagecheck

document.getElementById("submit").onclick = getefikword
// document.getElementById("submit").onclick = getayeneefik
// document.getElementById("submit").onclick = getayenecontext


async function getefikword(){
    
    document.getElementById("tablebody").innerHTML = ""
let efikword = document.getElementById("efikword").value
// console.log("hii")
    let response = await fetch (url + "fetch/" + efikword,{
      
    })
    console.log(response.json)

    if (response.status == 200){
        let data = await response.json();

        console.log(data)

        for (let englishword of data){
            let row = document.createElement("tr");
      let cell = document.createElement("td");
      cell.innerHTML = englishword.englishword

      let cell2 = document.createElement("td");
      cell2.innerHTML = englishword.efikword

      let cell4 = document.createElement("td")
      cell4.innerHTML = englishword.context
            row.appendChild(cell)
      row.appendChild(cell2)
      row.appendChild(cell4)

      document.getElementById("tablebody").appendChild(row);


        }
    }else{
        alert("Something went wrong, try again");
    }

}

