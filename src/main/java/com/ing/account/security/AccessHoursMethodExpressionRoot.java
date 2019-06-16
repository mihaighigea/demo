package com.ing.account.security;

import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.core.Authentication;

import java.time.LocalTime;

public class AccessHoursMethodExpressionRoot
        extends SecurityExpressionRoot implements MethodSecurityExpressionOperations {

    private static final String startTime = "08:00:00";
    private static final String endTime = "17:00:00";

    public AccessHoursMethodExpressionRoot(Authentication authentication) {
        super(authentication);
    }

    public boolean isAccessBetweenWorkingHours() {
        LocalTime localTime = LocalTime.now();
        return localTime.isAfter(LocalTime.parse(startTime))&&
            localTime.isBefore( LocalTime.parse(endTime));
    }

    @Override
    public void setFilterObject(Object o) {

    }

    @Override
    public Object getFilterObject() {
        return null;
    }

    @Override
    public void setReturnObject(Object o) {

    }

    @Override
    public Object getReturnObject() {
        return null;
    }

    @Override
    public Object getThis() {
        return null;
    }
}
