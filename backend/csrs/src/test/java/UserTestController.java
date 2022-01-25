import com.weart.csrs.domain.member.Member;
import com.weart.csrs.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
//@NoArgsConstructor
@AllArgsConstructor
public class UserTestController {

    private final MemberService memberService;

    @RequestMapping("/api/readUser/{username}")
    public @ResponseBody String  openApiReadUser(@PathVariable String username) {
        Member member = memberService.(username);
        return member.getName();
    }
    @RequestMapping("/api/readUser/{memberId}")
    public @ResponseBody String  openApiReadUser(@PathVariable Long memberId) {
        Member member = memberService.readUser(memberId);
        return member.getName();
    }
    @PostMapping("api/member")
    public String

    @RequestMapping("/openapi/readAuthority/{username}")
    public @ResponseBody String  openApiReadAuthority(@PathVariable String username) {
        List<String> auths = userMapper.readAuthority(username);

        StringBuffer buf = new StringBuffer();
        for(String auth : auths) {
            buf.append(auth);
            buf.append(" ");
        }
        return buf.toString();
    }
}
