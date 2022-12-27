function gerarMatricula() {
    var dia = new Date().getDay();
    var mes = new Date().getMonth();
    var ano = new Date().getFullYear();
    var numero = Math.floor(Math.random() * 1000);
    //var munero = Math.floor(Math.random() * 2);
    document.getElementById('matricula').value = (ano + "." + mes + "." + dia + "-" + numero);
}