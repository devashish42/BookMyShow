package bms.models;

import java.util.Collections;
import java.util.List;

public class Movie {
    public String name;
    public List<String> cast;
    public String info;

    public Movie(String name) {
        this.name = name;
        this.cast = Collections.emptyList();
        this.info = "";
    }
}
