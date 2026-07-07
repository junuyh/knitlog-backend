package com.knitlog.backend.domain.yarn;

import com.knitlog.backend.domain.yarn.dto.YarnInfoCreateRequest;
import com.knitlog.backend.domain.yarn.dto.YarnInfoResponse;
import com.knitlog.backend.domain.yarn.dto.YarnInfoUpdateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/yarns")
@RequiredArgsConstructor
public class YarnInfoController {

    private final YarnInfoService yarnInfoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public YarnInfoResponse create(@Valid @RequestBody YarnInfoCreateRequest request){
        return yarnInfoService.create(request);
    }

    @GetMapping
    public List<YarnInfoResponse> findAll() {
        return yarnInfoService.findAll();
    }

    @GetMapping("/{yarnInfoId}")
    public YarnInfoResponse findById(@PathVariable Long yarnInfoId) {
        return yarnInfoService.findById(yarnInfoId);
    }

    @PutMapping("/{yarnInfoId}")
    public YarnInfoResponse update(@PathVariable Long yarnInfoId, @Valid @RequestBody YarnInfoUpdateRequest request) {
        return yarnInfoService.update(yarnInfoId, request);
    }

    @DeleteMapping("/{yarnInfoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long yarnInfoId) {
        yarnInfoService.delete(yarnInfoId);
    }
}
