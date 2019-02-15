//Function AJAX
function loadDoc() {
  var xhttp = new XMLHttpRequest();
  var deletep = document.getElementById("delete").value;

        xhttp.onreadystatechange = function() {
          if (this.readyState == 4 && this.status == 200) {
           document.getElementById("respuesta").innerHTML = this.responseText;
          }
        };
        xhttp.open("GET", "../Backend/eraseInformation.php?deletep=" + deletep, true);
        xhttp.send();
  }

  //Function with AJAX to call listInformation
  list();
  function list() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
             document.getElementById("table").innerHTML = this.responseText;
            }
          };
          xhttp.open("GET", "../Backend/listInformation.php",true);
           xhttp.send();
    }
    setInterval(list,100);

    
