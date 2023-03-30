package net.artux.template.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class GroupCreateDto {

    @NotNull
    private String name;
    private String description;

}
