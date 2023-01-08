// const data = [{xid: 1, englishword: 'God', efikword: 'Abasi', context: 'The word for God or a god', poster: null}];

const url = "http://18.222.31.44/"

const resultsElement = document.getElementById('results');



document.getElementById('Translate').onclick = getefikword

console.log(efikword)
async function getefikword(){
    let efikword = document.getElementById("word").value
    resultsElement.innerHTML = ''
let response = await fetch (url + "fetch/" + efikword,{
      
})

if (response.status == 200){
    let data = await response.json();

    console.log(data)
for (let i = 0; i < data.length; i++) {
  const word = data[i];
  const card = document.createElement('div');
  card.classList.add('word-card');
  card.innerHTML = `
    <h2>${word.englishword}</h2>
    <p>${word.efikword}</p>
    <p>${word.context}</p>
  `;
  resultsElement.appendChild(card);
}
}
}