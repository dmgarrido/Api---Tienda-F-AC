package data;

import java.util.ArrayList;
import java.util.List;

import model.Disco;
import model.Libro;
import model.Pelicula;

import org.springframework.stereotype.Component;


public class Repository {


	public static List<Pelicula> lista_peliculas = new ArrayList<Pelicula>();
	public static List<Libro> lista_libros = new ArrayList<Libro>();
	public static List<Disco> lista_discos = new ArrayList<Disco>();

	
	static {
		lista_peliculas.add(new Pelicula(1, "Casablanca", "DVD", 6.0));
		lista_peliculas.add(new Pelicula(2, "El señor de los anillos", "Blu-Ray", 20.0));
		lista_peliculas.add(new Pelicula(3, "Terminator", "Blu-Ray", 18.0));
	}
	
	static {
		lista_libros.add(new Libro(1, "El quijote", "Cervantes", 10.0));
		lista_libros.add(new Libro(2, "Romeo y Julieta", "Shakespeare", 12.0));
		lista_libros.add(new Libro(3, "Clean code", "Robert C. Martin", 30.0));
	}
	
	static {
		lista_discos.add(new Disco(1, "Abbey Road", "The Beatles", 20.0));
		lista_discos.add(new Disco(2, "Sticky fingers", "The Rolling Stones", 15.0));
		lista_discos.add(new Disco(3, "Nevermind", "Nirvana", 10.0));
		lista_discos.add(new Disco(4, "Help", "The Beatles", 10.0));
	}

}
