/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

import java.math.BigDecimal;

/**
 *
 * @author RFagundes
 */


              public class ObjetosRescisao {
		  
		
		  
    private static BigDecimal salarioBD ;
    private static String feriasStr;
    private static String tipoStr;
    private static String admissaoStr;
    private static String demissaoStr;

    private static boolean feriasBl; 
    
    
    
       public static BigDecimal getSalarioBD() {
	    return salarioBD;
    }

   
       
       
    public static void  setSalarioBD(BigDecimal salario) {
	     salarioBD = salario;
    }


    
    

    
    
    
    
    
    public static String getFerias() {
	return feriasStr;
    }

   
    public void setFerias(String ferias) {
	feriasStr = ferias;
    }


    
    
    
    
    
    
    
  
    
    
    
    
    
    
    
    
    
    public static String getTipo() {
	return tipoStr;
    }

   
    public void setTipo(String tipo) {
	tipoStr = tipo;
    }

    
    
    
    
    
    
    
    public static String getAdmissao() {
	return admissaoStr;
    }

    
    public  void setAdmissao(String admissao) {
	admissaoStr = admissao;
    }

    
    
    
    
    
    
    
    
     public static String getDemissao() {
	return demissaoStr;
    }

    
    public  void setDemissao(String demissao) {
	demissaoStr = demissao;
    }
    
    
    
    
    
    
   
		  
		  
    
    
    
    
    
    
    
    
}
