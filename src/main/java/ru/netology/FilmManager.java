package ru.netology;

public class FilmManager {
    private String[] films = new String[0];
    private int numberOfFilms = 5;

    public FilmManager() {
    }

    public FilmManager(int numberOfFilms) {
        this.numberOfFilms = numberOfFilms;
    }

    public void add(String film) {
        String[] tmp = new String[films.length + 1];
        for (int i = 0; i < films.length; i++) {
            tmp[i] = films[i];
        }
        tmp[tmp.length - 1] = film;
        films = tmp;
    }

    public String[] findAll() {
        return films;
    }

    public String[] findLast() {
        int resultLength;
        if (films.length < numberOfFilms) {
            resultLength = films.length;
        } else {
            resultLength = numberOfFilms;
        }
        String[] result = new String[resultLength];
        for (int i = 0; i < result.length; i++) {
            result[i] = films[films.length - 1 - i];
        }
        return result;
    }
}
