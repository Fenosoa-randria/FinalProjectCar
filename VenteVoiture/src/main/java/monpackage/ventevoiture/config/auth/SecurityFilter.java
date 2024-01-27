package monpackage.ventevoiture.config.auth;

import java.io.IOException;

import monpackage.ventevoiture.Repository.AdminRepository;
import monpackage.ventevoiture.Repository.UtilisateurRepository;
import monpackage.ventevoiture.Service.LoginService;
import monpackage.ventevoiture.controlleur.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {
    @Autowired
    LoginService loginService;
    @Autowired
    UtilisateurRepository repository;
    @Autowired
    AdminRepository adminRepository;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        var token = this.recoverToken(request);
        if (token != null) {
            var login = loginService.getIdFromToken(token);

            var user = repository.findAllByIdUtilisateur(login);
            var admin = adminRepository.findAllByIdAdmin(login);

            if (user != null) {
                // L'identifiant appartient à un utilisateur
                var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
            if (admin != null) {
                // L'identifiant appartient à un administrateur
                var authentication = new UsernamePasswordAuthenticationToken(admin, null, admin.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request, response);
    }
    private String recoverToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if (authHeader == null)
          return null;
        return authHeader.replace("Bearer ", "");
    }
}
