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