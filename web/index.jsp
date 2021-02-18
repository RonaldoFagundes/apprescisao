<%-- 
    Document   : index
    Created on : 01/10/2020, 18:26:40
    Author     : RFagundes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="pt-br">
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="css/style.css" />
        <title>Principal</title>
    </head>
    
    
<body>
      
    
    
        
	
	
 <div class="c_rescissao">
	    
      
      
  <form action="executaPrincipal.jsp" method="post">
	
      <label>Admissão:</label><br/>	 
	  <input type="date"     name="admissao"/><br/>
	  
      <label>Demissão:</label><br/>  
	 <input type="date"     name="demissao"/><br/> 
	 
      <label></label><br/>  	    
	 <input type="text"     name="salario"  placeholder="ultimo salário"/><br/>    
	
      <label></label><br/>  
		Férias Vencida? <br/>		
		Sim <input type="radio"  name="ferias"  value="sim"  nochecked="yes"  /><br/>
		Não <input type="radio"  name="ferias"  value="nao"  nochecked="yes"  /><br/>
	
	<h3>Motivo :</h3>
	
        <select name="tipo">	
	     <option>Pedido</option>
	     <option>Demissao</option>	    
	</select><br/>
	 
	<label></label><br/>  
	 <input type="submit"  value="Calcular"/>
	 
    </form>
      
 		    
  </div>	
	

        
    
    
    
    
 </body>
    
    
    
    
    
</html>
