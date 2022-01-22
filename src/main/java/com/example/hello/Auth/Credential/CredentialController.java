package com.example.hello.Auth.Credential;

import com.example.hello.Common.ApiResponse;
import com.example.hello.Org_Empl.Employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("credential")
public class CredentialController {
    private String BASE_CODE = "api.credential";

    @Autowired
    CredentialRepository credentialRepository;





    @GetMapping("/list")
    public ApiResponse list(){
        return new ApiResponse(true, credentialRepository.findAll(),BASE_CODE + "list.sucess");
    }

    @GetMapping("/detail/{id}")
    public ApiResponse detail(@PathVariable int id) {
        return new ApiResponse(true, credentialRepository.findById(id), BASE_CODE + "detail.success");
    }

    @PostMapping("/create")
    public ApiResponse create(@RequestBody CredentialCreatePayload payload) {
            try {
//                if(orgRepository.findById(payload.getOrganisation().getId()) == null){
//                    payload.setOrganisation(orgRepository.save(payload.getOrganisation()));
//                }
                Credential credential = new Credential.Builder()
                        .setUsername(payload.getUsername())
                        .setPassword(payload.getPassword())
                        .setEmail(payload.getEmail())
                        .setActif(payload.isActif())
                        .setAccount(payload.getAccount()).build();
                Credential newCredential = credentialRepository.save(credential);
                return new ApiResponse(true, newCredential, BASE_CODE + "create.success");
            } catch (Exception e) {
                e.printStackTrace();
                return new ApiResponse(false, null, BASE_CODE + "create.error");
            }
    }

    @PutMapping("/update")
    public ApiResponse update(@RequestBody CredentialUpdatePayload payload) {
        Credential credential = credentialRepository.findById(payload.getCredential_id());
        if(credential != null){
            Credential newCredential = new Credential(payload);
            Credential freshCredential = credentialRepository.save(newCredential);
            return new ApiResponse(true, freshCredential, null);
        } else {
            return new ApiResponse(false, null, "404");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse delete(@PathVariable int id) {
        Credential credentialToDelete = credentialRepository.findById(id);
    if(credentialToDelete != null){
            credentialRepository.deleteById(id);
            return new ApiResponse(true, null, BASE_CODE + "delete.success");
        }else{
            return new ApiResponse(false, null, BASE_CODE + "delete.error");
        }
    }

}
