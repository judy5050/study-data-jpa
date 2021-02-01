package study.datajpa.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;
import study.datajpa.entity.Member;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class MemberJpaRepository {

    @PersistenceContext//스프링 부트가 엔티티 메니저를 가져다 준다.
    private EntityManager em;

    public Member save(Member member){

        em.persist(member);
        return member;
    }

    public void delete (Member member){

        em.remove(member);
    }

    public List<Member> findAll(){

        return em.createQuery(" select m from Member m").getResultList();

    }

    public long count(){
        return em.createQuery("select count(m) from  Member  m",Long.class)
                .getSingleResult();
    }

    public Optional<Member> findById(Long id){
        Member member=em.find(Member.class,id);
        return Optional.ofNullable(member);//null일 수 있음을 optional로 한번 감싼다.

    }

    public Member find(Long id){
        return em.find(Member.class,id);
    }

    public List<Member> findByUsernameAndAgeGreaterTen(String username,int age){
        return em.createQuery("select  m from Member  m where m.username=:username and m.age>:age")
                .setParameter("username",username)
                .setParameter("age",age)
                .getResultList();
    }

}
