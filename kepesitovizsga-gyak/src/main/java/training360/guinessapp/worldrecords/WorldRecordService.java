package training360.guinessapp.worldrecords;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import training360.guinessapp.RecorderNotFoundException;
import training360.guinessapp.dto.WorldRecordCreateCommand;
import training360.guinessapp.dto.WorldRecordDto;
import training360.guinessapp.recorders.Recorder;
import training360.guinessapp.recorders.RecorderRepository;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class WorldRecordService {

    private ModelMapper modelMapper;
    private WorldRecordRepository worldRecordRepository;
    private RecorderRepository recorderRepository;

    public List<WorldRecordDto> getWorldRecordsList() {
        return worldRecordRepository.findAll().stream()
                .map(worldRecord -> modelMapper.map(worldRecord, WorldRecordDto.class))
                .collect(Collectors.toList());
    }

    public WorldRecordDto addNewWorldRecord(WorldRecordCreateCommand command) {
        Recorder recorder = recorderRepository.findById(command.getRecorderId())
                .orElseThrow(() -> new RecorderNotFoundException(command.getRecorderId()));
        return modelMapper.map(worldRecordRepository.save(new WorldRecord(
                command.getDescription(),
                command.getValue(),
                command.getUnitOfMeasure(),
                command.getDateOfRecord(),
                recorder
        )), WorldRecordDto.class);
    }
}
