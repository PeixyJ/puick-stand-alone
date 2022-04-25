package com.hongdenglv.puick.thirpart.megvii.b4h.service.receive;

import com.hongdenglv.puick.thirpart.megvii.b4h.dto.report.RecognitionDTO;
import com.hongdenglv.puick.thirpart.megvii.b4h.dto.report.SnapBehaviorDTO;
import com.hongdenglv.puick.thirpart.megvii.b4h.dto.report.SnapFaceDTO;

/**
 * 识别上报处理服务
 *
 * @author PeiXy_J
 * @since 2022-4-25 15:04
 */
public interface ReceiveService {

    /**
     * 上报识别处理
     *
     * @param dto 上报内容
     * @author PeiXy_J
     * @since 15:06 2022-4-25
     */
    void recognitionHandle(RecognitionDTO dto);

    /**
     * 抓拍人脸上报处理
     *
     * @param dto 上报人脸内容
     * @author PeiXy_J
     * @since 15:09 2022-4-25
     */
    void snapFaceHandler(SnapFaceDTO dto);

    /**
     * 抓拍行为处理
     *
     * @param dto 上报行为内容
     * @author PeiXy_J
     * @since 15:17 2022-4-25
     */
    void snapBehaviorHandler(SnapBehaviorDTO dto);


}
