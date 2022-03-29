package com.example.hello.security.entity.payload;
import com.example.hello.Common.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequest{

    @NotBlank
    @Size(max = 50)
    @Email
    private String username;
    @NotBlank
    private String gender;
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    public ApiResponse isValid(){
        if(username == null ||username.isEmpty()){
            if(password == null ||password.isEmpty()){
                return new ApiResponse(false, null, "api.signup.valid-error-full");
            }else{
                return new ApiResponse(false, null, "api.signup.valid-error-email");
            }
        }else if(password == null ||password.isEmpty()){
            return new ApiResponse(false, null, "api.signup.valid-error-password");
        }else{
            return new ApiResponse(true, this, null);
        }
    }
}

