package com.example.hello.Org_Empl.Address;

import com.example.hello.Common.ApiResponse;
import com.example.hello.Org_Empl.Address.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("address")
public class AddressController {
    private String BASE_CODE = "api.address";

    @Autowired
    AddressRepository addressRepository;

    @GetMapping("/list")
    public ApiResponse list(){
        return new ApiResponse(true, addressRepository.findUnusedAddress(),BASE_CODE + "list.sucess");
    }

    @GetMapping("/detail/{id}")
    public ApiResponse detail(@PathVariable int id) {
        return new ApiResponse(true, addressRepository.findById(id), BASE_CODE + "detail.success");
    }

    @PostMapping("/create")
    public ApiResponse create(@RequestBody AddressCreatePayload payload) {
            try {
//                if(orgRepository.findById(payload.getOrganisation().getId()) == null){
//                    payload.setOrganisation(orgRepository.save(payload.getOrganisation()));
//                }
                Address address = new Address.Builder()
                        .setRoad(payload.getRoad())
                        .setBox(payload.getBox())
                        .setCountry(payload.getCountry())
                        .setCp(payload.getCp())
                        .setNumber(payload.getNumber())
                        .setTown(payload.getTown())
                        .setType(payload.getType()).build();
                Address newAddress = addressRepository.save(address);
                return new ApiResponse(true, newAddress, BASE_CODE + "create.success");
            } catch (Exception e) {
                e.printStackTrace();
                return new ApiResponse(false, null, BASE_CODE + "create.error");
            }
    }

    @PutMapping("/update")
    public ApiResponse update(@RequestBody AddressUpdatePayload payload) {
        Address address = addressRepository.findById(payload.getAddress_id());
        if(address != null){
            Address newAddress = new Address(payload);
            Address freshAddress = addressRepository.save(newAddress);
            return new ApiResponse(true, freshAddress, null);
        } else {
            return new ApiResponse(false, null, "404");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse delete(@PathVariable int id) {
        Address addressToDelete = addressRepository.findById(id);
    if(addressToDelete != null){
            addressRepository.deleteById(id);
            return new ApiResponse(true, null, BASE_CODE + "delete.success");
        }else{
            return new ApiResponse(false, null, BASE_CODE + "delete.error");
        }
    }

}
