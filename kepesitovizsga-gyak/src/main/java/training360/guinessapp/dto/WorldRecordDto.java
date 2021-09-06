package training360.guinessapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import training360.guinessapp.recorders.Recorder;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorldRecordDto {

    private Long id;
    private String description;
    private double value;
    private String unitOfMeasure;
    private LocalDate dateOfRecord;
    private String recorderName;
}
