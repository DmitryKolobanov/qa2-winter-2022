package HW_2;

import org.junit.jupiter.api.Test;

public class MovieTest {
    @Test
    public void testingMovie () {

        Movie testMovie = new Movie();

        testMovie.setTitle("Terminator 2");
        testMovie.setDirector("James Cameron");
        testMovie.setMovieLength(137);
        testMovie.setCountryOfOrigin("USA");
        testMovie.setHorror(true);

        System.out.println("Object: MOVIE");
        System.out.println(("Title: ") + (testMovie.getTitle()));
        System.out.println(("Director: ") + (testMovie.getDirector()));
        System.out.println(("Length: ") + (testMovie.getMovieLength() + (" minutes")));
        System.out.println(("Country of Origin: ") + (testMovie.getCountryOfOrigin()));
        System.out.println(("Horror: ") + (testMovie.isHorror()));
        }
    }

