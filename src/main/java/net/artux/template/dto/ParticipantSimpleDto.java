package net.artux.template.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import net.artux.template.model.Participant;

@Data
public class ParticipantSimpleDto {

    private final long id;
    private final String name;
    private String wish;

    public ParticipantSimpleDto(long id, String name, String wish) {
        this.id = id;
        this.name = name;
        this.wish = wish;
    }
}
