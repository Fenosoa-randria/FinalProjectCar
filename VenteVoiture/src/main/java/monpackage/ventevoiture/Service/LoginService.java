package monpackage.ventevoiture.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import monpackage.ventevoiture.Repository.AdminRepository;
import monpackage.ventevoiture.Repository.UtilisateurRepository;
import monpackage.ventevoiture.model.Admin;
import monpackage.ventevoiture.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Optional;

@Service
public class LoginService {
    @Autowired
    UtilisateurRepository utilisateurRepository;
    @Autowired
    AdminRepository adminRepository;

    @Value("${jwt.secret}")
    private String jwtSecret;


    public String[] verificationLogin(String email, String motDePasse) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findAllByEmailAndMotDePasse(email, motDePasse);
        Optional<Admin> admin = adminRepository.findAllByEmailAndMotDePasse(email, motDePasse);

        if (utilisateur.isPresent()) {
            String token = generateToken(utilisateur.get().getIdUtilisateur());
            return new String[]{token, "1"}; // Utilisateur ajouté dans la liste avec le token et le numéro 1
        } else if (admin.isPresent()) {
            String token = generateToken(admin.get().getIdAdmin());
            return new String[]{token, "2"}; // Admin ajouté dans la liste avec le token et le numéro 2
        } else {
            return null; // Retourne null en cas d'échec d'authentification
        }
    }
    private Key getKey() {
        // Utilisez toujours la même clé à partir de la propriété jwt.secret
        return Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }
    private String generateToken(String userId) {
        Key key = getKey();
        Date expirationDate = new Date(System.currentTimeMillis() + 24 * 3600 * 1000);

        return Jwts.builder()
                .setSubject(String.valueOf(userId))
                .setIssuedAt(new Date())
                .setExpiration(expirationDate)
                .signWith(key)
                .compact();
    }

    public String getIdFromToken(String token) {
        try {
            Key key = getKey();

            Jws<Claims> claimsJws = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);

            Claims body = claimsJws.getBody();

            return body.getSubject();
        } catch (Exception e) {
            System.out.println(e.getMessage());

            return null;
        }
    }


}
