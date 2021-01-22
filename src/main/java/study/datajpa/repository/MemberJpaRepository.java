package study.datajpa.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;
import study.datajpa.entity.Member;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberJpaRepository {

    @PersistenceContext//스프링 부트가 엔티티 메니저를 가져다 준다.
    private EntityManager em;

    public Member save(Member member){

        em.persist(member);
        return member;
    }

    public Member find(Long id){
        return em.find(Member.class,id);
    }

}
