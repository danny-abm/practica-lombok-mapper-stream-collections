package com.enterprise.training;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import com.enterprise.training.model.ClaseDTO;
import com.enterprise.training.model.main.ClaseMain;
import com.enterprise.trining.mapper.ClaseMapper;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        ArrayList<ClaseDTO> lista1 = new ArrayList<>();
        
        lista1.add(new ClaseDTO("Danny",2323,null));
        lista1.add(new ClaseDTO("DANIEL",2121,null));

        
        System.out.println(lista1);
        
       
        //SpringApplication.run(App.class, args);
    }
    
   /* @Autowired
    ClaseMapper claseMapper;

	@Bean
	public void testMapper() {
    	
    	ClaseMain back = new ClaseMain("danbar",2397);
    	
    	ClaseDTO front = claseMapper.ClaseMainToCLaseDTO(back);
    	
    	System.out.println(back);
    	System.out.println(front);
    	
    	
    }*/
}
