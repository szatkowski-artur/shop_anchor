package pl.artur97szat.shopanchor.utils;

import org.springframework.security.core.context.SecurityContextHolder;

public class Username {

    public static String get(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

}
