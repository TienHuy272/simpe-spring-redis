package hnt.spring.redis.controller;

import hnt.spring.redis.dto.ContractDataUploadInfo;
import hnt.spring.redis.service.ContractDataUploadInfoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/contract/contract-data-upload-info")
@Slf4j
@Tag(name="ContractManagementDataUploadInformationAPI", description="Provides API to manage contracts upload data information")
public class ContractDataUploadInfoController {

    @Autowired
    private ContractDataUploadInfoService contractDataUploadInfoService;

    @PostMapping
    public ResponseEntity<ContractDataUploadInfo> createContractDataUploadInfo(
            @RequestBody ContractDataUploadInfo contractDataUploadInfo ){
        log.debug("saving contract data upload information to the cache for contract {}", contractDataUploadInfo.getContractId());
        ContractDataUploadInfo savedContractDataUploadInfo=contractDataUploadInfoService.saveContractDataUploadInfo(contractDataUploadInfo);
        log.debug("contract data upload information is saved to the cache for contract {}", contractDataUploadInfo.getContractId());
        return new ResponseEntity<ContractDataUploadInfo>(savedContractDataUploadInfo, HttpStatus.CREATED);
    }

    @PutMapping(value="/{contractId}")
    public ResponseEntity<ContractDataUploadInfo> updateContractDataUploadInfo(
        @PathVariable Long contractId,@RequestBody ContractDataUploadInfo contractDataUploadInfo){
        log.debug("updating contract data upload information to the cache for contract {}", contractDataUploadInfo.getContractId());
        ContractDataUploadInfo  updatedContractDataUploadInfo=contractDataUploadInfoService.updateContractDataUploadInfo(contractId,contractDataUploadInfo);
        log.debug("contract data upload information is updated to the cache for contract {}",
                contractDataUploadInfo.getContractId());
        return new ResponseEntity<ContractDataUploadInfo>(updatedContractDataUploadInfo, HttpStatus.OK);
    }

    @GetMapping(value="/{contractId}")
    public ResponseEntity<ContractDataUploadInfo> getContractDataUploadInfo(@PathVariable Long contractId){
        log.debug("getting contract data upload information from the cache for contract {} ", contractId);
        ContractDataUploadInfo contractDataUploadInfo=contractDataUploadInfoService.getContractDataUploadInfo(contractId);
        log.debug( "contract data upload information is returned from the cache for contract {}", contractId);
        return new ResponseEntity<ContractDataUploadInfo>(contractDataUploadInfo, HttpStatus.OK);
    }
}
