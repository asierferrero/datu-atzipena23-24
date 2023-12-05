package dambi.accessingrelationaldata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/demo")
public class ErabiltzaileaController {
    @Autowired
    private ErabiltzaileaRepository erabiltzaileaRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String erabiltzaileaGehitu(@RequestParam int id, @RequestParam String name, @RequestParam String email) {
        Erabiltzailea erabiltzailea = new Erabiltzailea();
        erabiltzailea.setId(id);
        erabiltzailea.setName(name);
        erabiltzailea.setEmail(email);
        erabiltzaileaRepository.save(erabiltzailea);
        return "Erabiltzilea ondo gorde da";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Erabiltzailea> erabiltzaileGuztiak() {
        // This returns a JSON or XML with the users
        return erabiltzaileaRepository.findAll();
    }

    @PutMapping(value = "/update/{userId}")
    public ResponseEntity updateContact(@RequestBody Erabiltzailea erabiltzailea, @PathVariable int userId) {
        try {
            erabiltzailea.setId(userId);
            erabiltzaileaRepository.save(erabiltzailea);

            return ResponseEntity.ok().build();

        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/delete/{userId}")
    public ResponseEntity deleteUserById(@PathVariable int userId) {
        try {
            erabiltzaileaRepository.deleteById(userId);
            return ResponseEntity.ok().build();

        } catch (Exception ex) {
            System.out.println("Errorea " + userId + " userra ezabatzerakoan. ");
            return ResponseEntity.notFound().build();

        }
    }
}
