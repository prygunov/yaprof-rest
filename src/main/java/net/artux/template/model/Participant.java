package net.artux.template.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Participant {

    private final long id;
    private final String name;
    private String wish;
    private Participant recipient;

    public Participant(long id, String name, String wish) {
        this.id = id;
        this.name = name;
        this.wish = wish;
    }
}
