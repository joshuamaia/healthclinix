package com.jbconnect.healthclinix.security.port;

public interface LoginPort<IN ,OUT> {
    OUT execute(IN in);
}
