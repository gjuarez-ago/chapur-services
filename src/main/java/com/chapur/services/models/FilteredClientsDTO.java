package com.chapur.services.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilteredClientsDTO {
    String clientId;
    String cardNumber;
    ArrayList<Beneficiary> beneficiariesList;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Beneficiary {
        String name;
        String relationship;


    }
}
