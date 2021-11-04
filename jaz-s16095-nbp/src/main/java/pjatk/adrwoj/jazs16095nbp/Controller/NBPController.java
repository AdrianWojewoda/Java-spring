package pjatk.adrwoj.jazs16095nbp.Controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pjatk.adrwoj.jazs16095nbp.Model.EnumGold;
import pjatk.adrwoj.jazs16095nbp.Service.NBPService;
import pjatk.adrwoj.jazs16095nbp.Model.NBP;

import java.io.Console;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping("/nbp")
public class NBPController {

    private final NBPService nbpService;

    public NBPController(NBPService nbpService) {
        this.nbpService = nbpService;
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 400, message = "Bad Request")}
    )

    @ApiOperation(value="find gold price between two dates", notes="")
    @GetMapping()
    public ResponseEntity<Double> getGold(@ApiParam(value ="Data poczatkowa", example = "2020-06-24") @RequestParam("start") String start,
                                          @ApiParam(value ="Data koncowa", example = "2020-07-24") @RequestParam("end") String end) {

        DateTimeFormatter formator = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate formatedStart = LocalDate.parse(start, formator);
        LocalDate formatedEnd= LocalDate.parse(end, formator);
        Date requestDateTime = Calendar.getInstance().getTime();
        Double avg = nbpService.getPrice(start, end);
        NBP log = new NBP(EnumGold.Gold, formatedStart, formatedEnd, avg, requestDateTime);
        nbpService.save(log);

        return ResponseEntity.ok(avg);
    }

}
