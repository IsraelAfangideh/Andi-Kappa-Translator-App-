//Auth
console.log(localStorage.length)
if(localStorage.length == 0 || localStorage.getItem('authorized') == 'null'){
    window.location.href = "/login.html"
    
    localStorage.setItem('authorized', 'null')

}

