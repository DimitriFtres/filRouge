package com.example.hello.security.entity.response;

public class TokenResponse {
    private String access_token;
    private String token_type;
    private String refresh_token;
    private int expires_in;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public TokenResponse(String access_token, String token_type, String refresh_token, int expires_in) {
        this.access_token = access_token;
        this.token_type = token_type;
        this.refresh_token = refresh_token;
        this.expires_in = expires_in;
    }
    public TokenResponse(){

    }
    public TokenResponse(String result){
        String[] arr = result.split(",");

        this.access_token = arr[0].substring(arr[0].indexOf(":")+2, arr[0].length()-1);
        this.token_type = arr[1].substring(arr[1].indexOf(":")+2, arr[1].length()-1);
        this.refresh_token = arr[2].substring(arr[2].indexOf(":")+2, arr[2].length()-1);
        this.expires_in = Integer.parseInt(arr[3].substring(arr[3].indexOf(":")+1));
    }
}

