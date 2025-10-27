package com.empresa.entranssa.Service;

import com.empresa.entranssa.Dao.ParaderoDAO;
import com.empresa.entranssa.Model.Paradero;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ParaderoService {

        private final ParaderoDAO paraderoDAO;

        public ParaderoService(ParaderoDAO paraderoDAO) {
            this.paraderoDAO = paraderoDAO;
        }

        public List<Paradero> listarTodos() {
        return paraderoDAO.findAll();
         }

         public Paradero guardar(Paradero paradero) {
            return paraderoDAO.save(paradero);
        }

        public void eliminar(Long id) {
            paraderoDAO.deleteById(id);
        }

        public Paradero buscarPorId(Long id) {
            return paraderoDAO.findById(id).orElse(null);
        }
    }
