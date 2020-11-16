function contrasena() {
    const contrasena1 = document.getElementById('contrasena1');
    
    const contrasena2 = document.getElementById('contrasena2');

    if (contrasena1.value !== contrasena2.value) {
        document.getElementById('msjpass').classList.remove('d-none');
    } else {
        document.getElementById('msjpass').classList.add('d-none');
        document.getElementById('btnRegistro').disabled = false;
    }
    document.getElementById('btnRegistro').target = "null";
}

//contrasena2 = document.getElementById('contrasena');
//contrasena2.addEventListener('keyup', function (){
//    doEvaluar();
//});
//
//var doEvaluar=function(){
//    contrasena1=document.getElementById('contra');
//    contrasena2=document.getElementById('contrasena2');
//    if (contrasena1.equals(contrasena2)) {
//        document.getElementById('msjpass').classList.add('d-none');
//        document.getElementById('btnRegistro').disabled = false;
//    }else{
//        document.getElementById('msjpass').classList.remove('d-none');
//    }
//};
