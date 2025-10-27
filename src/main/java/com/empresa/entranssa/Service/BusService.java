package com.empresa.entranssa.Service;

import com.empresa.entranssa.Dao.BusDAO;

import com.empresa.entranssa.Model.Bus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusService {

    private final BusDAO busDAO;

    public BusService(BusDAO busDAO) {
        this.busDAO = busDAO;
    }

    public List<Bus> listarTodos() {
        return busDAO.findAll();
    }

    public Bus guardar(Bus bus) {
        return busDAO.save(bus);
    }

    public void eliminar(Long id) {
        busDAO.deleteById(id);
    }

    public Bus buscarPorId(Long id) {
        return busDAO.findById(id).orElse(null);
    }
}