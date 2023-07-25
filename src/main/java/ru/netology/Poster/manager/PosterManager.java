package ru.netology.Poster.manager;

import ru.netology.Poster.domain.PosterMovie;

public class PosterManager {
    private PosterMovie[] movies = new PosterMovie[0]; //создаем пустой массив
    private int limit = 5; //ограничиваем длину выводимого массива

    public PosterManager(int limit) {
        this.limit = limit;
    }
    public PosterManager() {
    }
    public void add(PosterMovie newMovie) {
        PosterMovie[] tmp = new PosterMovie[movies.length + 1]; //создаем новый временный увеличивающийся массив
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];  //копируем элементы из старого массива в новый
        }
        tmp[tmp.length - 1] = newMovie;
        movies = tmp; //присваиваем в поле новый массив
    }
    public PosterMovie[] findAll() {
        return movies;
    }
    public PosterMovie[] findLast() {
       int resultLength;
       if (limit < movies.length) {
           resultLength = limit;
       } else {
           resultLength = movies.length;
       }
       PosterMovie[] result = new PosterMovie[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = movies[movies.length - 1 - i];
        }
        return result;
    }
}

