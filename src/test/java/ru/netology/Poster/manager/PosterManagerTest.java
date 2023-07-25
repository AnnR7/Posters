package ru.netology.Poster.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Poster.domain.PosterMovie;

import static org.junit.jupiter.api.Assertions.*;

class PosterManagerTest {
    PosterManager manager = new PosterManager();

    PosterMovie movie1 = new PosterMovie("Бладшот");
    PosterMovie movie2 = new PosterMovie("Вперед");
    PosterMovie movie3 = new PosterMovie("Отель**Белград**");
    PosterMovie movie4 = new PosterMovie("Джентльмены");
    PosterMovie movie5 = new PosterMovie("Человек-невидимка");
    PosterMovie movie6 = new PosterMovie("Тролли. Мировой тур");
    PosterMovie movie7 = new PosterMovie("Номер один");


    @Test
    public void shouldFindAll() {

        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);
        manager.add(movie6);
        manager.add(movie7);

        PosterMovie[] expected = {movie1, movie2, movie3, movie4, movie5, movie6, movie7};
        PosterMovie[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastSizeEqualsLimit() {

        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);

        PosterMovie[] expected = {movie5, movie4, movie3, movie2, movie1};
        PosterMovie[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastSizeMoreLimit() {

        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);
        manager.add(movie6);
        manager.add(movie7);

        PosterMovie[] expected = {movie7, movie6, movie5, movie4, movie3};
        PosterMovie[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastSizeLessLimit() {

        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);

        PosterMovie[] expected = {movie3, movie2, movie1};
        PosterMovie[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastSizeEqualsCustomLimit() {

        PosterManager manager = new PosterManager(3);

        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);

        PosterMovie[] expected = {movie3, movie2, movie1};
        PosterMovie[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastSizeMoreCustomLimit() {

        PosterManager manager = new PosterManager(3);

        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);

        PosterMovie[] expected = {movie5, movie4, movie3};
        PosterMovie[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastSizeLessCustomLimit() {

        PosterManager manager = new PosterManager(7);

        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);

        PosterMovie[] expected = {movie5, movie4, movie3, movie2, movie1};
        PosterMovie[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

}