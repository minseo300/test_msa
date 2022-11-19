package msa.kafka.example;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name="member")
public class Member {
    @Id @GeneratedValue
    @Column(name="member_id")
    private Long id;

    private String name;
}
