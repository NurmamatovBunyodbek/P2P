package uz.pdp.p2p.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;
import uz.pdp.p2p.service.MyAuthService;

import java.io.IOException;

public class JwtFilter  extends OncePerRequestFilter {


  private  final   JwtProvider jwtProvider;

  private final   MyAuthService myAuthService;

    public JwtFilter(JwtProvider jwtProvider, MyAuthService myAuthService) {
        this.jwtProvider = jwtProvider;
        this.myAuthService = myAuthService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");

        if (token != null && token.startsWith("Bearer")) {
            token = token.substring(7);
            boolean validateToken = jwtProvider.validateToken(token);

            if (validateToken) {
                String username = jwtProvider.getUserNameFromToken(token);
                UserDetails userDetails = myAuthService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }

        filterChain.doFilter(request,response);
    }
}
