package com.example.hello.Wallet.Transaction;

import com.example.hello.Common.ApiResponse;
import com.example.hello.Wallet.Document.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("transaction")
public class TransactionController {
    private String BASE_CODE = "api.transaction";

    @Autowired
    TransactionRepository transactionRepository;





    @GetMapping("/list")
    public ApiResponse list(){
        return new ApiResponse(true, transactionRepository.findAll(),BASE_CODE + "list.sucess");
    }

    @GetMapping("/detail/{id}")
    public ApiResponse detail(@PathVariable int id) {
        return new ApiResponse(true, transactionRepository.findById(id), BASE_CODE + "detail.success");
    }

    @PostMapping("/create")
    public ApiResponse create(@RequestBody TransactionCreatePayload payload) {
            try {
//                if(orgRepository.findById(payload.getOrganisation().getId()) == null){
//                    payload.setOrganisation(orgRepository.save(payload.getOrganisation()));
//                }
                Transaction transaction = new Transaction.Builder()
                        .setType(payload.getType())
                        .setAmount(payload.getAmount())
                        .setWallet(payload.getWallet()).build();
                Transaction newtransaction = transactionRepository.save(transaction);
                return new ApiResponse(true, newtransaction, BASE_CODE + "create.success");
            } catch (Exception e) {
                e.printStackTrace();
                return new ApiResponse(false, null, BASE_CODE + "create.error");
            }
    }

    @PutMapping("/update")
    public ApiResponse update(@RequestBody TransactionUpdatePayload payload) {
        try {
//            if(orgRepository.findById(payload.getOrganisation().getId()) == null){
//                payload.setOrganisation(orgRepository.save(payload.getOrganisation()));
//            }
            Transaction transaction = new Transaction.Builder()
                    .setTransaction_id(payload.getTransaction_id())
                    .setType(payload.getType())
                    .setAmount(payload.getAmount())
                    .setWallet(payload.getWallet()).build();
            Transaction newtransaction = transactionRepository.save(transaction);
            return new ApiResponse(true, newtransaction, BASE_CODE + "create.success");
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse(false, null, BASE_CODE + "create.error");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse delete(@PathVariable int id) {
        Transaction transactionToDelete = transactionRepository.findById(id);
    if(transactionToDelete != null){
            transactionRepository.deleteById(id);
            return new ApiResponse(true, null, BASE_CODE + "delete.success");
        }else{
            return new ApiResponse(false, null, BASE_CODE + "delete.error");
        }
    }

}
