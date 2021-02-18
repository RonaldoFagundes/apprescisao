/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


const target = document.querySelectorAll('[data-anime]');
const animationClass = 'animate';




                function animeScroll(){
	    
	const windowTop = window.pageYOffset + ((window.innerHeight * 3) /4  );
	
	 target.forEach(function (element){
	  
	  if ((windowTop) > element.offsetTop) {
	  element.classList.add(animationClass);
	    }
	    else{
	  element.classList.remove(animationClass);
	    }
         }) ;   
	}
	
	
	
	
	window.addEventListener('scroll',function(){
	    
	      animeScroll();
	} );