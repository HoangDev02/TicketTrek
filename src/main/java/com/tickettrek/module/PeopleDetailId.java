package com.tickettrek.module;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class PeopleDetailId implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "people_id")
    private Integer peopleId;

    @Column(name = "tiket_id")
    private Integer tiketId;
}
