package com.example.hello.Auth.Account;

import com.example.hello.Auth.Credential.Credential;
import com.example.hello.Common.ApiResponse;
import com.example.hello.Org_Empl.Employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("account")
public class AccountController {
    private String BASE_CODE = "api.account";

    @Autowired
    AccountRepository accountRepository;





    @GetMapping("/list")
    public ApiResponse list(){
        return new ApiResponse(true, accountRepository.findAll(),BASE_CODE + "list.sucess");
    }

    @GetMapping("/detail/{id}")
    public ApiResponse detail(@PathVariable int id) {
        return new ApiResponse(true, accountRepository.findById(id), BASE_CODE + "detail.success");
    }

    @PostMapping("/create")
    public ApiResponse create(@RequestBody AccountCreatePayload payload) {
            try {
//                if(orgRepository.findById(payload.getOrganisation().getId()) == null){
//                    payload.setOrganisation(orgRepository.save(payload.getOrganisation()));
//                }
                Account account = new Account.Builder()
                        .setFirstname(payload.getFirstname())
                        .setLastname(payload.getLastname()).build();
                Account newAccount = accountRepository.save(account);
                return new ApiResponse(true, newAccount, BASE_CODE + "create.success");
            } catch (Exception e) {
                e.printStackTrace();
                return new ApiResponse(false, null, BASE_CODE + "create.error");
            }
    }

    @PutMapping("/update")
    public ApiResponse update(@RequestBody AccountUpdatePayload payload) {
        Account account = accountRepository.findById(payload.getAccount_id());
        if(account != null){
            Account newAccount = new Account(payload);
            Account freshAccount = accountRepository.save(newAccount);
            return new ApiResponse(true, freshAccount, null);
        } else {
            return new ApiResponse(false, null, "404");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse delete(@PathVariable int id) {
        Account accountToDelete = accountRepository.findById(id);
    if(accountToDelete != null){
            accountRepository.deleteById(id);
            return new ApiResponse(true, null, BASE_CODE + "delete.success");
        }else{
            return new ApiResponse(false, null, BASE_CODE + "delete.error");
        }
    }

}
