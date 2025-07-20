package com.hyuk84.stream.topology;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hyuk84.common.dto.TickerDto;
import com.hyuk84.common.serde.JsonSerdeFactory;
import com.hyuk84.stream.processor.TickerProcessor;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class TickerStreamTopology {

    @Value("${app.kafka.topic.ticker}")
    private String tickerTopic;

    private final ObjectMapper objectMapper;

    private final TickerProcessor tickerProcessor;

    public TickerStreamTopology(ObjectMapper objectMapper, TickerProcessor tickerProcessor) {
        this.objectMapper = objectMapper;
        this.tickerProcessor = tickerProcessor;
    }

    @Bean
    public KStream<String, TickerDto> tickerStream(StreamsBuilder builder) {
        return builder.stream(
                tickerTopic,
                Consumed.with(Serdes.String(), JsonSerdeFactory.serdeFor(TickerDto.class, objectMapper))
        ).peek((key, value) -> {
            tickerProcessor.process(key, value);
        });
    }

}
