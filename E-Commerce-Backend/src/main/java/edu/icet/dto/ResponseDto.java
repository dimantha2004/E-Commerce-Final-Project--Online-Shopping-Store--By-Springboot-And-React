package edu.icet.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDto {

    private int status;
    private String message;

    @Builder.Default
    private final LocalDateTime timestamp = LocalDateTime.now();

    private String token;
    private String role;
    private String expirationTime;

    private int totalpage;
    private long totalElement;

    private AddressDto address;

    private UserDto user;
    private List<UserDto> userList;

    private CategoryDto category;
    private List<CategoryDto> categoryList;

    private OrderItemDto orderItem;
    private List<OrderItemDto> orderItemList;

    private OrderDto order;
    private List<OrderDto> orderList;
}