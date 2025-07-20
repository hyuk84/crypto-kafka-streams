package com.hyuk84.stream.processor;

import com.hyuk84.common.dto.TickerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TickerProcessor {

    public void process(String key, TickerDto dto) {
        log.info("Processing Ticker: {}", dto);
    }
}
