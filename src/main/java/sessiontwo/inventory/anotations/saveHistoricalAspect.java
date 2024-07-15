package sessiontwo.inventory.anotations;

import lombok.AllArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import sessiontwo.inventory.services.historical.HistoricalService;

@Aspect
@Component

@AllArgsConstructor
public class saveHistoricalAspect {

    private final HistoricalService historicalService;

    @Pointcut("@annotation(sessiontwo.inventory.anotations.SaveHistorical)")
    public void saveHistoricalPointcut() {
        // Pointcut definition
    }

    @After("saveHistoricalPointcut() && @annotation(saveHistorical)")
    public void saveHistorical(JoinPoint joinPoint, SaveHistorical saveHistorical) {
       historicalService.save(saveHistorical.method());
    }
}
