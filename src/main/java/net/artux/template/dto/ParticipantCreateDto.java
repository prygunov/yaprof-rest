package net.artux.template.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ParticipantCreateDto {

    private String name;
    private String wish;

}
