package com.govtech.customjsonview.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.govtech.customjsonview.view.Views;
import lombok.Data;
import java.time.LocalDate;

@Data
public class User {

    @JsonView(Views.UserView.class)
    private Integer userId;

    @JsonView(Views.UserView.class)
    private String userName;

    @JsonView(Views.UserContactInfo.class)
    private String userContact;

    @JsonView(Views.UserContactInfo.class)
    private String userEmail;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonView(Views.UserView.class)
    private LocalDate userDoj;

    @JsonView(Views.UserAddressView.class)
    private String city;

    @JsonView(Views.UserAddressView.class)
    private String state;

    @JsonView(Views.UserAddressView.class)
    private String country;

    @JsonView(Views.UserView.class)
    private String profession;

    @JsonView(Views.UserView.class)
    @JsonProperty(value = "userAddress")
    public String getUserAddress() {
        return String.join(", ", city, state, country);
    }

}
