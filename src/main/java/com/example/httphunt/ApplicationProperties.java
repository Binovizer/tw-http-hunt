package com.example.httphunt;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * The type ApplicationProperties
 *
 * @author Mohd Nadeem
 */
@Data
@Configuration
public class ApplicationProperties {

    @Value("${user.id}")
    private String userId;

}
