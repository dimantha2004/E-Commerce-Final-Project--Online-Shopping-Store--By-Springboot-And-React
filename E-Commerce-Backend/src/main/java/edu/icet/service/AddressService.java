package edu.icet.service;

import edu.icet.dto.AddressDto;
import edu.icet.dto.Response;

public interface AddressService {

    Response saveAndUpdateAddress(AddressDto addressDto);
}
