<%-- 
    Document   : executaPrincipal
    Created on : 01/10/2020, 19:57:52
    Author     : RFagundes
--%>

<%@page import="java.util.Date"%>
<%@page import="java.math.BigDecimal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import= " br.com.model.ObjetosRescisao" %>
<%@page import= " br.com.model.CalcularRescisao"%>

<!DOCTYPE html>

<html lang="pt-br">
    
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="css/style.css" />
        <title>executaAplicação</title>
	
	   
		     
    </head>
    
    
    
    <body>
	
	
	
	  
		   
	  <%	      
	   String salario, admissao , demissao, tipo, ferias ; 		   
		   
	   
	   salario  = request.getParameter("salario").replace("," , ".") ;  
	   
	   admissao = request.getParameter("admissao");
		   
           demissao = request.getParameter("demissao");		   
	   
	   ferias   = request.getParameter("ferias");
	   
	   tipo     = request.getParameter("tipo");
	    
	   BigDecimal salarioBD = new BigDecimal(salario);
	   
	   
	   
	   ObjetosRescisao ob   = new ObjetosRescisao();
	   
	   
           ob.setSalarioBD(salarioBD);	   
           ob.setAdmissao(admissao);
	   ob.setDemissao(demissao);
	   ob.setTipo(tipo);
	   ob.setFerias(ferias);
	     
	   

	%>
	
	
<blockquote class="citacao col-wide" data-anime="right">
	

   <div class="inicio">    	
	
       <h1>Calculo de Rescisão!</h1>
       
   </div>  
	
	
  </blockquote>
    






	
	
<blockquote class="citacao col-wide" data-anime="left">
	

   <div class="descricao">    
    
        
	    <h2>Descrição:</h2>
	    
	   <%=
	     CalcularRescisao.admissao()
	    %>   
	    <br/>	
	    <%=
	     CalcularRescisao.admissaoStr()
	    %> 
	   <br/>	
	    <%=
	      CalcularRescisao.demissao()
	    %> 
	    <br/>	
	    <%=
	      CalcularRescisao.demissaoStr()
	    %>  
	    
	    <br/>	
	    <%=
	      " Periodo Trabalhado "+CalcularRescisao.periodoTrabalhado()
	    %>  
	    <br/>	
	    <%=
	      CalcularRescisao.timeYears()+" Anos "
	    %>  
	    <br/>	
	    <%=
	      CalcularRescisao.timeMonth()+" meses "
	      %>  
	    <br/>	
	    <%=
	      CalcularRescisao.timeDays()+" dias "
	    %>  
	    <br/>	
	    <%=
	      " Saldo trabalhado "+CalcularRescisao.periodoSaldo()
	    %>  
	    <br/>	
	    <%=
	      " meses ref para 13º "+CalcularRescisao.saldoMonth()
	    %>  
	    <br/>	
	    <%=
	      " dias ref para saldo "+CalcularRescisao.saldoDays()
	    %>  

    </div>  
	
	
  </blockquote>
    
    
    
	    
	    
	    
	    
   
	
 <blockquote class="citacao col-wide" data-anime="left">
		
	   
  <div class="valores">	   
	   
	  <h2>Vencimentos:</h2>
	    
	    <%=
		" Salário Base "+CalcularRescisao.salario()
	    %> 
	    <br/>
	     <%=
		" Saldo de Salário "+CalcularRescisao.calcularSaldoSalario()
	    %> 
	    <br/>
	      <%=
		" Férias vencidas "+CalcularRescisao.calcularFeriasVencidas()
	    %> 
	    <br/>
	      <%=
		" Férias Proporcionais  "+CalcularRescisao.calcularFeriasProporconal()
	    %> 
	    <br/>
	     <%=
		" 13º Salário  "+CalcularRescisao.calcular13Salario()
	    %> 
	    <br/>
	     <%=
		" Aviso Prévio Indenizado  "+CalcularRescisao.calcularAvisoPrevio()
	    %> 
	    <br/>
	     <%=
		" Total da Rescisão  "+CalcularRescisao.calcularTotal()
	      %> 
 </div>

 </blockquote>
   
    
		
	
	  
	
	
	
	
	      
	    
	    
  <blockquote class="citacao col-wide" data-anime="right">
		
  <div class="desc"> 
               <h2>Descontos:</h2>        
      
		<%=
		  "Desconto inss sobre saldo Salario "+CalcularRescisao.calcularInssSaldoSalario()
	        %>  
		  <br/>
		
		  <%=
		  "Desconto inss sobre 13º Salario "+CalcularRescisao.calcularInss13()
	        %>  
		  <br/>
		  
		  <%=
		  "Desconto inss sobre saldo Aviso "+CalcularRescisao.calcularInssAviso()
	        %>  
		  <br/>
		  
		   <%=
		  "Descontos totais "+CalcularRescisao.calcularDesconto()
	           %>  
		  <br/>
		  
	</div> 
		  
  </blockquote>
	
 
		  
		  
		  
		  
		  
		  
		  
		  
		
		    
		 <blockquote class="citacao col-wide" data-anime="right">
		     
		<div class="final">     
		     
		    <%=
		       " Total "+CalcularRescisao.calcularFinal()
	             %>     
		      
		 </div>
		     
		 </blockquote>
	
		
	
		     
		     
		     
		     
	<script type="text/javascript" src="js/funcoes.js" ></script>  	     
		     
    </body>
</html>
