package uz.najot.metroprojectdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StationDto {
    private Integer id;
    private String name;
    private Double balance;

}
