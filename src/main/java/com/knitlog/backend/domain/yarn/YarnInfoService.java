package com.knitlog.backend.domain.yarn;

import com.knitlog.backend.domain.yarn.dto.YarnInfoCreateRequest;
import com.knitlog.backend.domain.yarn.dto.YarnInfoResponse;
import com.knitlog.backend.domain.yarn.dto.YarnInfoUpdateRequest;
import com.knitlog.backend.global.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class YarnInfoService {

    private final YarnInfoRepository yarnInfoRepository;

    @Transactional
    public YarnInfoResponse create(YarnInfoCreateRequest request){
        YarnInfo yarnInfo = new YarnInfo(
                request.brand(),
                request.name(),
                request.season(),
                request.yarnType(),
                request.thickness(),
                request.lengthPer100g(),
                request.memo()
        );

        YarnInfo savedYarnInfo =  yarnInfoRepository.save(yarnInfo);

        return YarnInfoResponse.from(savedYarnInfo);
    }

    @Transactional(readOnly = true)
    public List<YarnInfoResponse> findAll() {
        return yarnInfoRepository.findAll().stream()
                .map(YarnInfoResponse::from)
                .toList();
    }

    @Transactional(readOnly = true)
    public YarnInfoResponse findById(Long yarnInfoId) {
        return YarnInfoResponse.from(getYarnInfo(yarnInfoId));
    }

    @Transactional
    public YarnInfoResponse update(Long yarnInfoId, YarnInfoUpdateRequest request) {
        YarnInfo yarnInfo = getYarnInfo(yarnInfoId);
        yarnInfo.update(
                request.brand(),
                request.name(),
                request.season(),
                request.yarnType(),
                request.thickness(),
                request.lengthPer100g(),
                request.memo()
        );
        return YarnInfoResponse.from(yarnInfo);
    }

    @Transactional
    public void delete(Long yarnInfoId) {
        yarnInfoRepository.delete(getYarnInfo(yarnInfoId));
    }

    private YarnInfo getYarnInfo(Long yarnInfoId) {
        return yarnInfoRepository.findById(yarnInfoId)
                .orElseThrow(() -> new EntityNotFoundException("YarnInfo not found: id=" + yarnInfoId));
    }
}
