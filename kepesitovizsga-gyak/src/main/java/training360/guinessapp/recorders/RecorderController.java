package training360.guinessapp.recorders;

import org.springframework.web.bind.annotation.*;
import training360.guinessapp.dto.RecorderCreateCommand;
import training360.guinessapp.dto.RecorderDto;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/recorders")
public class RecorderController {

    private RecorderService recorderService;

    public RecorderController(RecorderService recorderService) {
        this.recorderService = recorderService;
    }

    @GetMapping
    public List<RecorderDto> getRecordersList() {
        return recorderService.getRecordersList();
    }

    @PostMapping
    public RecorderDto addNewRecorder(@Valid @RequestBody RecorderCreateCommand command) {
        return recorderService.addNewRecorder(command);
    }
}
