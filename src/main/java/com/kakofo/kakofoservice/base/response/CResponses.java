package com.kakofo.kakofoservice.base.response;

public class CResponses {
    public static <T> CResponse<T> notFound() {
        return CResponse.error("Cette entité n'existe pas");
    }
}
