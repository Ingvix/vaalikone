/**
 * 
 */
function palautaKysymys(button) {
	var kysymysBoxi = button.parentElement.previousElementSibling.firstElementChild
	kysymysBoxi.value = kysymysBoxi.dataset.original
	kysymysBoxi.style.backgroundColor = ""
}

function tarkistaVastaavuus(textInput) {
	if (textInput.value == textInput.dataset.original) {
		textInput.style.backgroundColor = ""
	} else textInput.style.backgroundColor = "yellow"
}

function tarkistaMuutokset() {
	var rivit = document.getElementsByClassName("dataRow")
	for (let rivi of rivit) {
		var valintaruutu = rivi.childNodes[3].firstElementChild
		var kysymysBoxi = rivi.childNodes[5].firstElementChild
		if (valintaruutu.checked || kysymysBoxi.value != kysymysBoxi.dataset.original) {
			return true
		}
	}
	return false
}

function suodata() {
	var syote = document.getElementById("suodatin");
	var suodatin = syote.value.toUpperCase();
	var lista = document.getElementById("kysymysLista");
	var tr = lista.getElementsByTagName("tr");

	for (i = 0; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td")[2];
		if (td) {
			kysymys = td.firstChild.value;
			original = td.firstChild.dataset.original;
			if (kysymys.toUpperCase().indexOf(suodatin) > -1 || original.toUpperCase().indexOf(suodatin) > -1) {
				tr[i].style.display = "";
			} else {
				tr[i].style.display = "none";
			}
		}
	}
}