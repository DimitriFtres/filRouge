package com.example.hello.security.entity.payload;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefreshTokenRequest {

    @NotNull
    private String refresh;
    public void setRefresh(String refresh){
        this.refresh = refresh;
    }
    public String getRefresh(){
        return this.refresh;
    }
}