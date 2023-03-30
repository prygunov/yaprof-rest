package net.artux.template.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class GroupSimpleDto {

    private long id;
    private String name;
    private String description;

    public GroupSimpleDto(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
