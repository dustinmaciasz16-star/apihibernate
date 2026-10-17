package com.krakedev.peliculas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.krakedev.peliculas.entidades.Pelicula;
import com.krakedev.peliculas.repository.PeliculaRepository;

@Service
public class ServicioPelicula {

	private final PeliculaRepository peliculaRepository;
	
	public ServicioPelicula(PeliculaRepository peliculaRepository){
		this.peliculaRepository = peliculaRepository;
	}
	
	public Pelicula crear(Pelicula pelicula) {
		return peliculaRepository.save(pelicula);/*si existe id lo actualiza caso contrario lo crea*/
	}
	
	public List<Pelicula> listar(){
		return peliculaRepository.findAll();
	}
	
	public Pelicula buscarPorId(Long id){
		Optional<Pelicula> resultado = peliculaRepository.findById(id);//optional al hacer la busqueda acepta tanto la pelicula si la encuento y si no acepta null
		return resultado.orElse(null);//aki al retornar decimos que si encontro pelicula envie el resultado encaso contrario que es el .orElse muestra null
	}
	
	public Pelicula actualizar(Long id, Pelicula pelicula) {
		Pelicula encontrado = buscarPorId(id);
		
		if(encontrado == null) {
			return null;
		}
		encontrado.setNombre(pelicula.getNombre());
		encontrado.setDirector(pelicula.getDirector());
		encontrado.setGenero(pelicula.getGenero());
		encontrado.setDuracion(pelicula.getDuracion());
		encontrado.setDisponible(pelicula.isDisponible());
		
		return peliculaRepository.save(encontrado);
	}
	
	public boolean eliminar(Long id) {
		Pelicula encontrado = buscarPorId(id);
		
		if(encontrado == null) {
			return false;
		}
		peliculaRepository.delete(encontrado);
		return true;
	}
	
	public List<Pelicula> bucarPorGenero(String genero){
		return peliculaRepository.findByGenero(genero);
	}
	
	public List<Pelicula> buscarPorDisponible(boolean disponible){
		return peliculaRepository.findByDisponible(disponible);
	}
}
