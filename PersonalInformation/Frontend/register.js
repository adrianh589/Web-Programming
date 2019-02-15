//Function AJAX
function loadDoc() {
  var xhttp = new XMLHttpRequest();
  var firstName = document.getElementById("firstName").value;
  var lastName = document.getElementById("lastName").value;
  var email= document.getElementById("email").value;
  var creditCardType = document.getElementById("creditCardType").value;
  var cardHolder = document.getElementById("cardHolder").value;
  var cardNumber = document.getElementById("cardNumber").value;
  var cvv2 = document.getElementById("cvv2").value;
  var expDate = document.getElementById("expDate").value;
  var streetAdress = document.getElementById("streetAdress").value;
  var city = document.getElementById("city").value;
  var state = document.getElementById("state").value;
  var zip = document.getElementById("zip").value;
  var country = document.getElementById("country").value;
  var phone = document.getElementById("phone").value;
  var securityCode = document.getElementById("code").innerText;
  var securityCodeField = document.getElementById("securityCodeField").value;
  var empty = "";

  //Validate if all fields are filled
  if (firstName==empty||lastName==empty||email==empty||creditCardType==empty||cardHolder==empty||
  cardNumber==empty||cvv2==empty||expDate==empty||streetAdress==empty||city==empty||state==empty||
  zip==empty||country==empty||phone==empty){
    alert("Rellene todos los campos")

  } else if (securityCodeField!==securityCode||securityCodeField==empty) {//Validate if the code is correct
    alert("El codigo de seguridad es incorrecto")
  }
  else{//Registered user successfully
      xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
         document.getElementById("respuesta").innerHTML = this.responseText;
        }
      };
      xhttp.open("GET", "../Backend/register.php?nombre="+firstName+"&apellido="+lastName+"&email="+email+"&tipoTarjeta="+creditCardType
            +"&portadorTarjeta="+cardHolder+"&numeroTarjeta="+cardNumber+"&cvv2="+cvv2+"&fechaExp="+expDate+"&direccion="+streetAdress
            +"&ciudad="+city+"&estado="+state+"&zip="+zip+"&pais="+country+"&telefono="+phone+"&codigoSeguridad="+securityCode, true);
      xhttp.send();
      alert("Usuario registrado con exito")
    }
  }
f
  //Funtion to generate automatic code
  function generateCode(){
    var security_code = Math.floor((Math.random() * 9999) + 1000);
    document.getElementById("code").innerHTML = security_code;
  }
