let index = 0;

function addVezhba() {
    let vezhba = document.getElementById('vezhba');
    let vezhbaId = parseInt(vezhba.value);
    let hranabana = vezhba.options[vezhba.selectedIndex].text;
    let povtoruvanja = parseInt(document.getElementById('povt').value);

    let tabela = document.getElementById('tabela_ve');

    let rowdiv = document.createElement("div");
    rowdiv.setAttribute("class", "row sodrzi ahh");
    rowdiv.setAttribute("name", "vezhbas");

    let vezhbaIn = document.getElementById("ve" + index);
    vezhbaIn.value = vezhbaId;
    let povtoruvanjeIn = document.getElementById("po" + index++);
    povtoruvanjeIn.value = povtoruvanja;

    let vezhbadiv = document.createElement("div");
    vezhbadiv.setAttribute("class", "col-6");
    vezhbadiv.innerHTML = hranabana;
    rowdiv.appendChild(vezhbadiv);

    let povtoruvanjadiv = document.createElement("div");
    povtoruvanjadiv.setAttribute("class", "col-6");
    povtoruvanjadiv.innerHTML = povtoruvanja;
    rowdiv.appendChild(povtoruvanjadiv);


    tabela.appendChild(rowdiv);


}