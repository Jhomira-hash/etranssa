package com.empresa.entranssa.Service;

import com.empresa.entranssa.Dao.ParaderoDAO;
import com.empresa.entranssa.Dao.RutaDAO;
import com.empresa.entranssa.Model.Paradero;
import com.empresa.entranssa.Model.Ruta;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RutaService {
    private final RutaDAO rutaDAO;

    public RutaService(RutaDAO rutaDAO) {
        this.rutaDAO = rutaDAO;
    }

    public List<Ruta> listarTodos() {
        return rutaDAO.findAll();
    }

    public Ruta guardar(Ruta ruta) {
        return rutaDAO.save(ruta);
    }

    public void eliminar(Long id) {
        rutaDAO.deleteById(id);
    }

    public Ruta buscarPorId(Long id) {
        return rutaDAO.findById(id).orElse(null);
    }
}
