package hnt.spring.redis.service;

import hnt.spring.redis.dto.ContractDataUploadInfo;

import java.util.List;

public interface ContractDataUploadInfoService {
    ContractDataUploadInfo saveContractDataUploadInfo(ContractDataUploadInfo contractDataUploadInfo);
    ContractDataUploadInfo updateContractDataUploadInfo(Long contractId, ContractDataUploadInfo contractDataUploadInfo);
    Boolean deleteContractDataUploadInfo(Long contractId);
    List<ContractDataUploadInfo> getAllContractsDataUploadInfo();
    ContractDataUploadInfo getContractDataUploadInfo(Long contractId);
}
