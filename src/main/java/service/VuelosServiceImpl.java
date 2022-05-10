package service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.VuelosDao;
import model.Vuelo;

@Service
public class VuelosServiceImpl implements VuelosService{
	
	VuelosDao vuelosDao;

	public VuelosServiceImpl(@Autowired VuelosDao vuelosDao) {
		super();
		this.vuelosDao = vuelosDao;
	}

	@Override
	public List<Vuelo> vuelosDisponibles(int plazas) {
		return vuelosDao.findAll().stream().filter(x -> x.getPlazas() > plazas).collect(Collectors.toList());
	}

	@Override
	public boolean actualizaVuelo(int idVuelo, int plazas) {
		Vuelo vuelo = buscarVueloID(idVuelo);
		if(vuelo != null) {
			vuelo.setPlazas(vuelo.getPlazas() - plazas);
			vuelosDao.save(vuelo);
			return true;
		}
		return false;
	}
	
	public Vuelo buscarVueloID(int idVuelo) {
		return vuelosDao.findById(idVuelo).orElse(null);
	}

}
