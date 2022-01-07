package repository;

import com.weart.csrs.Repository.MEMBERRepository;
import com.weart.csrs.domain.MEMBER.MEMBER;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(classes = SpringRunner.class)
@RunWith(SpringRunner.class)
public class MEMBERRepositoryTest{

    @Autowired(required = false)
    MEMBERRepository memberRepository;

    @Test
    public void create(){
        MEMBER member = new MEMBER();

        member.getEmail();
    }

    @After
    public void cleanup() {
        memberRepository.deleteAll();
    }

    @Test
    public void MEMBER_불러오기() {
        //given
        String name = "서현";
        String email = "ymecca12@gmail.com";

        memberRepository.save(MEMBER.builder()
                .name(name)
                .email(email)
                .build()
        );

        //when
        List<MEMBER> memberList = memberRepository.findAll();

        //then
        MEMBER member = memberList.get(0);
        assertThat(member.getName()).isEqualTo(name);
        assertThat(member.getEmail()).isEqualTo(email);
        System.out.println("불러기오 Test Success");
    }

}
