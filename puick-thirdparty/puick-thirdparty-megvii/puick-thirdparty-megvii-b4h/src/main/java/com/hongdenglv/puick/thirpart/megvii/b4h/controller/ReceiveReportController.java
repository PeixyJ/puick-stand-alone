package com.hongdenglv.puick.thirpart.megvii.b4h.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hongdenglv.puick.thirpart.megvii.b4h.dto.report.RecognitionDTO;
import com.hongdenglv.puick.thirpart.megvii.b4h.dto.report.SnapBehaviorDTO;
import com.hongdenglv.puick.thirpart.megvii.b4h.dto.report.SnapFaceDTO;
import com.hongdenglv.puick.thirpart.megvii.b4h.service.receive.ReceiveService;
import com.hongdenglv.puick.thirpart.megvii.b4h.utils.RequestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 上报控制层
 *
 * @author PeiXy_J
 * @since 2022-4-25 14:31
 */
@RestController
@RequestMapping("/api/v1/receive")
public class ReceiveReportController {

    ReceiveService receiveService;

    public ReceiveReportController(ReceiveService receiveService) {
        this.receiveService = receiveService;
    }

    /**
     * 行为告警上报请求头
     */
    private static final String BEHAVIOR_BEGIN = "alert_events";

    /**
     * 人脸告警上报请求头
     */
    private static final String FACE_BEGIN = "screen_token";


    /**
     * JACKSON
     */
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * 接收抓拍上报
     * <p>
     * 抓拍包含
     * 陌生人抓拍
     * 行为抓拍
     *
     * @param httpServletRequest http请求
     * @author PeiXy_J
     * @since 14:36 2022-4-25
     */
    @PostMapping("snap")
    public void receiveSnapReport(HttpServletRequest httpServletRequest) throws IOException {
        //请求转String
        String requestPostStr = RequestUtils.getRequestPostStr(httpServletRequest);
        String beginContent = requestPostStr.substring(2, 16);
        if (beginContent.contains(FACE_BEGIN)) {
            receiveService.snapFaceHandler(OBJECT_MAPPER.readValue(requestPostStr, SnapFaceDTO.class));
        }
        if (beginContent.contains(BEHAVIOR_BEGIN)) {
            receiveService.snapBehaviorHandler(OBJECT_MAPPER.readValue(requestPostStr, SnapBehaviorDTO.class));
        }
    }

    /**
     * 接收识别告警上传
     *
     * @param recognitionDTO 上传内容DTO
     * @author PeiXy_J
     * @since 14:45 2022-4-25
     */
    @PostMapping("recognition")
    public void receiveRecognitionReport(@RequestBody RecognitionDTO recognitionDTO) {
        receiveService.recognitionHandle(recognitionDTO);
    }
}
