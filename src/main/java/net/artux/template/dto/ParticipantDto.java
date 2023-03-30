package net.artux.template.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import net.artux.template.model.Participant;

@Data
@RequiredArgsConstructor
public class ParticipantDto {

    private final long id;
    private final String name;
    private String wish;
    private ParticipantSimpleDto recipient;

    public ParticipantDto(long id, String name, String wish, ParticipantSimpleDto recipient) {
        this.id = id;
        this.name = name;
        this.wish = wish;
        this.recipient = recipient;
    }
}
