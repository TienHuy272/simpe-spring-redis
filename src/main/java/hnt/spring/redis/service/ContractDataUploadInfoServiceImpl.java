package hnt.spring.redis.service;

import hnt.spring.redis.dao.ContractDataUploadInfoDao;
import hnt.spring.redis.dto.ContractDataUploadInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContractDataUploadInfoServiceImpl implements ContractDataUploadInfoService {

    private final ContractDataUploadInfoDao contractDataUploadInfoDao;


    @Override
    public ContractDataUploadInfo saveContractDataUploadInfo(ContractDataUploadInfo contractDataUploadInfo){
        return contractDataUploadInfoDao.saveContractDataUploadInfo(contractDataUploadInfo);
    }

    @Override
    public ContractDataUploadInfo updateContractDataUploadInfo(Long contractId,ContractDataUploadInfo contractDataUploadInfo){
        return contractDataUploadInfoDao.updateContractDataUploadInfo(contractId,contractDataUploadInfo);
    }

    @Override
    public Boolean deleteContractDataUploadInfo(Long contractId){
        return contractDataUploadInfoDao.deleteContractDataUploadInfo(contractId);
    }

    @Override
    public List<ContractDataUploadInfo>getAllContractsDataUploadInfo(){
        return contractDataUploadInfoDao.getAllContractsDataUploadInfo();
    }

    @Override
    public ContractDataUploadInfo getContractDataUploadInfo(Long contractId){
        return contractDataUploadInfoDao.getContractDataUploadInfo(contractId);
    }
}
