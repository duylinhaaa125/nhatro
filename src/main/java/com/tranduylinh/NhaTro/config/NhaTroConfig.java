package com.tranduylinh.NhaTro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tranduylinh.NhaTro.api.HeThongNhaTroAPI;

@Configuration
public class NhaTroConfig {

	@Bean
    public HeThongNhaTroAPI heThongNhaTroAPI() {
        return new HeThongNhaTroAPI(); // Instantiate or inject your HeThongNhaTroAPI bean here
    }
}
