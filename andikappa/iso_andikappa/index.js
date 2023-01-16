
const url = "http://3.145.155.9/"
//"http://127.0.0.1:8080/"
//"http://18.222.31.44/"


//Auth
console.log(localStorage.length)
if(localStorage.length == 0){
    window.location.href = "/login.html"
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
    <p>Author: <a class = "authorinfo" href = "#" data-userid=${author.userid} data-cred=${author.cred} data-sex=${author.sex} title = 'cred = ${author.cred} sex = ${author.sex}'>${author.firstname} ${author.surname}</a></p>

  `;
  resultsElement.appendChild(card);

}
resultsElement.addEventListener('click', function (event) {
  if (event.target.classList.contains('authorinfo')) {
    const cred = event.target.dataset.cred;
    const sex = event.target.dataset.sex;
    const author = event.target.dataset.userid;
    localStorage.setItem('clickedauthorid', author);
    localStorage.setItem('clickedauthorcred',cred);
    localStorage.setItem('clickedauthorsex',sex);
    window.location.href = '/profile.html';
  }
});



}if (resultsElement.innerText == ''){
    document.getElementById("notfound").innerText = "Translation doesn't exist :("
}
}


