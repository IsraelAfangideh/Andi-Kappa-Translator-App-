
const url = "http://127.0.0.1:8080/"
//"http://18.222.31.44/"


//Auth
console.log(localStorage.length)
if(localStorage.length == 0){
    window.location.href = "../login/login.html"
}
const resultsElement = document.getElementById('results');
const excuseElement = document.getElementById("notfound");




document.getElementById('Translate').onclick = getefikword

async function getefikword(){
    event.preventDefault();

    let efikword = document.getElementById("word").value

    resultsElement.innerHTML = ''
    excuseElement.innerText = ''
let response = await fetch (url + "fetch/" + efikword,{
      
})


if (response.status == 200){
    let data = await response.json();

    console.log(data)
for (let i = 0; i < data.length; i++) {
  const word = data[i];

  let authorresponse = await fetch (url + "author/fetch/" + word.authorid[0],{
      
  })


  let author = await authorresponse.json()
  console.log(author)
  const card = document.createElement('div');
  card.classList.add('word-card');
  card.innerHTML = `
    <h2>${word.englishword}</h2>
    <p>${word.efikword}</p>
    <p>${word.example}</p>
    <p>Author: <a class = "authorinfo" href = "http://127.0.0.1:8080/author/fetch/${author.userid}" title = 'cred = ${author.cred} sex = ${author.sex}'>${author.firstname} ${author.surname}</a></p>
  `;
  resultsElement.appendChild(card);

  function savelocalstorage(){
    localStorage.setItem('clickedauthorid', author.userid)
  }
  const authorLink = document.querySelector('.authorinfo');
  authorLink.addEventListener('click', savelocalstorage);

  console.log(localStorage.getItem('clickedauthorid'))
}
}if (resultsElement.innerText == ''){
    document.getElementById("notfound").innerText = "Translation doesn't exist :("
}
}


