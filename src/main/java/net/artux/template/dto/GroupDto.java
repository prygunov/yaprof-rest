package net.artux.template.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class GroupDto {

    private long id;
    private String name;
    private String description;
    private List<ParticipantDto> participants;

    public GroupDto(long id, String name, String description, List<ParticipantDto> participants) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.participants = participants;
    }
}
