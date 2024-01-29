package monpackage.ventevoiture.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import monpackage.ventevoiture.Repository.AdminRepository;
import monpackage.ventevoiture.Repository.UtilisateurRepository;
import monpackage.ventevoiture.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.Optional;

@Service
public class UtilisateurService {
//    @Autowired
//    UtilisateurRepository utilisateurRepository;
//    public String verificationLogin(String email, String motDePasse) {
//        Optional<Utilisateur> utilisateur = utilisateurRepository.findAllByEmailAndMotDePasse(email, motDePasse);
//        if (utilisateur.isPresent()) {
//            return generateToken(utilisateur.get().getIdUtilisateur());
//        }
//        return null; // Retourne null en cas d'échec d'authentification
//    }
//    @Value("${jwt.secret}")
//    private String jwtSecret;
//
//    private Key getKey() {
//        // Utilisez toujours la même clé à partir de la propriété jwt.secret
//        return Keys.hmacShaKeyFor(jwtSecret.getBytes());
//    }
//    private String generateToken(int userId) {
//        Key key = getKey();
//
//        Date expirationDate = new Date(System.currentTimeMillis() + 24 * 3600 * 1000);
//
//        return Jwts.builder()
//                .setSubject(String.valueOf(userId))
//                .setIssuedAt(new Date())
//                .setExpiration(expirationDate)
//                .signWith(key)
//                .compact();
//    }
//
//    public Integer getUserIdFromToken(String token) {
//        try {
//            Key key = getKey();
//
//            Jws<Claims> claimsJws = Jwts.parserBuilder()
//                    .setSigningKey(key)
//                    .build()
//                    .parseClaimsJws(token);
//
//            Claims body = claimsJws.getBody();
//
//            return Integer.parseInt(body.getSubject());
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//
//            return null;
//        }
//    }

}
