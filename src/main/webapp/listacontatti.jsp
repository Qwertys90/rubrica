<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@page import="java.util.List" %>
    <%@page import="it.dstech.models.Contact" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
<link href="../css/bootstrap2.css" rel="stylesheet" type="text/css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="../js/jquery-3.2.1.js"></script>
<script src="../js/bootstrap.js"></script>
<script src="../js/bootstrap-confirmation.js"></script>
<style type="text/css">
table{
border:2px solid rgb(0,191,255);
}
td, th{
padding:2px 10px 2px 10px;
}

tr:hover {
 backgroundr:rgba(0, 191, 255, 0.9) !important;
}
</style>
<script type=text/javascript>
function modifica(contactID, contactNome, contactTelefono, contactEmail){
    document.getElementById("ID").value = contactID; 
    document.getElementById("Nome").value = contactNome;  
    document.getElementById("Telefono").value = contactTelefono;
    document.getElementById("Email").value = contactEmail;
 }


function conferma(){
if(!confirm('Eliminare il contatto?'))
return false;
}


function sortTable(a) {
  var table, rows, switching, i, x, y, shouldSwitch;
  table = document.getElementById("myTable");
  switching = true;
  /*Make a loop that will continue until
  no switching has been done:*/
  while (switching) {
    //start by saying: no switching is done:
    switching = false;
    rows = table.getElementsByTagName("TR");
    /*Loop through all table rows (except the
    first, which contains table headers):*/
    for (i = 1; i < (rows.length - 1); i++) {
      //start by saying there should be no switching:
      shouldSwitch = false;
      /*Get the two elements you want to compare,
      one from current row and one from the next:*/
      x = rows[i].getElementsByTagName("TD")[a];
      y = rows[i + 1].getElementsByTagName("TD")[a];
      //check if the two rows should switch place:
      if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
        //if so, mark as a switch and break the loop:
        shouldSwitch= true;
        break;
      }
    }
    if (shouldSwitch) {
      /*If a switch has been marked, make the switch
      and mark that a switch has been done:*/
      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
      switching = true;
    }
  }
  rows = table.getElementsByTagName("TR");
  for (i = 1; i < (rows.length); i++) {
	  if(i%2==0)
		  rows[i].style.background = "rgba(0, 191, 255, 0.6)";
	  else
		  rows[i].style.background = "rgba(0, 191, 255, 0.2)";
  }
}

</script>

</head>
<body>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Nuovo Contatto</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form method=post action=save>
        
  <div class="input-group">
    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
    <input id="email" type="text" class="form-control" name="nome" placeholder="Nome">
  </div>
   <div class="input-group">
    <span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
    <input id="email" type="text" class="form-control" name="telefono" placeholder="Telefono">
  </div>
   <div class="input-group">
    <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
    <input id="email" type="text" class="form-control" name="mail" placeholder="Email">
  </div>


      </div>
      <div class="modal-footer">
      <button type="submit" class="btn btn-primary">Aggiungi Contatto</button></form>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        
      </div>
    </div>
  </div>
</div>

<div class="modal fade" id="modalModifica" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Nuovo Contatto</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form method=post action=update>
        <input type=hidden name=ID id=ID value=0>
  <div class="input-group">
    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
    <input id="Nome" type="text" class="form-control" name="nome" placeholder="Nome">
  </div>
   <div class="input-group">
    <span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
    <input id="Telefono" type="text" class="form-control" name="telefono" placeholder="Telefono">
  </div>
   <div class="input-group">
    <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
    <input id="Email" type="text" class="form-control" name="mail" placeholder="Email">
  </div>




      </div>
      <div class="modal-footer">
      <button type="submit" class="btn btn-primary">Modifica Contatto</button></form>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        
      </div>
    </div>
  </div>
</div>




<div class="card card-container" id=myTable>
<table width=100%>
<tr style="background-color: rgba(0, 191, 255, 0.8);"><th>Nome<span onclick="sortTable(0)" class="glyphicon glyphicon-download"></span></th><th>Mail<span onclick="sortTable(1)" class="glyphicon glyphicon-download"></span></th><th>Telefono<span onclick="sortTable(2)" class="glyphicon glyphicon-download"></span></th><th></th><th></th></tr>
<%  
List<Contact> list = (List<Contact>) request.getAttribute("contactLis");
int i = 1;
for(Contact contact : list) {
	String colore;
	if(i%2==0) colore="rgba(0, 191, 255, 0.6)";
	else colore="rgba(0, 191, 255, 0.2)";
	
    out.println("<tr style='background-color:"+colore+"'><td><span class='glyphicon glyphicon-user'></span> " + contact.getNome() + "</td><td><span class='glyphicon glyphicon-envelope'></span> " + contact.getMail() + "</td><td><span class='glyphicon glyphicon-earphone'></span> " + contact.getTelefono() + "</td><td align=right width=200px><div style='display:block'><form onsubmit='return conferma()' method=post action='delete'><input type=hidden name=idElimina value="+contact.getID()+"><button class='btn btn-danger' type=submit value=elimina><span class='glyphicon glyphicon-trash'></button></form></td><td><button  class='btn btn-success' data-toggle='modal' data-target='#modalModifica' href=# onclick=\"modifica('"+contact.getID()+"','"+contact.getNome()+"','"+contact.getTelefono()+"','"+contact.getMail()+"')\"><span class='glyphicon glyphicon-edit'></span></div></td></tr>");
	i++;
}
%>

</table>
<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Aggiungi nuovo contatto</button>

</div>
</body>
</html>