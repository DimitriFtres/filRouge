package com.example.hello.Org_Empl.Employee;

import com.example.hello.Common.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    private String BASE_CODE = "api.employee";

    @Autowired
    EmployeeRepository employeeRepository;





    @GetMapping("/list")
    public ApiResponse list(){
        return new ApiResponse(true,employeeRepository.findAll(),BASE_CODE + "list.sucess");
    }

    @GetMapping("/detail/{id}")
    public ApiResponse detail(@PathVariable int id) {
        return new ApiResponse(true, employeeRepository.findById(id), BASE_CODE + "detail.success");
    }

    @PostMapping("/create")
    public ApiResponse create(@RequestBody EmployeeCreatePayload payload) {
            try {
//                if(orgRepository.findById(payload.getOrganisation().getId()) == null){
//                    payload.setOrganisation(orgRepository.save(payload.getOrganisation()));
//                }
                Employee employee = new Employee.Builder()
                        .setRole(payload.getRole())
                        .setAccount(payload.getAccount())
                        .setActif(payload.isActif())
                        .setOrganization(payload.getOrganization()).build();
                Employee newEmployee = employeeRepository.save(employee);
                return new ApiResponse(true, newEmployee, BASE_CODE + "create.success");
            } catch (Exception e) {
                e.printStackTrace();
                return new ApiResponse(false, null, BASE_CODE + "create.error");
            }
    }

    @PutMapping("/update")
    public ApiResponse update(@RequestBody EmployeeUpdatePayload payload) {
        try {
//            if(orgRepository.findById(payload.getOrganisation().getId()) == null){
//                payload.setOrganisation(orgRepository.save(payload.getOrganisation()));
//            }
            Employee employee = new Employee.Builder()
                    .setEmployee_id(payload.getEmployee_id())
                    .setRole(payload.getRole())
                    .setAccount(payload.getAccount())
                    .setActif(payload.isActif())
                    .setOrganization(payload.getOrganization()).build();
            Employee newEmployee = employeeRepository.save(employee);
            return new ApiResponse(true, newEmployee, BASE_CODE + "create.success");
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse(false, null, BASE_CODE + "create.error");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse delete(@PathVariable int id) {
        Employee employeeToDelete = employeeRepository.findById(id);
    if(employeeToDelete != null){
            employeeRepository.deleteById(id);
            return new ApiResponse(true, null, BASE_CODE + "delete.success");
        }else{
            return new ApiResponse(false, null, BASE_CODE + "delete.error");
        }
    }

}
