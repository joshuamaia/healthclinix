package com.jbconnect.healthclinix.entity.user.port;

public interface FindOnePort<IN, OUT> {

    OUT execute(IN in);
}
