package com.govtech.customjsonview.view;

public interface Views {

    // To expose only user address information
    public static interface UserAddressView {}

    // To expose only user view information
    public static interface UserView {}

    // To expose only user contact information
    public static interface UserContactInfo  {}

    // To expose user all information
    public static interface UserInfo extends UserView, UserContactInfo {}

}
