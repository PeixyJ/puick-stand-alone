package com.hongdenglv.puick.thirpart.megvii.b4h.dto.report;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * H4B抓拍人脸上报
 *
 * @author PeiXy_J
 * @since 2022-4-25 15:08
 */
@NoArgsConstructor
@Data
public class SnapFaceDTO {

    @JsonProperty("screen_token")
    private String screenToken;
    @JsonProperty("photo")
    private String photo;
    @JsonProperty("photo_md5")
    private String photoMd5;
    @JsonProperty("fullImage")
    private String fullImage;
    @JsonProperty("fullImage_md5")
    private String fullimageMd5;
    @JsonProperty("age")
    private Integer age;
    @JsonProperty("gender")
    private Integer gender;
    @JsonProperty("short_group")
    private Integer shortGroup;
    @JsonProperty("confidence")
    private Integer confidence;
    @JsonProperty("event_type")
    private Integer eventType;
    @JsonProperty("fmp")
    private Integer fmp;
    @JsonProperty("fmp_error")
    private Integer fmpError;
    @JsonProperty("bestStranger")
    private Boolean bestStranger;
    @JsonProperty("quality")
    private Double quality;
    @JsonProperty("roll")
    private Integer roll;
    @JsonProperty("yaw")
    private Integer yaw;
    @JsonProperty("pitch")
    private Integer pitch;
    @JsonProperty("blurness")
    private Integer blurness;
    @JsonProperty("track_id")
    private Integer trackId;
    @JsonProperty("track_die")
    private Boolean trackDie;
    @JsonProperty("timestamp")
    private Integer timestamp;
    @JsonProperty("video_number")
    private Integer videoNumber;
    @JsonProperty("chnDetectType")
    private Integer chnDetectType;
    @JsonProperty("device_id")
    private String deviceId;
    @JsonProperty("algType")
    private Integer algType;
    @JsonProperty("bindingInfo")
    private List<?> bindingInfo;
    @JsonProperty("objType")
    private String objType;
    @JsonProperty("faceAttr")
    private FaceAttrDTO faceAttr;
    @JsonProperty("detectionResult")
    private DetectionResultDTO detectionResult;
    @JsonProperty("targetResult")
    private TargetResultDTO targetResult;

    @NoArgsConstructor
    @Data
    public static class FaceAttrDTO {
        @JsonProperty("age")
        private Integer age;
        @JsonProperty("gender")
        private Integer gender;
        @JsonProperty("skinColor")
        private Integer skinColor;
        @JsonProperty("hair")
        private Integer hair;
        @JsonProperty("beard")
        private Integer beard;
        @JsonProperty("hat")
        private HatDTO hat;
        @JsonProperty("respirator")
        private RespiratorDTO respirator;
        @JsonProperty("glasses")
        private GlassesDTO glasses;

        @NoArgsConstructor
        @Data
        public static class HatDTO {
            @JsonProperty("hatWear")
            private Integer hatWear;
            @JsonProperty("hatColor")
            private Integer hatColor;
            @JsonProperty("hatType")
            private Integer hatType;
        }

        @NoArgsConstructor
        @Data
        public static class RespiratorDTO {
            @JsonProperty("respiratorWear")
            private Integer respiratorWear;
            @JsonProperty("respiratorType")
            private Integer respiratorType;
        }

        @NoArgsConstructor
        @Data
        public static class GlassesDTO {
            @JsonProperty("glassLeftWear")
            private Integer glassLeftWear;
            @JsonProperty("glassLeftType")
            private Integer glassLeftType;
            @JsonProperty("glassRightWear")
            private Integer glassRightWear;
            @JsonProperty("glassRightType")
            private Integer glassRightType;
        }
    }

    @NoArgsConstructor
    @Data
    public static class DetectionResultDTO {
        @JsonProperty("left")
        private Integer left;
        @JsonProperty("top")
        private Integer top;
        @JsonProperty("right")
        private Integer right;
        @JsonProperty("bottom")
        private Integer bottom;
    }

    @NoArgsConstructor
    @Data
    public static class TargetResultDTO {
        @JsonProperty("left")
        private Integer left;
        @JsonProperty("top")
        private Integer top;
        @JsonProperty("right")
        private Integer right;
        @JsonProperty("bottom")
        private Integer bottom;
    }
}
