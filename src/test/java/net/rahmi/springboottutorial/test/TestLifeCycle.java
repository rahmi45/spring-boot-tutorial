package net.rahmi.springboottutorial.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test life cycle")
public class TestLifeCycle 
{

	  @BeforeAll //La méthode annotée sera invoquée avant l'exécution de la première méthode de la classe annotée avec @Test, @RepeatedTest, @ParameterizedTest ou @Testfactory
	  static void beforeAll()
	  {
	    System.out.println("## Appel BeforeAll Annotation  ##");
	    System.out.println();
	  }

	  @AfterAll //La méthode annotée sera invoquée après l'exécution de toutes les méthodes de la classe annotées avec @Test...
	  static void afterAll()
	  {
	    System.out.println("## Appel AfterAll Annotation  ##");
	    System.out.println();
	  }

	  @BeforeEach //La méthode annotée sera invoquée avant l'exécution de chaque méthode de la classe annotée avec @Test...
	  void beforeEach()
	  {
	    System.out.println("## Appel BeforeEach Annotation  ##");
	    System.out.println();
	  }

	  @AfterEach //La méthode annotée sera invoquée après l'exécution de chaque méthode de la classe annotée avec @Test...
	  void afterEach()
	  {
	    System.out.println("## Appel AfterEach Annotation ##");
	    System.out.println();
	  }

	  @Test
	  void test1()
	  {
	    System.out.println("## Exécution test1 ##");
	    System.out.println();
	  }

	  @Test
	  @DisplayName("Test Case 2!!!")
	  void test2()
	  {
	    System.out.println("## Exécution test2 ##");
	    System.out.println();
	  }

	  @Test
	  @Disabled // Désactiver les tests de la classe ou la méthode annotée.
	  void test3()
	  {
	    System.out.println("## Exécution test3 ##");
	    System.out.println();
	  }
}
