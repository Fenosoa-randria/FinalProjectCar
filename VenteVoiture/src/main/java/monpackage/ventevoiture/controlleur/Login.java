package monpackage.ventevoiture.controlleur;

import monpackage.ventevoiture.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
public class Login {

    @Autowired
    LoginService loginService;

    @CrossOrigin(origins = {"http://localhost:8100", "http://localhost:4000"})
    @PostMapping("/verificationLogin")
    public ResponseEntity verificationLogin(@RequestParam String email, @RequestParam String motdepasse) {
        try {
            String[] result = loginService.verificationLogin(email, motdepasse);
            if (result != null) {
                String token = result[0];
                String userType = result[1];
                return ResponseEntity.ok( token + "," + userType);
            } else {
                return ResponseEntity.ok("0");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la vérification du login");
        }
    }
}
