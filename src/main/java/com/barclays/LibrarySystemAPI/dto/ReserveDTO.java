package com.barclays.LibrarySystemAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReserveDTO {
    private String  itemType;
    private String  title;
    private Long id;
    private String date;
}
