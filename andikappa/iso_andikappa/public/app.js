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

await setDoc(doc(db, "translations", "1"), {
  "Context": document.getElementById("context").value,
  "Definition": document.getElementById("definition").value,
  "Efik-Word": document.getElementById("efikword").value,
  "English-Word": document.getElementById("englishword").value,
  "Word-Type": document.getElementById("wordtype").value
  // "CreatedAt": serverTimestamp()
});

// db.collection("translations").doc("2").set({

// })

console.log("addTranslation function run")


// }