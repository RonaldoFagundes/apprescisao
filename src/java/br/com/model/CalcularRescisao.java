/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 *
 * @author RFagundes
 */


     


                    public class CalcularRescisao {
    
	     
	
		    
	            private static  BigDecimal bdDias   = new BigDecimal(30);  
		    private static  BigDecimal bdMeses  = new BigDecimal(12);  
		    private static  BigDecimal bdTerco  = new BigDecimal(3); 
		    private static  BigDecimal bdZero   = new BigDecimal(0);
		    
		    
		    
		    
		    
		    private static  BigDecimal bdSalario, bdDiarias, bdSalarioMedia, bdSaldoSalario, 
			                       bdFeriasVencidas, bdFeriasPropo, bdTercoFerias,bdFeriasTotal, bd13Salario,
			                       bdAvisoPrv, bdTotal, bdInssSaldo, bdInssAviso ,bdInss13, bdDesc, bdFinal;
	
		    
		    
		    
		    private static int  iDaysT,  iMonthT ,  iYearsT, iDaysS, iMonthA, iAvosF, iAvos13;
		    
	           
		    
		
		    
private static DateFormat DateFormat_BR  = new SimpleDateFormat("dd-MM-yyyy");
		    
private static DateFormat DateFormat_US  = new SimpleDateFormat("yyyy-MM-dd");
		    
		    
private static DateTimeFormatter DateFormatterBR = DateTimeFormatter.ofPattern
	("dd/MM/yyyy");
		    
private static DateTimeFormatter DateFormatterUS = DateTimeFormatter.ofPattern
	("yyyy-MM-dd");
		    
		    
private static  NumberFormat  CURRENCYBR  = NumberFormat.getCurrencyInstance(new Locale("pt","BR"));  
		    
		    
		  
		    
		    
		    
		    
		    
		    
		    private static LocalDate  ldAdmissao , ldDemissao ,ldRef ; 
		    
	            private static Period     periodTrabalhado, periodSaldo;
	       
		    private static String     strAdmissao, strAdmissaoFormat, StrDemissao, strDemissaoFormat, strFerias;
		    
		   
	            private static String  StrRef   = "1999-12-31";
		    
		    
		    
		    
		    
	
		    
		    
		    
		    
		    
		    
		    
	
	  
		   
		   
		
		     public static String admissao (){
		    
		strAdmissao = ObjetosRescisao.getAdmissao();
	
		    return " admissão formato original "+strAdmissao;
		}
		
		
		     
		     
		     
		    public static String demissao (){
		    
		    StrDemissao = ObjetosRescisao.getDemissao();
		   return " demissão formato original "+StrDemissao;
		} 
		     
		     
		    
		    
		   
		       
		       public static String admissaoStr (){
			   
    //ldAdmissao = LocalDate.parse(strAdmissao, DateTimeFormatter.ofPattern("yyyy-MM-dd"));    
   // strAdmissaoFormat = ldAdmissao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    
      
    ldAdmissao = LocalDate.parse(strAdmissao, DateFormatterUS);    
    strAdmissaoFormat = ldAdmissao.format(DateFormatterBR);
    
              return " admissão formato covertido "+strAdmissaoFormat;
			 } 
		
		       
		       
		
		       
	      public static String demissaoStr (){
			   
    //ldDemissao = LocalDate.parse(StrDemissao, DateTimeFormatter.ofPattern("yyyy-MM-dd"));    
    //strDemissaoFormat = ldDemissao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
       
       
       
      ldDemissao = LocalDate.parse(StrDemissao,DateFormatterUS);
      strDemissaoFormat = ldDemissao.format(DateFormatterBR);
    
             return " demissão formato covertido "+strDemissaoFormat;
			 } 
		
		       
		       
		       
		       
		       
		       
		       
		         public static Period periodoTrabalhado (){
			    
	       periodTrabalhado = Period.between(ldAdmissao,ldDemissao);
			    
			       return periodTrabalhado;
			} 
			 
			
			
			
			public static int timeYears (){
			return iYearsT = periodTrabalhado.getYears();
			}
			
			
			public static int timeMonth (){
			return  iMonthT = periodTrabalhado.getMonths();
			}
			
			 public static int timeDays (){
			  return iDaysT = periodTrabalhado.getDays();
		       }
			
			 
			 
			 
			 
			 
			
			
		      public static Period periodoSaldo (){
			    
	       ldRef = LocalDate.parse(StrRef,DateFormatterUS);
			  
	       periodSaldo = Period.between(ldRef,ldDemissao);
			    
			       return periodSaldo;
			} 
		
		      
		      
			
			public static int saldoMonth (){
			return iMonthA = periodSaldo.getMonths();
			}       
			       
			 public static int saldoDays (){
		      return iDaysS = periodSaldo.getDays();
		       }
			 
	
		      
		      
		      
			
	  
		       
		      
		      
		      
		      
	            public static  String salario (){
	       
	     bdSalario      = ObjetosRescisao.getSalarioBD();
	      
	     bdDiarias      = bdSalario.divide(bdDias, RoundingMode.UP);
	     bdSalarioMedia = bdSalario.divide(bdMeses,RoundingMode.UP);
	       
	             return CURRENCYBR.format(bdSalario);
	       }
	
	
			     
			     
			     
		
		      

	          public static String calcularSaldoSalario (){
			    
		              if (iDaysS >= 1 ){
	    bdSaldoSalario = bdDiarias.multiply(BigDecimal.valueOf(iDaysS));
			   }
		    return CURRENCYBR.format(bdSaldoSalario);
			} 		      
				       
			
		  
		  
		  
	           public static String calcularFeriasVencidas (){
			    
			strFerias = ObjetosRescisao.getFerias();
		    
		             if(strFerias.equals("sim")){
			  
	    bdFeriasVencidas =   bdSalario.divide(bdTerco, RoundingMode.UP).add(bdSalario) ;  
		     
			     }
			    else {
			   bdFeriasVencidas = bdZero;	
			    }
			     return CURRENCYBR.format(bdFeriasVencidas);   
		       }
		  
		  
		  
		   
		   
		  
		  
		     public static String calcularFeriasProporconal (){
		     
			
			    if (iMonthT >=1 ){
			  
			     if(iDaysS >=15 ){
				
			  iAvosF = iMonthT +2 ;	
			    } 
			    else {
			   iAvosF = iMonthT + 1;	
			    }
			}
			else {
			  iAvosF =  1;  
			}
			   
		 bdFeriasPropo  = bdSalarioMedia.multiply(BigDecimal.valueOf(iAvosF));
			      
	         bdTercoFerias = bdFeriasPropo.divide(bdTerco,  RoundingMode.UP);

		 bdFeriasTotal = bdFeriasPropo.add(bdTercoFerias);      
			      
		      
	               return CURRENCYBR.format(bdFeriasTotal);
			      
         }	  
		  
		  
		  
		  
		  
		      public static String calcular13Salario (){
			
			
			
		              if (iMonthA >= 1 ){
			
				
			      if (iDaysS >= 15 ){
				  
			      iAvos13 = iMonthA + 2;
				
			      }
			      else {
				iAvos13 = iMonthA + 1;  
			      }
			      }
			     else {
				 
				iAvos13 = 1; 
			     }
			

			      
	bd13Salario = bdSalario.divide(bdMeses,RoundingMode.UP).multiply(BigDecimal.valueOf(iAvos13));
			      
			  return CURRENCYBR.format(bd13Salario);      
			    
			}  
		  
		  
		  
		
		  
		  
		  
		  public static String calcularAvisoPrevio (){
			    
		      
			       if(iYearsT >= 1){
	 bdAvisoPrv = bdSalario.add(bdDiarias.multiply(BigDecimal.valueOf(iYearsT * 3 )));
			       }
			     else{
			   bdAvisoPrv = bdSalario; 
			     }
		   return CURRENCYBR.format(bdAvisoPrv); 
			   }		       
				       
			
			
			
			
					 
		 	
	
				   
				   
				   
				   
				   
		           public static String calcularTotal (){
			  
		  bdTotal = bdSaldoSalario.add(bdFeriasVencidas).add(bdFeriasTotal).add(bd13Salario).add(bdAvisoPrv);
			             
			       return CURRENCYBR.format(bdTotal);
			   }
		      
		      
		      
			   
			   
			
		      
		          public static String calcularInssSaldoSalario (){
			    
		   if(bdSaldoSalario.compareTo(new BigDecimal(1045.00)) <= 0){
				
	      bdInssSaldo = bdSaldoSalario.multiply(BigDecimal.valueOf(7.5/100));
			    }
		 
		   else if (bdSaldoSalario.compareTo(new BigDecimal(1045.00)) > 1 || bdSaldoSalario.compareTo(new BigDecimal(2089.60)) <= 1) {
				
	      bdInssSaldo = bdSaldoSalario.multiply(BigDecimal.valueOf(9/100));
			    }
		 
		   else if(bdSaldoSalario.compareTo(new BigDecimal(2089.60)) > 1 || bdSaldoSalario.compareTo(new BigDecimal(3134.40)) <= 1) {
				
	      bdInssSaldo = bdSaldoSalario.multiply(BigDecimal.valueOf(12/100));
			    }
		 
		   else  if(bdSaldoSalario.compareTo(new BigDecimal(3134.90)) > 1 || bdSaldoSalario.compareTo(new BigDecimal(6101.06)) <= 1) {
				
	      bdInssSaldo = bdSaldoSalario.multiply(BigDecimal.valueOf(14/100));
			    }
 
			    return CURRENCYBR.format(bdInssSaldo);
		      }
		       
		       
		   
		   
		   
		      
		         public static String calcularInss13 (){
			    
		 if(bd13Salario.compareTo(new BigDecimal(1045.00)) <= 1){
				
	      bdInss13 = bd13Salario.multiply(BigDecimal.valueOf(7.5/100));
			    }
		 
		 else if(bd13Salario.compareTo(new BigDecimal(1045.00)) > 1 || bd13Salario.compareTo(new BigDecimal(2089.60)) <= 1) {
				
	      bdInss13 = bd13Salario.multiply(BigDecimal.valueOf(9/100));
			    }
		 
		 else if(bd13Salario.compareTo(new BigDecimal(2089.60)) > 1 || bd13Salario.compareTo(new BigDecimal(3134.40)) <= 1) {
				
	      bdInss13 = bd13Salario.multiply(BigDecimal.valueOf(12/100));
			    }
		 
		 else if(bd13Salario.compareTo(new BigDecimal(3134.90)) > 1 || bd13Salario.compareTo(new BigDecimal(6101.06)) <= 1) {
				
	      bdInss13 = bd13Salario.multiply(BigDecimal.valueOf(14/100));
			    }
  	 
			     return CURRENCYBR.format(bdInss13);
		      }
		    
		       
		       
		       
		       
		       
		       
		       public static String calcularInssAviso (){
		  
	           if(bdAvisoPrv.compareTo(new BigDecimal(1045.00)) <= 1){
				
	      bdInssAviso = bdAvisoPrv.multiply(BigDecimal.valueOf(7.5/100));
			    }
		 
		   else if(bdAvisoPrv.compareTo(new BigDecimal(1045.00)) > 1 || bdAvisoPrv.compareTo(new BigDecimal(2089.60)) <= 1) {
				
	      bdInssAviso = bdAvisoPrv.multiply(BigDecimal.valueOf(9/100));
			    }
		 
		   else if(bdAvisoPrv.compareTo(new BigDecimal(2089.60)) > 1 || bdAvisoPrv.compareTo(new BigDecimal(3134.40)) <= 1) {
				
	      bdInssAviso = bdAvisoPrv.multiply(BigDecimal.valueOf(12/100));
			    }
		 
		   else if(bdAvisoPrv.compareTo(new BigDecimal(3134.90)) > 1 || bdAvisoPrv.compareTo(new BigDecimal(6101.06)) <= 1) {
				
	      bdInssAviso = bdAvisoPrv.multiply(BigDecimal.valueOf(14/100));
			    }
  	 
			       return CURRENCYBR.format(bdInssAviso);
	      
			  }
		
		       
			
		     
	
		   public static String calcularDesconto (){
	   bdDesc = bdInssSaldo.add(bdInssAviso).add(bdInss13);
		     return CURRENCYBR.format(bdDesc);
		}
			
		
			
			
			
			
			
			
			
			  public static String calcularFinal (){
			    
			bdFinal = bdTotal.subtract(bdDesc);
			
                         return CURRENCYBR.format(bdFinal);			
  			
			    
			}
			
			
			
			
		
		
		
		
           	
		  
		  
		  
		      
		      
		      
		/*      
		  
		
		  public static String tipo (){
		      
		   strTipo = ObjetosRescisao.getTipo();
		   return strTipo;
		  }
		  
		  
		  
		  
		  
		  
		 public static int prazo (int admissao , int demissao){
		    
		         iTempo = demissao - admissao;   
			 iTempo *= 3 ;
		              return iTempo;
		  }


		
		
		  
		  
		  
		
		
		   public static BigDecimal aviso (BigDecimal valor ){
		    
		   bdDiarias = valor.divide(bdDias, RoundingMode.UP);
			  
		  bdAviso = bdDiarias.multiply(BigDecimal.valueOf(iTempo));
			  
		                 return bdAviso;
		}  
	


                   */














		   
		  
}
