package pe.edu.cibertec.ProyectoFinalAplWeb1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.cibertec.ProyectoFinalAplWeb1.dto.DiscoDto;
import pe.edu.cibertec.ProyectoFinalAplWeb1.service.DiscosService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/disk")
public class DiscoController {
    @Autowired
    private DiscosService discosService;

    // Método para listar todos los discos
    @GetMapping
    public String listarDiscos(Model model) {
        try {
            List<DiscoDto> discos = discosService.getAllDiscos();
            model.addAttribute("discos", discos);
            return "listarDiscos";
        } catch (Exception e) {
            model.addAttribute("error", "Error al obtener la lista de discos.");
            return "error";
        }
    }

    // Método para ver el detalle de un disco
    @GetMapping("/{id}")
    public String detalleDisco(@PathVariable("id") int id, Model model) {
        try {
            Optional<DiscoDto> disco = discosService.getDiscoById(id);
            if (disco.isPresent()) {
                model.addAttribute("disco", disco.get());
                return "detalleDisco";
            } else {
                model.addAttribute("error", "Disco no encontrado.");
                return "error";
            }
        } catch (Exception e) {
            model.addAttribute("error", "Error al obtener el detalle del disco.");
            return "error";
        }
    }
}
