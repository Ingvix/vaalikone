window.onload = tasaaSarakkeet

function tasaaSarakkeet() {
	var otsakerivi = document.getElementById("tableHeader")
	var tietorivi = document.querySelector(".dataRow")
	var otsakkeet = otsakerivi.children
	var tiedot = tietorivi.children
	for (i = 0; i < otsakkeet.length-1; i++) {
		if (otsakkeet[i].offsetWidth < tiedot[i].offsetWidth) {
			otsakkeet[i].style.width = tiedot[i].offsetWidth - (i == 0 ? 8 : 9) + "px"
        } else {
			tiedot[i].style.width = otsakkeet[i].offsetWidth - (i == 0 ? 8 : 9) + "px"
        }
    }
}

function suodata() {
	var syote = document.getElementById("suodatin")
	var ehdot = [...document.getElementsByClassName("ehto")].filter(ehto => ehto.checked)
	var suodatin = syote.value.toUpperCase()
	var lista = document.getElementById("rullaLista")
	var tr = lista.getElementsByTagName("tr")
	
	for (i = 0; i < tr.length; i++) {
		tds = tr[i].getElementsByTagName("td")
		ehdot.some(function(ehto) {
			td = tds[ehto.value]
			if (td) {
				tieto = td.firstElementChild.innerText
				if (tieto.toUpperCase().indexOf(suodatin) > -1) {
					arvo = ""
					return true
				} else {
					arvo = "none"
				}
			}
		})
		tr[i].style.display = arvo
	}
}

function deleteData(){


	var xhttp = new XMLHttpRequest();

	var deleteId = document.getElementById("eID").value;
	

    xhttp.onreadystatechange = function() {
      if (this.readyState == 4 && this.status == 200) {
          alert("Poistit ehdokkaan " + deleteId);
          window.location="http://localhost:8080/Ehdokaspaneeli"
      }
   
    };
    xhttp.open("POST","./ehdokasservice/delete/"+deleteId,true);
    
    xhttp.send();
}


