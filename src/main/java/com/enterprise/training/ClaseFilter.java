package com.enterprise.training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.Test;



import com.enterprise.training.model.ClaseDTO;
import com.enterprise.training.model.Job;
import com.enterprise.training.model.Ubication;


public class ClaseFilter {
	
	private List<Job> job = Arrays.asList(
			new Job("Programador", Arrays.asList(new Ubication ("MetroPark",12))),
			new Job("Soporte", Arrays.asList(new Ubication ("Calle 50",29))),
			new Job("Analista de Sist", Arrays.asList(new Ubication ("Albrook",35)))
			
			);

	private List <ClaseDTO> list2 =  Arrays.asList(
			new ClaseDTO("danny",123,job),
			new ClaseDTO("daniel",121,null),
			new ClaseDTO("mum",122,null),
			new ClaseDTO("dad",124,null)
			);
	
	@Test
	public void filter() {
		list2.stream()
		.filter(list->list.getCode()<124)
		.map(ClaseDTO::getNombre)
		.distinct()
		.collect(Collectors.toList())
		.forEach(System.out::println);
	}
	
	@Test
	public void mapeando_x_work() {
		
		ClaseDTO me = list2.get(0);
		List <Ubication> location = me.getJobPerson()
				.stream()
				.flatMap(work->work.getUbi().stream())
				.sorted(Comparator.comparing(Ubication::getKm).reversed())
				.collect(Collectors.toList());
		System.out.println("\nTrabajos de Danny de mas lejos a mas cerca:\n"+location);
	}
	
	@Test 
	public void find_and_match() {
		ClaseDTO me = list2.get(0);
		Predicate<Job> unaUbicacion = wk->wk.getUbi().size()>1;
		Optional<Job> work= me.getJobPerson()
				.stream()
				//.filter(unaUbicacion)
				.findFirst();
		System.out.println("\nEl ultimo trabajo de Danny:\n"+work);
		
		boolean masUnaUbi= job.stream().allMatch(unaUbicacion);
		System.out.println("Todos tienen mas de una ubicacion:"+masUnaUbi);
		boolean UnaUbi= job.stream().anyMatch(unaUbicacion);
		System.out.println("\nAlguno tienen mas de una ubicacion:"+UnaUbi);
		boolean ningunaMasUbi=job.stream().noneMatch(unaUbicacion);
		System.out.println("\nNinguno tienen mas de una ubicacion:"+ningunaMasUbi);
		
		
	}
	
	@Test
	public void numberOfWwork() {
		ClaseDTO me = list2.get(0);
		int nw= me.getJobPerson()
				.stream()
				.reduce( 0,(sum,wk)->sum+wk.getUbi().size(), (sum1,sum2)->sum1+sum2);
		System.out.println("\nTotal de tranbajos: "+nw);
	}

}
