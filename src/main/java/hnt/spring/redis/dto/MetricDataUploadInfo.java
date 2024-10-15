package hnt.spring.redis.dto;

import lombok.Data;

import java.io.Serializable;


@Data
public class MetricDataUploadInfo implements Serializable {
    private Long metricId;
    private String fuckingOtherFields;
}
