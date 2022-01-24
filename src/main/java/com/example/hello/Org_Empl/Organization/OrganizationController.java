package com.example.hello.Org_Empl.Organization;

import com.example.hello.Common.ApiResponse;
import com.example.hello.Org_Empl.Employee.Employee;
import com.example.hello.Org_Empl.Employee.EmployeeUpdatePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("organization")
public class OrganizationController {
    private String BASE_CODE = "api.organization";

    @Autowired
    OrganizationRepository organizationRepository;

    @GetMapping("/list")
    public ApiResponse getList(){
        return new ApiResponse(true, organizationRepository.findAll(), BASE_CODE);
    }

    @GetMapping("/organisation/{id}")
    public ApiResponse getOrganization(@PathVariable int id){
        return new ApiResponse(true, organizationRepository.findById(id), BASE_CODE);
    }

    @PostMapping("/create")
    public ApiResponse createOrganization(@RequestBody OrganizationCreatePayload payload)
    {
        Organization organization = new Organization.Builder()
                .setName(payload.getName())
                .setDescription(payload.getDescription())
                .setActif(payload.isActif()).build();
        Organization newOrganization = organizationRepository.save(organization);
        return new ApiResponse(true, newOrganization, BASE_CODE);
    }

    @PutMapping("/update")
    public ApiResponse update(@RequestBody OrganizationUpdatePayload payload) {
        Organization organization = organizationRepository.findById(payload.getOrganization_id());
        if(organization != null){
            Organization newOrganization = new Organization(payload);
            Organization freshOrganization = organizationRepository.save(newOrganization);
            return new ApiResponse(true, freshOrganization, null);
        } else {
            return new ApiResponse(false, null, "404");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse delete(@PathVariable int id) {
        Organization organizationToDelete = organizationRepository.findById(id);
        if(organizationToDelete != null){
            organizationRepository.deleteById(id);
            return new ApiResponse(true, null, BASE_CODE + "delete.success");
        }else{
            return new ApiResponse(false, null, BASE_CODE + "delete.error");
        }
    }
}
