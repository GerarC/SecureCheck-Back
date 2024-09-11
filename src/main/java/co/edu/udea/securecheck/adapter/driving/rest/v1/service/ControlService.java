package co.edu.udea.securecheck.adapter.driving.rest.v1.service;

import co.edu.udea.securecheck.adapter.driving.rest.v1.dto.response.ControlResponse;
import co.edu.udea.securecheck.adapter.driving.rest.v1.dto.response.PageResponse;

import java.util.List;
import java.util.Map;

public interface ControlService {
    PageResponse<ControlResponse> getControls(Map<String, String> query);
}
