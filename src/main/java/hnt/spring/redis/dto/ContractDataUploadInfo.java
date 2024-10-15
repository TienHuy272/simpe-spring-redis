package hnt.spring.redis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContractDataUploadInfo implements Serializable {
    private Long contractId;
    private List<MetricDataUploadInfo> metricDataUploadInfo;
}
