//Welcome
import firebase from "firebase/app";

export class app{
firebaseApp = firebase.initializeApp({
  apiKey: "AIzaSyAcFqlPGM7U65HFet91ObLIN8l3sCQPy4c",
  authDomain: "andikappa-2b175.firebaseapp.com",
  projectId: "andikappa-2b175",
  storageBucket: "andikappa-2b175.appspot.com",
  messagingSenderId: "508193390719",
});

// console.log(firebaseApp.firestore)
database = firebase.firestore();

// database.collection("transactions").add
// await setDoc(doc(db, "translations", "1"), {
//   "Context": document.getElementById("context").value,
//   "Definition": document.getElementById("definition").value,
//   "Efik-Word": document.getElementById("efikword").value
//   // "CreatedAt": serverTimestamp()
// });

// db.collection("translations").doc("2").set({

// })

// console.log("addTranslation function run")


// }

}