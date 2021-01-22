package study.datajpa.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter //setter 은 가급적 엔티티에 없는것이 좋다.
public class Member {

    @Id
    @GeneratedValue
    private Long id;
    private String username;

    protected Member(){

    }

    public Member(String username) {
        this.username = username;
    }
}
