package training360.guinessapp.worldrecords;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import training360.guinessapp.recorders.Recorder;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "world_record")
public class WorldRecord {

    public WorldRecord(String description, double value, String unitOfMeasure, LocalDate dateOfRecord, Recorder recorder) {
        this.description = description;
        this.value = value;
        this.unitOfMeasure = unitOfMeasure;
        this.dateOfRecord = dateOfRecord;
        this.recorder = recorder;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private double value;

    @Column(name = "unit_of_measure")
    private String unitOfMeasure;

    @Column(name = "date_of_record")
    private LocalDate dateOfRecord;

    @OneToOne
    private Recorder recorder;
}
