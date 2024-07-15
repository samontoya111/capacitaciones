package sessiontwo.inventory.services.report;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import sessiontwo.inventory.entities.product.Product;
import sessiontwo.inventory.entities.report.Report;
import sessiontwo.inventory.entities.report.ReportRepository;
import sessiontwo.inventory.services.product.ProductService;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReportService {

    private final ProductService productService;
    private final ReportRepository reportRepository;

    @Async
    public void generateReport() {
        CompletableFuture.supplyAsync(productService::getOutOfStockProducts)
                .thenApply(
                    this::buildReport
                )
                .thenAccept(this::saveReport).join();
    }

    private String buildReport(List<Product> products){
        String format = "%s: %d";

       return products.stream()
               .map(product->  format.formatted(product.getName(), product.getQuantity()))
                       .collect(Collectors.joining(", "));
    }
    private void saveReport(String report){
        reportRepository.save(Report.builder().description(report).build());
    }

    public ResponseEntity<List<Report>> viewReport() {
        List<Report> reports = (List<Report>) reportRepository.findAll();
        return new ResponseEntity<>(reports, HttpStatus.OK);

    }
}
