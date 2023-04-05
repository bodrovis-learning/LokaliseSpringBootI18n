package com.lokalise.javai18nspringboot;
import org.springframework.stereotype.Controller;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller public class HelloController {
  @GetMapping("/")
  public String hello() {
      return "hello";
  }

  // http://localhost:8080/datetime?date=1993-04-25&datetime=2018-11-22T01:30:00.000-05:00
  @GetMapping("/datetime")
  @ResponseBody
  public String dateTime(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
                        @RequestParam("datetime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime datetime) {
      return date.toString() + "<br>" + datetime.toString();
  }
}