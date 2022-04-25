package com.hongdenglv.puick.thirpart.megvii.b4h.dto.report;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * H4B抓拍行为上报
 *
 * @author PeiXy_J
 * @since 2022-4-25 15:14
 */
@NoArgsConstructor
@Data
public class SnapBehaviorDTO {


    @JsonProperty("alert_events")
    private List<AlertEventsDTO> alertEvents;
    @JsonProperty("photo")
    private String photo;
    @JsonProperty("device_id")
    private String deviceId;
    @JsonProperty("stream_id")
    private Integer streamId;
    @JsonProperty("frame_id")
    private Integer frameId;
    @JsonProperty("dts")
    private Integer dts;
    @JsonProperty("pts")
    private Integer pts;
    @JsonProperty("recv_ts")
    private Integer recvTs;
    @JsonProperty("algType")
    private Integer algType;

    @NoArgsConstructor
    @Data
    public static class AlertEventsDTO {
        @JsonProperty("area_id")
        private Integer areaId;
        @JsonProperty("area_type")
        private String areaType;
        @JsonProperty("alertor_id")
        private Integer alertorId;
        @JsonProperty("alertor_type")
        private String alertorType;
        @JsonProperty("target")
        private TargetDTO target;

        @NoArgsConstructor
        @Data
        public static class TargetDTO {
            @JsonProperty("target_type")
            private String targetType;
            @JsonProperty("target_id")
            private Integer targetId;
            @JsonProperty("points")
            private List<PointsDTO> points;

            @NoArgsConstructor
            @Data
            public static class PointsDTO {
                @JsonProperty("x")
                private Integer x;
                @JsonProperty("y")
                private Integer y;
            }
        }
    }
}
