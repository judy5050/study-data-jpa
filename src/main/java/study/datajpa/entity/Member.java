package study.datajpa.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter //setter 은 가급적 엔티티에 없는것이 좋다.
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of={"id","username","age"})//연관관계 필드는 tostring 하지 않는것이 좋다.
public class Member {

    @Id
    @GeneratedValue
    @Column(name="member_id")
    private Long id;
    private String username;
    private int age;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="team_id")
    private Team team;


    public Member(String username) {
        this.username = username;
    }

    public Member(String username, int age, Team team ) {

        this.username=username;
        this.age=age;

        if(team!=null)
        {
            changeTeam(team);
        }


    }

    public void changeTeam(Team team){//멤버의 팀변경
        this.team=team;
        team.getMembers().add(this);

    }
}
