package hnt.spring.redis.dao;

import hnt.spring.redis.dto.ContractDataUploadInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Repository
public class ContractDataUploadInfoDaoImpl implements ContractDataUploadInfoDao {

    private static final String HASH_KEY="UPLOAD_INFO";
    private final RedisTemplate<String, Object> redisTemplate;

    public ContractDataUploadInfoDaoImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


    @Override
    public ContractDataUploadInfo saveContractDataUploadInfo(ContractDataUploadInfo contractDataUploadInfo) {
        try{
            redisTemplate.opsForHash().put(HASH_KEY,
                    contractDataUploadInfo.getContractId().toString(),
                    contractDataUploadInfo);
            return contractDataUploadInfo;
        }catch(Exception e){
            log.error("Error saving to the cache {} for contract {} ",
                    HASH_KEY,
                    contractDataUploadInfo.getContractId().toString(), e);
            return null;
        }
    }

    @Override
    public ContractDataUploadInfo updateContractDataUploadInfo(Long contractId,
                                                               ContractDataUploadInfo contractDataUploadInfo) {
        try{
            redisTemplate.opsForHash().put(HASH_KEY,
                    contractId.toString(),
                    contractDataUploadInfo);
            return contractDataUploadInfo;
        }catch(Exception e){
            log.error("Error updating the cache {} for contract {}", HASH_KEY, contractDataUploadInfo.getContractId().toString(), e);
            return null;
        }
    }

    @Override
    public boolean deleteContractDataUploadInfo(Long contractId) {
        try{
            redisTemplate.opsForHash().delete(HASH_KEY,contractId.toString());
            return true;
        }catch(Exception e){
            log.error("Error deleting the cache {} for contract {}", HASH_KEY,contractId.toString(),e);
            return false;
        }

    }

    @Override
    public List<ContractDataUploadInfo> getAllContractsDataUploadInfo() {
        List<Object> objects = redisTemplate.opsForHash().values(HASH_KEY);
        return objects.stream()
                .map(obj -> (ContractDataUploadInfo) obj)
                .collect(Collectors.toList());
    }

    @Override
    public ContractDataUploadInfo getContractDataUploadInfo(Long contractId) {
        ContractDataUploadInfo contractDataUploadInfo= (ContractDataUploadInfo) redisTemplate.opsForHash().get(HASH_KEY,contractId.toString());
        return contractDataUploadInfo;
    }
}
