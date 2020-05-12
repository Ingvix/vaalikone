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

function palauta(button) {
	var tekstiBoxi = button.parentElement.previousElementSibling.firstElementChild
	tekstiBoxi.value = tekstiBoxi.dataset.original
	tekstiBoxi.style.backgroundColor = ""
}

function tarkistaVastaavuus(textInput) {
	if (textInput.value == textInput.dataset.original) {
		textInput.style.backgroundColor = ""
	} else textInput.style.backgroundColor = "yellow"
}

function tarkistaMuutokset() {
	var kentat = document.querySelectorAll(".text input, .text textarea")
	var onMuutoksia = false
	for (let kentta of kentat) {
		if (kentta.value == "") {
			alert("Täytä kaikki kentät.")
			return false
		}
		if (kentta.value != kentta.dataset.original) {
			onMuutoksia = true
			console.log(kentta)
		}
	}
	if (!onMuutoksia) {
		alert("Ei muutoksia.")
	}
	return onMuutoksia
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