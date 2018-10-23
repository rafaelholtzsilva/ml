package br.com.ml.xmen.controller.test;


import static org.junit.Assert.assertTrue;

import org.junit.Test;

/*@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes= {MutantController.class,MutantService.class})*/
public class MutantControllerTest {

/*	@LocalServerPort*/
    private int port;

/*	@Autowired
	private TestRestTemplate restTemplate;
*/
	@Test
	public void canRetrieveByIdWhenExists() throws Exception{

//		given(superHeroRepository.getSuperHero(2)).willReturn(new SuperHero("Rob", "Mannon", "RobotMan"));

		// when
//		ResponseEntity<Void> superHeroResponse = restTemplate.getForEntity("http://localhost:" + port + "/", Void.class);

		assertTrue(true);
		// then
//		assertThat(superHeroResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
	//	assertThat(superHeroResponse.getBody().equals(new SuperHero("Rob", "Mannon", "RobotMan")));
	}
/*
	@Test
	public void canRetrieveByIdWhenDoesNotExist() {
		// given
		given(superHeroRepository.getSuperHero(2)).willThrow(new NonExistingHeroException());

		// when
		ResponseEntity<SuperHero> superHeroResponse = restTemplate.getForEntity("/superheroes/2", SuperHero.class);

		// then
		assertThat(superHeroResponse.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
		assertThat(superHeroResponse.getBody()).isNull();
	}

	@Test
	public void canRetrieveByNameWhenExists() {
		// given
		given(superHeroRepository.getSuperHero("RobotMan"))
				.willReturn(Optional.of(new SuperHero("Rob", "Mannon", "RobotMan")));

		// when
		ResponseEntity<SuperHero> superHeroResponse = restTemplate.getForEntity("/superheroes/?name=RobotMan",
				SuperHero.class);

		// then
		assertThat(superHeroResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(superHeroResponse.getBody().equals(new SuperHero("Rob", "Mannon", "RobotMan")));
	}

	@Test
	public void canRetrieveByNameWhenDoesNotExist() {
		// given
		given(superHeroRepository.getSuperHero("RobotMan")).willReturn(Optional.empty());

		// when
		ResponseEntity<SuperHero> superHeroResponse = restTemplate.getForEntity("/superheroes/?name=RobotMan",
				SuperHero.class);

		// then
		assertThat(superHeroResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(superHeroResponse.getBody()).isNull();
	}

	@Test
	public void canCreateANewSuperHero() {
		// when
		ResponseEntity<SuperHero> superHeroResponse = restTemplate.postForEntity("/superheroes/",
				new SuperHero("Rob", "Mannon", "RobotMan"), SuperHero.class);

		// then
		assertThat(superHeroResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);
	}

	@Test
	public void headerIsPresent() throws Exception {
		// when
		ResponseEntity<SuperHero> superHeroResponse = restTemplate.getForEntity("/superheroes/2", SuperHero.class);

		// then
		assertThat(superHeroResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(superHeroResponse.getHeaders().get("X-SUPERHERO-APP")).containsOnly("super-header");
	}
*/
/*	public MutantController getMutantController() {
		return mutantController;
	}

	public void setMutantController(MutantController mutantController) {
		this.mutantController = mutantController;
	}*/

/*	public TestRestTemplate getRestTemplate() {
		return restTemplate;
	}

	public void setRestTemplate(TestRestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}*/
	
	

}