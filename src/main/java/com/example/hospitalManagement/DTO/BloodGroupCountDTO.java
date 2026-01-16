package com.example.hospitalManagement.DTO;

import com.example.hospitalManagement.Enum.BloodGroupType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BloodGroupCountDTO {
    private BloodGroupType bloodGroupType;
    private Long count;
}
