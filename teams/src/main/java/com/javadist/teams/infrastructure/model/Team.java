package com.javadist.teams.infrastructure.model;

import com.javadist.teams.service.Errors.MemberIsAlreadyInTheTeam;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private long leaderId;

    @Column
    private String name;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Member> members = new ArrayList<>();

    public void assignMemberToTeam(Long memberID) throws MemberIsAlreadyInTheTeam {
        if (this.members.stream().filter(ele -> ele.getId() == memberID).count() > 1) {
            throw new MemberIsAlreadyInTheTeam();
        }
        this.members.add(Member.builder().id(memberID).build());
    }


}
