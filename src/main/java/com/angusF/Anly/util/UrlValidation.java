package com.angusF.Anly.util;

import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;

@Component
public class UrlValidation {
    public boolean isValidUrl(String url) throws MalformedURLException {
        UrlValidator urlValidator = new UrlValidator();
        return urlValidator.isValid(url);
    }
}
