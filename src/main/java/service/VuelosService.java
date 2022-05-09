package service;
import java.util.List;

import model.Vuelo;

public interface VuelosService {
	List<Vuelo> vuelosDisponibles(int plazas);
	boolean actualizaVuelo(int idVuelo, int plazas);
	public Vuelo buscarVueloID(int idVuelo);
}
