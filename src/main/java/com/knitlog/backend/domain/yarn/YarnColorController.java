package com.knitlog.backend.domain.yarn;

import com.knitlog.backend.domain.yarn.dto.YarnColorCreateRequest;
import com.knitlog.backend.domain.yarn.dto.YarnColorResponse;
import com.knitlog.backend.domain.yarn.dto.YarnColorUpdateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/yarns/{yarnInfoId}/colors")
@RequiredArgsConstructor
public class YarnColorController {

    private final YarnColorService yarnColorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public YarnColorResponse create(@PathVariable Long yarnInfoId,
                                    @Valid @RequestBody YarnColorCreateRequest request) {
        return yarnColorService.create(yarnInfoId, request);
    }

    @GetMapping
    public List<YarnColorResponse> findAll(@PathVariable Long yarnInfoId) {
        return yarnColorService.findAllByYarnInfo(yarnInfoId);
    }

    @GetMapping("/{colorId}")
    public YarnColorResponse findById(@PathVariable Long yarnInfoId, @PathVariable Long colorId) {
        return yarnColorService.findById(yarnInfoId, colorId);
    }

    @PutMapping("/{colorId}")
    public YarnColorResponse update(@PathVariable Long yarnInfoId, @PathVariable Long colorId,
                                    @Valid @RequestBody YarnColorUpdateRequest request) {
        return yarnColorService.update(yarnInfoId, colorId, request);
    }

    @DeleteMapping("/{colorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long yarnInfoId, @PathVariable Long colorId) {
        yarnColorService.delete(yarnInfoId, colorId);
    }
}
