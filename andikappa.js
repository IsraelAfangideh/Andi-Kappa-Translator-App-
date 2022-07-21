const url = "http://localhost:5000"; //putting our base url in a variable
//For cleaner code below
const url2 ="http://localhost:5000/english/"


document.getElementById("getAllEnglishWords").onclick = getEnglishWords// this button will get all English Words
document.getElementById("getThisEnglishWord").onclick = getThisEnglishWord//Event listener to get a particular English Word
document.getElementById("loginButton").onclick = loginFunction//Event listener to get a particular English Word
 //running into problems here

async function getEnglishWords (){

    let response = await fetch(url + "/english")

    //log the response in the console just to see the respons eobject

    console.log (response)

    //control flow on status code

    if (response.status == 200) {
        
        let data = await response.json();//translate json and set it equal to data
        //. json is the function that turns our json back into JS

        for(let English_word of data){// for each english word, do something

        let row = document.createElement("tr")
        let cell = document.createElement("td")
let cell2 = document.createElement("td")
        cell.innerHTML = English_word.english_word
        cell2.innerHTML = English_word.efik.efik_word

        row.appendChild(cell)
        row.appendChild(cell2)
// A new row will be appended FOR EVERY EMPLOYEE that got 
        document.getElementById("translator_body").appendChild(row)

        }

    } else {
        alert ("Something went wrong, make sure your Java is running")
    }

    
//Note: Spelling mistakes in JS can be devastating
}//get all words


async function getThisEnglishWord (){
// console.log((document.getElementById("wordInput").value))
let eW = document.getElementById('wordInput').value
    let response2 = await fetch(url2 + eW)

    //log the response in the console just to see the response eobject

    console.log (response2)

    //control flow on status code

    if (response2.status == 200) {
        
        let data2 = await response2.json();//translate json and set it equal to data
        //. json is the function that turns our json back into JS

        for(let English_word of data2){// for each english word, do something

        let row= document.createElement("tr")
        let cell = document.createElement("td")
let cell2 = document.createElement("td")
        cell.innerHTML = English_word.english_word
        cell2.innerHTML = English_word.eng

        row.appendChild(cell)
        row.appendChild(cell2)
// A new row will be appended FOR EVERY EMPLOYEE that got 
        // document.getElementById("translator_body").appendChild(row)

        }

    } else {
        alert ("Something went wrong, make sure your Java is running")
    }

} //get this word

async function loginFunction (){
 let user  = document.getElementById("username").value
 let pass = document.getElementById("password").value

 //We send this information as JSON to Java
 let userCreds = {
    username: user,
    password: pass

 }//left values are the properties of this object, the right values are the variables
 // The names of the variables must match our JAVA object, which in his case is our log in DTO
console.log(userCreds)

//Fetch request to the server
//This fetch request had two parts


let response = await fetch(url + "/login", {
//this is a post rwuest instead of a get fetch
method: "POST",
body: JSON.stringify(userCreds),
credentials: "include"
//this last line will ensure a cookie gets captured so that we can use sessions
//future fetches after login will require this include variable

})
console.log(response.status)
if (response.status === 202) {
    //convert the incoming user data from JSON to JS
    let data = await response.json();
    //Wipe our login row if login is successful
    document.getElementById("loginRow").innerText = "Welcome " + data.username

    //This is where page redirect should go.
}else {
    document.getElementById("WelcomeHead").innerText="Login Failed :( Try Again"
    document.getElementById("WelcomeHead").style.color = red
}

}

//Ben recommends having one login page, and based on the user's user