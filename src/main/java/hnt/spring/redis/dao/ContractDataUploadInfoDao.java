package hnt.spring.redis.dao;

import hnt.spring.redis.dto.ContractDataUploadInfo;

import java.util.List;

public interface ContractDataUploadInfoDao {
    ContractDataUploadInfo saveContractDataUploadInfo(ContractDataUploadInfo contractDataUploadInfo);
    ContractDataUploadInfo updateContractDataUploadInfo(Long contractId, ContractDataUploadInfo contractDataUploadInfo);
    boolean deleteContractDataUploadInfo(Long contractId);
    List<ContractDataUploadInfo> getAllContractsDataUploadInfo();
    ContractDataUploadInfo getContractDataUploadInfo(Long contractId);
}
