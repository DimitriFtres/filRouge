package com.example.hello.Wallet.Wallet;

import com.example.hello.Common.ApiResponse;
import com.example.hello.Wallet.Document.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("wallet")
public class WalletController {
    private String BASE_CODE = "api.wallet";

    @Autowired
    WalletRepository walletRepository;





    @GetMapping("/list")
    public ApiResponse list(){
        return new ApiResponse(true, walletRepository.findAll(),BASE_CODE + "list.sucess");
    }

    @GetMapping("/detail/{id}")
    public ApiResponse detail(@PathVariable int id) {
        return new ApiResponse(true, walletRepository.findById(id), BASE_CODE + "detail.success");
    }

    @PostMapping("/create")
    public ApiResponse create(@RequestBody WalletCreatePayload payload) {
            try {
//                if(orgRepository.findById(payload.getOrganisation().getId()) == null){
//                    payload.setOrganisation(orgRepository.save(payload.getOrganisation()));
//                }
                Wallet wallet = new Wallet.Builder()
                        .setName(payload.getName())
                        .setDescription(payload.getDescription())
                        .setActif(payload.isActif())
                        .setType(payload.getType())
                        .setEmployee(payload.getEmployee()).build();
                Wallet newwallet = walletRepository.save(wallet);
                return new ApiResponse(true, newwallet, BASE_CODE + "create.success");
            } catch (Exception e) {
                e.printStackTrace();
                return new ApiResponse(false, null, BASE_CODE + "create.error");
            }
    }

    @PutMapping("/update")
    public ApiResponse update(@RequestBody WalletUpdatePayload payload) {
        try {
//            if(orgRepository.findById(payload.getOrganisation().getId()) == null){
//                payload.setOrganisation(orgRepository.save(payload.getOrganisation()));
//            }
            Wallet wallet = new Wallet.Builder()
                    .setWallet_id(payload.getWallet_id())
                    .setName(payload.getName())
                    .setDescription(payload.getDescription())
                    .setActif(payload.isActif())
                    .setType(payload.getType())
                    .setEmployee(payload.getEmployee()).build();
            Wallet newwallet = walletRepository.save(wallet);
            return new ApiResponse(true, newwallet, BASE_CODE + "create.success");
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse(false, null, BASE_CODE + "create.error");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse delete(@PathVariable int id) {
        Wallet walletToDelete = walletRepository.findById(id);
    if(walletToDelete != null){
            walletRepository.deleteById(id);
            return new ApiResponse(true, null, BASE_CODE + "delete.success");
        }else{
            return new ApiResponse(false, null, BASE_CODE + "delete.error");
        }
    }

}
