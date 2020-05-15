let indexh = 0;
let indexp = 0;

function addHrana() {
        let hrana = document.getElementById('hrana');
        let hranaid = parseInt(hrana.value);
        let hranabana = hrana.options[hrana.selectedIndex].text;
        let kolichina = parseInt(document.getElementById('kol_hr').value);

        let tabela = document.getElementById('tabela_hr');

        let rowdiv = document.createElement("div");
        rowdiv.setAttribute("class", "row sodrzi ahh");
        rowdiv.setAttribute("name", "hranas");

        let hranadiv = document.createElement("div");
        hranadiv.setAttribute("class", "col-6");
        hranadiv.innerHTML = hranabana;
        rowdiv.appendChild(hranadiv);

        let hranaIn = document.getElementById("hr" + indexh);
        hranaIn.value = hranaid;
        let kolichinIn = document.getElementById("hrk" + indexh++);
        kolichinIn.value = kolichina;
        //kolichinIn.setAttribute("class", "d-none");

        hranadiv.appendChild(hranaIn);

        let kolichinadiv = document.createElement("div");
        let kolichinatext = document.createTextNode(kolichina);
        kolichinadiv.setAttribute("class", "col-6");
        kolichinadiv.innerHTML = kolichina;
        rowdiv.appendChild(kolichinadiv);

        kolichinadiv.appendChild(kolichinIn);

        tabela.appendChild(rowdiv);



}

function addPialok() {
        let pialok = document.getElementById('pialok');
        let pialokid = parseInt(pialok.value);
        let pialokpi = pialok.options[pialok.selectedIndex].text;
        let kolichina = parseInt(document.getElementById('kol_pi').value);

        let tabela = document.getElementById('tabela_pi');

        let rowdiv = document.createElement("div");
        rowdiv.setAttribute("class", "row sodrzi ahh");


        let pialokdiv = document.createElement("div");
        pialokdiv.setAttribute("class", "col-6");
        pialokdiv.innerHTML = pialokpi;
        rowdiv.appendChild(pialokdiv);


    let pialokIn = document.getElementById("pi" + indexp);
    pialokIn.value = pialokid;
    let kolichinIn = document.getElementById("pik" + indexp++);
    kolichinIn.value = kolichina;

    pialokdiv.appendChild(pialokIn);

        let kolichinadiv = document.createElement("div");
        kolichinadiv.setAttribute("class", "col-6");
        kolichinadiv.innerHTML = kolichina;
        kolichinadiv.appendChild(kolichinIn);
        rowdiv.appendChild(kolichinadiv);

        tabela.appendChild(rowdiv);
}