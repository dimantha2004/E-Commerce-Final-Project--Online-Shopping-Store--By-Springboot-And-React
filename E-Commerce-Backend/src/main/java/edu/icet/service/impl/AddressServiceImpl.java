package edu.icet.service.impl;

import edu.icet.dto.AddressDto;
import edu.icet.dto.Response;
import edu.icet.entity.Address;
import edu.icet.entity.User;
import edu.icet.repository.AddressRepository;
import edu.icet.service.AddressService;
import edu.icet.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final UserService userService;

    @Override
    public Response saveAndUpdateAddress(AddressDto addressDto) {
        User user=userService.getLoginUser();
        Address address=user.getAddress();

        if (address == null){
            address = new Address();
            address.setUser(user);
        }
        if (addressDto.getStreet() != null) address.setStreet(addressDto.getStreet());
        if (addressDto.getCity() != null) address.setCity(addressDto.getCity());
        if (addressDto.getState() != null) address.setState(addressDto.getState());
        if (addressDto.getZipcode() != null) address.setZipcode(addressDto.getZipcode());
        if (addressDto.getCountry() != null) address.setCountry(addressDto.getCountry());

        addressRepository.save(address);

        String message = (user.getAddress() == null) ? "Address successfully created" : "Address successfully updated";
        return Response.builder()
                .status(200)
                .message(message)
                .build();
    }
}
