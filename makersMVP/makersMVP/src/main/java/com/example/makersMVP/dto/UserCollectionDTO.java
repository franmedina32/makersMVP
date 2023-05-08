package com.example.makersMVP.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCollectionDTO {
    private String userEmail;
    private String collectionName;
    private String contractAddress;

    public UserCollectionDTO() {
    }

    public UserCollectionDTO(String userEmail, String collectionName, String contractAddress) {
        this.userEmail = userEmail;
        this.collectionName = collectionName;
        this.contractAddress = contractAddress;
    }
}
