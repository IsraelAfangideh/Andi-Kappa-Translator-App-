window.onload = getauthorprofile

const url = "http://3.145.155.9/"

async function getauthorprofile(){

let authorid = localStorage.getItem('clickedauthorid')

  let authorresponse = await fetch (url + "author/fetch/" + authorid ,{
      
  })

  let author = await authorresponse.json()

  document.getElementById('firstname').value = author.firstname
  document.getElementById('lastname').value = author.surname
  document.getElementById('cred').value = author.cred
  document.getElementById('sex').value = author.sex

  document.getElementById('profileheader').innerText = (author.firstname + "'s Home Page")


  console.log(author)
}
