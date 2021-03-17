package kb.weather;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    String getUser() {
        return "Hello " + SecurityContextHolder.getContext().getAuthentication().getName() + ".";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    String getAdmin() {
        return "Hello Admin " + SecurityContextHolder.getContext().getAuthentication().getName() + ".";
    }
}
