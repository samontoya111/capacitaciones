package sessiontwo.inventory.rest;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sessiontwo.inventory.constants.Constants;
import sessiontwo.inventory.entities.report.Report;
import sessiontwo.inventory.services.report.ReportService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/report")
public class ReportController {
    private final ReportService reportService;

    @GetMapping("")
    public ResponseEntity<String> generateReport()  {
        reportService.generateReport();
        return new ResponseEntity<>(Constants.GENERATE_REPORT, HttpStatus.OK);
    }
    @GetMapping("view")
    public ResponseEntity<List<Report>> viewReport()  {
        return reportService.viewReport();
    }
}