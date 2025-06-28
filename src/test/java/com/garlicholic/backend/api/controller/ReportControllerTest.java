package com.garlicholic.backend.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.garlicholic.backend.api.controller.response.ReportResponse;
import com.garlicholic.backend.domain.ReportCoreService;
import com.garlicholic.backend.storage.ReportEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.queryParameters;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ReportController.class)
@AutoConfigureRestDocs(outputDir = "build/generated-snippets")
class ReportControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ReportCoreService reportCoreService;

    @Test
    void readAll() throws Exception {
        // given
        List<ReportResponse> reportResponses = List.of(
                new ReportResponse(1L, "이희연", LocalDateTime.now(), "좋음", "문제 없음", false, "마늘밭 얘기하며 웃음꽃 피웠어요.")
        );
        when(reportCoreService.readAll(any(Long.class))).thenReturn(reportResponses);

        // when
        ResultActions resultActions = performGetRequest();

        // then
        resultActions.andExpect(status().isOk())
                .andDo(document("read-all-report",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        queryParameters(
                                parameterWithName("userId").description("유저 ID")
                        ),
                        responseFields(
                                fieldWithPath("resultType").description("응답 결과 타입"),
                                fieldWithPath("error").description("에러 정보"),
                                fieldWithPath("success").description("성공 시 데이터"),
                                fieldWithPath("success[].reportId").description("리포트 ID"),
                                fieldWithPath("success[].patientName").description("환자 이름"),
                                fieldWithPath("success[].datetime").description("작성 일시 (yyyy-MM-ddTHH:mm:ss)"),
                                fieldWithPath("success[].condition").description("컨디션 상태"),
                                fieldWithPath("success[].healthStatus").description("건강 상태"),
                                fieldWithPath("success[].isMedicine").description("약 복용 여부"),
                                fieldWithPath("success[].memo").description("메모/특이사항")
                        )
                ));
    }

    private ResultActions performGetRequest() throws Exception {
        return mockMvc.perform(get("/report")
                .param("userId", "1")
                .contentType(APPLICATION_JSON)
        );
    }

}