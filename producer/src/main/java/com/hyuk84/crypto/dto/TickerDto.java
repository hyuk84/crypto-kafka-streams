package com.hyuk84.crypto.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class TickerDto {
    private String type;
    private String code;
    private double opening_price;
    private double high_price;
    private double low_price;
    private double trade_price;
    private double prev_closing_price;
    private double acc_trade_price;
    private String change;
    private double change_price;
    private double signed_change_price;
    private double change_rate;
    private double signed_change_rate;
    private String ask_bid;
    private double trade_volume;
    private double acc_trade_volume;
    private String trade_date;
    private String trade_time;
    private long trade_timestamp;
    private double acc_ask_volume;
    private double acc_bid_volume;
    private double highest_52_week_price;
    private String highest_52_week_date;
    private double lowest_52_week_price;
    private String lowest_52_week_date;
    private String market_state;
    @JsonProperty("is_trading_suspended")
    private boolean trading_suspended;
    private String delisting_date;
    private String market_warning;
    private long timestamp;
    private double acc_trade_price_24h;
    private double acc_trade_volume_24h;
    private String stream_type;
}