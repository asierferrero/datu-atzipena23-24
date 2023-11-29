package dambi.accessingrelationaldata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/hasi")
public class ErabiltzaileaController {
    @Autowired
    private ErabiltzaileaRepository erabiltzaileaRepository;

    @PostMapping(path="/gehitu")
    public @ResponseBody String erabiltzaileaGehitu(@RequestParam String izena) {
        Erabiltzailea erabiltzailea = new Erabiltzailea();
        erabiltzailea.setIzena(izena);
        erabiltzaileaRepository.save(erabiltzailea);
        return "Erabiltzilea ondo gorde da";
    }

    @GetMapping(path = "/denak")
    public @ResponseBody Iterable<Erabiltzailea> erabiltzaileGuztiak() {
        // This returns a JSON or XML with the users
        return erabiltzaileaRepository.findAll();
    }

}
