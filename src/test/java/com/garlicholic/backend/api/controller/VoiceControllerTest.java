package com.garlicholic.backend.api.controller;

import static org.mockito.BDDMockito.given;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.partWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParts;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import com.garlicholic.backend.domain.ChatResult;
import com.garlicholic.backend.domain.VoiceCoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

@WebMvcTest(VoiceController.class)
@AutoConfigureRestDocs(outputDir = "build/generated-snippets")
class VoiceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private VoiceCoreService voiceCoreService;

    @Test
    void handleAudioUpload() throws Exception {
        // given
        MockMultipartFile audioFile = new MockMultipartFile(
                "audio", "test.wav", MediaType.MULTIPART_FORM_DATA_VALUE, "dummy".getBytes()
        );
        ChatResult chatResult = new ChatResult();
        chatResult.setContents("안녕하세요, 환자님! 오늘 아침 6시 48분에 음성 파일을 올려주셨군요. 잘 들었습니다. 혹시 오늘 하루는 어떻게 보내실 예정이신가요?");
        given(voiceCoreService.chat(any())).willReturn(chatResult);

        // when
        ResultActions resultActions = performPostRequest(audioFile);

        // then
        resultActions.andExpect(status().isOk())
                .andDo(document("voice-chat",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        requestParts(
                                partWithName("audio").description("업로드할 오디오 파일 (multipart/form-data)")
                        ),
                        responseFields(
                                fieldWithPath("resultType").description("응답 결과 타입"),
                                fieldWithPath("error").description("에러 정보"),
                                fieldWithPath("success").description("성공 시 데이터"),
                                fieldWithPath("success.answer").description("채팅 응답"),
                                fieldWithPath("success.isDementia").description("치매 의심 여부")
                        )
                ));
    }

    private ResultActions performPostRequest(MockMultipartFile audioFile) throws Exception {
        return mockMvc.perform(multipart("/voice-chat")
                        .file(audioFile))
                .andExpect(status().isOk());
    }

}