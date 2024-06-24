import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.FilmManager;

public class FilmManagerTest {
    FilmManager defaultManager = new FilmManager();
    FilmManager customManager = new FilmManager(7);

    @BeforeEach
    public void setUp() {
        defaultManager.add("Film 1");
        defaultManager.add("Film 2");
        defaultManager.add("Film 3");
        defaultManager.add("Film 4");
        defaultManager.add("Film 5");
        defaultManager.add("Film 6");
        defaultManager.add("Film 7");
    }

    @Test
    public void shouldFindAllFilms() {
        String[] expected = {"Film 1", "Film 2", "Film 3", "Film 4", "Film 5", "Film 6", "Film 7"};
        String[] actual = defaultManager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSetLastFilmsIfDefaultLimit() {
        String[] expected = {"Film 7", "Film 6", "Film 5", "Film 4", "Film 3"};
        String[] actual = defaultManager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSetLastFilmsIfCustomLimit() {
        customManager.add("Film 1");
        customManager.add("Film 2");
        customManager.add("Film 3");
        customManager.add("Film 4");
        customManager.add("Film 5");
        customManager.add("Film 6");
        customManager.add("Film 7");

        String[] expected = {"Film 7", "Film 6", "Film 5", "Film 4", "Film 3", "Film 2", "Film 1"};
        String[] actual = customManager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSetLastFilmsBelowCustomLimit() {
        customManager.add("Film 1");
        customManager.add("Film 2");
        customManager.add("Film 3");

        String[] expected = {"Film 3", "Film 2", "Film 1"};
        String[] actual = customManager.findLast();

        assertArrayEquals(expected, actual);
    }
}
