package msa.kafka.example;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/member")
    public String postMember(@RequestBody PostMemberRequest request){
        String result=memberService.postMember(request.getName());

        return result;
    }

    @GetMapping("/member")
    public List<GetMemberResponse> getMembers(){
        List<GetMemberResponse> result=memberService.getMembers();

        return result;
    }

    @GetMapping("/member/{memberId}")
    public GetMemberResponse getMember(@PathVariable(name="memberId")Long memberId){
        GetMemberResponse response=memberService.getMember(memberId);

        return response;
    }
}
