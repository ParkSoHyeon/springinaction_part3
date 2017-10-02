package spittr.security;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import spittr.domain.Spitter;

import java.io.Serializable;

public class SpitterPermissionEvaluator implements PermissionEvaluator{
    private static final GrantedAuthority ADMIN_AUTHORITY = new GrantedAuthorityImpl("ROLE_ADMIN");
    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        if(targetDomainObject instanceof Spitter) {
            Spitter spitter = (Spitter) targetDomainObject;
            String username = spitter.getUsername();

            if("delete".equals(permission)) {
                return isAdmin(authentication) || username.equals(authentication.getName());
            }
        }
        throw new UnsupportedOperationException("hasPermission not supported for object <" + targetDomainObject + "> and permission <" + permission + ">");
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        throw new UnsupportedOperationException();
    }

    private boolean isAdmin(Authentication auth) {
        return auth.getAuthorities().contains(ADMIN_AUTHORITY);
    }
}
