//Function AJAX
function loadDoc() {
  var xhttp = new XMLHttpRequest();
  var modifyField = document.getElementById("modifyField").value;
  var id = document.getElementById("ID").value;
  var modifySelect = document.getElementById("modifySelect").value;

  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
     document.getElementById("respuesta").innerHTML = this.responseText;
    }
  };
  xhttp.open("GET", "../Backend/editInformation.php?modifyField="+modifyField+"&ID="+id+"&modifySelect="+modifySelect, true);
  xhttp.send();
}

//Function with AJAX to call listInformation
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
