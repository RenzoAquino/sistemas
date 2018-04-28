package com.sisint.common.resources.ws;

import com.google.common.base.MoreObjects;

public class RestResponse <T> {

    private T body;
    private FailResponse fail;

    public RestResponse() {
    }

    public RestResponse(T body) {
        this.body = body;
    }

    public RestResponse(FailResponse fail) {
        this.fail = fail;
    }

    public T getBody() {
        return body;
    }

    public FailResponse getFail() {
        return fail;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("body", body)
                .add("fail", fail)
                .toString();
    }
}
