package com.example.hello.Wallet.Salary;

import com.example.hello.Common.ApiResponse;
import com.example.hello.Wallet.Document.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("salary")
public class SalaryController {
    private String BASE_CODE = "api.salary";

    @Autowired
    SalaryRepository salaryRepository;





    @GetMapping("/list")
    public ApiResponse list(){
        return new ApiResponse(true, salaryRepository.findAll(),BASE_CODE + "list.sucess");
    }

    @GetMapping("/detail/{id}")
    public ApiResponse detail(@PathVariable int id) {
        return new ApiResponse(true, salaryRepository.findById(id), BASE_CODE + "detail.success");
    }

    @PostMapping("/create")
    public ApiResponse create(@RequestBody SalaryCreatePayload payload) {
            try {
//                if(orgRepository.findById(payload.getOrganisation().getId()) == null){
//                    payload.setOrganisation(orgRepository.save(payload.getOrganisation()));
//                }
                Salary salary = new Salary.Builder()
                        .setType(payload.getType())
                        .setBilling_date(payload.getBilling_date())
                        .setAmount(payload.getAmount())
                        .setPeriodicity(payload.getPeriodicity())
                        .setEmployee(payload.getEmployee()).build();
                Salary newsalary = salaryRepository.save(salary);
                return new ApiResponse(true, newsalary, BASE_CODE + "create.success");
            } catch (Exception e) {
                e.printStackTrace();
                return new ApiResponse(false, null, BASE_CODE + "create.error");
            }
    }

    @PutMapping("/update")
    public ApiResponse update(@RequestBody SalaryUpdatePayload payload) {
        try {
//            if(orgRepository.findById(payload.getOrganisation().getId()) == null){
//                payload.setOrganisation(orgRepository.save(payload.getOrganisation()));
//            }
            Salary salary = new Salary.Builder()
                    .setSalary_id(payload.getSalary_id())
                    .setType(payload.getType())
                    .setBilling_date(payload.getBilling_date())
                    .setAmount(payload.getAmount())
                    .setPeriodicity(payload.getPeriodicity())
                    .setEmployee(payload.getEmployee()).build();
            Salary newsalary = salaryRepository.save(salary);
            return new ApiResponse(true, newsalary, BASE_CODE + "create.success");
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse(false, null, BASE_CODE + "create.error");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse delete(@PathVariable int id) {
        Salary salaryToDelete = salaryRepository.findById(id);
    if(salaryToDelete != null){
            salaryRepository.deleteById(id);
            return new ApiResponse(true, null, BASE_CODE + "delete.success");
        }else{
            return new ApiResponse(false, null, BASE_CODE + "delete.error");
        }
    }

}
