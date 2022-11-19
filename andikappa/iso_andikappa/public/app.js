// Initialize Firestore through Firebase
import { initializeApp } from "https://www.gstatic.com/firebasejs/9.13.0/firebase-app.js";
import { getAnalytics } from "https://www.gstatic.com/firebasejs/9.13.0/firebase-analytics.js";
    // TODO: Add SDKs for Firebase products that you want to use
    // https://firebase.google.com/docs/web/setup#available-libraries
import { getAuth } from 'https://www.gstatic.com/firebasejs/9.13.0/firebase-auth.js'
import { getFirestore } from 'https://www.gstatic.com/firebasejs/9.13.0/firebase-firestore.js'
import { collection, addDoc, doc, setDoc } from "https://www.gstatic.com/firebasejs/9.13.0/firebase-firestore.js"; 
const firebaseApp = initializeApp({
  apiKey: "AIzaSyAcFqlPGM7U65HFet91ObLIN8l3sCQPy4c",
  authDomain: "andikappa-2b175.firebaseapp.com",
  projectId: "andikappa-2b175",
  storageBucket: "andikappa-2b175.appspot.com",
  messagingSenderId: "508193390719",
  appId: "1:508193390719:web:b6ddf2a56d493b19e37f4a",
  measurementId: "G-0Y1Y0QT2G6"
});

const db = getFirestore();


document.getElementById("language").onclick = languagecheck
document.getElementById("ö").onclick = addö
document.getElementById("ñ").onclick = addñ

document.getElementById("submitNewTranslation").onclick = addtranslation



// IN LINE FUNCTIONS
window.onload = function() {
  document.getElementById("language").value = "Add New Translation"
}




    //DIVORCED FUNCTIONS
 function addñ(){

  document.getElementById("efikword").value = document.getElementById("efikword").value += "ñ"

 }

 function addö(){
document.getElementById("efikword").value = document.getElementById("efikword").value += "ö"
}
 


function languagecheck (){
  console.log(document.getElementById("language").value)

if (document.getElementById("language").value == "Search English Word") {

  console.log("englishdetected")
  window.location.href = "getEnglish.html"


  
}else if (document.getElementById("language").value == "Search Efik Word") {

 
  window.location.href = "getEfik.html"

  

}
}

async function addtranslation (){

  let context = document.getElementById("context").value
  let definition =  document.getElementById("definition").value
  let efikword = document.getElementById("efikword").value

  
console.log(efikword)
await addDoc(doc(db, "translations"), {
  "Context": context,
  "Definition": definition,
  "EfikWord": efikword
  // "CreatedAt": serverTimestamp()
});



console.log("addTranslation function run")

}