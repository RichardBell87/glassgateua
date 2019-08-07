package glassgate.domain;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {
    USER, ADMIN, CREATOR;

    @Override
    public String getAuthority() {
        return name();
    }
}
