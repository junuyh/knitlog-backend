package com.knitlog.backend.domain.yarn;

import com.knitlog.backend.domain.yarn.dto.YarnColorCreateRequest;
import com.knitlog.backend.domain.yarn.dto.YarnColorResponse;
import com.knitlog.backend.domain.yarn.dto.YarnColorUpdateRequest;
import com.knitlog.backend.global.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class YarnColorService {

    private final YarnColorRepository yarnColorRepository;
    private final YarnInfoRepository yarnInfoRepository;

    @Transactional
    public YarnColorResponse create(Long yarnInfoId, YarnColorCreateRequest request){
        YarnInfo yarnInfo = getYarnInfo(yarnInfoId);
        YarnColor yarnColor = new YarnColor(
                yarnInfo,
                request.colorCode(),
                request.colorName(),
                request.memo()
        );

        YarnColor savedYarnColor = yarnColorRepository.save(yarnColor);
        return YarnColorResponse.from(savedYarnColor);
    }

    @Transactional(readOnly = true)
    public List<YarnColorResponse> findAllByYarnInfo(Long yarnInfoId){
        getYarnInfo(yarnInfoId);
        return yarnColorRepository.findByYarnInfoId(yarnInfoId).stream()
                .map(YarnColorResponse::from)
                .toList();
    }

    @Transactional(readOnly = true)
    public YarnColorResponse findById(Long yarnInfoId, Long colorId) {
        return YarnColorResponse.from(getYarnColor(yarnInfoId, colorId));
    }

    @Transactional
    public YarnColorResponse update(Long yarnInfoId, Long colorId, YarnColorUpdateRequest request) {
        YarnColor yarnColor = getYarnColor(yarnInfoId, colorId);
        yarnColor.update(request.colorCode(), request.colorName(), request.memo());
        return YarnColorResponse.from(yarnColor);
    }

    @Transactional
    public void delete(Long yarnInfoId, Long colorId) {
        yarnColorRepository.delete(getYarnColor(yarnInfoId, colorId));
    }

    private YarnInfo getYarnInfo(Long yarnInfoId) {
        return yarnInfoRepository.findById(yarnInfoId)
                .orElseThrow(() -> new EntityNotFoundException("YarnInfo not found: id=" + yarnInfoId));
    }

    private YarnColor getYarnColor(Long yarnInfoId, Long colorId) {
        YarnColor yarnColor = yarnColorRepository.findById(colorId)
                .orElseThrow(() -> new EntityNotFoundException("YarnColor not found: id=" + colorId));
        if (!yarnColor.getYarnInfo().getId().equals(yarnInfoId)) {
            throw new EntityNotFoundException(
                    "YarnColor not found: id=" + colorId + " for yarnInfoId=" + yarnInfoId);
        }
        return yarnColor;
    }
}
