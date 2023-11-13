package com.example.employeefilter.exception;

import lombok.extern.java.Log;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;
import java.util.Map;
@Component
public class GenericError extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, options);
        errorAttributes.put("success", Boolean.FALSE);
        errorAttributes.put("code", errorAttributes.get("error"));
        errorAttributes.put("message", errorAttributes.get("message"));
        errorAttributes.remove("error");
        errorAttributes.remove("path");
        return errorAttributes;
    }
}