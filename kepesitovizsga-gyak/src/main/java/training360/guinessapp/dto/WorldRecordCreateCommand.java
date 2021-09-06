package training360.guinessapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import training360.guinessapp.recorders.Recorder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorldRecordCreateCommand {

    @NotNull
    @NotBlank
    private String description;

    @NotNull
    private double value;

    @NotNull
    @NotBlank
    private String unitOfMeasure;

    @NotNull
    private LocalDate dateOfRecord;

    @NotNull
    private Long recorderId;
}
